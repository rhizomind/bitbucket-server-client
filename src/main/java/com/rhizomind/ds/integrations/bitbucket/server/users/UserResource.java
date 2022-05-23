package com.rhizomind.ds.integrations.bitbucket.server.users;

import javax.ws.rs.GET;

public interface UserResource {

    @GET
    UserRepresentation toUserRepresentation();

}
