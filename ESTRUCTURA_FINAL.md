# 🏗 ÁRBOL COMPLETO DEL PROYECTO - BIBLIO2

## Estructura Final Refactorizada (Clean Architecture)

```
biblio2/
│
├── 📄 pom.xml                                      # Configuración Maven (SIN CAMBIOS)
├── 📄 mvnw                                         # Maven Wrapper
├── 📄 mvnw.cmd                                     # Maven Wrapper (Windows)
│
└── 📁 biblio2/
    │
    ├── 📄 pom.xml
    ├── 📄 mvnw
    ├── 📄 mvnw.cmd
    │
    └── 📁 src/
        │
        ├── 📁 main/
        │   │
        │   ├── 📁 java/
        │   │   └── 📁 com/biblio2/biblio2/
        │   │       │
        │   │       ├── 📄 Biblio2Application.java ⭐
        │   │       │   └─ Punto de entrada de la aplicación
        │   │       │
        │   │       ├── 📁 domain/                          ☘️ CAPA DE DOMINIO
        │   │       │   │
        │   │       │   ├── 📁 entity/
        │   │       │   │   ├── 📄 Libro.java              ✅ Entidad de dominio
        │   │       │   │   ├── 📄 Usuario.java            ✅ Entidad de dominio
        │   │       │   │   └── 📄 Prestamo.java           ✅ Entidad de dominio
        │   │       │   │
        │   │       │   ├── 📁 exception/
        │   │       │   │   ├── 📄 LibroNoEncontradoException.java        ✅
        │   │       │   │   ├── 📄 UsuarioNoEncontradoException.java      ✅
        │   │       │   │   └── 📄 PrestamoNoDisponibleException.java     ✅
        │   │       │   │
        │   │       │   ├── 📁 port/                       # Interfaces para adaptadoresportugal
        │   │       │   │   ├── 📄 LibroRepositoryPort.java          ✅
        │   │       │   │   ├── 📄 UsuarioRepositoryPort.java        ✅
        │   │       │   │   └── 📄 PrestamoRepositoryPort.java       ✅
        │   │       │   │
        │   │       │   └── 📁 usecase/
        │   │       │       │
        │   │       │       ├── 📁 libro/
        │   │       │       │   ├── 📄 CrearLibroUseCase.java        ✅ USAR ESTOS
        │   │       │       │   ├── 📄 ObtenerLibrosUseCase.java     ✅ USAR ESTOS
        │   │       │       │   ├── 📄 ObtenerLibroPorIdUseCase.java ✅ USAR ESTOS
        │   │       │       │   ├── 📄 ActualizarLibroUseCase.java   ✅ USAR ESTOS
        │   │       │       │   └── 📄 EliminarLibroUseCase.java     ✅ USAR ESTOS
        │   │       │       │
        │   │       │       ├── 📁 usuario/
        │   │       │       │   ├── 📄 RegistrarUsuarioUseCase.java      ✅
        │   │       │       │   ├── 📄 ObtenerUsuarioPorIdUseCase.java   ✅
        │   │       │       │   └── 📄 ActualizarUsuarioUseCase.java     ✅
        │   │       │       │
        │   │       │       └── 📁 prestamo/
        │   │       │           ├── 📄 PrestamoUseCases.java             ⭐ NUEVA INTERFAZ CONSOLIDADA
        │   │       │           ├── 📄 CrearPrestamoUseCase.java         (auxiliar)
        │   │       │           ├── 📄 DevolverPrestamoUseCase.java      (auxiliar)
        │   │       │           ├── 📄 RenovarPrestamoUseCase.java       (auxiliar)
        │   │       │           └── 📄 ListarPrestamosPorUsuarioUseCase.java (auxiliar)
        │   │       │
        │   │       ├── 📁 application/                   🔶 CAPA DE APLICACIÓN
        │   │       │   │
        │   │       │   ├── 📁 service/
        │   │       │   │   ├── 📄 LibroApplicationService.java       ✅
        │   │       │   │   ├── 📄 UsuarioApplicationService.java     ✅
        │   │       │   │   └── 📄 PrestamoApplicationService.java    ⭐ REFACTORIZADO
        │   │       │   │
        │   │       │   ├── 📁 dto/
        │   │       │   │   ├── 📄 LibroRequest.java                  ✅
        │   │       │   │   ├── 📄 LibroResponse.java                 ✅
        │   │       │   │   ├── 📄 UsuarioRequest.java                ✅
        │   │       │   │   ├── 📄 UsuarioResponse.java               ✅
        │   │       │   │   ├── 📄 PrestamoRequest.java               ✅
        │   │       │   │   └── 📄 PrestamoResponse.java              ✅
        │   │       │   │
        │   │       │   └── 📁 exception/
        │   │       │       ├── 📄 LibroNoEncontradoException.java     (copia de dominio)
        │   │       │       ├── 📄 UsuarioNoEncontradoException.java   (copia de dominio)
        │   │       │       └── 📄 PrestamoNoDisponibleException.java  (copia de dominio)
        │   │       │
        │   │       └── 📁 infrastructure/                🟠 CAPA DE INFRAESTRUCTURA
        │   │           │
        │   │           ├── 📁 config/
        │   │           │   └── 📄 SecurityConfig.java               ✅ Configuración Spring Security
        │   │           │
        │   │           ├── 📁 persistence/
        │   │           │   │
        │   │           │   ├── 📁 entity/
        │   │           │   │   ├── 📄 LibroEntity.java              ✅ Mapeo JPA
        │   │           │   │   ├── 📄 UsuarioEntity.java            ✅ Mapeo JPA
        │   │           │   │   └── 📄 PrestamoEntity.java           ✅ Mapeo JPA
        │   │           │   │
        │   │           │   ├── 📁 repository/
        │   │           │   │   ├── 📄 LibroJpaRepository.java        ✅ Spring Data JPA
        │   │           │   │   ├── 📄 UsuarioJpaRepository.java      ✅ Spring Data JPA
        │   │           │   │   └── 📄 PrestamoJpaRepository.java     ✅ Spring Data JPA
        │   │           │   │
        │   │           │   └── 📁 adapter/
        │   │           │       ├── 📄 LibroRepositoryAdapter.java    ✅ Inversión de dependencias
        │   │           │       ├── 📄 UsuarioRepositoryAdapter.java  ✅ Inversión de dependencias
        │   │           │       └── 📄 PrestamoRepositoryAdapter.java ✅ Inversión de dependencias
        │   │           │
        │   │           └── 📁 rest/
        │   │               │
        │   │               ├── 📁 controller/
        │   │               │   ├── 📄 LibroController.java           ✅ Endpoints REST - IMPORTES ACTUALIZADAS
        │   │               │   ├── 📄 UsuarioController.java         ✅ Endpoints REST
        │   │               │   └── 📄 PrestamoController.java        ✅ Endpoints REST - MÉTODOS ACTUALIZADOS
        │   │               │
        │   │               ├── 📁 dto/
        │   │               │   ├── 📄 LibroRequest.java              (referencias application/dto)
        │   │               │   ├── 📄 LibroResponse.java             (referencias application/dto)
        │   │               │   ├── 📄 UsuarioRequest.java            (referencias application/dto)
        │   │               │   ├── 📄 UsuarioResponse.java           (referencias application/dto)
        │   │               │   ├── 📄 PrestamoRequest.java           (referencias application/dto)
        │   │               │   └── 📄 PrestamoResponse.java          (referencias application/dto)
        │   │               │
        │   │               └── 📁 exception/
        │   │                   └── 📄 GlobalExceptionHandler.java    ✅ Manejo centralizado de excepciones
        │   │
        │   └── 📁 resources/
        │       ├── 📄 application.properties         ✅ Configuración (H2, JPA, etc.)
        │       └── 📁 static/                        (para assets estáticos si aplica)
        │
        └── 📁 test/
            └── 📁 java/
                └── 📁 com/biblio2/biblio2/
                    ├── 📄 Biblio2ApplicationTests.java
                    └── (tests adicionales)
│
└── 📁 target/                                   # Generado por Maven
    ├── 📄 biblio2-0.0.1-SNAPSHOT.jar           # JAR ejecutable
    ├── 📁 classes/                              # Clases compiladas
    ├── 📁 generated-sources/                    # Código generado
    └── ...
```

---

## 📊 RESUMEN DE ARCHIVOS

### Por Capa

| Capa | Tipo | Cantidad | Estado |
|------|------|----------|--------|
| **Dominio** | Entidades | 3 | ✅ |
| | Excepciones | 3 | ✅ |
| | Puertos | 3 | ✅ |
| | Casos de Uso | 13 | ✅ |
| **Aplicación** | Servicios | 3 | ✅ |
| | DTOs | 6 | ✅ |
| | Excepciones | 3 | ✅ |
| **Infraestructura** | Configuración | 1 | ✅ |
| | Entidades JPA | 3 | ✅ |
| | Repositorios | 3 | ✅ |
| | Adapters | 3 | ✅ |
| | Controladores | 3 | ✅ |
| | Excepciones | 1 | ✅ |
| | Total | **51+** | ✅ |

---

## 🎯 FLUJO DE UNA SOLICITUD HTTP

```
1. ENTRADA (REST Adapter)
   └─> LibroController.java (HTTP Request)
       └─> POST /api/libros

2. APLICACIÓN (Application Service)
   └─> LibroApplicationService.java
       └─> Implementa CrearLibroUseCase

3. DOMINIO (Business Logic)
   └─> CrearLibroUseCase (interfaz)
       └─> Valida reglas de negocio
           └─> Lanza excepciones si es necesario

4. PUERTO (Interfaz de Salida)
   └─> LibroRepositoryPort (interfaz)
       └─> Define contrato de persistencia

5. INFRAESTRUCTURA (Adapter)
   └─> LibroRepositoryAdapter
       └─> Mapea Libro → LibroEntity
           └─> Delega a JPA

6. PERSISTENCIA (Spring Data)
   └─> LibroJpaRepository
       └─> Ejecuta query en BD (H2)

7. RESPUESTA (Adapter REST)
   └─> LibroResponse (DTO)
       └─> HTTP Response JSON
```

---

## 🔄 INVERSIÓN DE DEPENDENCIAS

```
ANTES (Incorrecto):
┌─────────────────┐
│  Controlador    │
└────────┬────────┘
         │ Depende
         ↓
┌─────────────────┐
│  Base de Datos  │
└─────────────────┘

AHORA (Clean Architecture):
┌─────────────────┐
│  Dominio        │ <─── Define contrato
│  (Interface)    │
└────────▲────────┘
         │ Implementa
         │
┌────────┴────────┐
│  Infraestructura│ <─── Implementa contrato
│  (Adapter)      │
└────────┬────────┘
         │ Usa
         ↓
┌─────────────────┐
│  Base de Datos  │
└─────────────────┘
```

---

## ⚠️ PROBLEMAS RESUELTOS

### ✅ ANTES: Conflicto de Métodos
```java
// ❌ PROBLEMA: 4 métodos ejecutar() = CONFLICTO
class PrestamoApplicationService implements
    CrearPrestamoUseCase,           // Prestamo ejecutar(Long, Long)
    DevolverPrestamoUseCase,        // void ejecutar(Long)
    RenovarPrestamoUseCase,         // Prestamo ejecutar(Long)
    ListarPrestamosPorUsuarioUseCase { // List<Prestamo> ejecutar(Long)
}
```

### ✅ AHORA: Interfaz Consolidada
```java
// ✅ SOLUCIÓN: Métodos específicos sin conflicto
class PrestamoApplicationService implements PrestamoUseCases {
    Prestamo crearPrestamo(Long usuarioId, Long libroId) { }
    void devolverPrestamo(Long prestamoId) { }
    Prestamo renovarPrestamo(Long prestamoId) { }
    List<Prestamo> listarPorUsuario(Long usuarioId) { }
}
```

---

## 🚨 DUPLICIDADES PENDIENTES DE ELIMINAR

Estos archivos son duplicados y deben eliminarse para limpiar el árbol:

```
❌ domain/usecase/CrearLibroUseCase.java
❌ domain/usecase/ObtenerLibrosUseCase.java
❌ domain/usecase/ObtenerLibroPorIdUseCase.java
❌ domain/usecase/EliminarLibroUseCase.java
❌ domain/usecase/ActualizarLibroUseCase.java

✅ REPLACE CON (subcarpeta libro/):
domain/usecase/libro/CrearLibroUseCase.java
domain/usecase/libro/ObtenerLibrosUseCase.java
domain/usecase/libro/ObtenerLibroPorIdUseCase.java
domain/usecase/libro/EliminarLibroUseCase.java
domain/usecase/libro/ActualizarLibroUseCase.java
```

---

## 📚 MÓDULOS FUNCIONALES

### Módulo: LIBROS
```
Entities:     Libro.java
UseCases:     CrearLibroUseCase, ObtenerLibrosUseCase, etc.
Service:      LibroApplicationService
Controller:   LibroController
Entity JPA:   LibroEntity
Repository:   LibroJpaRepository
Adapter:      LibroRepositoryAdapter
DTOs:         LibroRequest, LibroResponse
Exceptions:   LibroNoEncontradoException
```

### Módulo: USUARIOS
```
Entities:     Usuario.java
UseCases:     RegistrarUsuarioUseCase, ObtenerUsuarioPorIdUseCase, etc.
Service:      UsuarioApplicationService
Controller:   UsuarioController
Entity JPA:   UsuarioEntity
Repository:   UsuarioJpaRepository
Adapter:      UsuarioRepositoryAdapter
DTOs:         UsuarioRequest, UsuarioResponse
Exceptions:   UsuarioNoEncontradoException
```

### Módulo: PRÉSTAMOS
```
Entities:      Prestamo.java
UseCases:      PrestamoUseCases (CONSOLIDADA), CrearPrestamoUseCase, etc.
Service:       PrestamoApplicationService (REFACTORIZADO)
Controller:    PrestamoController (ACTUALIZADO)
Entity JPA:    PrestamoEntity
Repository:    PrestamoJpaRepository
Adapter:       PrestamoRepositoryAdapter
DTOs:          PrestamoRequest, PrestamoResponse
Exceptions:    PrestamoNoDisponibleException
```

---

## 🔍 CHECKLIST DE ARQUITECTURA

- [x] Separación clara de capas (Domain, Application, Infrastructure)
- [x] Inversión de dependencias (Puertos/Adapters)
- [x] Entidades agnósticas de framework
- [x] DTOs para transferencia de datos
- [x] Excepciones de dominio
- [x] Servicios de aplicación como orquestadores
- [x] Controladores REST como adaptadores entrada
- [x] Repositorios adapters como adaptadores salida
- [x] Configuración centralizada
- [x] Manejo centralizado de excepciones
- [ ] Eliminar archivos duplicados (PENDIENTE)

---

## 📈 MÉTRICAS DE CALIDAD

| Métrica | Valor | Estado |
|---------|-------|--------|
| Complejidad Ciclomática | Baja | ✅ |
| Duplicación de Código | Baja | ⚠️ (5 archivos solo) |
| Cohesión Módular | Alta | ✅ |
| Acoplamiento | Bajo | ✅ |
| Testabilidad | Alta | ✅ |

---

## 🎓 PATRONES IMPLEMENTADOS

1. **Clean Architecture**
   - Separación en capas
   - Dependencias apuntan hacia el centro (Dominio)
2. **Hexagonal Architecture**
   - Adaptadores entrada (REST Controllers)
   - Adaptadores salida (Repository Adapters)
   - Puertos (Interfaces de contrato)
3. **Repository Pattern**
   - Abstracción de persistencia
4. **Dependency Injection**
   - Spring autowiring
   - Constructor injection
5. **DTO Pattern**
   - Separación entre entidades y DTOs
6. **Exception Handling**
   - Excepciones personalizadas por dominio

---

**Versión:** 2.0  
**Última actualización:** 8 de mayo de 2026  
**Estado:** ✅ COMPLETO (pendiente limpieza de duplicados)

