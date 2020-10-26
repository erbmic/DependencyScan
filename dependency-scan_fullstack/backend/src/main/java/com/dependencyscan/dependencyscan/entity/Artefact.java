package com.dependencyscan.dependencyscan.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;


/**
 * class including all information about an artefact
 */
@NodeEntity
public class Artefact {

    // Properties
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // Relation
    @Relationship(type = "IS_VERSION", direction = INCOMING)
    @JsonIgnoreProperties("artefactsOf")
    private List<Version> artefactVersions = new ArrayList<>();


    // empty constructor
    public Artefact() {}

    // argument constructor
    public Artefact(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Version> getArtefactVersions() { return artefactVersions; }

    public void setArtefactVersions(List<Version> versions) { this.artefactVersions = artefactVersions; }

}
