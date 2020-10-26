package com.dependencyscan.dependencyscan.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;


/**
 * class including all information about a version
 */
@NodeEntity
public class Version {

    // Properties
    @Id
    @GeneratedValue
    private Long id;
    private String version;
    private String uniqueName;
    private String state;
    private String description;
    private String url;
    private String creation_date;

    //Relation (default direction = OUTGOING)
    @Relationship(type = "IS_VERSION")
    @JsonIgnoreProperties("artefactVersions")
    // private List<Artefact> artefactsOf = new ArrayList<>();
    Artefact artefactsOf;

    @Relationship(type = "DEPENDS_ON")
    // private List<Artefact> artefactsOf = new ArrayList<>();
    List<Version> dependingVersions = new ArrayList<>();

    // empty constructor
    public Version() {
    }

    // argument constructor
    public Version(String version, String uniqueName, String creation_date, String url, String description) {
        this.version = version;
        this.uniqueName = uniqueName;
        this.creation_date = creation_date;
        this.description = description;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() { return version; }

    public void setVersion(String version) { this.version = version; }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Artefact getArtefactsOf() {
        return artefactsOf;
    }

    public void setArtefactsOf(Artefact artefactsOf) {
        this.artefactsOf = artefactsOf;
    }

    public List<Version> getDependingVersions() {
        return dependingVersions;
    }

    public void setDependingVersions(List<Version> dependingVersions) {
        this.dependingVersions = dependingVersions;
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

    /*public List<Artefact> getArtefacts() {
        return artefactsOf;
    }

    public void setArtefacts(List<Artefact> artefactsOf) { this.artefactsOf = artefactsOf; }*/




// -------------------------------------------------------------------------
/*    //Relation
    @Relationship(type = "is_version")
    @JsonIgnoreProperties("artefactVersions")
    private Artefact artefact;

    // empty constructor
    public Version() {}

    // argument constructor
    public Version(Artefact artefact, String version) {
        this.artefact = artefact;
        this.version = version;
    }
    // public Version(Artefact artefact) { this.artefact = artefact; }
    //public Version(String version) { this.version = version; }

    public Long getId() {
        return id;
    }

    public String getVersion() { return version; }

    public void setVersion(String version) { this.version = version; }

    public Artefact getArtefact() {
        return artefact;
    }*/

    // public String getNameOfArtefact() { return artefact.getName(); }
}
