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

/**
 * In a larger application this is where you would check the 
 * other services that you depend upon to make sure everything
 * is up and running correctly.
 * 
 */
public class UselessHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        // We'll just assume that everything is peachy
        return Result.healthy();
    }
}
