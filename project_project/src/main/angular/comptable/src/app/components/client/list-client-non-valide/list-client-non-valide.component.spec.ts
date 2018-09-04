import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListClientNonValideComponent } from './list-client-non-valide.component';

describe('ListClientNonValideComponent', () => {
  let component: ListClientNonValideComponent;
  let fixture: ComponentFixture<ListClientNonValideComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListClientNonValideComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListClientNonValideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
