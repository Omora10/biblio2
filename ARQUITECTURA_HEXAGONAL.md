# Arquitectura Hexagonal - Proyecto Biblio2

## 📋 Descripción General

Este proyecto implementa una **arquitectura hexagonal (Ports & Adapters)** con Spring Boot, separando claramente tres capas:

1. **Dominio (Domain)** - Lógica de negocio pura
2. **Aplicación (Application)** - Casos de uso y orquestación
3. **Infraestructura (Infrastructure)** - Detalles técnicos (BD, REST, etc.)

---

## 🏗️ Estructura de Carpetas

```
src/main/java/com/biblio2/biblio2/
│
├── domain/                          # ❌ SIN dependencias de Spring
│   ├── entity/
│   │   └── Libro.java              # Entidad de dominio pura
│   ├── port/
│   │   └── LibroRepositoryPort.java # Puerto (interfaz) de persistencia
│   └── usecase/
│       ├── CrearLibroUseCase.java
│       ├── ObtenerLibrosUseCase.java
│       ├── ObtenerLibroPorIdUseCase.java
│       ├── EliminarLibroUseCase.java
│       └── ActualizarLibroUseCase.java
│
├── application/                     # 📦 Implementa casos de uso
│   ├── service/
│   │   └── LibroApplicationService.java  # Implementa todos los casos de uso
│   └── exception/
│       └── LibroNoEncontradoException.java
│
└── infrastructure/                  # 🔌 Detalles técnicos
    ├── persistence/
    │   ├── entity/
    │   │   └── LibroEntity.java     # Entidad JPA (BD)
    │   ├── repository/
    │   │   └── LibroJpaRepository.java  # Repositorio Spring Data JPA
    │   └── adapter/
    │       └── LibroRepositoryAdapter.java  # Adapta puerto al JPA
    └── rest/
        ├── controller/
        │   └── LibroController.java  # Controlador REST
        ├── dto/
        │   ├── LibroRequest.java
        │   └── LibroResponse.java
        └── exception/
            └── GlobalExceptionHandler.java  # Manejo global de errores
```

---

## 🔄 Flujo de Información

### 1️⃣ Solicitud HTTP (Entrada)

```
POST /api/libros
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}
  ↓
LibroController (REST)
```

### 2️⃣ Capa de Infraestructura (Entrada)

```
LibroController
  ↓
Recibe LibroRequest (DTO)
  ↓
Mapea a parámetros del caso de uso
  ↓
Inyecta CrearLibroUseCase
```

### 3️⃣ Capa de Aplicación

```
LibroApplicationService (implementa CrearLibroUseCase)
  ↓
public Libro ejecutar(String titulo, String autor, String isbn)
  ↓
Crea nueva instancia: new Libro(titulo, autor, isbn)
  ↓
Delega al puerto: libroRepository.guardar(libro)
```

### 4️⃣ Capa de Dominio

```
Libro libro = new Libro(titulo, autor, isbn)
  ↓
LibroRepositoryPort.guardar(libro)
  ↓
(Sin conocer CÓMO se guarda, solo QUÉ se guarda)
```

### 5️⃣ Capa de Infraestructura (Salida)

```
LibroRepositoryAdapter (implementa LibroRepositoryPort)
  ↓
Mapea Libro → LibroEntity
  ↓
Llama: jpaRepository.save(entity)
  ↓
JPA persiste en H2
```

### 6️⃣ Respuesta HTTP

```
LibroEntity guardada
  ↓
Mapea de vuelta a Libro
  ↓
LibroController mapea Libro → LibroResponse
  ↓
Spring serializa a JSON
  ↓
Respuesta 201 CREATED
{
  "id": 1,
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

---

## 📡 Endpoints REST Disponibles

### 1. Crear Libro
```
POST /api/libros
Content-Type: application/json

{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}

Respuesta: 201 CREATED
```

### 2. Obtener Todos los Libros
```
GET /api/libros

Respuesta: 200 OK
[
  {
    "id": 1,
    "titulo": "Clean Code",
    "autor": "Robert C. Martin",
    "isbn": "978-0132350884"
  }
]
```

### 3. Obtener un Libro por ID
```
GET /api/libros/1

Respuesta: 200 OK
{
  "id": 1,
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

### 4. Actualizar un Libro
```
PUT /api/libros/1
Content-Type: application/json

{
  "titulo": "Clean Code Updated",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}

Respuesta: 200 OK
```

### 5. Eliminar un Libro
```
DELETE /api/libros/1

Respuesta: 204 NO CONTENT
```

---

## 🎯 Principios de la Arquitectura Hexagonal

### ✅ Separación de Responsabilidades

| Capa | Responsabilidad | Dependencias |
|------|-----------------|-------------|
| **Domain** | Lógica de negocio pura | Ninguna |
| **Application** | Orquestar casos de uso | Domain |
| **Infrastructure** | Detalles técnicos | Domain, Application |

### ✅ Inversión de Dependencias

- El **Dominio** no conoce ni de Spring, ni de JPA, ni de REST
- El **Dominio** define interfaces (puertos)
- La **Infraestructura** implementa esas interfaces (adaptadores)
- La **Aplicación** usa los puertos

### ✅ Independencia de Frameworks

Si necesitas cambiar de JPA a MongoDB:
- Solo modificas `LibroRepositoryAdapter`
- El dominio y la aplicación permanecen iguales

Si necesitas cambiar de REST a gRPC:
- Solo modificas `LibroController`
- El dominio y la aplicación permanecen iguales

---

## 🚀 Características Implementadas

### Dominio
- ✅ Entidad `Libro` sin anotaciones de Spring
- ✅ Puerto `LibroRepositoryPort` (interfaz de persistencia)
- ✅ 5 casos de uso (interfaces)

### Aplicación
- ✅ Servicio `LibroApplicationService` (implementa todos los casos de uso)
- ✅ Excepción personalizada `LibroNoEncontradoException`
- ✅ Inyección de dependencias limpia

### Infraestructura
- ✅ Entidad JPA `LibroEntity` con mapeo a tabla `libros`
- ✅ Repositorio Spring Data `LibroJpaRepository`
- ✅ Adaptador `LibroRepositoryAdapter` (conecta dominio con JPA)
- ✅ Controlador REST `LibroController` (CRUD completo)
- ✅ DTOs `LibroRequest` y `LibroResponse`
- ✅ Manejador global de excepciones
- ✅ Base de datos H2 en memoria

---

## 💾 Configuración de Base de Datos (H2)

```properties
# En-memoria, se elimina al reiniciar
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# Consola web en: http://localhost:8080/h2-console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Crear tabla automáticamente
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
```

---

## 🔧 Cómo Ejecutar

### 1. Compilar
```bash
cd biblio2
mvnw clean compile
```

### 2. Ejecutar la aplicación
```bash
mvnw spring-boot:run
```

### 3. Probar los endpoints
```bash
# Crear un libro
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Clean Code",
    "autor": "Robert C. Martin",
    "isbn": "978-0132350884"
  }'

# Obtener todos
curl http://localhost:8080/api/libros

# Obtener uno
curl http://localhost:8080/api/libros/1

# Actualizar
curl -X PUT http://localhost:8080/api/libros/1 \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Clean Code V2",
    "autor": "Robert C. Martin",
    "isbn": "978-0132350884"
  }'

# Eliminar
curl -X DELETE http://localhost:8080/api/libros/1
```

### 4. Acceder a la consola H2
```
http://localhost:8080/h2-console
```

---

## 📚 Casos de Uso Implementados

### 1. CrearLibroUseCase
```java
Entrada: String titulo, String autor, String isbn
Salida: Libro (con ID asignado)
Proceso: Valida y persiste un nuevo libro
```

### 2. ObtenerLibrosUseCase
```java
Entrada: (ninguna)
Salida: List<Libro>
Proceso: Obtiene todos los libros registrados
```

### 3. ObtenerLibroPorIdUseCase
```java
Entrada: Long id
Salida: Libro
Proceso: Obtiene un libro específico o lanza excepción si no existe
```

### 4. ActualizarLibroUseCase
```java
Entrada: Long id, String titulo, String autor, String isbn
Salida: Libro (actualizado)
Proceso: Modifica un libro existente
```

### 5. EliminarLibroUseCase
```java
Entrada: Long id
Salida: (void)
Proceso: Elimina un libro del repositorio
```

---

## 🧪 Extensiones Futuras

### Fácil de agregar sin modificar capas existentes:

1. **Autenticación/Autorización**
   - Agregar al controlador con `@PreAuthorize`

2. **Validación**
   - Agregar al servicio de aplicación

3. **Auditoría**
   - Agregar columnas de auditoría a `LibroEntity`

4. **Caché**
   - Agregar `@Cacheable` al servicio

5. **Logging**
   - Agregar logs en el servicio de aplicación

6. **Búsqueda avanzada**
   - Agregar métodos a `LibroJpaRepository`

---

## 📖 Referencias

- [Clean Code de Robert C. Martin](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)
- [Arquitectura Hexagonal - Alistair Cockburn](https://alistair.cockburn.us/hexagonal-architecture/)
- [Spring Boot Best Practices](https://spring.io/guides)

---

**Última actualización:** 31/03/2026
**Versión:** 1.0
**Autor:** GitHub Copilot

