package com.dependencyscan.dependencyscan.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

import java.util.List;
import java.util.Map;

/**
 * json DTO class to handle incoming json
 */
@JsonDeserialize(using = JsonDtoDeserializer.class)
public class JsonDto {

    //Properties
    private String version;
    private String uniqueName;
    private String description;
    private String url;
    private String creation_date;
    private Map<String, String> artefactsOf;
    private List<Map<String, String>> dependingVersionsMap;

    // empty constructor
    public JsonDto() {
    }

    // argument constructor
    public JsonDto(String version, String uniqueName, String description, String url, String creation_date) {
        this.version = version;
        this.uniqueName = uniqueName;
        this.uniqueName = description;
        this.uniqueName = url;
        this.uniqueName = creation_date;
    }

    public JsonDto(String uniqueName, String version) {
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public Map<String, String> getArtefactsOf() {
        return artefactsOf;
    }

    public void setArtefactsOf(Map<String, String> artefactsOf) {
        this.artefactsOf = artefactsOf;
    }

    public List<Map<String, String>> getDependingVersionsMap() {
        return dependingVersionsMap;
    }

    public void setDependingVersionsMap(List<Map<String, String>> dependingVersionsMap) {
        this.dependingVersionsMap = dependingVersionsMap;
    }
}


