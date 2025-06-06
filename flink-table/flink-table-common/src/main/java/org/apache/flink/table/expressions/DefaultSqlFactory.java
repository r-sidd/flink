/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.expressions;

import org.apache.flink.annotation.Internal;
import org.apache.flink.table.api.ValidationException;
import org.apache.flink.table.functions.FunctionDefinition;

/**
 * Default implementation of {@link SqlFactory} that throws an exception when trying to serialize an
 * inline function.
 */
@Internal
public class DefaultSqlFactory implements SqlFactory {

    public static final DefaultSqlFactory INSTANCE = new DefaultSqlFactory();

    @Override
    public String serializeInlineFunction(FunctionDefinition functionDefinition) {
        throw new ValidationException(
                "Only functions that have been registered before are serializable.");
    }
}
