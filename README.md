# 📚 Proyecto Biblio2

Sistema de gestión de libros desarrollado con **Spring Boot** siguiendo **Arquitectura Hexagonal (Ports & Adapters)**.

## 🏆 Características

✅ **CRUD Completo** de libros (Create, Read, Update, Delete)  
✅ **Arquitectura Hexagonal** con 3 capas bien separadas  
✅ **Base de datos H2** en memoria  
✅ **API REST** funcional con endpoints RESTful  
✅ **Manejo de errores** global y elegante  
✅ **Inyección de dependencias** con Spring  
✅ **Sin acoplamiento** entre capas  

---

## 🏗️ Arquitectura

### Tres Capas Claramente Separadas

```
┌─────────────────────────────────────────┐
│        INFRAESTRUCTURA (REST)           │
│  - LibroController                      │
│  - LibroRequest/Response (DTOs)         │
│  - GlobalExceptionHandler               │
└────────────┬────────────────────────────┘
             │
┌────────────▼────────────────────────────┐
│      APLICACIÓN (Business Logic)        │
│  - LibroApplicationService              │
│  - Casos de Uso (interfaces)            │
│  - Excepciones de aplicación            │
└────────────┬────────────────────────────┘
             │
┌────────────▼────────────────────────────┐
│        DOMINIO (Puro, sin Spring)       │
│  - Entidad Libro                        │
│  - Puerto LibroRepositoryPort           │
│  - Casos de Uso (interfaces)            │
└────────────┬────────────────────────────┘
             │
┌────────────▼────────────────────────────┐
│     INFRAESTRUCTURA (Persistencia)      │
│  - LibroEntity (JPA)                    │
│  - LibroJpaRepository                   │
│  - LibroRepositoryAdapter               │
│  - Base de datos H2                     │
└─────────────────────────────────────────┘
```

---

## 🚀 Inicio Rápido

### 1. Compilar
```bash
cd biblio2
mvnw clean compile
```

### 2. Ejecutar
```bash
mvnw spring-boot:run
```

### 3. Probar endpoints
```bash
# Crear un libro
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Clean Code","autor":"Robert C. Martin","isbn":"978-0132350884"}'

# Obtener todos
curl http://localhost:8080/api/libros

# Obtener uno
curl http://localhost:8080/api/libros/1

# Actualizar
curl -X PUT http://localhost:8080/api/libros/1 \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Clean Code V2","autor":"Robert C. Martin","isbn":"978-0132350884"}'

# Eliminar
curl -X DELETE http://localhost:8080/api/libros/1
```

### 4. Consola H2
```
http://localhost:8080/h2-console
```

---

## 📚 Tecnologías

| Tecnología | Versión | Uso |
|-----------|---------|-----|
| **Java** | 21 | Lenguaje de programación |
| **Spring Boot** | 3.5.13 | Framework principal |
| **Spring Data JPA** | - | Persistencia de datos |
| **JPA/Hibernate** | - | ORM |
| **H2 Database** | - | Base de datos en memoria |
| **Maven** | - | Gestor de dependencias |

---

## 📁 Estructura del Proyecto

```
com.biblio2.biblio2/
│
├── domain/                              ← Lógica de negocio PURA
│   ├── entity/Libro.java               ← Entidad sin Spring
│   ├── port/LibroRepositoryPort.java   ← Puerto de persistencia
│   └── usecase/                        ← Interfaces de casos de uso
│       ├── CrearLibroUseCase
│       ├── ObtenerLibrosUseCase
│       ├── ObtenerLibroPorIdUseCase
│       ├── EliminarLibroUseCase
│       └── ActualizarLibroUseCase
│
├── application/                         ← Orquestación y casos de uso
│   ├── service/LibroApplicationService ← Implementa todos los casos
│   └── exception/LibroNoEncontradoException
│
└── infrastructure/                      ← Detalles técnicos
    ├── persistence/
    │   ├── entity/LibroEntity.java      ← Entidad JPA
    │   ├── repository/LibroJpaRepository ← Spring Data JPA
    │   └── adapter/LibroRepositoryAdapter ← Implementa puerto
    └── rest/
        ├── controller/LibroController   ← Endpoints HTTP
        ├── dto/                         ← Request/Response
        └── exception/GlobalExceptionHandler
```

---

## 🎯 Principios Aplicados

### ✅ Separación de Responsabilidades
- **Dominio**: Solo lógica de negocio
- **Aplicación**: Coordinación de casos de uso
- **Infraestructura**: Detalles técnicos

### ✅ Inversión de Dependencias
- Dominio NO depende de Spring
- Dominio NO depende de JPA
- Dominio NO depende de REST
- Solo la infraestructura depende del dominio

### ✅ Adaptadores y Puertos
- **Puertos**: Interfaces que define el dominio
- **Adaptadores**: Implementaciones técnicas en infraestructura

### ✅ Testabilidad
- Cada capa es independiente y testeable
- Fácil hacer mocks de dependencias

---

## 🔄 Flujo de una Solicitud

```
1. POST /api/libros (HTTP)
   ↓
2. LibroController recibe LibroRequest
   ↓
3. Llama a CrearLibroUseCase.ejecutar()
   ↓
4. LibroApplicationService ejecuta la lógica
   ↓
5. Usa LibroRepositoryPort.guardar()
   ↓
6. LibroRepositoryAdapter traduce a JPA
   ↓
7. LibroJpaRepository persiste en H2
   ↓
8. Respuesta JSON con Libro creado
```

---

## 📝 Endpoints Disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| **POST** | `/api/libros` | Crear nuevo libro |
| **GET** | `/api/libros` | Obtener todos |
| **GET** | `/api/libros/{id}` | Obtener uno |
| **PUT** | `/api/libros/{id}` | Actualizar |
| **DELETE** | `/api/libros/{id}` | Eliminar |

---

## 🛠️ Extensiones Fáciles

Sin modificar el dominio ni la aplicación, puedes:

1. **Cambiar de BD**: Reemplaza H2 por PostgreSQL, MySQL, etc.
2. **Cambiar de protocolo**: Agrega gRPC, GraphQL, etc.
3. **Agregar seguridad**: Implementa OAuth, JWT, etc.
4. **Agregar validaciones**: Spring Validation en el controlador
5. **Agregar logs**: Utiliza SLF4J en cualquier capa

---

## 📖 Documentación Completa

Para más detalles sobre la arquitectura, ve a: **[ARQUITECTURA_HEXAGONAL.md](./ARQUITECTURA_HEXAGONAL.md)**

---

## 🤝 Contribuciones

Este es un proyecto educativo que demuestra las mejores prácticas de arquitectura en Java/Spring Boot.

---

## 👨‍💻 Autor
- **Orlando Mora**

---

## 📄 Licencia
Sin licencia específica - Proyecto de aprendizaje

---

**Última actualización:** 31/03/2026  
**Versión:** 1.0.0

