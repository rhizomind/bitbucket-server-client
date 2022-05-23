package com.rhizomind.ds.integrations.bitbucket.server.projects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhizomind.ds.integrations.bitbucket.server.LinkRepresentation;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class RepoRepresentation {

    private int id;
    private String slug;
    private String name;
    private String description;
    private ProjectRepresentation project;
    @JsonProperty("public")
    private boolean _public;
    private boolean forkable;
    private String scmId;
    private String state;
    private String statusMessage;

    private Map<String, List<LinkRepresentation>> links;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

}
