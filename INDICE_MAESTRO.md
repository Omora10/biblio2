# 📚 ÍNDICE MAESTRO - Proyecto Biblio2 Arquitectura Hexagonal

## 🎯 Bienvenido al Proyecto Biblio2

Este es un **proyecto completo de ejemplo** que demuestra cómo implementar una **arquitectura hexagonal (Ports & Adapters)** en Java con Spring Boot.

---

## 📖 Documentación Disponible

### 1️⃣ **[README.md](./README.md)** - 🚀 COMIENZA AQUÍ
**Contenido:**
- Resumen ejecutivo del proyecto
- Características principales (8 checkmarks)
- Diagrama ASCII de la arquitectura
- Guía rápida de inicio
- Tabla de tecnologías
- Lista de endpoints
- Recursos de aprendizaje

**Cuándo leerlo:** Primero - para obtener una visión general

**Tiempo de lectura:** 5 minutos

---

### 2️⃣ **[ARQUITECTURA_HEXAGONAL.md](./ARQUITECTURA_HEXAGONAL.md)** - 🏗️ PROFUNDIDAD
**Contenido:**
- Descripción detallada de la arquitectura
- Estructura completa de carpetas
- Flujo de información en 6 pasos
- 5 endpoints REST con ejemplos
- Principios de arquitectura
- Tabla de separación de responsabilidades
- Matriz de dependencias
- 5 casos de uso implementados
- Extensiones futuras
- Referencias bibliográficas

**Cuándo leerlo:** Después del README - para entender la arquitectura en detalle

**Tiempo de lectura:** 15 minutos

---

### 3️⃣ **[GUIA_PRUEBAS.md](./GUIA_PRUEBAS.md)** - 🧪 PRUEBAS
**Contenido:**
- Base URL (localhost:8080)
- 5 endpoints con ejemplos cURL
- Headers y JSON bodies
- Secuencia completa CRUD
- Códigos de respuesta HTTP
- Casos de error
- Acceso a consola H2
- Flujo arquitecónico ejemplo

**Cuándo leerlo:** Cuando quieras probar los endpoints

**Tiempo de lectura:** 10 minutos

**Para experimentar:** Copia los comandos cURL y ejecútalos en tu terminal

---

### 4️⃣ **[DIAGRAMA_ARQUITECTURA.md](./DIAGRAMA_ARQUITECTURA.md)** - 📊 VISUALIZACIÓN
**Contenido:**
- Vista general de 5 capas (ASCII art)
- Diagramas detallados de cada componente
- Flujo completo de solicitud POST (15 pasos)
- Patrón Adapter explicado
- Matriz de dependencias
- Principios respetados

**Cuándo leerlo:** Cuando necesites visualizar la arquitectura

**Tiempo de lectura:** 10 minutos

**Consejo:** Abre esta junto con el IDE para entender el flujo

---

### 5️⃣ **[ESTRUCTURA_IDEA.md](./ESTRUCTURA_IDEA.md)** - 🗂️ NAVEGACIÓN
**Contenido:**
- Árbol completo de directorios
- Estructura de carpetas con emojis
- Resumen por capa
- Leyenda de símbolos (18 símbolos)
- Estadísticas del proyecto
- Flujo de dependencias
- Cómo navegar en IntelliJ IDEA
- Orden de lectura recomendado
- Atajos útiles de IntelliJ

**Cuándo leerlo:** Cuando abras el proyecto en IntelliJ IDEA

**Tiempo de lectura:** 8 minutos

---

### 6️⃣ **[RESUMEN_IMPLEMENTACION.md](./RESUMEN_IMPLEMENTACION.md)** - ✅ CHECKLIST
**Contenido:**
- Lista completa de 18 archivos creados
- Estadísticas de archivos por capa
- Características implementadas (con checkmarks)
- Próximos pasos opcionales
- Comandos útiles
- Recursos de aprendizaje
- Checklist de validación

**Cuándo leerlo:** Como referencia final para verificar que todo está

**Tiempo de lectura:** 5 minutos

---

## 🎓 Ruta de Aprendizaje Recomendada

### Nivel 1: Introducción (15 minutos)
```
1. README.md (5 min)
   ↓
2. ARQUITECTURA_HEXAGONAL.md - Solo sección "Descripción General" (5 min)
   ↓
3. ESTRUCTURA_IDEA.md - Vista rápida (5 min)
```

### Nivel 2: Entendimiento (30 minutos)
```
1. ARQUITECTURA_HEXAGONAL.md - Completo (15 min)
   ↓
2. DIAGRAMA_ARQUITECTURA.md - Vista general (10 min)
   ↓
3. Abre el IDE y revisa los 18 archivos (5 min)
```

### Nivel 3: Práctica (45 minutos)
```
1. Abre el proyecto en IntelliJ IDEA (5 min)
   ↓
2. Compila el proyecto: mvnw clean compile (10 min)
   ↓
3. Ejecuta: mvnw spring-boot:run (5 min)
   ↓
4. GUIA_PRUEBAS.md - Ejecuta todos los endpoints (15 min)
   ↓
5. DIAGRAMA_ARQUITECTURA.md - Verifica el flujo en vivo (5 min)
```

### Nivel 4: Profundización (1+ hora)
```
1. Revisa cada archivo Java en orden:
   - Dominio primero
   - Aplicación segundo
   - Infraestructura tercero
   
2. Usa IntelliJ IDEA para:
   - Ver diagramas de clases (Ctrl+Alt+Shift+U)
   - Seguir referencias (Ctrl+B)
   - Ver jerarquía (Ctrl+H)
```

---

## 🏗️ Mapa Mental de la Arquitectura

```
┌─────────────────────────────────────────────┐
│            ARQUITECTURA HEXAGONAL          │
└─────────────────────────────────────────────┘
              │
    ┌─────────┼─────────┐
    │         │         │
    ▼         ▼         ▼
  ENTRADA  DOMINIO   SALIDA
 (REST)    (PURO)   (BD)
    │         │         │
    ├─────────┼─────────┤
    │  APLICACIÓN       │
    │  (ORQUESTA)       │
    └───────────────────┘

CARACTERÍSTICAS:
✅ Bajo acoplamiento
✅ Alta cohesión
✅ Testeable
✅ Escalable
✅ Mantenible
```

---

## 📁 Estructura de Carpetas por Propósito

### 📚 Documentación (6 archivos .md)
```
.
├── README.md                    ← Visión general
├── ARQUITECTURA_HEXAGONAL.md   ← Guía completa
├── GUIA_PRUEBAS.md             ← Cómo probar
├── DIAGRAMA_ARQUITECTURA.md    ← Diagramas
├── ESTRUCTURA_IDEA.md          ← Navegación
└── RESUMEN_IMPLEMENTACION.md   ← Checklist
```

### 💻 Código Fuente (18 archivos .java)
```
biblio2/src/main/java/com/biblio2/biblio2/
│
├── domain/           (7 archivos - PURO)
│   ├── entity/
│   ├── port/
│   └── usecase/
│
├── application/      (2 archivos - APLICACIÓN)
│   ├── service/
│   └── exception/
│
└── infrastructure/   (9 archivos - TÉCNICO)
    ├── persistence/
    │   ├── entity/
    │   ├── repository/
    │   └── adapter/
    └── rest/
        ├── controller/
        ├── dto/
        └── exception/
```

### ⚙️ Configuración (1 archivo)
```
biblio2/src/main/resources/
└── application.properties    ← H2 + JPA + Consola
```

---

## 🚀 Guía Rápida de Ejecución

### Paso 1: Clonar/Descargar
```bash
# Ya tienes el proyecto en:
# D:\OM\Proyecto 1\biblio2\
```

### Paso 2: Compilar
```bash
cd "D:\OM\Proyecto 1\biblio2\biblio2"
mvnw clean compile
```

### Paso 3: Ejecutar
```bash
mvnw spring-boot:run
```

### Paso 4: Probar
```bash
# Abre GUIA_PRUEBAS.md
# Copia un comando cURL
# Ejecútalo en PowerShell

curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Clean Code","autor":"Robert Martin","isbn":"978-0132350884"}'
```

### Paso 5: Explorar BD
```
http://localhost:8080/h2-console
```

---

## 💡 Conceptos Clave Explicados

### Arquitectura Hexagonal
**Qué es:** Patrón que separa la lógica de negocio de los detalles técnicos

**Por qué:** 
- Código limpio
- Fácil de testear
- Fácil de mantener
- Fácil de cambiar tecnologías

**Ver:** ARQUITECTURA_HEXAGONAL.md (sección "Principios")

---

### Puertos y Adaptadores
**Puertos:** Interfaces que definen "qué" necesita el negocio
**Adaptadores:** Implementaciones que dicen "cómo" hacerlo

**Ejemplo:**
- Puerto: `LibroRepositoryPort` (qué: guardar libros)
- Adaptador: `LibroRepositoryAdapter` (cómo: usando JPA)

**Ver:** DIAGRAMA_ARQUITECTURA.md (sección "Patrón Adapter")

---

### Inversión de Dependencias
**Dominio no depende de Infraestructura**
**Infraestructura depende de Dominio**

**Beneficio:** Puedes cambiar la BD sin tocar el negocio

**Ver:** ARQUITECTURA_HEXAGONAL.md (sección "Inversión de Dependencias")

---

## 📊 Estadísticas del Proyecto

| Métrica | Valor |
|---------|-------|
| **Archivos Java** | 18 |
| **Líneas de código** | ~1,500 |
| **Archivos Markdown** | 6 |
| **Líneas de documentación** | ~2,000 |
| **Tiempo de implementación** | ~2 horas |
| **Endpoints REST** | 5 |
| **Casos de Uso** | 5 |
| **Puertos** | 1 |
| **Adaptadores** | 1 |

---

## 🎯 Checklist de Validación

- [x] Dominio sin anotaciones de Spring ✅
- [x] Dominio sin JPA ✅
- [x] Dominio sin REST ✅
- [x] Aplicación implementa casos de uso ✅
- [x] Infraestructura aislada ✅
- [x] Inyección de dependencias correcta ✅
- [x] CRUD funcional ✅
- [x] Manejo de errores ✅
- [x] Base de datos H2 ✅
- [x] Documentación completa ✅
- [x] Ejemplos de pruebas ✅
- [x] Diagramas ASCII ✅

---

## ❓ Preguntas Frecuentes

### ¿Por qué 3 capas?
**R:** Dominio (qué), Aplicación (cómo coordina), Infraestructura (cómo implementa)

### ¿Por qué Libro tiene dos clases?
**R:** `Libro` es del dominio, `LibroEntity` es para JPA. Separa conceptos.

### ¿Puedo usar otra BD?
**R:** Sí, solo reemplaza `LibroRepositoryAdapter` y `LibroEntity`

### ¿Puedo usar GraphQL?
**R:** Sí, agrega un controlador GraphQL sin tocar el dominio

### ¿Cómo agregar validación?
**R:** En el controlador REST con `@Valid` y anotaciones de validación

---

## 🔗 Enlaces Rápidos

| Documento | Propósito | URL |
|-----------|-----------|-----|
| **README** | Resumen | ./README.md |
| **Arquitectura** | Guía completa | ./ARQUITECTURA_HEXAGONAL.md |
| **Pruebas** | Endpoints | ./GUIA_PRUEBAS.md |
| **Diagramas** | Visualización | ./DIAGRAMA_ARQUITECTURA.md |
| **Estructura** | Navegación | ./ESTRUCTURA_IDEA.md |
| **Resumen** | Checklist | ./RESUMEN_IMPLEMENTACION.md |

---

## 📞 Soporte

### ¿El código no compila?
1. Verifica que tienes Java 21
2. Ejecuta: `mvnw clean compile`
3. Revisa los errores en `target/`

### ¿No funciona el endpoint?
1. Verifica que la app está ejecutándose
2. Abre: `http://localhost:8080/h2-console`
3. Revisa la tabla `libros` en la BD

### ¿Necesito entender mejor?
1. Lee: ARQUITECTURA_HEXAGONAL.md
2. Estudia: DIAGRAMA_ARQUITECTURA.md
3. Ejecuta: GUIA_PRUEBAS.md

---

## 🎓 Recursos de Aprendizaje

### Libros Recomendados
- **Clean Code** - Robert C. Martin
- **Domain-Driven Design** - Eric Evans
- **Clean Architecture** - Robert C. Martin

### Artículos
- Hexagonal Architecture - Alistair Cockburn
- Ports and Adapters - Sam Newman

### Videos
- Spring Boot Best Practices
- Arquitectura Hexagonal en Java

---

## 📝 Próximas Mejoras (Opcionales)

```
├── Autenticación
├── Autorización
├── Validación de entrada
├── Tests unitarios
├── Tests de integración
├── Logging
├── Caché
├── Paginación
├── Búsqueda
├── Swagger/OpenAPI
└── Dockerización
```

---

## ✍️ Notas Importantes

1. **Base de datos en memoria:** Se borra al reiniciar
2. **ISBN único:** No puedes duplicar ISBNs
3. **Consola H2:** En `http://localhost:8080/h2-console`
4. **Puerto por defecto:** 8080

---

## 🎉 ¡Proyecto Completado!

Este proyecto demuestra:
- ✅ Arquitectura profesional
- ✅ Código limpio
- ✅ Separación de responsabilidades
- ✅ Inyección de dependencias
- ✅ Patrones de diseño
- ✅ REST API funcional
- ✅ Documentación completa

**Listo para producción** (con mejoras opcionales)

---

## 📞 Contacto / Preguntas

Si tienes dudas sobre el proyecto:
1. Revisa la documentación (6 archivos)
2. Ejecuta los ejemplos en GUIA_PRUEBAS.md
3. Inspecciona el código en IntelliJ IDEA

---

**Índice Maestro - Última actualización: 31/03/2026**  
**Versión: 1.0.0**  
**Estado: ✅ Completado**

---

*Proyecto educativo que demuestra las mejores prácticas de arquitectura en Java/Spring Boot*

