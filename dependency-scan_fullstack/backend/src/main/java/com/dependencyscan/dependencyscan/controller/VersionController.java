package com.dependencyscan.dependencyscan.controller;

import com.dependencyscan.dependencyscan.dao.VersionRepository;
import com.dependencyscan.dependencyscan.dto.ArtefactVersions;
import com.dependencyscan.dependencyscan.dto.JsonDto;
import com.dependencyscan.dependencyscan.entity.Version;
import com.dependencyscan.dependencyscan.service.VersionService;
import org.springframework.web.bind.annotation.*;

/**
 * version controller class for artefact endpoints
 */
@RestController
@RequestMapping("/versions")
public class VersionController {

    private final VersionRepository versionRepository;
    private final VersionService versionService;

    public VersionController(VersionRepository versionRepository, VersionService versionService) {
        this.versionRepository = versionRepository;
        this.versionService = versionService;
    }

    @GetMapping
    public Iterable<Version> findAllVersions() {
        return versionRepository.findAll();
    }

    @GetMapping("/findVersionById/{id}")
    public Version findVersionById(@PathVariable Long id) {
        return versionService.findVersionById(id);
    }

    @GetMapping("/findVersionByUniqueNameContaining/{uniqueName}")
    public Iterable<Version> findVersionByUniqueNameContaining(@PathVariable String uniqueName) {
        return versionService.findVersionByUniqueNameContaining(uniqueName);
    }

    @GetMapping("/getAllVersionsOfArtefact/{nameOfArtefact}")
    public ArtefactVersions getAllVersionsOfArtefact(@PathVariable String nameOfArtefact) {
        return versionService.getAllVersionsOfArtefact(nameOfArtefact);
    }

    @GetMapping("/getAllDepsOfArtefactVersion/{id}")
    public Iterable<Version> getAllDepsOfArtefactVersion(@PathVariable Integer id) {
        return versionService.getAllDepsOfArtefactVersion(id);
    }

    @GetMapping("/getAllUsagesOfArtefactVersion/{id}")
    public Iterable<Version> getAllUsagesOfArtefactVersion(@PathVariable Integer id) {
        return versionService.getAllUsagesOfArtefactVersion(id);
    }

    @PostMapping("/loadjson")
    public Iterable<JsonDto> connectVersionToDependingVersionForDto(@RequestBody Iterable<JsonDto> json) {
        return versionService.connectVersionToDependingVersionForDto(json);
    }

/*    @PostMapping("/setStateOfSpecificVersion/{id}/{state}")
    public void setStateOfSpecificVerison(@PathVariable Integer id, @PathVariable String state) {
        versionService.setStateOfSpecificVerison(id, state);
    }*/

    @PostMapping("/setStateOfSpecificVersion")
    public void setStateOfSpecificVersion(@RequestBody Version json) {
        versionService.setStateOfSpecificVersion(json);
    }


}
