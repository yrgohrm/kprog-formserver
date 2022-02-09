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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.commons.io.IOUtils;

/**
 * This resource will echo back post data and request parameters 
 * as a very simple HTML page.
 * 
 * It will not escape any data sent to it and is thus a bad, bad resource.
 * 
 */
@Path("/unsafeecho")
public class UnsafeEchoResource {
    @Context
    private HttpServletRequest request;
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.TEXT_PLAIN})
    public String handlePostFormdata() throws IOException {
        return getDataFromParamsAndBody();
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.TEXT_PLAIN})
    public String handleGetFormdata() throws IOException {
        return getDataFromParamsAndBody();
    }
        
    private String getDataFromParamsAndBody() throws IOException {
        final var params = request.getParameterMap();
        final var paramsOutput = new StringBuilder();
        params.entrySet().forEach(entry ->
            paramsOutput.append(entry.getKey())
                        .append("=")
                        .append(Arrays.toString(entry.getValue()))
                        .append("<br>")
            );
        
        var postBody = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);

        return "<!DOCTYPE html><html><body>"
                + "Parameters:<br>"+ paramsOutput.toString() + 
                "<br/>Post body:<br>" + postBody + "</body></html>";
    }
}
