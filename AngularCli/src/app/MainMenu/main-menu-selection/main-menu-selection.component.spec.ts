import {ComponentFixture, TestBed} from '@angular/core/testing';

import {MainMenuSelectionComponent} from './main-menu-selection.component';

describe('MainMenuSelectionComponent', () => {
  let component: MainMenuSelectionComponent;
  let fixture: ComponentFixture<MainMenuSelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MainMenuSelectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MainMenuSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
