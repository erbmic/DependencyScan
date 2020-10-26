package com.dependencyscan.dependencyscan.dto;

import com.dependencyscan.dependencyscan.entity.Artefact;
import com.dependencyscan.dependencyscan.entity.Version;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
public class ArtefactVersions {

    private final Artefact artefact;
    private final List<Version> versionsOfArtefact;

    public ArtefactVersions(Artefact artefact, List<Version> version) {
        this.artefact = artefact;
        this.versionsOfArtefact = version;
    }

    public Artefact getArtefact() {
        return artefact;
    }

    public List<Version> getArtefactVersions() {
        return versionsOfArtefact;
    }

}
