import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BilanMoisComponent } from './bilan-mois.component';

describe('BilanMoisComponent', () => {
  let component: BilanMoisComponent;
  let fixture: ComponentFixture<BilanMoisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BilanMoisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BilanMoisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
