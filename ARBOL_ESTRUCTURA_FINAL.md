# ÁRBOL DE ESTRUCTURA FINAL - BIBLIO2

```
biblio2/
├── .gitignore
├── .git/
├── pom.xml
├── mvnw
├── mvnw.cmd
│
├── REFACTORIZACION_COMPLETA.md
├── README.md
├── ARQUITECTURA_HEXAGONAL.md
├── DIAGRAMA_ARQUITECTURA.md
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/biblio2/biblio2/
│   │   │       ├── Biblio2Application.java
│   │   │       │
│   │   │       ├── domain/                          [CAPA DE DOMINIO]
│   │   │       │   ├── entity/
│   │   │       │   │   ├── Libro.java
│   │   │       │   │   ├── Usuario.java
│   │   │       │   │   └── Prestamo.java
│   │   │       │   │
│   │   │       │   ├── exception/
│   │   │       │   │   ├── LibroNoEncontradoException.java
│   │   │       │   │   ├── UsuarioNoEncontradoException.java
│   │   │       │   │   └── PrestamoNoDisponibleException.java
│   │   │       │   │
│   │   │       │   ├── port/
│   │   │       │   │   ├── LibroRepositoryPort.java
│   │   │       │   │   ├── UsuarioRepositoryPort.java
│   │   │       │   │   └── PrestamoRepositoryPort.java
│   │   │       │   │
│   │   │       │   └── usecase/
│   │   │       │       ├── libro/
│   │   │       │       │   ├── CrearLibroUseCase.java
│   │   │       │       │   ├── ObtenerLibroPorIdUseCase.java
│   │   │       │       │   ├── ObtenerLibrosUseCase.java
│   │   │       │       │   ├── ActualizarLibroUseCase.java
│   │   │       │       │   └── EliminarLibroUseCase.java
│   │   │       │       ├── usuario/
│   │   │       │       │   ├── RegistrarUsuarioUseCase.java
│   │   │       │       │   ├── ObtenerUsuarioPorIdUseCase.java
│   │   │       │       │   └── ActualizarUsuarioUseCase.java
│   │   │       │       └── prestamo/
│   │   │       │           ├── CrearPrestamoUseCase.java
│   │   │       │           ├── DevolverPrestamoUseCase.java
│   │   │       │           ├── RenovarPrestamoUseCase.java
│   │   │       │           └── ListarPrestamosPorUsuarioUseCase.java
│   │   │       │
│   │   │       ├── application/                     [CAPA DE APLICACIÓN]
│   │   │       │   ├── dto/
│   │   │       │   │   ├── LibroRequest.java
│   │   │       │   │   ├── LibroResponse.java
│   │   │       │   │   ├── UsuarioRequest.java
│   │   │       │   │   ├── UsuarioResponse.java
│   │   │       │   │   ├── PrestamoRequest.java
│   │   │       │   │   └── PrestamoResponse.java
│   │   │       │   │
│   │   │       │   ├── exception/
│   │   │       │   │   ├── LibroNoEncontradoException.java
│   │   │       │   │   ├── UsuarioNoEncontradoException.java
│   │   │       │   │   └── PrestamoNoDisponibleException.java
│   │   │       │   │
│   │   │       │   └── service/
│   │   │       │       ├── LibroApplicationService.java
│   │   │       │       ├── UsuarioApplicationService.java
│   │   │       │       └── PrestamoApplicationService.java
│   │   │       │
│   │   │       └── infrastructure/                  [CAPA DE INFRAESTRUCTURA]
│   │   │           ├── config/
│   │   │           │   └── SecurityConfig.java
│   │   │           │
│   │   │           ├── persistence/
│   │   │           │   ├── adapter/
│   │   │           │   │   ├── LibroRepositoryAdapter.java
│   │   │           │   │   ├── UsuarioRepositoryAdapter.java
│   │   │           │   │   └── PrestamoRepositoryAdapter.java
│   │   │           │   ├── entity/
│   │   │           │   │   ├── LibroEntity.java (con campo prestado)
│   │   │           │   │   ├── UsuarioEntity.java
│   │   │           │   │   └── PrestamoEntity.java
│   │   │           │   └── repository/
│   │   │           │       ├── LibroJpaRepository.java
│   │   │           │       ├── UsuarioJpaRepository.java
│   │   │           │       └── PrestamoJpaRepository.java
│   │   │           │
│   │   │           └── rest/
│   │   │               ├── controller/
│   │   │               │   ├── LibroController.java
│   │   │               │   ├── UsuarioController.java
│   │   │               │   └── PrestamoController.java
│   │   │               ├── dto/
│   │   │               │   ├── LibroRequest.java
│   │   │               │   ├── LibroResponse.java
│   │   │               │   ├── UsuarioRequest.java
│   │   │               │   ├── UsuarioResponse.java
│   │   │               │   ├── PrestamoRequest.java
│   │   │               │   └── PrestamoResponse.java
│   │   │               └── exception/
│   │   │                   └── GlobalExceptionHandler.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/biblio2/biblio2/
│               └── Biblio2ApplicationTests.java
│
├── target/
│   ├── classes/
│   ├── generated-sources/
│   └── [archivos compilados]
│
└── .idea/
    └── [configuración de IntelliJ]
```

## RESUMEN POR CAPA

### Domain Layer (Dominio)
- 3 entidades: Libro, Usuario, Préstamo
- 9 casos de uso: 5 para Libros, 2 para Usuarios, 4 para Préstamos
- 3 excepciones de dominio
- 3 puertos (interfaces) de repositorio

### Application Layer (Aplicación)
- 3 servicios de aplicación (orquestadores)
- 6 DTOs (request/response)
- 3 excepciones de aplicación

### Infrastructure Layer (Infraestructura)
- 3 adaptadores de repositorio
- 3 entidades JPA
- 3 repositorios Spring Data JPA
- 3 controladores REST
- 1 manejador global de excepciones
- 1 configuración de seguridad

---

## CONVENCIONES APLICADAS

✅ **Paquetes por funcionalidad**: domain/entity, domain/port, domain/usecase, etc.
✅ **Módulos funcionales**: libro/, usuario/, prestamo/ dentro de usecase/
✅ **Separación de capas**: domain/, application/, infrastructure/
✅ **DTOs duplicados**: Existen en application/dto y rest/dto (pueden consolidarse)
✅ **Excepciones**: Duplicadas en domain/exception y application/exception (por diseño)
✅ **Interfaz (casos de uso)**: Método `ejecutar()` implementado en servicios

---

## FLUJO DE UNA PETICIÓN HTTP

```
HTTP Request
    ↓
[RestController] (UsuarioController)
    ↓
[Application Service] (UsuarioApplicationService)
    ↓
[Use Case Implementation] (RegistrarUsuarioUseCase.ejecutar())
    ↓
[Port] (UsuarioRepositoryPort)
    ↓
[Adapter] (UsuarioRepositoryAdapter)
    ↓
[JPA Repository] (UsuarioJpaRepository)
    ↓
[JPA Entity] (UsuarioEntity)
    ↓
[Database] (H2)
    ↓
[DTO Response] (UsuarioResponse)
    ↓
HTTP Response (JSON)
```

---

Generado: 26/04/2024

