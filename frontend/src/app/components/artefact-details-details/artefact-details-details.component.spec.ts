import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtefactDetailsDetailsComponent } from './artefact-details-details.component';

describe('ArtefactDetailsDetailsComponent', () => {
  let component: ArtefactDetailsDetailsComponent;
  let fixture: ComponentFixture<ArtefactDetailsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArtefactDetailsDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtefactDetailsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

/*  it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});
