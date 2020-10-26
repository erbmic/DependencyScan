import {Component, OnInit} from '@angular/core';
import {Artefact} from '../../common/artefact';
import {VersionService} from '../../services/version.service';
import {ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-artefact-details-details',
  templateUrl: './artefact-details-details.component.html',
  styleUrls: ['./artefact-details-details.component.css']
})
export class ArtefactDetailsDetailsComponent implements OnInit {

  artefactVersion: Artefact;
  stateForm: FormGroup;
  books = ['Obsolete', 'Maintained', 'Ready for Testing', '-'];

  constructor(private versionService: VersionService, private route: ActivatedRoute, private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleArtefactDetails();
    });
  }

  // get the id of the Parent url and search version infos of the specified version with this id
  // tslint:disable-next-line:typedef
  private handleArtefactDetails() {
    const theArtefactVersionId: number = +this.route.snapshot.parent.paramMap.get('id');
    this.versionService.getVersion(theArtefactVersionId).subscribe(
      data => {
        console.log('Artefact Details=' + JSON.stringify(data));
        this.artefactVersion = data;
        this.handleVersionState(data);
      }
    );
  }


  // tslint:disable-next-line:typedef
  private handleVersionState(data: Artefact) {
    const theState = data.state;

    if (theState == null) {
      this.stateForm = this.fb.group({
        stateControl: ['-']
      });
      console.log('no state set yet, display "-"');
    }
    else {
      this.stateForm = this.fb.group({
        stateControl: [theState.toString()]
      });
      console.log('display state of version: ' + theState);
    }
  }

// tslint:disable-next-line:typedef ban-types
  setState(theState: String) {
    const theArtefactVersionId: number = +this.route.snapshot.parent.paramMap.get('id');
    // @ts-ignore
    this.versionService.setVersionState(theState, theArtefactVersionId);
    console.log('Set version state to: ' + theState);
  }

}
