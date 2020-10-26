import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtefactDetailsDependenciesComponent } from './artefact-details-dependencies.component';

describe('ArtefactDetailsDependenciesComponent', () => {
  let component: ArtefactDetailsDependenciesComponent;
  let fixture: ComponentFixture<ArtefactDetailsDependenciesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArtefactDetailsDependenciesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtefactDetailsDependenciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

/*  it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});
