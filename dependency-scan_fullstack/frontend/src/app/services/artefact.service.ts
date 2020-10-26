import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Artefact } from '../common/artefact';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArtefactService {

  private baseUrl = 'http://localhost:8080/artefacts';

  constructor(private httpClient: HttpClient) { }

  getAllArtefacts(theArtefactId: number): Observable<Artefact[]> {
    // need to build URL based on artefact id
    return this.getArtefacts(this.baseUrl);
  }

  getArtefactById(theArtefactId: number): Observable<Artefact> {
    // need to build URL based on artefact id
    const searchUrl = `${this.baseUrl}/getArtefactById/${theArtefactId}`;
    return this.httpClient.get<Artefact>(searchUrl);
  }

  searchArtefacts(theKeyword: string): Observable<Artefact[]> {
    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/findArtefactsByNameContaining/${theKeyword}`;

    return this.getArtefacts(searchUrl);
  }

  // return response from endpoint as artefact list
  // tslint:disable-next-line:typedef
  private getArtefacts(searchUrl: string) {
    return this.httpClient.get<Artefact[]>(searchUrl);
  }
}
