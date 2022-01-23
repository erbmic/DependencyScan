package com.dependencyscan.dependencyscan.dao;

import com.dependencyscan.dependencyscan.dto.ArtefactData;
import com.dependencyscan.dependencyscan.dto.ArtefactVersions;
import com.dependencyscan.dependencyscan.entity.Artefact;
import com.dependencyscan.dependencyscan.entity.Version;
import org.springframework.data.domain.Page;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * repository interface for the {@link Artefact}
 */
public interface ArtefactRepository extends Neo4jRepository<Artefact, Long> {

    Iterable<Artefact> findAll();

    Artefact getArtefactById(Long id);

    Artefact getArtefactByName(String title);

    Iterable<Artefact> findArtefactsByNameContaining(String title);

    @Query("MATCH (artefact:Artefact {name:$0}) RETURN artefact")
    List<Artefact> getPersons(String name);

    @Query("MATCH (n) WHERE id(n)=$0 RETURN n")
    Artefact getArtefactFromId(Integer idOfArtefact);

    Iterable<Artefact> findArtefactByNameLike(String title);

    @Query("MATCH (v:Version {version: '1.0.2'})-[IS_VERSION]->(a:Artefact {name: 'Log'})\n" +
            "RETURN (a)")
    List<Artefact> getArtefactWithVersion();

    @Query("MATCH (artefact: Artefact {name:$nameOfArtefact})" +
            "MATCH (artefact)<-[x:IS_VERSION]-(versions)" +
            "RETURN collect(artefact) AS artefact, collect(versions) AS version")
    List<ArtefactData> getAllVersionsOfArtefact(String nameOfArtefact);

    @Query("MATCH (v:Version {version: '1.2.0'})-[IS_VERSION]->(a:Artefact {name:$nameOfArtefact})\n" +
            "OPTIONAL MATCH (v)-[dr:DEPENDS_ON*1..10]->(other)\n" +
            "OPTIONAL MATCH (other)-[k:IS_VERSION]->(y:Artefact)\n" +
            "RETURN collect(y) AS dep, collect(other) AS depVersion")
    List<Artefact> getAllDepsOfArtefactVersion(String nameOfArtefact);


}
