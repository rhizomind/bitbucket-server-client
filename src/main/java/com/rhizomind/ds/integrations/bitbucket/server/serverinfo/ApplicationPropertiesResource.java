package com.rhizomind.ds.integrations.bitbucket.server.serverinfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("rest/api/1.0/application-properties")
@Produces("application/json")
@Consumes("application/json")
public interface ApplicationPropertiesResource {

    @GET
    ApplicationPropertiesRepresentation applicationProperties();

}
