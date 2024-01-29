import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Movie } from './domain/movie';
import { MoviesService } from '../movies.service';
import { Router } from '@angular/router';
import { editMoviePath, newMoviePath } from '../app.routes';

@Component({
  selector: 'app-movies-table',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './movies-table.component.html',
  styleUrl: './movies-table.component.less'
})
export class MoviesTableComponent {
  movies: Movie[] = [];

  constructor(private moviesService: MoviesService, private router: Router) { }

  ngOnInit() {
    this.movies = this.moviesService.getMovies();
  }

  createNewMovie() {
    this.router.navigate([newMoviePath]);
  }

  editMovie() {
    this.router.navigate([editMoviePath]);
  }

}
