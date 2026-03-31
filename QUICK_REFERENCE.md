# ⚡ Referencia Rápida - Biblio2

## 🚀 Inicio en 30 segundos

```bash
# 1. Compilar
cd "D:\OM\Proyecto 1\biblio2\biblio2"
mvnw clean compile

# 2. Ejecutar
mvnw spring-boot:run

# 3. Probar (en otra terminal)
curl http://localhost:8080/api/libros
```

---

## 📡 Endpoints Rápidos

| Método | URL | Body |
|--------|-----|------|
| **POST** | `/api/libros` | `{"titulo":"X","autor":"Y","isbn":"Z"}` |
| **GET** | `/api/libros` | (ninguno) |
| **GET** | `/api/libros/1` | (ninguno) |
| **PUT** | `/api/libros/1` | `{"titulo":"X","autor":"Y","isbn":"Z"}` |
| **DELETE** | `/api/libros/1` | (ninguno) |

---

## 🏗️ Estructura Simplificada

```
Domain (PURO)
  ├── Libro (entidad)
  ├── LibroRepositoryPort (puerto)
  └── 5 UseCases (interfaces)
        ↓
Application (ORQUESTA)
  └── LibroApplicationService
        ↓
Infrastructure (TÉCNICO)
  ├── LibroEntity (JPA)
  ├── LibroRepositoryAdapter
  └── LibroController (REST)
```

---

## 📁 Rutas Importantes

```
Código:           D:\OM\Proyecto 1\biblio2\biblio2\src\main\java
Dominio:          ...domain\
Aplicación:       ...application\
Infraestructura:  ...infrastructure\
Configuración:    ..\resources\application.properties
```

---

## 🎯 Archivos Clave para Entender

```
1. Empieza aquí:
   → domain/entity/Libro.java
   → domain/port/LibroRepositoryPort.java
   
2. Luego ve aquí:
   → application/service/LibroApplicationService.java
   
3. Finalmente:
   → infrastructure/rest/controller/LibroController.java
   → infrastructure/persistence/adapter/LibroRepositoryAdapter.java
```

---

## 💻 Comandos Frecuentes

```bash
# Compilar
mvnw clean compile

# Ejecutar
mvnw spring-boot:run

# Tests
mvnw test

# Empaquetar
mvnw clean package

# Limpiar
mvnw clean

# Ver dependencias
mvnw dependency:tree
```

---

## 🔗 URLs Útiles (cuando app está ejecutándose)

```
API:           http://localhost:8080/api/libros
H2 Console:    http://localhost:8080/h2-console
Credenciales:  user=sa, password=(dejar en blanco)
```

---

## 📊 Tabla de Responsabilidades

| Capa | ¿Qué hace? | ¿Qué no hace? |
|------|-----------|---------------|
| **Domain** | Lógica de negocio | Spring, JPA, REST |
| **Application** | Orquesta casos de uso | REST, JPA directo |
| **Infrastructure** | REST, JPA, BD | Lógica de negocio |

---

## 🧪 Ejemplos cURL Rápidos

### Crear
```bash
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Clean Code","autor":"Martin","isbn":"123"}'
```

### Leer
```bash
curl http://localhost:8080/api/libros
curl http://localhost:8080/api/libros/1
```

### Actualizar
```bash
curl -X PUT http://localhost:8080/api/libros/1 \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Updated","autor":"Martin","isbn":"123"}'
```

### Eliminar
```bash
curl -X DELETE http://localhost:8080/api/libros/1
```

---

## ⚠️ Códigos de Error

| Código | Significado |
|--------|-------------|
| **200** | OK |
| **201** | Creado ✓ |
| **204** | Eliminado ✓ |
| **404** | No encontrado |
| **500** | Error servidor |

---

## 🔍 Debugging Rápido

### ¿No compila?
```
1. mvnw clean compile
2. Revisa D:\OM\Proyecto 1\biblio2\biblio2\target\
```

### ¿No funciona el endpoint?
```
1. Verifica que mvnw spring-boot:run está en ejecución
2. Abre http://localhost:8080/api/libros
3. Revisa la consola por errores
```

### ¿BD vacía?
```
1. Es normal, es en memoria
2. Crea datos: POST /api/libros
3. Verifica en h2-console
```

---

## 📚 Documentación Disponible

| Archivo | Lectura |
|---------|---------|
| **README.md** | 5 min |
| **ARQUITECTURA_HEXAGONAL.md** | 15 min |
| **DIAGRAMA_ARQUITECTURA.md** | 10 min |
| **GUIA_PRUEBAS.md** | 10 min |
| **ESTRUCTURA_IDEA.md** | 8 min |
| **INDICE_MAESTRO.md** | 5 min |

---

## 🎓 Conceptos en 10 segundos

**Hexagonal:** Dominio en el centro, Infraestructura en los lados  
**Puertos:** Lo que el negocio necesita  
**Adaptadores:** Cómo lo implementamos  
**Inversión:** Infraestructura depende de Dominio  

---

## ✅ Checklist Rápido

- [ ] Compilé el proyecto
- [ ] Ejecuté `mvnw spring-boot:run`
- [ ] Probé un endpoint con cURL
- [ ] Accedí a h2-console
- [ ] Leí README.md
- [ ] Entré ARQUITECTURA_HEXAGONAL.md
- [ ] Inspección el código en el IDE

---

## 🆘 SOS Rápido

**P:** ¿Por qué hay dos clases Libro?  
**R:** Una es dominio (pura), otra es JPA (BD)

**P:** ¿Puedo cambiar de BD?  
**R:** Sí, solo cambia `LibroRepositoryAdapter` y `LibroEntity`

**P:** ¿Dónde está la lógica?  
**R:** En `LibroApplicationService`

**P:** ¿Dónde está la BD?  
**R:** En memoria H2, no se persiste entre reinicios

**P:** ¿Cómo agrego más funcionalidad?  
**R:** Agrega casos de uso en domain/usecase/

---

**Creado:** 31/03/2026  
**Versión:** 1.0  
**Tipo:** Quick Reference

