# 🏗️ Diagrama de Arquitectura Hexagonal - Biblio2

## Vista General de Capas

```
╔════════════════════════════════════════════════════════════════════════════╗
║                          ENTRADA HTTP (REST)                              ║
║                                                                            ║
║                     POST /api/libros (LibroRequest)                       ║
║                            │                                             ║
║                            ▼                                             ║
╚════════════════════════════════════════════════════════════════════════════╝

╔════════════════════════════════════════════════════════════════════════════╗
║               INFRAESTRUCTURA - PUERTO DE ENTRADA (REST)                  ║
║                                                                            ║
║  ┌────────────────────────────────────────────────────────────────────┐  ║
║  │                      LibroController                               │  ║
║  │  POST /api/libros                                                 │  ║
║  │  GET /api/libros                                                  │  ║
║  │  GET /api/libros/{id}                                             │  ║
║  │  PUT /api/libros/{id}                                             │  ║
║  │  DELETE /api/libros/{id}                                          │  ║
║  └────────────────────────────────────────────────────────────────────┘  ║
║                                                                            ║
║  ┌────────────────┐               ┌────────────────┐                     ║
║  │ LibroRequest   │               │ LibroResponse  │                     ║
║  │ (DTO entrada)  │               │ (DTO salida)   │                     ║
║  └────────────────┘               └────────────────┘                     ║
║                                                                            ║
│                    GlobalExceptionHandler (manejo global)                │
╚════════════════════════════════════════════════════════════════════════════╝
                                   │
                                   │ Depende de casos de uso
                                   ▼

╔════════════════════════════════════════════════════════════════════════════╗
║                    CAPA DE APLICACIÓN                                     ║
║            (Orquestación de lógica de negocio)                            ║
║                                                                            ║
║  ┌────────────────────────────────────────────────────────────────────┐  ║
║  │              LibroApplicationService                               │  ║
║  │  implements:                                                       │  ║
║  │    ├── CrearLibroUseCase                                          │  ║
║  │    ├── ObtenerLibrosUseCase                                       │  ║
║  │    ├── ObtenerLibroPorIdUseCase                                   │  ║
║  │    ├── ActualizarLibroUseCase                                     │  ║
║  │    └── EliminarLibroUseCase                                       │  ║
║  │                                                                   │  ║
║  │  Métodos principales:                                            │  ║
║  │    • crear(titulo, autor, isbn): Libro                           │  ║
║  │    • obtenerTodos(): List<Libro>                                 │  ║
║  │    • obtenerPorId(id): Libro                                     │  ║
║  │    • actualizar(id, titulo, autor, isbn): Libro                 │  ║
║  │    • eliminar(id): void                                          │  ║
║  └────────────────────────────────────────────────────────────────────┘  ║
║                                                                            ║
║  ┌────────────────────────────────────────────────────────────────────┐  ║
║  │           LibroNoEncontradoException (excepción)                  │  ║
║  └────────────────────────────────────────────────────────────────────┘  ║
║                                                                            ║
║  ✅ Depende SOLO de: Domain                                              ║
║  ✅ Sin Spring annotations (salvo @Service)                              ║
║  ✅ Inyecta puerto LibroRepositoryPort                                   ║
╚════════════════════════════════════════════════════════════════════════════╝
                                   │
                                   │ Usa puerto
                                   ▼

╔════════════════════════════════════════════════════════════════════════════╗
║                    CAPA DE DOMINIO (PURA)                                 ║
║         Lógica de negocio sin conocer detalles técnicos                   ║
║                                                                            ║
║  ┌────────────────────────────────────────────────────────────────────┐  ║
║  │                      Libro (Entity)                                │  ║
║  │  ┌─────────────────────────────────────────────────────────────┐  │  ║
║  │  │  - id: Long                                                 │  │  ║
║  │  │  - titulo: String                                           │  │  ║
║  │  │  - autor: String                                            │  │  ║
║  │  │  - isbn: String                                             │  │  ║
║  │  │                                                             │  │  ║
║  │  │  + getId()                                                  │  │  ║
║  │  │  + getTitulo()                                              │  │  ║
║  │  │  + getAutor()                                               │  │  ║
║  │  │  + getIsbn()                                                │  │  ║
║  │  │  ... getters y setters                                      │  │  ║
║  │  └─────────────────────────────────────────────────────────────┘  │  ║
║  └────────────────────────────────────────────────────────────────────┘  ║
║                                                                            ║
║  ┌────────────────────────────────────────────────────────────────────┐  ║
║  │              PUERTO (Interface del Dominio)                        │  ║
║  │                                                                    │  ║
║  │  ┌────────────────────────────────────────────────────────────┐   │  ║
║  │  │        LibroRepositoryPort                                 │   │  ║
║  │  │                                                             │   │  ║
║  │  │  + guardar(Libro): Libro                                   │   │  ║
║  │  │  + obtenerPorId(Long): Optional<Libro>                     │   │  ║
║  │  │  + obtenerTodos(): List<Libro>                             │   │  ║
║  │  │  + eliminar(Long): void                                    │   │  ║
║  │  │  + existe(Long): boolean                                   │   │  ║
║  │  │  + actualizar(Libro): Libro                                │   │  ║
║  │  └────────────────────────────────────────────────────────────┘   │  ║
║  └────────────────────────────────────────────────────────────────────┘  ║
║                                                                            ║
║  ┌────────────────────────────────────────────────────────────────────┐  ║
║  │                  CASOS DE USO (Interfaces)                         │  ║
║  │                                                                    │  ║
║  │  ┌──────────────────────────────────────────────────────────────┐ │  ║
║  │  │ CrearLibroUseCase                                            │ │  ║
║  │  │ + ejecutar(titulo, autor, isbn): Libro                       │ │  ║
║  │  └──────────────────────────────────────────────────────────────┘ │  ║
║  │                                                                    │  ║
║  │  ┌──────────────────────────────────────────────────────────────┐ │  ║
║  │  │ ObtenerLibrosUseCase                                         │ │  ║
║  │  │ + ejecutar(): List<Libro>                                    │ │  ║
║  │  └──────────────────────────────────────────────────────────────┘ │  ║
║  │                                                                    │  ║
║  │  ┌──────────────────────────────────────────────────────────────┐ │  ║
║  │  │ ObtenerLibroPorIdUseCase                                     │ │  ║
║  │  │ + ejecutar(id): Libro                                        │ │  ║
║  │  └──────────────────────────────────────────────────────────────┘ │  ║
║  │                                                                    │  ║
║  │  ┌──────────────────────────────────────────────────────────────┐ │  ║
║  │  │ ActualizarLibroUseCase                                       │ │  ║
║  │  │ + ejecutar(id, titulo, autor, isbn): Libro                  │ │  ║
║  │  └──────────────────────────────────────────────────────────────┘ │  ║
║  │                                                                    │  ║
║  │  ┌──────────────────────────────────────────────────────────────┐ │  ║
║  │  │ EliminarLibroUseCase                                         │ │  ║
║  │  │ + ejecutar(id): void                                         │ │  ║
║  │  └──────────────────────────────────────────────────────────────┘ │  ║
║  └────────────────────────────────────────────────────────────────────┘  ║
║                                                                            ║
║  ✅ SIN ANOTACIONES DE SPRING                                             ║
║  ✅ SIN DEPENDENCIAS DE INFRAESTRUCTURA                                   ║
║  ✅ COMPLETAMENTE AGNÓSTICO                                              ║
╚════════════════════════════════════════════════════════════════════════════╝
                                   │
              Implementación del puerto (adaptador)
                                   ▼

╔════════════════════════════════════════════════════════════════════════════╗
║           INFRAESTRUCTURA - PUERTO DE SALIDA (Persistencia)               ║
║                                                                            ║
║  ┌────────────────────────────────────────────────────────────────────┐  ║
║  │               LibroRepositoryAdapter                               │  ║
║  │          implements LibroRepositoryPort                            │  ║
║  │                                                                    │  ║
║  │  Responsabilidades:                                               │  ║
║  │  1. Recibe Libro (dominio)                                        │  ║
║  │  2. Mapea a LibroEntity (JPA)                                     │  ║
║  │  3. Usa LibroJpaRepository                                        │  ║
║  │  4. Mapea respuesta de vuelta a Libro                             │  ║
║  │                                                                    │  ║
║  │  ┌─────────────────────┐         ┌──────────────────────────┐   │  ║
║  │  │ Libro (Dominio)     │◄───────►│ LibroEntity (JPA)        │   │  ║
║  │  │                     │ Mapeo   │                          │   │  ║
║  │  └─────────────────────┘         └──────────────────────────┘   │  ║
║  │                                             │                    │  ║
║  │                                             ▼                    │  ║
║  │                      ┌──────────────────────────────────────┐   │  ║
║  │                      │  LibroJpaRepository                  │   │  ║
║  │                      │  extends JpaRepository               │   │  ║
║  │                      │                                      │   │  ║
║  │                      │  Métodos heredados:                  │   │  ║
║  │                      │  • save()                            │   │  ║
║  │                      │  • findById()                        │   │  ║
║  │                      │  • findAll()                         │   │  ║
║  │                      │  • deleteById()                      │   │  ║
║  │                      │  • existsById()                      │   │  ║
║  │                      │  • etc.                              │   │  ║
║  │                      └──────────────────────────────────────┘   │  ║
║  └────────────────────────────────────────────────────────────────────┘  ║
║                                                                            ║
║  ┌────────────────────────────────────────────────────────────────────┐  ║
║  │                     LibroEntity (JPA)                              │  ║
║  │  ┌────────────────────────────────────────────────────────────┐   │  ║
║  │  │  @Entity                                                  │   │  ║
║  │  │  @Table(name = "libros")                                  │   │  ║
║  │  │                                                            │   │  ║
║  │  │  - @Id Long id                                            │   │  ║
║  │  │  - @Column String titulo                                  │   │  ║
║  │  │  - @Column String autor                                   │   │  ║
║  │  │  - @Column String isbn (unique=true)                      │   │  ║
║  │  │                                                            │   │  ║
║  │  │  + getters/setters                                         │   │  ║
║  │  └────────────────────────────────────────────────────────────┘   │  ║
║  └────────────────────────────────────────────────────────────────────┘  ║
║                                                                            ║
║  ✅ Implementa LibroRepositoryPort                                        ║
║  ✅ Traduce entre Dominio e Infraestructura                              ║
║  ✅ Patrón Adapter (Hexagonal)                                           ║
╚════════════════════════════════════════════════════════════════════════════╝
                                   │
                                   │ Persistencia
                                   ▼

╔════════════════════════════════════════════════════════════════════════════╗
║                      BASE DE DATOS H2 (En Memoria)                        ║
║                                                                            ║
║  ┌────────────────────────────────────────────────────────────────────┐  ║
║  │ Tabla: libros                                                      │  ║
║  │                                                                    │  ║
║  │ ┌──────┬──────────────────────┬─────────────────┬──────────────┐  │  ║
║  │ │ id   │ titulo               │ autor           │ isbn         │  │  ║
║  │ ├──────┼──────────────────────┼─────────────────┼──────────────┤  │  ║
║  │ │ 1    │ Clean Code           │ Robert Martin   │ 978-0132... │  │  ║
║  │ │ 2    │ Design Patterns      │ Gang of Four    │ 978-0201... │  │  ║
║  │ │ 3    │ Refactoring          │ Martin Fowler   │ 978-0201... │  │  ║
║  │ └──────┴──────────────────────┴─────────────────┴──────────────┘  │  ║
║  └────────────────────────────────────────────────────────────────────┘  ║
║                                                                            ║
║  jdbc:h2:mem:testdb (En memoria, se elimina al reiniciar)                ║
╚════════════════════════════════════════════════════════════════════════════╝
```

---

## 🔄 Flujo Completo de una Solicitud POST

```
USUARIO
  │
  ├─ POST /api/libros
  │  Content-Type: application/json
  │  {
  │    "titulo": "Clean Code",
  │    "autor": "Robert C. Martin",
  │    "isbn": "978-0132350884"
  │  }
  │
  ▼

INFRAESTRUCTURA REST
  │
  ├─ LibroController @PostMapping("/api/libros")
  ├─ Recibe: LibroRequest request
  ├─ Deserializa JSON → LibroRequest object
  │
  ▼

APLICACIÓN
  │
  ├─ Inyecta: CrearLibroUseCase (que es LibroApplicationService)
  ├─ Llama: crearLibroUseCase.ejecutar(
  │            "Clean Code",
  │            "Robert C. Martin",
  │            "978-0132350884"
  │         )
  │
  ▼

LibroApplicationService (Implementa CrearLibroUseCase)
  │
  ├─ Crea entidad dominio: new Libro("Clean Code", "Robert C. Martin", "978-0132350884")
  ├─ Inyecta puerto: LibroRepositoryPort libroRepository
  ├─ Llama: libroRepository.guardar(libro)
  │
  ▼

DOMINIO
  │
  ├─ Puerto: LibroRepositoryPort.guardar(Libro)
  │ (El dominio NO sabe QUÉ implementa este puerto)
  │
  ▼

LibroRepositoryAdapter (Implementa LibroRepositoryPort)
  │
  ├─ Recibe: Libro (objeto de dominio)
  ├─ Mapea a: new LibroEntity("Clean Code", "Robert C. Martin", "978-0132350884")
  ├─ Inyecta: LibroJpaRepository jpaRepository
  ├─ Llama: jpaRepository.save(libroEntity)
  │
  ▼

LibroJpaRepository (Spring Data JPA)
  │
  ├─ Recibe: LibroEntity (anotada con @Entity, @Table)
  ├─ Genera SQL: INSERT INTO libros (titulo, autor, isbn) VALUES (?, ?, ?)
  ├─ Ejecuta contra base de datos
  │
  ▼

BASE DE DATOS H2
  │
  ├─ Inserta fila en tabla 'libros'
  ├─ Genera ID: 1
  ├─ Retorna LibroEntity con ID asignado
  │
  ▼

LibroRepositoryAdapter
  │
  ├─ Recibe: LibroEntity (con ID = 1)
  ├─ Mapea a: Libro(1, "Clean Code", "Robert C. Martin", "978-0132350884")
  ├─ Retorna: Libro objeto
  │
  ▼

LibroApplicationService
  │
  ├─ Retorna: Libro guardado
  │
  ▼

LibroController
  │
  ├─ Recibe: Libro (id=1, titulo="Clean Code", ...)
  ├─ Mapea a: LibroResponse(1, "Clean Code", "Robert C. Martin", "978-0132350884")
  ├─ Serializa a: JSON
  │
  ▼

RESPUESTA HTTP
  │
  ├─ Status: 201 CREATED
  ├─ Content-Type: application/json
  ├─ Body:
  │  {
  │    "id": 1,
  │    "titulo": "Clean Code",
  │    "autor": "Robert C. Martin",
  │    "isbn": "978-0132350884"
  │  }
  │
  ▼

USUARIO
  (Recibe respuesta satisfactoria)
```

---

## 🧩 Patrón Adapter (Hexagonal)

```
           DOMINIO
           (Puro)
              △
              │
              │ Puerto
              │
    ┌─────────┼─────────┐
    │         │         │
    │  ADAPTER ▼         │
    │                   │
    │ LibroRepository   │
    │ Adapter           │
    │                   │
    └─────────┼─────────┘
              │
              │ Implementa
              │
          JPA/H2
         (Técnico)
```

**Ventaja Principal:**
- Si necesitas cambiar JPA por MongoDB, solo cambias el Adapter
- El dominio y la aplicación nunca se entean del cambio

---

## 📊 Matriz de Dependencias

```
┌──────────────────┬─────────────┬──────────────┬────────────────┐
│ Capa             │ Depende de  │ Usa Anotaciones de | Testeable │
├──────────────────┼─────────────┼──────────────┼────────────────┤
│ Domain           │ Nada        │ NO (@Entity) │ ✅ SÍ          │
├──────────────────┼─────────────┼──────────────┼────────────────┤
│ Application      │ Domain      │ SI (@Service)│ ✅ SÍ          │
├──────────────────┼─────────────┼──────────────┼────────────────┤
│ Infrastructure   │ Domain +    │ SI           │ ✅ SÍ          │
│                  │ Application │ (@Component, │                │
│                  │             │  @Entity)    │                │
└──────────────────┴─────────────┴──────────────┴────────────────┘
```

---

## 🎯 Principios Respetados

```
┌────────────────────────────────────────────────────────────┐
│ 1. SEPARACIÓN DE RESPONSABILIDADES                         │
│    ✅ Dominio = Lógica de negocio                         │
│    ✅ Aplicación = Orquestación                           │
│    ✅ Infraestructura = Detalles técnicos                 │
└────────────────────────────────────────────────────────────┘

┌────────────────────────────────────────────────────────────┐
│ 2. INVERSIÓN DE DEPENDENCIAS                               │
│    ✅ Las capas altas NO dependen de las bajas            │
│    ✅ Dominio = Centro independiente                      │
│    ✅ Infraestructura implementa puertos del dominio      │
└────────────────────────────────────────────────────────────┘

┌────────────────────────────────────────────────────────────┐
│ 3. BAJO ACOPLAMIENTO                                       │
│    ✅ Cambiar JPA no afecta dominio                       │
│    ✅ Cambiar REST no afecta dominio                      │
│    ✅ Cada capa es intercambiable                         │
└────────────────────────────────────────────────────────────┘

┌────────────────────────────────────────────────────────────┐
│ 4. ALTA COHESIÓN                                           │
│    ✅ Cada capa tiene responsabilidad clara                │
│    ✅ Métodos relacionados están agrupados                │
│    ✅ No hay código esparcido                             │
└────────────────────────────────────────────────────────────┘

┌────────────────────────────────────────────────────────────┐
│ 5. TESTABILIDAD                                            │
│    ✅ Mock fácil del repositorio                          │
│    ✅ Servicios sin dependencias reales                   │
│    ✅ Cada componente independiente                       │
└────────────────────────────────────────────────────────────┘
```

---

**Diagrama actualizado:** 31/03/2026

