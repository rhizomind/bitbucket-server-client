package com.rhizomind.ds.integrations.bitbucket.server.projects;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface RepoResource {

    @GET
    RepoRepresentation toRepresentation();

    @Path("commits")
    RepoCommitsResource getCommitsResource();

    @GET
    @Path("tags")
    RepoTagsPage getRepoTagsPage();

}
