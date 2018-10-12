import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDocumentNewsComponent } from './add-document-news.component';

describe('AddDocumentNewsComponent', () => {
  let component: AddDocumentNewsComponent;
  let fixture: ComponentFixture<AddDocumentNewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDocumentNewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDocumentNewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
