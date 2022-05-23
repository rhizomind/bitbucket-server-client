package com.rhizomind.ds.integrations.bitbucket.server.projects;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface RepoCommitsResource {

    @GET
    RepoCommitsPage getAll();

    @Path("{commitId}")
    RepoCommitResource getOne(@PathParam("commitId") String commitId);

}
