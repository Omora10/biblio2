import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  template: `
    <section class="page">
      <h2>Panel de Control</h2>
      <p>Resumen general de la biblioteca.</p>
    </section>
  `
})
export class DashboardComponent {}
