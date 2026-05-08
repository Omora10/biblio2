# ⚡ QUICK START - BIBLIO2

## 🚀 Inicio Rápido en 5 Minutos

### 1️⃣ Ubicarse en el proyecto
```bash
cd "/Users/mora/Documents/Proyectos Java Spriing/biblio2/biblio2"
```

### 2️⃣ Compilar
```bash
mvn clean compile
```
**Esperado:** `BUILD SUCCESS`

### 3️⃣ Ejecutar
```bash
mvn spring-boot:run
```
**Esperado:** `Started Biblio2Application in X.XXX seconds`

### 4️⃣ Probar (en otra terminal)
```bash
# Crear un libro
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{"titulo": "Test", "autor": "Author", "isbn": "123"}'

# Listar libros
curl http://localhost:8080/api/libros
```

### 5️⃣ Acceder a la BD (H2 Console)
```
http://localhost:8080/h2-console
Credenciales: sa / (sin contraseña)
```

---

## 📝 REFACTORIZACIÓN COMPLETADA

✅ **Problema principal resuelto:** Conflicto de métodos en `PrestamoApplicationService`

**Cambios realizados:**
1. ✅ Interfaz consolidada `PrestamoUseCases` creada
2. ✅ `PrestamoApplicationService` refactorizado
3. ✅ `PrestamoController` actualizado
4. ✅ `LibroController` importaciones actualizadas

---

## 📚 DOCUMENTACIÓN CREADA

1. **RESUMEN_REFACTORIZACION.md** - Resumen ejecutivo
2. **CAMBIOS_DETALLADOS.md** - Listado específico de cambios
3. **ESTRUCTURA_FINAL.md** - Árbol de directorios y arquitectura
4. **GUIA_EJECUCION_COMPLETA.md** - Guía détallada con ejemplos curl
5. **QUICK_START.md** - Este archivo (inicio rápido)

---

## 🎯 ENDPOINTS PRINCIPALES

### Libros
```bash
GET    /api/libros                    # Listar todos
POST   /api/libros                    # Crear
GET    /api/libros/{id}              # Obtener por ID
PUT    /api/libros/{id}              # Actualizar
DELETE /api/libros/{id}              # Eliminar
```

### Usuarios
```bash
POST   /api/usuarios/registrar        # Registrar
GET    /api/usuarios/{id}            # Obtener por ID
PUT    /api/usuarios/{id}            # Actualizar
GET    /api/usuarios/email/{email}   # Obtener por email
```

### Préstamos
```bash
POST   /api/prestamos                 # Crear préstamo
PUT    /api/prestamos/{id}/devolver  # Devolver
PUT    /api/prestamos/{id}/renovar   # Renovar
GET    /api/prestamos/usuario/{id}   # Listar por usuario
```

---

## 🛠 COMANDOS ÚTILES

```bash
# Compilar
mvn clean compile

# Tests
mvn test

# Empaquetar
mvn clean package

# Ejecutar
mvn spring-boot:run

# JAR
java -jar target/biblio2-0.0.1-SNAPSHOT.jar

# Dependencias
mvn dependency:tree

# Limpiar caché
mvn clean -U
```

---

## ⚠️ PENDIENTES

**Eliminar archivos duplicados:**
```bash
cd biblio2
rm src/main/java/com/biblio2/biblio2/domain/usecase/CrearLibroUseCase.java
rm src/main/java/com/biblio2/biblio2/domain/usecase/ObtenerLibrosUseCase.java
rm src/main/java/com/biblio2/biblio2/domain/usecase/ObtenerLibroPorIdUseCase.java
rm src/main/java/com/biblio2/biblio2/domain/usecase/EliminarLibroUseCase.java
rm src/main/java/com/biblio2/biblio2/domain/usecase/ActualizarLibroUseCase.java
```

---

## ✅ VERIFICACIÓN

Después de ejecutar, verificar que:

- [x] Aplicación inicia sin errores
- [x] Endpoints responden correctamente
- [x] Base de datos H2 funciona
- [x] Consola H2 accesible en `/h2-console`
- [x] Logs muestran dependencias inyectadas correctamente

---

## 🔍 TROUBLESHOOTING RÁPIDO

| Problema | Solución |
|----------|----------|
| Port 8080 in use | Cambiar en `application.properties`: `server.port=8081` |
| Errores de compilación | `mvn clean compile` |
| Tests fallando | `mvn test -DskipTests` para saltar |
| BD no se crea | Verificar `spring.jpa.hibernate.ddl-auto=create-drop` |
| Imports no resueltos | `mvn clean install` |

---

## 📖 ARQUITECTURA EN 1 VISTAZO

```
Request HTTP
    ↓
Controller REST (Input Adapter)
    ↓
Application Service (Orquestador)
    ↓
Domain (Lógica de negocio pura)
    ↓
Repository Port (Contrato)
    ↓
Repository Adapter (Output Adapter)
    ↓
Spring Data JPA
    ↓
Base de Datos H2
    ↓
Response JSON
```

---

## 🎓 RECURSOS RÁPIDOS

- API Documentation: Una vez corriendo acceder a [Swagger UI](http://localhost:8080/swagger-ui.html) si lo configuras
- H2 Console: http://localhost:8080/h2-console
- Logs: Ver en consola durante ejecución con `mvn spring-boot:run`

---

## ✨ PRÓXIMOS PASOS

1. ✅ Compilar y ejecutar exitosamente
2. ✅ Probar endpoints con curl/Postman
3. ⏳ Eliminar archivos duplicados
4. ⏳ Escribir unit tests
5. ⏳ Agregar validaciones
6. ⏳ Migrar a BD real (PostgreSQL)
7. ⏳ Implementar JWT
8. ⏳ Documentar API con Swagger

---

## 📞 REFERENCIAS

Ver documentación detallada en:
- `RESUMEN_REFACTORIZACION.md` - Contexto completo
- `CAMBIOS_DETALLADOS.md` - Qué cambió exactamente
- `ESTRUCTURA_FINAL.md` - Arquitectura completa
- `GUIA_EJECUCION_COMPLETA.md` - Guía paso a paso

---

**Estado:** ✅ LISTO PARA USAR  
**Fecha:** 8 de mayo de 2026  
**Arquitectura:** Clean + Hexagonal  
**Build:** Maven  
**IDE:** IntelliJ IDEA (recomendado)

