import { Component } from '@angular/core';
import { MovieFormComponent } from '../movie-form/movie-form.component';

@Component({
  selector: 'app-edit-movie-form',
  standalone: true,
  imports: [MovieFormComponent],
  templateUrl: './edit-movie-form.component.html',
  styleUrl: './edit-movie-form.component.less'
})
export class EditMovieFormComponent {

}
