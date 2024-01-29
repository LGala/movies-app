import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MoviesTableComponent } from './movies-table/movies-table.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MoviesTableComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.less'
})
export class AppComponent {
  constructor() { }
}
