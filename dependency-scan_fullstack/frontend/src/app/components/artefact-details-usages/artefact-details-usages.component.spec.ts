import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtefactDetailsUsagesComponent } from './artefact-details-usages.component';

describe('ArtefactDetailsUsagesComponent', () => {
  let component: ArtefactDetailsUsagesComponent;
  let fixture: ComponentFixture<ArtefactDetailsUsagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArtefactDetailsUsagesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtefactDetailsUsagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

/*  it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});
