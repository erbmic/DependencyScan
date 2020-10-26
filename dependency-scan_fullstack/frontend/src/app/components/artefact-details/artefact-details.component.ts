import { Component, OnInit } from '@angular/core';
import {Artefact} from '../../common/artefact';
import {VersionService} from '../../services/version.service';
import {ActivatedRoute} from '@angular/router';
import {ArtefactService} from '../../services/artefact.service';

@Component({
  selector: 'app-artefact-details',
  templateUrl: './artefact-details.component.html',
  styleUrls: ['./artefact-details.component.css']
})
export class ArtefactDetailsComponent implements OnInit {

  artefactVersion: Artefact;

  constructor(private versionService: VersionService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleArtefactDetails();
    });
  }

  // get the id of the url and search version infos of the specified version with this id
  // tslint:disable-next-line:typedef
  private handleArtefactDetails() {
    const theArtefactVersionId: number = +this.route.snapshot.paramMap.get('id');

    this.versionService.getVersion(theArtefactVersionId).subscribe(
      data => {
        this.artefactVersion = data;
      }
    );
  }
}
