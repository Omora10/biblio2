# 📁 Estructura del Proyecto - Vista de IntelliJ IDEA

```
biblio2/ (Raíz del proyecto)
│
├── README.md ⭐ (Lee esto primero)
├── ARQUITECTURA_HEXAGONAL.md 📚 (Documentación detallada)
├── DIAGRAMA_ARQUITECTURA.md 📊 (Diagramas ASCII)
├── GUIA_PRUEBAS.md 🧪 (Cómo probar endpoints)
├── RESUMEN_IMPLEMENTACION.md ✅ (Este proyecto)
│
└── biblio2/ (Carpeta del módulo Spring Boot)
    │
    ├── pom.xml (Maven - dependencias)
    ├── mvnw & mvnw.cmd (Maven Wrapper)
    │
    ├── src/
    │   │
    │   ├── main/
    │   │   │
    │   │   ├── java/
    │   │   │   └── com/biblio2/biblio2/
    │   │   │       │
    │   │   │       ├── 🏠 Biblio2Application.java (Punto de entrada)
    │   │   │       │
    │   │   │       ├── 🎯 DOMINIO (Lógica de negocio PURA)
    │   │   │       │   └── domain/
    │   │   │       │       ├── entity/
    │   │   │       │       │   └── Libro.java ✨
    │   │   │       │       │       - id: Long
    │   │   │       │       │       - titulo: String
    │   │   │       │       │       - autor: String
    │   │   │       │       │       - isbn: String
    │   │   │       │       │
    │   │   │       │       ├── port/
    │   │   │       │       │   └── LibroRepositoryPort.java 🚪
    │   │   │       │       │       (Interfaz del puerto)
    │   │   │       │       │
    │   │   │       │       └── usecase/
    │   │   │       │           ├── CrearLibroUseCase.java 📝
    │   │   │       │           ├── ObtenerLibrosUseCase.java 📖
    │   │   │       │           ├── ObtenerLibroPorIdUseCase.java 🔍
    │   │   │       │           ├── ActualizarLibroUseCase.java ✏️
    │   │   │       │           └── EliminarLibroUseCase.java 🗑️
    │   │   │       │
    │   │   │       ├── ⚙️ APLICACIÓN (Orquestación)
    │   │   │       │   └── application/
    │   │   │       │       ├── service/
    │   │   │       │       │   └── LibroApplicationService.java 🔧
    │   │   │       │       │       (Implementa todos los casos de uso)
    │   │   │       │       │
    │   │   │       │       └── exception/
    │   │   │       │           └── LibroNoEncontradoException.java ⚠️
    │   │   │       │
    │   │   │       └── 🔌 INFRAESTRUCTURA (Detalles técnicos)
    │   │   │           └── infrastructure/
    │   │   │               ├── persistence/
    │   │   │               │   ├── entity/
    │   │   │               │   │   └── LibroEntity.java 📊
    │   │   │               │   │       (@Entity JPA)
    │   │   │               │   │
    │   │   │               │   ├── repository/
    │   │   │               │   │   └── LibroJpaRepository.java 🏦
    │   │   │               │   │       (Spring Data JPA)
    │   │   │               │   │
    │   │   │               │   └── adapter/
    │   │   │               │       └── LibroRepositoryAdapter.java 🔗
    │   │   │               │           (Implementa puerto)
    │   │   │               │
    │   │   │               └── rest/
    │   │   │                   ├── controller/
    │   │   │                   │   └── LibroController.java 🌐
    │   │   │                   │       REST Endpoints
    │   │   │                   │
    │   │   │                   ├── dto/
    │   │   │                   │   ├── LibroRequest.java 📬
    │   │   │                   │   │   (DTO de entrada)
    │   │   │                   │   │
    │   │   │                   │   └── LibroResponse.java 📭
    │   │   │                   │       (DTO de salida)
    │   │   │                   │
    │   │   │                   └── exception/
    │   │   │                       └── GlobalExceptionHandler.java 🛡️
    │   │   │                           (Manejo global de errores)
    │   │   │
    │   │   └── resources/
    │   │       ├── application.properties 🔧
    │   │       │   ├── H2 Database config
    │   │       │   ├── JPA/Hibernate config
    │   │       │   └── Consola H2 enabled
    │   │       │
    │   │       ├── static/ (Archivos estáticos)
    │   │       └── templates/ (Plantillas)
    │   │
    │   └── test/
    │       └── java/
    │           └── com/biblio2/biblio2/
    │               └── Biblio2ApplicationTests.java
    │
    └── target/ (Compilado)
        └── [Clases compiladas]

```

---

## 📊 Resumen por Capa

### 🎯 DOMINIO (7 archivos)
```
domain/
├── entity/
│   └── Libro.java                    (Entidad pura)
├── port/
│   └── LibroRepositoryPort.java      (Puerto)
└── usecase/
    ├── CrearLibroUseCase.java
    ├── ObtenerLibrosUseCase.java
    ├── ObtenerLibroPorIdUseCase.java
    ├── ActualizarLibroUseCase.java
    └── EliminarLibroUseCase.java
```

### ⚙️ APLICACIÓN (2 archivos)
```
application/
├── service/
│   └── LibroApplicationService.java  (Servicio)
└── exception/
    └── LibroNoEncontradoException.java
```

### 🔌 INFRAESTRUCTURA (7 archivos)
```
infrastructure/
├── persistence/
│   ├── entity/
│   │   └── LibroEntity.java          (JPA)
│   ├── repository/
│   │   └── LibroJpaRepository.java   (Spring Data)
│   └── adapter/
│       └── LibroRepositoryAdapter.java (Adaptador)
└── rest/
    ├── controller/
    │   └── LibroController.java       (REST)
    ├── dto/
    │   ├── LibroRequest.java
    │   └── LibroResponse.java
    └── exception/
        └── GlobalExceptionHandler.java
```

---

## 🎯 Leyenda de Símbolos

| Símbolo | Significado |
|---------|-------------|
| ✨ | Entidad de dominio |
| 🚪 | Puerto (interfaz) |
| 📝 | Caso de uso |
| 📖 | Caso de uso |
| 🔍 | Caso de uso |
| ✏️ | Caso de uso |
| 🗑️ | Caso de uso |
| 🔧 | Servicio de aplicación |
| ⚠️ | Excepción |
| 📊 | Entidad JPA |
| 🏦 | Repositorio |
| 🔗 | Adaptador |
| 🌐 | Controlador REST |
| 📬 | DTO entrada |
| 📭 | DTO salida |
| 🛡️ | Handler excepciones |
| 🔧 | Configuración |
| 🏠 | Clase de inicio |

---

## 📈 Estadísticas

| Métrica | Valor |
|---------|-------|
| Total de clases | 18 |
| Clases de dominio | 7 |
| Clases de aplicación | 2 |
| Clases de infraestructura | 9 |
| Interfaces | 6 |
| Excepciones | 1 |
| Archivos de documentación | 5 |
| Líneas de código aprox. | 1500+ |

---

## 🔄 Flujo de Dependencias

```
REST HTTP Input
      ↓
   LibroController (REST)
      ↓
   CrearLibroUseCase (Interfaz)
      ↓
   LibroApplicationService (Implementa)
      ↓
   LibroRepositoryPort (Puerto)
      ↓
   LibroRepositoryAdapter (Implementa)
      ↓
   LibroJpaRepository (Spring Data)
      ↓
   LibroEntity (JPA)
      ↓
   H2 Database
      ↓
   Response JSON
```

---

## 🚀 Cómo Navegar en IntelliJ IDEA

### 1. Abrir el Proyecto
```
File → Open → Selecciona: D:\OM\Proyecto 1\biblio2\biblio2
```

### 2. Explorar la Estructura
```
Vista del Proyecto (Project View)
├── Expand "biblio2"
├── Expand "src/main/java"
├── Expand "com/biblio2/biblio2"
├── Verás domain, application, infrastructure
```

### 3. Abrir Clases
- `Ctrl+N` o `Cmd+O` para ir a clase
- Ej: Type "LibroController" para ir al controlador

### 4. Ver Dependencias
- Click derecho en clase → Analyze → Run Dependency Analysis

### 5. Buscar Referencias
- `Ctrl+B` para ir a definición
- `Ctrl+Alt+B` para implementaciones

---

## 📝 Orden de Lectura Recomendado

### 1️⃣ Primero
- `README.md` - Visión general

### 2️⃣ Segundo
- `ARQUITECTURA_HEXAGONAL.md` - Entender arquitectura

### 3️⃣ Tercero
- Explorar en este orden:
  - `domain/entity/Libro.java`
  - `domain/port/LibroRepositoryPort.java`
  - `domain/usecase/*` (todos los casos de uso)

### 4️⃣ Cuarto
- `application/service/LibroApplicationService.java`

### 5️⃣ Quinto
- `infrastructure/persistence/adapter/LibroRepositoryAdapter.java`
- `infrastructure/persistence/entity/LibroEntity.java`
- `infrastructure/rest/controller/LibroController.java`

### 6️⃣ Sexto
- `DIAGRAMA_ARQUITECTURA.md` - Visualizar flujos
- `GUIA_PRUEBAS.md` - Probar endpoints

---

## ⚡ Atajos Útiles en IntelliJ

| Atajo | Acción |
|-------|--------|
| `Ctrl+Alt+Shift+U` | Mostrar diagrama de clases |
| `Ctrl+H` | Ver jerarquía de clases |
| `Ctrl+F12` | Ver estructura del archivo |
| `Alt+F1` | Mostrar en Project view |
| `Ctrl+Shift+A` | Buscar acciones |
| `Ctrl+,` | Abrir Settings |

---

## 🔍 Puntos Clave para Inspeccionar

### En el Dominio
- ✅ No tiene anotaciones @Entity, @Service, @Component
- ✅ No importa nada de Spring
- ✅ No importa JPA
- ✅ Interfaces puras (puertos y casos de uso)

### En la Aplicación
- ✅ Implementa interfaces del dominio
- ✅ Tiene @Service
- ✅ Inyecta puertos (LibroRepositoryPort)
- ✅ No depende de clases JPA

### En la Infraestructura
- ✅ Implementa puertos del dominio
- ✅ Tiene @Component, @Repository, @RestController
- ✅ Usa JPA (@Entity, @Column)
- ✅ Conoce REST (@RequestMapping, @PostMapping)
- ✅ Mapea entre Libro (dominio) y LibroEntity (JPA)

---

## 📌 Archivo de Inicio

**Punto de entrada de la aplicación:**
```
Biblio2Application.java
├── @SpringBootApplication
├── public static void main(String[] args)
└── SpringApplication.run(Biblio2Application.class, args);
```

Ejecuta con: `mvnw spring-boot:run`

---

**Estructura visualizada:** 31/03/2026  
**Versión:** 1.0  
**Formato:** Compatible con IntelliJ IDEA 2023+

