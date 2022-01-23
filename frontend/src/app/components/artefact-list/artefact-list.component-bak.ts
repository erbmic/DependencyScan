/*
import { Component, OnInit } from '@angular/core';
import {ArtefactService} from '../../services/artefact.service';
import {Artefact} from '../../common/artefact';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-artefact-list',
  templateUrl: './artefact-list-table.component.html',
  // templateUrl: './artefact-list.component.html',
  styleUrls: ['./artefact-list.component.css']
})
export class ArtefactListComponent implements OnInit {

  artefacts: Artefact[];
  currentArtefactId: number;
  constructor(private artefactService: ArtefactService, private route: ActivatedRoute) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listArtefacts();
    });
  }

  // tslint:disable-next-line:typedef
  private listArtefacts() {

    // Check if "id" parameter is available
    const hasArtefactId: boolean = this.route.snapshot.paramMap.has('id');
    if (hasArtefactId) {
      // get the "id" param string. convert string to a number using the "+" symbol
      this.currentArtefactId = +this.route.snapshot.paramMap.get('id');
    }
    else {
      // not category id available .... default to category id 1
      this.currentArtefactId = 1;
    }

    // now get the products for the given category id
    this.artefactService.getArtefactList(this.currentArtefactId).subscribe(
      data => {
        this.artefacts = data;
      }
    );
  }
}
*/
