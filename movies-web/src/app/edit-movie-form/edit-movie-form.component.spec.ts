import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMovieFormComponent } from './edit-movie-form.component';

describe('EditMovieFormComponent', () => {
  let component: EditMovieFormComponent;
  let fixture: ComponentFixture<EditMovieFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditMovieFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditMovieFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
