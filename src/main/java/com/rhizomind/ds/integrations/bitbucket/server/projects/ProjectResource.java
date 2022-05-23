package com.rhizomind.ds.integrations.bitbucket.server.projects;

import javax.ws.rs.GET;

public interface ProjectResource {

    @GET
    ProjectRepresentation toRepresentation();

}
