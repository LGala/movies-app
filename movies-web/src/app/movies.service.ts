import { Injectable } from '@angular/core';
import { Movie } from './movies-table/domain/movie';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  constructor() { }

  getMovies(): Movie[] {
    return [
      {
        title: 'title1',
        releaseDate: 'releaseDate1',
        voteAverage: 1,
        hasVideoFormat: false
      },
      {
        title: 'title2',
        releaseDate: 'releaseDate2',
        voteAverage: 2,
        hasVideoFormat: true
      },
      {
        title: 'title3',
        releaseDate: 'releaseDate3',
        voteAverage: 3,
        hasVideoFormat: false
      }
    ]
  }

  addMovie(movie: Movie): void {

  }
}
