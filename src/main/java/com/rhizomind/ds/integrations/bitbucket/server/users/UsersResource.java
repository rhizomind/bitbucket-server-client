package com.rhizomind.ds.integrations.bitbucket.server.users;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("rest/api/1.0/users")
public interface UsersResource {

    @GET
    UsersPage getAll();

    @GET
    @Path("{id}")
    UserResource getOne(@PathParam("id") String id);

}
