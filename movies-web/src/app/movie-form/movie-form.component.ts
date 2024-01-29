import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-movie-form',
  standalone: true,
  imports: [],
  templateUrl: './movie-form.component.html',
  styleUrl: './movie-form.component.less'
})
export class MovieFormComponent {
  @Input() title = '';

  @Input() buttonText = '';
}
