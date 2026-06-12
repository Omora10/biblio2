import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-inventario-list',
  standalone: true,
  imports: [RouterLink],
  template: `
    <section class="page">
      <h2>Inventario</h2>
      <p>Listado de libros del catalogo.</p>
      <a routerLink="/inventario/nuevo">Nuevo libro</a>
    </section>
  `
})
export class InventarioListComponent {}
