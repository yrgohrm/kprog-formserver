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
package se.yrgo.kprog.formserver;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import se.yrgo.kprog.formserver.health.UselessHealthCheck;
import se.yrgo.kprog.formserver.resources.EchoResource;
import se.yrgo.kprog.formserver.resources.UnsafeEchoResource;

/**
 * Main class for the Form application. This is the basic layout
 * for an application that uses Dropwizard as framework.
 * 
 */
public class FormApplication extends Application<FormConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FormApplication().run(args);
    }

    @Override
    public String getName() {
        return "formserver";
    }

    @Override
    public void run(final FormConfiguration configuration,
            final Environment environment) {
        environment.healthChecks().register("useless", new UselessHealthCheck());
        environment.jersey().register(EchoResource.class);
        environment.jersey().register(UnsafeEchoResource.class);
    }
}
