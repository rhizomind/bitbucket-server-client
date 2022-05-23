package com.rhizomind.ds.integrations.bitbucket.server.serverinfo;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ApplicationPropertiesRepresentation {

    private String version;
    private String buildNumber;
    private ZonedDateTime buildDate;
    private String displayName;

}
