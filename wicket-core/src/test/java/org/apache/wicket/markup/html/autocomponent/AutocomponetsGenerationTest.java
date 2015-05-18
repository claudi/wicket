/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.markup.html.autocomponent;

import org.apache.wicket.WicketTestCase;
import org.apache.wicket.markup.IMarkupCache;
import org.junit.Test;

/*
 * Test case for https://issues.apache.org/jira/browse/WICKET-5904
 * and for https://issues.apache.org/jira/browse/WICKET-5908
 */
public class AutocomponetsGenerationTest extends WicketTestCase
{

	@Test
	public void autocomponetsNumberDoesntChange()
	{
		AutoComponentsPage autoComponentsPage = new AutoComponentsPage();
		tester.startPage(autoComponentsPage);
		
		int childrenNumber = tester.getLastRenderedPage().size();
		
		//clean markup cache and render the same page instance again
		IMarkupCache markupCache = tester.getApplication().getMarkupSettings().getMarkupFactory().getMarkupCache();
		
		markupCache.clear();
		tester.startPage(autoComponentsPage);
		
		//the number of child components must not have been changed
		assertEquals(childrenNumber, tester.getLastRenderedPage().size());
		
	}

}
