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
package org.xwiki.rendering.xdomxml10.internal.renderer.parameter;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.xwiki.rendering.listener.ListType;

public class ListTypeConverter
{
    private static final Map<String, ListType> STRINGTOLISTTYPE = Stream.of(
        new AbstractMap.SimpleImmutableEntry<>("bulleted", ListType.BULLETED),
        new AbstractMap.SimpleImmutableEntry<>("numbered", ListType.NUMBERED))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final Map<ListType, String> LISTTYPETOSTRING = Stream.of(
        new AbstractMap.SimpleImmutableEntry<>(ListType.BULLETED, "bulleted"),
        new AbstractMap.SimpleImmutableEntry<>(ListType.NUMBERED, "numbered"))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public ListType toFormat(String str)
    {
        return STRINGTOLISTTYPE.containsKey(str) ? STRINGTOLISTTYPE.get(str) : ListType.BULLETED;
    }

    public String toString(ListType type)
    {
        return LISTTYPETOSTRING.containsKey(type) ? LISTTYPETOSTRING.get(type) : LISTTYPETOSTRING
            .get(ListType.BULLETED);
    }
}
