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

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Tests for the EchoResource.
 * 
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class EchoResourceTest extends DropwizardTestBase {

    /**
     * Test that the GET method works as expected.
     */
    @Test
    public void testHandleGetFormdata() throws Exception {
        WebTarget target = getWebTarget("/api/echo?data=test");
        String resp = target.request(MediaType.TEXT_HTML).get(String.class);
        assertTrue(resp.contains("Parameters:<br>data=[test]"));
    }

    /**
     * Test that the POST method works as expected.
     */
    @Test
    public void testHandlePostFormdata() throws Exception {
        WebTarget target = getWebTarget("/api/echo");
        Form f = new Form();
        f.param("data", "someval");
        String resp = target.request(MediaType.TEXT_HTML).post(Entity.form(f), String.class);
        assertTrue(resp.contains("Post body:<br>data=someval"));
    }
    
    /**
     * Test that the data is escaped properly in the output.
     */
    @Test
    public void testHandleBadGetFormdata() throws Exception {
        WebTarget target = getWebTarget("/api/echo?data=%3Cbr%3E");
        String resp = target.request(MediaType.TEXT_HTML).get(String.class);
        assertFalse(resp.contains("data=[<br>]"));
    }
}
