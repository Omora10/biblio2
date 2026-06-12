import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

interface BookItem {
  title: string;
  author: string;
  isbn: string;
  status: 'Disponible' | 'Prestado' | 'En Mantenimiento';
  coverUrl: string;
}

@Component({
  selector: 'app-inventario-list',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './inventario-list.component.html',
  styleUrl: './inventario-list.component.css'
})
export class InventarioListComponent {
  authors = ['Todos los autores', 'Gabriel Garcia Marquez', 'Isabel Allende', 'Jorge Luis Borges'];
  genres = ['Cualquier genero', 'Realismo Magico', 'Ficcion Historica', 'Ensayo', 'Ciencia Ficcion'];
  statusFilters = ['Todos', 'Disponible', 'Prestado'];

  books: BookItem[] = [
    {
      title: 'Cien Anos de Soledad',
      author: 'Gabriel Garcia Marquez',
      isbn: '978-0307350',
      status: 'Disponible',
      coverUrl:
        'https://lh3.googleusercontent.com/aida-public/AB6AXuA237d9Hh7IpHVzPDZXUN4mRy0URUjJmuBUjPXIvCF31EbgPemDUIJ04jYgVIo4sTVb735SX_wfkJ9n_nhbIDbY9eTrJR43LIUqHHH8geLsSyrbltN-BNPwa_6Y7RWPe4Mj1W_p4eJlfpTJd3oWpeiaRmJ6qvm_--pdPCTPeaGEoRLdrpoT7pExwsavJ8X8lUjsJjIxZ1wKgwsg_QvJvJG8p4BFS7yxcMLvinSqCZV_sjT3zc2dc-6JnEZEF6oXyy3W2gKLzkl-zRc'
    },
    {
      title: 'La Casa de los Espiritus',
      author: 'Isabel Allende',
      isbn: '978-8401341',
      status: 'Prestado',
      coverUrl:
        'https://lh3.googleusercontent.com/aida-public/AB6AXuCBQAh008RBIdPaBOGZo9DTRZHym3BJUMzgbC9sk5QFuvtS_paIVa_0XgKLIchwgtDO0TYg1Ai6fHnrZ2ASwgqhWOjOwg5ktEHdE1bai65oBkyFk4hHM_6_dHpXNwzZK0upF1ta18T4NdbO2vWRTJwfzYi0-8lCRO1zsYARXmf38I0kz_ae6Vk3WmaKyGop_rN99l2cdlWZRHg60xu14JgmaPRgvd0gPC4Oo0ARrmGd1KHm9hIw802xVud-QviDPW-PHQsa5Rp9w_k'
    },
    {
      title: 'Ficciones',
      author: 'Jorge Luis Borges',
      isbn: '978-8420633',
      status: 'En Mantenimiento',
      coverUrl:
        'https://lh3.googleusercontent.com/aida-public/AB6AXuDeJGOr-_iYDARB7DTvSZ-CBjLpQHqW3TjbIENRQUt0J-Kvn0rYHSQN8HuEIktSZfU52ZnNoVPTjNrhMaJYaayFhrikDw9nJy5Am5Tsq6S8wNi15JXq2YHs_7Q0_vCqyw72-dfN43fUBEJMOxsBZkitrozldg8QeqEyxA-vdiZamj4uBOx_e02ekfAMnJawIhPqvv7Vo6-QFUNoGk9UMAnAQexeYZ3z4EsoCR05bCFH47Gyu9OjaXJn7YOz_zip2a-X_-TpTWwIhM8'
    },
    {
      title: 'Cronica de una Muerte Anunciada',
      author: 'Gabriel Garcia Marquez',
      isbn: '978-1400034',
      status: 'Disponible',
      coverUrl:
        'https://lh3.googleusercontent.com/aida-public/AB6AXuBOvfXUnh4BqaXq9oxvKzGfTsFUhBL7D4qz7sJSxRYMbgjKw9dGrSwOQzMf7Xtn0S7bzaX_XoPu5wQR4oROXggFV1EvTjQ2JplZPoxW6mc9rxBxYDU3PUnUzgqCFH1m1_iCwmuM7stH6NbJKqqKo02UzZJFgPWwHvVHD5V8csMwfcsNGBIh5cp6NsQA1H25E2dpleu_OvUQDSZwc0qkTWYjmntTKLu-ZmH0CrgupHaq5F0iimhCyZ52b6hYoqMpk4rg5p8vcbZ5YMU'
    },
    {
      title: 'El Aleph',
      author: 'Jorge Luis Borges',
      isbn: '978-0141183',
      status: 'Disponible',
      coverUrl:
        'https://lh3.googleusercontent.com/aida-public/AB6AXuCffRyp3-0e6YuEmGUt6F9eGpFIbI_EYPQQzrXai3os63Ar7N8HzlL6Br8BTM9YxXSdpDIT3N2T21OZkVPn8_ze4fwcZAPFoCSMYuzx2-fFTtxzOohUdw3-gcmCLoWgVlD3t-RGNkaSbq0BfGj6ICBz9_MPPSz4tONFbcMgMfMNyRSSFQDqi467eND-_mJyEGYuNlcn9mAan6QwfHF18EHPl7-E3VQvfjMbmHdzWXcZY8NxOzVsO4s1AYupbmrQMtGClK6CYEVa0nA'
    },
    {
      title: 'Eva Luna',
      author: 'Isabel Allende',
      isbn: '978-0553280',
      status: 'Prestado',
      coverUrl:
        'https://lh3.googleusercontent.com/aida-public/AB6AXuD5WQHHQQ9mcEUPzhjieZGdnpaJZFblmI5SHdD-SxCBfWG-MYVK6cknGIyziCRYIT1CC2Fb_SX9sLvezRmbC_9nSLLeKT6y1nr7kHVa-ipNLveF9d2RIliGYRMMKVKeImjHlR2H92tOf1MJAxkDVkDbIcyGN4KA-Lq2zDJHFZkEv82n6kGBXqviyWeBsuBVcDO2mBpOqbBeL9Dq9uAwod2FH2HxWhuggZtr6J5vG4gyBW9KVEwn0VSW9arRpsR37d4ih6-VWNRZYFQ'
    }
  ];

  pages = ['1', '2', '3', '...'];
}
