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
package org.apache.wicket.protocol.http.documentvalidation;

/**
 * Class representing text content that can appear within an element.
 * 
 * @author Chris Turner
 * @deprecated Will be removed in Wicket 9.0 together with {@link HtmlDocumentValidator}
 */
@Deprecated
public class TextContent implements DocumentElement
{
	private final String value;

	/**
	 * Construct the text content with the expected value.
	 * 
	 * @param value
	 *            The value
	 */
	public TextContent(final String value)
	{
		this.value = value;
	}

	/**
	 * Get the value of this text content.
	 * 
	 * @return The value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Output a descriptive string.
	 * 
	 * @return The string
	 */
	@Override
	public String toString()
	{
		return "[text = '" + value + "']";
	}
}