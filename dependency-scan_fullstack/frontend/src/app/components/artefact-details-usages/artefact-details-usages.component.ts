import { Component, OnInit } from '@angular/core';
import {Artefact} from "../../common/artefact";
import {VersionService} from "../../services/version.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-artefact-details-usages',
  templateUrl: './artefact-details-usages.component.html',
  styleUrls: ['./artefact-details-usages.component.css']
})
export class ArtefactDetailsUsagesComponent implements OnInit {

  artefactVersions: Artefact[] = [];

  constructor(private versionService: VersionService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleArtefactDetails();
    });
  }

  // get the id of the url and search version usages of the specified version with this id
  // tslint:disable-next-line:typedef
  private handleArtefactDetails() {
    const theArtefactVersionId: number = +this.route.snapshot.parent.paramMap.get('id');

    this.versionService.getAllUsagesOfArtefactVersion(theArtefactVersionId).subscribe(
      data => {
        this.artefactVersions = data;
      }
    );
  }
}
