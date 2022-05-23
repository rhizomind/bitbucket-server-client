package com.rhizomind.ds.integrations.bitbucket.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PagedResult<T> {

    private List<T> values;
    private int size;
    @JsonProperty("isLastPage")
    private boolean lastPage;
    private int nextPageStart;
    private int start;
    private int limit;

}
