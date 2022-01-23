import { Component, OnInit } from '@angular/core';
import {VersionService} from '../../services/version.service';
import {ActivatedRoute} from '@angular/router';
import {Artefact} from '../../common/artefact';

@Component({
  selector: 'app-tool-menu',
  templateUrl: './tool-menu.component.html',
  styleUrls: ['./tool-menu.component.css']
})
export class ToolMenuComponent implements OnInit {

  artefactVersion: Artefact;
  searchMode = false;

  constructor(private versionService: VersionService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleTools();
    });
  }
  // tslint:disable-next-line:typedef
  private handleTools() {

    this.searchMode = this.route.snapshot.paramMap.has('id');
    const theArtefactVersionId: number = +this.route.snapshot.paramMap.has('id');
    console.log("the id is" + theArtefactVersionId);
    if (this.searchMode) {
      this.x();
    } else {
      this.x();
    }
  }

  // tslint:disable-next-line:typedef
  private x() {
    const theArtefactVersionId: number = +this.route.snapshot.paramMap.has('id');


    this.versionService.getVersion(theArtefactVersionId).subscribe(
      data => {
        this.artefactVersion = data;
      }
    );
  }
  // tslint:disable-next-line:typedef
  private y() {

    this.versionService.getVersion(0).subscribe(
      data => {
        this.artefactVersion = data;
      }
    );
  }
}
