/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */

package org.apache.logging.log4j.core.util;

/**
 * Prefixes thread names with {@code "Log4j2-"}.
 */
public class Log4jThread extends Thread {

    private static final String PREFIX = "Log4j2-";

    private static int threadInitNumber;

    private static synchronized int nextThreadNum() {
        return threadInitNumber++;
    }

    private static String toThreadName(final Object name) {
        return PREFIX + name;
    }

    public Log4jThread() {
        super(toThreadName(nextThreadNum()));
    }

    public Log4jThread(final Runnable target) {
        super(target, toThreadName(nextThreadNum()));
    }

    public Log4jThread(final Runnable target, final String name) {
        super(target, toThreadName(name));
    }

    public Log4jThread(final String name) {
        super(toThreadName(name));
    }

    public Log4jThread(final ThreadGroup group, final Runnable target) {
        super(group, target, toThreadName(nextThreadNum()));
    }

    public Log4jThread(final ThreadGroup group, final Runnable target, final String name) {
        super(group, target, toThreadName(name));
    }

    public Log4jThread(final ThreadGroup group, final Runnable target, final String name, final long stackSize) {
        super(group, target, toThreadName(name), stackSize);
    }

    public Log4jThread(final ThreadGroup group, final String name) {
        super(group, toThreadName(name));
    }

}
