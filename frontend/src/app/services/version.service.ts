import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Artefact } from '../common/artefact';
import { Observable } from 'rxjs';
import {Version} from '../common/version';


@Injectable({
  providedIn: 'root'
})
export class VersionService {

  constructor(private httpClient: HttpClient) { }

  // private baseUrl of all Versions Endpoints;
  private baseUrl = 'http://localhost:8080/versions';

  // tslint:disable-next-line:typedef
  private postData: { state: string; id: number };

  artefact: Artefact;

  // get a specific version by id
  getVersion(theArtefactVersionId: number): Observable<Artefact> {
    // need to build URL based on artefact id
    const searchUrl = `${this.baseUrl}/findVersionById/${theArtefactVersionId}`;

    return this.getArtefactVersion(searchUrl);
  }

  // get all versions by name containing
  searchVersion(theKeyword: string): Observable<Artefact[]> {
    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/findVersionByUniqueNameContaining/${theKeyword}`;

    return this.getArtefactVersions(searchUrl);
  }

  // get all dependencies of an artefactversion
  getAllDepsOfArtefactVersion(theArtefactVersionId: number): Observable<Artefact[]> {
    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/getAllDepsOfArtefactVersion/${theArtefactVersionId}`;

    return this.getArtefactVersions(searchUrl);
  }

  // get all usages of an artefactversion
  getAllUsagesOfArtefactVersion(theArtefactVersionId: number): Observable<Artefact[]> {
    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/getAllUsagesOfArtefactVersion/${theArtefactVersionId}`;

    return this.getArtefactVersions(searchUrl);
  }

  getVersionState(theArtefactVersionId: number): Observable<Artefact> {
    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/getVersionState/${theArtefactVersionId}`;

    return this.getArtefactVersion(searchUrl);
  }

  // tslint:disable-next-line:typedef
  setVersionState(theState: string, theArtefactVersionId: number) {
    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/setStateOfSpecificVersion`;
    const headers = new HttpHeaders({'Content-Type': 'application/json'});

    const postData = {
      state: theState,
      id: theArtefactVersionId
    };
    console.log(searchUrl, postData, headers);
    // @ts-ignores
    this.httpClient.post(searchUrl, postData, headers);
    console.log(searchUrl, postData, headers);
  }



  // return response from endpoint as artefact list
  // tslint:disable-next-line:typedef
  private getArtefactVersions(searchUrl: string) {
    return this.httpClient.get<Artefact[]>(searchUrl);
  }

  // return response from endpoint as artefact
  // tslint:disable-next-line:typedef
  private getArtefactVersion(searchUrl: string) {
    return this.httpClient.get<Artefact>(searchUrl);
  }

}
