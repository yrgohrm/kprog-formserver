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
package se.yrgo.kprog.formserver.health;

import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheck.Result;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test that our useless health check is in fact useless.
 * 
 */
public class UselessHealthCheckTest {
    
    public UselessHealthCheckTest() {
    }

    /**
     * Test that we will indeed get a healthy reponse.
     * 
     * @throws java.lang.Exception
     */
    @Test
    public void testCheck() throws Exception {
        UselessHealthCheck instance = new UselessHealthCheck();
        HealthCheck.Result expResult = Result.healthy();
        HealthCheck.Result result = instance.check();
        assertEquals(expResult, result);
    }
}
