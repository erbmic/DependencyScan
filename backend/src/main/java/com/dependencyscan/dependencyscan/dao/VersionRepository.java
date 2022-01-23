package com.dependencyscan.dependencyscan.dao;

import com.dependencyscan.dependencyscan.dto.ArtefactVersions;
import com.dependencyscan.dependencyscan.dto.JsonDto;
import com.dependencyscan.dependencyscan.entity.Artefact;
import com.dependencyscan.dependencyscan.entity.Version;
import org.springframework.data.neo4j.annotation.Depth;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * repository interface for the {@link Version}
 */
public interface VersionRepository extends Neo4jRepository<Version, Long> {

    Iterable<Version> findAll();

    Version findVersionById(Long id);

    Iterable<Version> findVersionByUniqueNameContaining(String uniqueName);

    @Query("MATCH (artefact: Artefact {name:$nameOfArtefact})" +
            "MATCH (artefact)<-[x:IS_VERSION]-(versions)" +
            "RETURN artefact as artefact, collect(versions) as versionsOfArtefact")
    ArtefactVersions getAllVersionsOfArtefact(String nameOfArtefact);

    @Query("MATCH (v:Version)\n" +
            "WHERE id(v) = $id\n" +
            "MATCH (v)-[DEPENDS_ON*]->(deps)\n" +
            "MATCH (deps)-[IS_VERSION]->(y:Artefact)\n" +
            "RETURN deps")
    Iterable<Version> getAllDepsOfArtefactVersion(Integer id);

    @Query("MATCH (v:Version)\n" +
            "WHERE id(v) = $id\n" +
            "MATCH (v)<-[DEPENDS_ON*]-(usages)\n" +
            "MATCH (usages)-[IS_VERSION]->(y:Artefact)\n" +
            "RETURN usages")
    Iterable<Version> getAllUsagesOfArtefactVersion(Integer id);

    // merge and create all the data from a receiving json. Use "merge" to create only if not exist.
    // merges all the versions, artefacts, and relations IS_VERSION out from a json
    @Query("UNWIND $json AS json\n" +
            "MERGE (v:Version {version: json.version," +
            "uniqueName: json.uniqueName," +
            "url: json.url," +
            "creation_date: json.creation_date," +
            "description: json.description})\n" +
            "MERGE (a:Artefact { name: json.artefactsOf.name })\n" +
            "MERGE (v)-[:IS_VERSION]->(a)")
    void mergeVersionsAndConnectWithArtefactForDto(Iterable<JsonDto> json);

    // merges all the DEPENDS_ON relations
    @Query("UNWIND $json AS json\n" +
            "MATCH (v:Version { uniqueName: json.uniqueName })\n" +
            "FOREACH (dependingVersions IN json.dependingVersionsMap | " +
            "MERGE (dv:Version {uniqueName: dependingVersions.uniqueName})\n" +
            "MERGE (v)-[:DEPENDS_ON]->(dv))")
    void connectVersionToDependingVersion(Iterable<JsonDto> json);

    // set state of specific version
/*    @Query("MATCH (v:Version)\n" +
            "WHERE id(v) = $id\n" +
            "SET v.state = $state\n" +
            "RETURN v")
    void setStateOfSpecificVerison(Integer id, String state);*/

    // set state of specific version
    @Query("MATCH (v:Version)\n" +
            "WHERE id(v) = $id\n" +
            "SET v.state = $state")
    void setStateOfSpecificVersion(Integer id, String state);
}
