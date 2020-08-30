package com.atlassian.tutorial.myPlugin.rest;

import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/")
@Scanned
public class FastDefReloadWithTests {
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/reload/withtests")
    @AnonymousAllowed
    public Response withTest() {
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
