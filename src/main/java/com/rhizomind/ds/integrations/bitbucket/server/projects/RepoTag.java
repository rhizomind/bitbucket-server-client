package com.rhizomind.ds.integrations.bitbucket.server.projects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class RepoTag {

    private String id;
    private String hash;
    private String latestCommit;
    private String latestChangeset;
    private String displayId;
    private String type;

    @JsonAnySetter
    @JsonAnyGetter
    private Map<String, Object> unknownProperties = new HashMap<>();

}
