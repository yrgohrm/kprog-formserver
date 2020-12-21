/*
 * Copyright 2020 Hampus Ram <hampus.ram@educ.goteborg.se>.
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
package se.yrgo.kprog.formserver.resources;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import static org.junit.jupiter.api.Assertions.assertTrue;
import se.yrgo.kprog.formserver.FormApplication;
import se.yrgo.kprog.formserver.FormConfiguration;

/**
 * Base class for moving out repetetive code for dropwizard tests.
 */
public class DropwizardTestBase {

    protected static final DropwizardAppExtension<FormConfiguration> DROPWIZARD = new DropwizardAppExtension<FormConfiguration>(FormApplication.class, ResourceHelpers.resourceFilePath("config.yml"));

    protected WebTarget getWebTarget(String url) {
        assertTrue(url != null && url.startsWith("/"), "Target URL must start with /");
        Client client = DROPWIZARD.client();
        int localPort = DROPWIZARD.getLocalPort();
        return client.target("http://localhost:" + localPort + url);
    }
}
