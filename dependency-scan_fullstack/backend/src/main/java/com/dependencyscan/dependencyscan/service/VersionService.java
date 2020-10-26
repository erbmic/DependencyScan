package com.dependencyscan.dependencyscan.service;

import com.dependencyscan.dependencyscan.dao.VersionRepository;
import com.dependencyscan.dependencyscan.dto.ArtefactVersions;
import com.dependencyscan.dependencyscan.dto.JsonDto;
import com.dependencyscan.dependencyscan.entity.Version;
import org.neo4j.driver.exceptions.Neo4jException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * artefact service class for service handling
 */
@Transactional
@Service
public class VersionService {

    private final VersionRepository versionRepository;

    @Autowired
    public VersionService(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    // service method to find version by id
    public Version findVersionById(Long id) {
        Version foundVersion = versionRepository.findVersionById(id);
        return foundVersion;
    }

    // service method to find versions by name containing
    public Iterable<Version> findVersionByUniqueNameContaining(String uniqueName) {
        Iterable<Version> foundVersions = versionRepository.findVersionByUniqueNameContaining(uniqueName);
        return foundVersions;
    }

    // service method to find all versions of artefact
    public ArtefactVersions getAllVersionsOfArtefact(String nameOfArtefact) {
        ArtefactVersions versionsOfArtefact = versionRepository.getAllVersionsOfArtefact(nameOfArtefact);
        return versionsOfArtefact;
    }

    // service method to find all dependencies
    public Iterable<Version> getAllDepsOfArtefactVersion(Integer id) {
        Iterable<Version> dependenciesOfArtefactVersion = versionRepository.getAllDepsOfArtefactVersion(id);
        return dependenciesOfArtefactVersion;
    }

    // service method to find all usages
    public Iterable<Version> getAllUsagesOfArtefactVersion(Integer id) {
        Iterable<Version> usagesOfArtefactVersion = versionRepository.getAllUsagesOfArtefactVersion(id);
        return usagesOfArtefactVersion;
    }

    // service method to merge and connect all artefacts and versions out of a json
    public Iterable<JsonDto> connectVersionToDependingVersionForDto(Iterable<JsonDto> json) {
        try {
            versionRepository.mergeVersionsAndConnectWithArtefactForDto(json);
            versionRepository.connectVersionToDependingVersion(json);
        } catch (Neo4jException e) {
            e.printStackTrace();
        }
        return (Iterable<JsonDto>) json;
    }

/*    public void setStateOfSpecificVerison(Integer id, String state) {
        try {
            versionRepository.setStateOfSpecificVerison(id, state);
        } catch (Neo4jException e) {
            e.printStackTrace();
        }
    }*/

    // service method get id and state from object and set state in database
    public void setStateOfSpecificVersion(Version json) {
        var id = json.getId();
        var state = json.getState();

        try {
            versionRepository.setStateOfSpecificVersion(Math.toIntExact(id), state);
        } catch (Neo4jException e) {
            e.printStackTrace();
        }
    }


/*    public Version setStateOfSpecificVerison(Integer id, String state) {
        Version state = versionRepository.setStateOfSpecificVerison(Integer id, String state);
        return state;
    }*/
}
