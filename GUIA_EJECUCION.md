# GUÍA DE EJECUCIÓN - BIBLIO2

## 1. REQUISITOS PREVIOS

- ✅ Java 21 (verificar con: `java -version`)
- ✅ Maven 3.6+ (verificar con: `mvn -version`)
- ✅ Git instalado
- ✅ IntelliJ IDEA (donde ya está abierto el proyecto)

---

## 2. COMPILACIÓN DEL PROYECTO

### Opción A: Desde Terminal
```bash
cd "/Users/mora/Documents/Proyectos Java Spriing/biblio2/biblio2"
mvn clean compile
```

### Opción B: Desde IntelliJ
1. Click en el menú: **Build** → **Build Project**
2. O presionar: **Cmd + F9** (en macOS)

**Resultado esperado**: ✅ BUILD SUCCESS (solo advertencias de métodos nunca usados)

---

## 3. EJECUCIÓN DE TESTS

```bash
cd "/Users/mora/Documents/Proyectos Java Spriing/biblio2/biblio2"
mvn test
```

**O desde IntelliJ**:
1. Click derecho en: `src/test/java`
2. Seleccionar: **Run 'Tests' in 'biblio2'**

---

## 4. EJECUTAR LA APLICACIÓN

### Opción A: Desde Terminal
```bash
cd "/Users/mora/Documents/Proyectos Java Spriing/biblio2/biblio2"
mvn spring-boot:run
```

### Opción B: Desde IntelliJ
1. Abre: `src/main/java/com/biblio2/biblio2/Biblio2Application.java`
2. Click en el icono **▶ Run** junto a la clase
3. O presiona: **Ctrl + R**

### Opción C: Empaquetar y Ejecutar JAR
```bash
cd "/Users/mora/Documents/Proyectos Java Spriing/biblio2/biblio2"
mvn clean package
java -jar target/biblio2-0.0.1-SNAPSHOT.jar
```

**Salida esperada**:
```
Started Biblio2Application in X.XXX seconds
```

---

## 5. ACCESO A LA APLICACIÓN

### API REST Principal
- **URL**: http://localhost:8080

### H2 Database Console (Desarrollo)
- **URL**: http://localhost:8080/h2-console
- **Driver Class**: org.h2.Driver
- **JDBC URL**: jdbc:h2:mem:testdb
- **User Name**: sa
- **Password**: (dejar vacío)

---

## 6. ENDPOINTS DISPONIBLES

### Usuarios

#### Registrar nuevo usuario
```bash
curl -X POST http://localhost:8080/api/usuarios/registrar \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Pérez",
    "email": "juan@example.com",
    "password": "mi_contraseña_segura"
  }'
```

#### Obtener usuario por ID
```bash
curl -X GET http://localhost:8080/api/usuarios/1
```

#### Obtener usuario por email
```bash
curl -X GET http://localhost:8080/api/usuarios/email/juan@example.com
```

#### Actualizar usuario
```bash
curl -X PUT http://localhost:8080/api/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Carlos Pérez",
    "email": "juancarlos@example.com"
  }'
```

### Libros (Existentes)

#### Crear libro
```bash
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Clean Code",
    "autor": "Robert C. Martin",
    "isbn": "978-0132350884"
  }'
```

#### Obtener todos los libros
```bash
curl -X GET http://localhost:8080/api/libros
```

### Préstamos

#### Crear préstamo (usuario 1 toma libro 1)
```bash
curl -X POST http://localhost:8080/api/prestamos \
  -H "Content-Type: application/json" \
  -d '{
    "usuarioId": 1,
    "libroId": 1
  }'
```

#### Listar préstamos de un usuario
```bash
curl -X GET http://localhost:8080/api/prestamos/usuario/1
```

#### Devolver un préstamo
```bash
curl -X PUT http://localhost:8080/api/prestamos/1/devolver
```

#### Renovar un préstamo
```bash
curl -X PUT http://localhost:8080/api/prestamos/1/renovar
```

---

## 7. FLUJO DE PRUEBA MANUAL

### Paso 1: Crear Usuario
```bash
curl -X POST http://localhost:8080/api/usuarios/registrar \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "María García",
    "email": "maria@example.com",
    "password": "pass123"
  }'
```
**Respuesta**: Obtendrás ID de usuario (p.ej. `"id": 1`)

### Paso 2: Crear Libro
```bash
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Spring in Action",
    "autor": "Craig Walls",
    "isbn": "978-1617294945"
  }'
```
**Respuesta**: Obtendrás ID de libro (p.ej. `"id": 1`)

### Paso 3: Crear Préstamo
```bash
curl -X POST http://localhost:8080/api/prestamos \
  -H "Content-Type: application/json" \
  -d '{
    "usuarioId": 1,
    "libroId": 1
  }'
```
**Respuesta**: Préstamo creado con ID (p.ej. `"id": 1`)

### Paso 4: Verificar Préstamo
```bash
curl -X GET http://localhost:8080/api/prestamos/usuario/1
```
**Respuesta**: Listado con el préstamo creado

### Paso 5: Renovar Préstamo
```bash
curl -X PUT http://localhost:8080/api/prestamos/1/renovar
```
**Respuesta**: Préstamo con nueva fecha de devolución

### Paso 6: Devolver Préstamo
```bash
curl -X PUT http://localhost:8080/api/prestamos/1/devolver
```
**Respuesta**: Éxito (sin contenido)

### Paso 7: Verificar que Libro está disponible
```bash
curl -X GET http://localhost:8080/api/libros/1
```
**Respuesta**: `"prestado": false`

---

## 8. CÓDIGOS DE RESPUESTA HTTP

| Código | Significado | Ejemplo |
|--------|-------------|---------|
| **200** | OK - Solicitud exitosa | GET /api/usuarios/1 |
| **201** | Created - Recurso creado | POST /api/usuarios/registrar |
| **400** | Bad Request - Datos inválidos | Libro no disponible para préstamo |
| **404** | Not Found - Recurso no existe | Usuario con ID 999 no encontrado |
| **500** | Internal Server Error | Error no controlado |

---

## 9. ESTRUCTURA DE RESPUESTAS

### Respuesta Exitosa (200)
```json
{
  "id": 1,
  "nombre": "María García",
  "email": "maria@example.com"
}
```

### Respuesta de Error (404/400)
```json
{
  "timestamp": "2024-04-26T10:30:45.123456",
  "status": 404,
  "error": "Usuario no encontrado",
  "message": "Usuario con ID 999 no encontrado"
}
```

---

## 10. VARIABLES DE ENTORNO

No se requieren variables de entorno. Todo está configurado en `application.properties`:

```properties
spring.application.name=biblio2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
```

---

## 11. TROUBLESHOOTING

### Error: "Port 8080 already in use"
```bash
# Encuentra el proceso que usa el puerto
lsof -i :8080

# Mata el proceso (obtén el PID del paso anterior)
kill -9 <PID>

# O especifica otro puerto
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

### Error: "No se encuentra Java 21"
```bash
# Verifica la versión instalada
java -version

# Descarga Java 21 desde: https://www.oracle.com/java/technologies/downloads/
# O usa sdkman: sdk install java 21.0.1-oracle
```

### Error: "Connection refused" en tests
- Asegúrate que la aplicación no está ejecutándose en segundo plano
- Los tests inician su propia instancia de base de datos

### Error en compilación de Maven
```bash
# Limpia la caché de Maven
mvn clean
rm -rf ~/.m2/repository

# Compila de nuevo
mvn compile
```

---

## 12. MONITOREO

### Logs en Tiempo Real
Mientras la aplicación corre, verás logs como:

```
2024-04-26 10:30:15.123  INFO 12345 --- [main] o.s.b.w.e.tomcat.TomcatWebServer: Tomcat started on port(s): 8080
2024-04-26 10:30:15.456  INFO 12345 --- [main] c.b.b.Biblio2Application: Started Biblio2Application in 3.456 seconds
2024-04-26 10:30:25.789  INFO 12345 --- [http-nio-8080-exec-1] c.b.b.i.r.c.UsuarioController: POST /api/usuarios/registrar
```

### Acceso a Base de Datos
1. Abre: http://localhost:8080/h2-console
2. Ejecuta consultas SQL directas para verificar datos

---

## 13. DETENER LA APLICACIÓN

### Si está corriendo en terminal
Presiona: **Ctrl + C**

### Si está corriendo en IntelliJ
Click en: **Stop** (cuadrado rojo en toolbar)

---

## 14. PRÓXIMAS MEJORAS

Después de verificar que todo funciona:

1. **Autenticación JWT**: Implementar tokens de autenticación
2. **Swagger/OpenAPI**: Documentación interactiva de APIs
3. **Validaciones**: Anotaciones @Valid, @NotNull, etc.
4. **Tests**: Aumentar cobertura de tests unitarios e integración
5. **Docker**: Crear Dockerfile para ejecutar en contenedor
6. **PostgreSQL**: Cambiar de H2 a PostgreSQL en producción

---

## 15. COMANDOS RÁPIDOS

```bash
# Compilar
mvn clean compile

# Tests
mvn test

# Ejecutar
mvn spring-boot:run

# Empaquetar
mvn clean package

# Ejecutar JAR
java -jar target/biblio2-0.0.1-SNAPSHOT.jar

# Ver dependencias
mvn dependency:tree

# Limpiar todo
mvn clean
```

---

**¡La aplicación está lista para usar!** 🎉

Generado: 26/04/2024

