import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ArtefactListComponent } from './components/artefact-list/artefact-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ArtefactService } from './services/artefact.service';
import { RouterModule, Routes } from '@angular/router';
import { ToolMenuComponent } from './components/tool-menu/tool-menu.component';
import { SearchComponent } from './components/search/search.component';
import { ArtefactDetailsComponent } from './components/artefact-details/artefact-details.component';
import { ArtefactDetailsDependenciesComponent } from './components/artefact-details-dependencies/artefact-details-dependencies.component';
import { ArtefactDetailsUsagesComponent } from './components/artefact-details-usages/artefact-details-usages.component';
import { ArtefactDetailsDetailsComponent } from './components/artefact-details-details/artefact-details-details.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';



const routes: Routes = [
  {
    path: 'artefacts/:id',
    component: ArtefactDetailsComponent,
    children: [
      {path: 'details', component: ArtefactDetailsDetailsComponent },
      {path: '', redirectTo: 'details', pathMatch: 'full'},
      {path: 'deps', component: ArtefactDetailsDependenciesComponent },
      {path: 'usages', component: ArtefactDetailsUsagesComponent }
    ]
  },
  {path: 'search/:keyword', component: ArtefactListComponent},
  {path: 'artefact', component: ArtefactListComponent},
  {path: '', redirectTo: '/artefact', pathMatch: 'full'},
  {path: '**', redirectTo: '/artefact', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ArtefactListComponent,
    ToolMenuComponent,
    SearchComponent,
    ArtefactDetailsComponent,
    ArtefactDetailsDependenciesComponent,
    ArtefactDetailsUsagesComponent,
    ArtefactDetailsDetailsComponent,
  ],
    imports: [
        RouterModule.forRoot(routes),
        BrowserModule,
        HttpClientModule,
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
    ],
  providers: [ArtefactService],
  bootstrap: [AppComponent]
})
export class AppModule { }
