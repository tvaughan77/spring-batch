/*
 * Copyright 2006-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.batch.sample.domain.order;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.batch.sample.domain.order.internal.OrderTransformer;

/**
 * @author Dave Syer
 * 
 */
public class OrderTransformerTests {

	private OrderTransformer converter = new OrderTransformer();

	@Test
	public void testConvert() throws Exception {
		converter.setAggregators(new HashMap<String, LineAggregator<String[]>>() {
			{
				put("header", new PassThroughLineAggregator<String[]>());
				put("customer", new PassThroughLineAggregator<String[]>());
				put("address", new PassThroughLineAggregator<String[]>());
				put("billing", new PassThroughLineAggregator<String[]>());
				put("item", new PassThroughLineAggregator<String[]>());
				put("footer", new PassThroughLineAggregator<String[]>());
			}
		});
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setCustomer(new Customer());
		order.setBillingAddress(new Address());
		order.setBilling(new BillingInfo());
		order.setLineItems(new ArrayList<LineItem>());
		order.setTotalPrice(new BigDecimal(10));
		Object result = converter.transform(order);
		assertTrue(result instanceof Collection);
	}

}