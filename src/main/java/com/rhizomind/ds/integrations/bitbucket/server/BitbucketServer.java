package com.rhizomind.ds.integrations.bitbucket.server;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rhizomind.ds.integrations.bitbucket.server.projects.ProjectsResource;
import com.rhizomind.ds.integrations.bitbucket.server.serverinfo.ApplicationPropertiesResource;
import com.rhizomind.ds.integrations.bitbucket.server.users.UsersResource;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

public class BitbucketServer {

    private final Client client;
    private final ResteasyWebTarget target;

    public BitbucketServer(String serverUrl, String token) {
        ObjectMapper objectMapper = new ObjectMapper()
                .disable(
                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                        DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE
                )
                .disable(
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                        SerializationFeature.FAIL_ON_EMPTY_BEANS
                )
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModules(
                        new Jdk8Module(),
                        new JavaTimeModule()
                );


        this.client = ClientBuilder
                .newBuilder()
                .register(new MyProvider(objectMapper))
                .build();
        this.target = (ResteasyWebTarget) client.target(serverUrl.toString());
        this.target.register(new ClientRequestFilter() {
            @Override
            public void filter(ClientRequestContext requestContext) throws IOException {
                requestContext.getHeaders().putSingle("Authorization", "Bearer " + token);
            }
        });
    }

    public ApplicationPropertiesResource systemResource(){
        return this.target.proxy(ApplicationPropertiesResource.class);
    }

    public ProjectsResource projectsResource() {
        return this.target.proxy(ProjectsResource.class);
    }

    public UsersResource usersResource() {
        return this.target.proxy(UsersResource.class);
    }

    @Provider
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    class MyProvider extends JacksonJsonProvider {
        MyProvider(ObjectMapper mapper) {
            super(mapper);
        }
    }

}
