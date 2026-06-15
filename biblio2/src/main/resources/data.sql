INSERT INTO libros (titulo, autor, isbn, prestado) VALUES
                                                       ('Cien años de soledad', 'Gabriel Garcia Marquez', '978-9584236821', false),
                                                       ('Don Quijote de la Mancha', 'Miguel de Cervantes', '978-8491050277', false),
                                                       ('La casa de los espiritus', 'Isabel Allende', '978-8401352898', false),
                                                       ('Ficciones', 'Jorge Luis Borges', '978-8420633318', false),
                                                       ('El amor en los tiempos del colera', 'Gabriel Garcia Marquez', '978-0307389732', false),
                                                       ('Rayuela', 'Julio Cortazar', '978-8437604572', false),
                                                       ('Pedro Paramo', 'Juan Rulfo', '978-8437604183', false),
                                                       ('La ciudad y los perros', 'Mario Vargas Llosa', '978-8466333753', false),
                                                       ('El tunel', 'Ernesto Sabato', '978-8432216428', false),
                                                       ('Maria', 'Jorge Isaacs', '978-9583000454', false);

INSERT INTO usuarios (nombre, email, password) VALUES
                                                   ('Administrador', 'admin@biblio.com', '123456'),
                                                   ('Ana Perez', 'ana@biblio.com', '123456'),
                                                   ('Carlos Ruiz', 'carlos@biblio.com', '123456'),
                                                   ('Elena Martinez', 'elena@biblio.com', '123456'),
                                                   ('Juan Garcia', 'juan@biblio.com', '123456');

INSERT INTO prestamos (usuario_id, libro_id, fecha_prestamo, fecha_devolucion, devuelto) VALUES
                                                                                             (2, 1, DATE '2026-06-10', NULL, false),
                                                                                             (3, 2, DATE '2026-06-11', NULL, false),
                                                                                             (4, 3, DATE '2026-06-01', DATE '2026-06-12', true);

UPDATE libros SET prestado = true WHERE id IN (1, 2);