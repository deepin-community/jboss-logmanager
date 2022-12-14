/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
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

package org.jboss.logmanager;

import java.io.File;
import java.io.FileNotFoundException;

import org.jboss.logmanager.handlers.FileHandler;

/**
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
public class TestFileHandler extends FileHandler {
    private static final String BASE_LOG_DIR;

    static {
        BASE_LOG_DIR = System.getProperty("test.log.dir");
    }

    public TestFileHandler() {
        super();
        setErrorManager(AssertingErrorManager.of());
    }

    public TestFileHandler(final String fileName, final boolean append) throws FileNotFoundException {
        super(fileName, append);
        setErrorManager(AssertingErrorManager.of());
    }

    @Override
    public void setFileName(final String fileName) throws FileNotFoundException {
        final String name = fileName == null ? null : BASE_LOG_DIR.concat(fileName);
        super.setFileName(name);
    }
}
