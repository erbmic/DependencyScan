package com.dependencyscan.dependencyscan.service;

import com.dependencyscan.dependencyscan.dao.ArtefactRepository;
import com.dependencyscan.dependencyscan.dto.ArtefactData;
import com.dependencyscan.dependencyscan.entity.Artefact;
import com.dependencyscan.dependencyscan.entity.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * artefact service class for artefact handling
 */
@Transactional
@Service
public class ArtefactService {

    private final ArtefactRepository artefactRepository;

    @Autowired
    public ArtefactService(ArtefactRepository artefactRepository) {
        this.artefactRepository = artefactRepository;
    }

    // service method to find all artefacts
    public Iterable<Artefact> findAll() {
        Iterable<Artefact> artefacts = artefactRepository.findAll();
        return artefacts;
    }

    // service method to find artefact by id
    public Artefact getArtefactById(Long id) {
        Artefact artefact = artefactRepository.getArtefactById(id);
        return artefact;
    }

    // service method to find artefact by name
    public Artefact getArtefactByName(String name) {
        Artefact artefact = artefactRepository.getArtefactByName(name);
        return artefact;
    }

    // service method to find artefact by name containing
    public Iterable<Artefact> findArtefactsByNameContaining(String name) {
        Iterable<Artefact> artefacts = artefactRepository.findArtefactsByNameContaining(name);
        return artefacts;
    }
}
