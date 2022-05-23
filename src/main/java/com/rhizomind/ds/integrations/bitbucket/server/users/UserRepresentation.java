package com.rhizomind.ds.integrations.bitbucket.server.users;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.rhizomind.ds.integrations.bitbucket.server.LinkRepresentation;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class UserRepresentation {

    private String id;
    private String type;
    private String slug;
    private String emailAddress;
    private String displayName;
    private String name;
    private boolean active;
    private Map<String, List<LinkRepresentation>> links;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

}
