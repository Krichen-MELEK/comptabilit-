import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPageContentComponent } from './admin-page-content.component';

describe('AdminPageContentComponent', () => {
  let component: AdminPageContentComponent;
  let fixture: ComponentFixture<AdminPageContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPageContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPageContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
