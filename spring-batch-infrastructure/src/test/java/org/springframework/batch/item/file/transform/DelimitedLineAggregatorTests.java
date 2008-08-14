/*
 * Copyright 2006-2007 the original author or authors.
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
package org.springframework.batch.item.file.transform;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Dave Syer
 * 
 */
public class DelimitedLineAggregatorTests {

	private DelimitedLineAggregator<String> aggregator = new DelimitedLineAggregator<String>();

	@Test
	public void testSetDelimiter() {
		aggregator.setDelimiter(";");
		assertEquals("foo;bar", aggregator.aggregate(new String[] { "foo", "bar" }));
	}

	@Test
	public void testAggregate() {
		assertEquals("foo,bar", aggregator.aggregate(new String[] { "foo", "bar" }));
	}

}