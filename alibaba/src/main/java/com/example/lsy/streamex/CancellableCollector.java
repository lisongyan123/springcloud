/*
 * Copyright 2015, 2019 StreamEx contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.java8.streamex;

import java.util.function.Predicate;
import java.util.stream.Collector;

/* package */ abstract class CancellableCollector<T, A, R> implements Collector<T, A, R> {
    abstract Predicate<A> finished();
}