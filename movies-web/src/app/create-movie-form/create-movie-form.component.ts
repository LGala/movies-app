import { Component } from '@angular/core';
import { MovieFormComponent } from '../movie-form/movie-form.component';

@Component({
  selector: 'app-create-movie-form',
  standalone: true,
  imports: [MovieFormComponent],
  templateUrl: './create-movie-form.component.html',
  styleUrl: './create-movie-form.component.less'
})
export class CreateMovieFormComponent {
  constructor() { }
}
