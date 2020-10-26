import { Component, OnInit } from '@angular/core';
import {Artefact} from "../../common/artefact";
import {VersionService} from "../../services/version.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-artefact-details-dependencies',
  templateUrl: './artefact-details-dependencies.component.html',
  styleUrls: ['./artefact-details-dependencies.component.css']
})
export class ArtefactDetailsDependenciesComponent implements OnInit {

  artefactVersions: Artefact[] = [];

  constructor(private versionService: VersionService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleArtefactDetails();
    });
  }

  // get the id of the url and search version dependencies of the specified version with this id
  // tslint:disable-next-line:typedef
  private handleArtefactDetails() {
    const theArtefactVersionId: number = +this.route.snapshot.parent.paramMap.get('id');

    this.versionService.getAllDepsOfArtefactVersion(theArtefactVersionId).subscribe(
      data => {
        this.artefactVersions = data;
      }
    );
  }
}
