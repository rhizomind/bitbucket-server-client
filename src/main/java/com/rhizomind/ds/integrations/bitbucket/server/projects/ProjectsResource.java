package com.rhizomind.ds.integrations.bitbucket.server.projects;

import com.rhizomind.ds.integrations.bitbucket.server.PagedResult;

import javax.ws.rs.*;

@Path("rest/api/1.0/projects")
@Produces("application/json")
@Consumes("application/json")
public interface ProjectsResource {

    @GET
    PagedResult<ProjectRepresentation> getAll();

    @Path("{projectKey}")
    ProjectResource getOne(@PathParam("projectKey") String projectKey);

    @Path("{projectKey}/repos")
    ReposResource getProjectReposResource(@PathParam("projectKey") String projectKey);

}
