/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.test.hamcrest;

import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Matchers for easier handling of our custom collections,
 * for example ImmutableOpenMap
 */
public class CollectionMatchers {

    public static class ImmutableOpenMapHasKeyMatcher extends TypeSafeMatcher<ImmutableOpenMap> {

        private final String key;

        public ImmutableOpenMapHasKeyMatcher(String key) {
            this.key = key;
        }

        @Override
        protected boolean matchesSafely(ImmutableOpenMap item) {
            return item.containsKey(key);
        }

        @Override
        public void describeMismatchSafely(final ImmutableOpenMap map, final Description mismatchDescription) {
            if (map.size() == 0) {
                mismatchDescription.appendText("was empty");
            } else {
                mismatchDescription.appendText(" was ").appendValue(map);
            }
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("ImmutableOpenMap should contain key " + key);
        }
    }

}
