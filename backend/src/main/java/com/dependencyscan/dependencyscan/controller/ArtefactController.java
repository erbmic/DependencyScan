package com.dependencyscan.dependencyscan.controller;

import com.dependencyscan.dependencyscan.dao.ArtefactRepository;
import com.dependencyscan.dependencyscan.dto.ArtefactData;
import com.dependencyscan.dependencyscan.entity.Artefact;
import com.dependencyscan.dependencyscan.service.ArtefactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * artefact controller class for artefact endpoints
 */
@RestController
@RequestMapping("/artefacts")
public class ArtefactController {

    private final ArtefactRepository artefactRepository;
    private final ArtefactService artefactService;

    public ArtefactController(ArtefactRepository artefactRepository, ArtefactService artefactService) {
        this.artefactRepository = artefactRepository;
        this.artefactService = artefactService;
    }

    @GetMapping
    public Iterable<Artefact> findAll() {
        return artefactService.findAll();
    }

    @GetMapping("/getArtefactById/{id}")
    public Artefact getArtefactById(@PathVariable Long id) {
        return artefactService.getArtefactById(id);
    }

    @GetMapping("/getArtefactByName/{nameOfArtefact}")
    public Artefact getArtefactByName(@PathVariable String nameOfArtefact) {
        return artefactService.getArtefactByName(nameOfArtefact);
    }

    @GetMapping("/findArtefactsByNameContaining/{nameOfArtefact}")
    public Iterable<Artefact> findArtefactsByNameContaining(@PathVariable String nameOfArtefact) {
        return artefactService.findArtefactsByNameContaining(nameOfArtefact);
    }

}
