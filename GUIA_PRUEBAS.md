# 🧪 Guía de Pruebas - API REST de Libros

## Requisitos Previos

- El servidor debe estar ejecutándose en `http://localhost:8080`
- Herramienta de pruebas: cURL, Postman o similar

---

## 📍 Base URL
```
http://localhost:8080
```

---

## 🎯 Endpoints y Ejemplos

### 1️⃣ CREAR UN LIBRO (POST)

**Endpoint:**
```
POST /api/libros
```

**Headers:**
```
Content-Type: application/json
```

**Body (JSON):**
```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Clean Code",
    "autor": "Robert C. Martin",
    "isbn": "978-0132350884"
  }'
```

**Respuesta Esperada (201 Created):**
```json
{
  "id": 1,
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

---

### 2️⃣ OBTENER TODOS LOS LIBROS (GET)

**Endpoint:**
```
GET /api/libros
```

**cURL:**
```bash
curl http://localhost:8080/api/libros
```

**Respuesta Esperada (200 OK):**
```json
[
  {
    "id": 1,
    "titulo": "Clean Code",
    "autor": "Robert C. Martin",
    "isbn": "978-0132350884"
  },
  {
    "id": 2,
    "titulo": "Design Patterns",
    "autor": "Gang of Four",
    "isbn": "978-0201633610"
  }
]
```

---

### 3️⃣ OBTENER UN LIBRO POR ID (GET)

**Endpoint:**
```
GET /api/libros/{id}
```

**Ejemplo:**
```
GET /api/libros/1
```

**cURL:**
```bash
curl http://localhost:8080/api/libros/1
```

**Respuesta Esperada (200 OK):**
```json
{
  "id": 1,
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

**Si no existe (404 Not Found):**
```json
{
  "timestamp": "2026-03-31T10:30:00.123456",
  "status": 404,
  "error": "Libro no encontrado",
  "message": "Libro con ID 999 no encontrado"
}
```

---

### 4️⃣ ACTUALIZAR UN LIBRO (PUT)

**Endpoint:**
```
PUT /api/libros/{id}
```

**Ejemplo:**
```
PUT /api/libros/1
```

**Headers:**
```
Content-Type: application/json
```

**Body (JSON):**
```json
{
  "titulo": "Clean Code - Segunda Edición",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

**cURL:**
```bash
curl -X PUT http://localhost:8080/api/libros/1 \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Clean Code - Segunda Edición",
    "autor": "Robert C. Martin",
    "isbn": "978-0132350884"
  }'
```

**Respuesta Esperada (200 OK):**
```json
{
  "id": 1,
  "titulo": "Clean Code - Segunda Edición",
  "autor": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

---

### 5️⃣ ELIMINAR UN LIBRO (DELETE)

**Endpoint:**
```
DELETE /api/libros/{id}
```

**Ejemplo:**
```
DELETE /api/libros/1
```

**cURL:**
```bash
curl -X DELETE http://localhost:8080/api/libros/1
```

**Respuesta Esperada (204 No Content):**
```
(sin body)
```

---

## 📊 Secuencia de Pruebas Recomendada

### Escenario Completo CRUD

**Paso 1: Crear 3 libros**
```bash
# Libro 1
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Clean Code","autor":"Robert C. Martin","isbn":"978-0132350884"}'

# Libro 2
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Design Patterns","autor":"Gang of Four","isbn":"978-0201633610"}'

# Libro 3
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Refactoring","autor":"Martin Fowler","isbn":"978-0201485677"}'
```

**Paso 2: Obtener todos los libros**
```bash
curl http://localhost:8080/api/libros
# Deberías ver 3 libros con IDs 1, 2, 3
```

**Paso 3: Obtener el libro con ID 2**
```bash
curl http://localhost:8080/api/libros/2
# Deberías ver Design Patterns
```

**Paso 4: Actualizar el libro con ID 2**
```bash
curl -X PUT http://localhost:8080/api/libros/2 \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Design Patterns Updated","autor":"Gang of Four","isbn":"978-0201633610"}'
```

**Paso 5: Eliminar el libro con ID 3**
```bash
curl -X DELETE http://localhost:8080/api/libros/3
```

**Paso 6: Verificar que quedan 2 libros**
```bash
curl http://localhost:8080/api/libros
# Deberías ver solo 2 libros (IDs 1 y 2)
```

---

## 🔍 Códigos de Respuesta HTTP

| Código | Significado | Ejemplo |
|--------|-------------|---------|
| **200** | OK | Solicitud exitosa |
| **201** | Created | Recurso creado exitosamente |
| **204** | No Content | Eliminar exitoso (sin body) |
| **400** | Bad Request | Datos inválidos |
| **404** | Not Found | Libro no encontrado |
| **500** | Internal Server Error | Error del servidor |

---

## 💾 Acceder a la Base de Datos H2

**URL:**
```
http://localhost:8080/h2-console
```

**Credenciales:**
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User Name:** `sa`
- **Password:** (dejar en blanco)

**Query para ver todos los libros:**
```sql
SELECT * FROM libros;
```

---

## 🐛 Casos de Error

### Obtener un libro que no existe

```bash
curl http://localhost:8080/api/libros/999
```

**Respuesta (404 Not Found):**
```json
{
  "timestamp": "2026-03-31T10:45:30.123456",
  "status": 404,
  "error": "Libro no encontrado",
  "message": "Libro con ID 999 no encontrado"
}
```

### Actualizar un libro que no existe

```bash
curl -X PUT http://localhost:8080/api/libros/999 \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Test","autor":"Test","isbn":"123"}'
```

**Respuesta (404 Not Found):**
```json
{
  "timestamp": "2026-03-31T10:45:30.123456",
  "status": 404,
  "error": "Libro no encontrado",
  "message": "Libro con ID 999 no encontrado"
}
```

### Eliminar un libro que no existe

```bash
curl -X DELETE http://localhost:8080/api/libros/999
```

**Respuesta (204 No Content):**
```
(sin body, pero se ejecuta sin error)
```

---

## 📝 Notas Importantes

1. **La base de datos H2 es en memoria** - Los datos se pierden cuando reinicia la aplicación
2. **ISBN debe ser único** - No puedes crear dos libros con el mismo ISBN
3. **IDs se asignan automáticamente** - No necesitas proporcionar el ID al crear
4. **Mapeo de tabla**: El modelo JPA crea una tabla llamada `libros` con columnas `id`, `titulo`, `autor`, `isbn`

---

## 🎓 Flujo Arquitecónico Ejemplo

Cuando ejecutas:
```bash
POST /api/libros con {"titulo":"Clean Code",...}
```

Sucede internamente:
```
1. LibroController recibe HTTP POST
   ↓
2. Deserializa JSON → LibroRequest
   ↓
3. Inyecta CrearLibroUseCase
   ↓
4. Llama: crearLibroUseCase.ejecutar(titulo, autor, isbn)
   ↓
5. LibroApplicationService crea: new Libro(...)
   ↓
6. Llama: libroRepository.guardar(libro)
   ↓
7. LibroRepositoryAdapter mapea Libro → LibroEntity
   ↓
8. LibroJpaRepository.save(entity) → H2
   ↓
9. Retorna entidad guardada
   ↓
10. Mapea LibroEntity → Libro → LibroResponse
   ↓
11. LibroController serializa → JSON
   ↓
12. Response 201 CREATED
```

---

**Última actualización:** 31/03/2026

