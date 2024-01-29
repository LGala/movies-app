import { Routes } from '@angular/router';
import { CreateMovieFormComponent } from './create-movie-form/create-movie-form.component';
import { MoviesTableComponent } from './movies-table/movies-table.component';
import { EditMovieFormComponent } from './edit-movie-form/edit-movie-form.component';

export const {
  dashboardPath,
  newMoviePath,
  editMoviePath
} = {
  dashboardPath: '',
  newMoviePath: 'movies/new',
  editMoviePath: 'movies/edit',
};


export const routes: Routes = [
  { path: dashboardPath, component: MoviesTableComponent },
  { path: newMoviePath, component: CreateMovieFormComponent },
  { path: editMoviePath, component: EditMovieFormComponent },
];
