package com.rhizomind.ds.integrations.bitbucket.server.projects;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface ReposResource {

    @GET
    ReposPage getAll();

    @Path("{slug}")
    RepoResource getOne(@PathParam("slug") String slug);
}
