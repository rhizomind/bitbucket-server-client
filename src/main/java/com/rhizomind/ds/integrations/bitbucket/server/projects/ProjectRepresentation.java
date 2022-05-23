package com.rhizomind.ds.integrations.bitbucket.server.projects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhizomind.ds.integrations.bitbucket.server.LinkRepresentation;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class ProjectRepresentation {

    private String avatar;
    private String scope;
    private String description;
    private String namespace;
    private String name;
    private String key;
    private String id;
    private String type;

    @JsonProperty("public")
    private boolean _public;

    private Map<String, List<LinkRepresentation>> links;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();


}
