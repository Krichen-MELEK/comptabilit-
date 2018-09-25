import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BilanMoisDetailsComponent } from './bilan-mois-details.component';

describe('BilanMoisDetailsComponent', () => {
  let component: BilanMoisDetailsComponent;
  let fixture: ComponentFixture<BilanMoisDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BilanMoisDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BilanMoisDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
