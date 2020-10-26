package com.dependencyscan.dependencyscan.dto;

import com.dependencyscan.dependencyscan.entity.Artefact;
import com.dependencyscan.dependencyscan.entity.Version;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
public class ArtefactData {

    private List<Artefact> artefact;
    private List<Version> version;

    public ArtefactData(List<Artefact> artefact, List<Version> artefactVersions) {
        this.artefact = artefact;
        this.version = artefactVersions;
    }


    public List<Artefact> getArtefact() {
        return artefact;
    }

    public List<Version> getArtefactVersions() {
        return version;
    }




}
