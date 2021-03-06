/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.internal.parser.xhtml;

import java.io.StringReader;

import org.junit.Rule;
import org.junit.Test;
import org.xwiki.rendering.block.XDOM;
import org.xwiki.rendering.parser.Parser;
import org.xwiki.test.mockito.MockitoComponentMockingRule;

import static org.junit.Assert.*;

/**
 * Unit tests for {@link XHTMLParser}.
 *
 * @version $Id$
 * @since 8.1M1
 */
public class XHTMLParserTest
{
    @Rule
    public MockitoComponentMockingRule<XHTMLParser> mocker = new MockitoComponentMockingRule<>(XHTMLParser.class,
        Parser.class, "xhtml/1.0");

    @Test
    public void parseWithEmptyContent() throws Exception
    {
        XDOM xdom = this.mocker.getComponentUnderTest().parse(new StringReader(""));
        assertTrue(xdom.getChildren().isEmpty());
    }
}
