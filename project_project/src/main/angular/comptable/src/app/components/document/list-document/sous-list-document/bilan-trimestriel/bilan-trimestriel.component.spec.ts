import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BilanTrimestrielComponent } from './bilan-trimestriel.component';

describe('BilanTrimestrielComponent', () => {
  let component: BilanTrimestrielComponent;
  let fixture: ComponentFixture<BilanTrimestrielComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BilanTrimestrielComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BilanTrimestrielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
