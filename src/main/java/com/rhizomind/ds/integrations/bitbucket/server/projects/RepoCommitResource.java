package com.rhizomind.ds.integrations.bitbucket.server.projects;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface RepoCommitResource {

    @GET
    RepoCommitRepresentation toRepresentation();

    @GET
    @Path("diff")
    RepoCommitDiffRepresentation getDiff();

}
