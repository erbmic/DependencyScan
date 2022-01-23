import {Component, OnInit} from '@angular/core';
import {ArtefactService} from '../../services/artefact.service';
import {Artefact} from '../../common/artefact';
import {ActivatedRoute} from '@angular/router';
import {VersionService} from '../../services/version.service';

@Component({
  selector: 'app-artefact-list',
  templateUrl: './artefact-list-table.component.html',
  // templateUrl: './artefact-list.component.html',
  styleUrls: ['./artefact-list.component.css']
})
export class ArtefactListComponent implements OnInit {

  artefacts: Artefact[] = [];
  // artefacts: Artefact = new Artefact();
  currentArtefactId: number;
  searchMode: boolean;

  constructor(private artefactService: ArtefactService, private versionService: VersionService, private route: ActivatedRoute) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listArtefacts();
    });
  }

  // if search for an artefact, handle search method, if not -
  // tslint:disable-next-line:typedef
  private listArtefacts() {
    // bookean if the url of this route containens the serach keyword
    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if (this.searchMode) {
      this.handleSearchArtefactVersions();
    } else {
      this.handleListArtefacts();
    }
  }

  // searchmethod
  // tslint:disable-next-line:typedef
  private handleSearchArtefactVersions() {
    // get the keyword to search for
    const theKeyword: string = this.route.snapshot.paramMap.get('keyword');

    console.log(`keyword=${theKeyword}`);

    // now search for the products using keyword
    this.versionService.searchVersion(theKeyword).subscribe(
      data => {
        this.artefacts = data;
      }
    );
  }

  // method if nothging is searched
  // tslint:disable-next-line:typedef
  handleListArtefacts() {
    // check if "id" parameter is available
    const hasId: boolean = this.route.snapshot.paramMap.has('id');

    // now get the products for the given category id
    this.artefactService.getAllArtefacts(this.currentArtefactId).subscribe(
      data => {
        this.artefacts = data;
      }
    );
  }
}
