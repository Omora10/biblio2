# 🚀 GUÍA DE EJECUCIÓN - PROYECTO BIBLIO2

## ✅ REQUISITOS PREVIOS

- **Java:** 21 (OpenJDK o similar)
- **Maven:** 3.8.1+
- **Git:** (opcional, para control de versiones)
- **IDE:** IntelliJ IDEA (recomendado) o cualquier editor con soporte Java

### Verificar versiones

```bash
java -version
mvn -version
```

---

## 📍 UBICACIÓN DEL PROYECTO

```
/Users/mora/Documents/Proyectos Java Spriing/biblio2/biblio2
```

---

## 🔧 COMANDOS DE COMPILACIÓN

### 1. Compilar el proyecto

```bash
cd "/Users/mora/Documents/Proyectos Java Spriing/biblio2/biblio2"
mvn clean compile
```

**Salida esperada:**
```
[INFO] BUILD SUCCESS
```

---

### 2. Ejecutar tests (opcional)

```bash
mvn test
```

---

### 3. Empaquetar el proyecto

```bash
mvn clean package
```

Esto genera: `target/biblio2-0.0.1-SNAPSHOT.jar`

---

## 🚀 EJECUCIÓN DE LA APLICACIÓN

### Opción A: Con Maven (Recomendado para desarrollo)

```bash
cd "/Users/mora/Documents/Proyectos Java Spriing/biblio2/biblio2"
mvn spring-boot:run
```

**Salida esperada:**
```
Started Biblio2Application in X.XXX seconds
```

### Opción B: Ejecutar JAR directamente (Después de empaquetar)

```bash
java -jar target/biblio2-0.0.1-SNAPSHOT.jar
```

### Opción C: Con IntelliJ IDEA

1. Abrir el proyecto en IntelliJ
2. Click derecho en `Biblio2Application.java`
3. Seleccionar `Run 'Biblio2Application'`

---

## 🌐 ACCEDER A LA APLICACIÓN

Una vez que la aplicación está corriendo:

### API REST

```
http://localhost:8080
```

### Consola H2 (Base de datos en memoria)

```
http://localhost:8080/h2-console
```

**Credenciales H2:**
- URL: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: (dejar vacío)

---

## 📡 PRUEBAS DE ENDPOINTS

### Libros API

#### Listar todos los libros
```bash
curl -X GET http://localhost:8080/api/libros
```

#### Crear un nuevo libro
```bash
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Clean Code",
    "autor": "Robert C. Martin",
    "isbn": "0132350882"
  }'
```

#### Obtener libro por ID
```bash
curl -X GET http://localhost:8080/api/libros/1
```

#### Actualizar un libro
```bash
curl -X PUT http://localhost:8080/api/libros/1 \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Clean Code - Updated",
    "autor": "Robert C. Martin",
    "isbn": "0132350882"
  }'
```

#### Eliminar un libro
```bash
curl -X DELETE http://localhost:8080/api/libros/1
```

---

### Usuarios API

#### Registrar un nuevo usuario
```bash
curl -X POST http://localhost:8080/api/usuarios/registrar \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Pérez",
    "email": "juan@example.com",
    "password": "password123"
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
    "nombre": "Juan Pérez Actualizado",
    "email": "juan.nuevo@example.com"
  }'
```

---

### Préstamos API

#### Crear un préstamo
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

## 🐛 SOLUCIÓN DE PROBLEMAS

### Error: `mvn: command not found`

**Solución:**
- Instalar Maven desde: https://maven.apache.org/download.cgi
- Agregar Maven al PATH del sistema

### Error: `java: No such file or directory`

**Solución:**
- Instalar Java 21 desde: https://www.oracle.com/java/technologies/downloads/
- Configurar JAVA_HOME

### Error: "Port 8080 already in use"

**Solución:**

**Opción 1:** Cambiar el puerto en `application.properties`
```properties
server.port=8081
```

**Opción 2:** Liberar el puerto
```bash
# En macOS/Linux, encontrar el proceso:
lsof -i :8080

# Matar el proceso:
kill -9 <PID>
```

### Error: "BUILD FAILURE"

**Solución:**
1. Limpiar caché de Maven:
   ```bash
   mvn clean -U
   ```

2. Verificar dependencias:
   ```bash
   mvn dependency:tree
   ```

3. Eliminar archivos duplicados en `domain/usecase/`:
   ```bash
   rm src/main/java/com/biblio2/biblio2/domain/usecase/CrearLibroUseCase.java
   rm src/main/java/com/biblio2/biblio2/domain/usecase/ObtenerLibrosUseCase.java
   rm src/main/java/com/biblio2/biblio2/domain/usecase/ObtenerLibroPorIdUseCase.java
   rm src/main/java/com/biblio2/biblio2/domain/usecase/EliminarLibroUseCase.java
   rm src/main/java/com/biblio2/biblio2/domain/usecase/ActualizarLibroUseCase.java
   ```

---

## 📊 ESTRUCTURA ESPERADA AL COMPILAR

```
target/
├── biblio2-0.0.1-SNAPSHOT.jar          # JAR ejecutable
├── biblio2-0.0.1-SNAPSHOT.jar.original # Original sin dependencias
├── classes/                             # Clases compiladas
│   └── com/biblio2/biblio2/...
├── generated-sources/                   # Código generado
├── maven-status/                        # Estado de Maven
└── maven-archiver/                      # Metadatos
```

---

## 🛠 CONFIGURACIÓN DE VARIABLES DE ENTORNO

### Crear perfil Maven para desarrollo

Editar `pom.xml` (si necesario):

```xml
<profiles>
    <profile>
        <id>dev</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <maven.test.skip>false</maven.test.skip>
        </properties>
    </profile>
</profiles>
```

Ejecutar con perfil:
```bash
mvn clean spring-boot:run -Pdev
```

---

## 📋 CHECKLIST PRE-PRODUCCIÓN

- [ ] Compilación sin errores (`mvn clean compile`)
- [ ] Tests pasando (`mvn test`)
- [ ] Empaquetar correctamente (`mvn package`)
- [ ] Aplicación inicia correctamente (`mvn spring-boot:run`)
- [ ] Todos los endpoints responden
- [ ] Base de datos se crea correctamente (H2)
- [ ] Eliminar archivos duplicados de `domain/usecase/`
- [ ] Documentación actualizada
- [ ] Git commit con cambios (`git add . && git commit -m "refactorización completa"`)

---

## 📚 RECURSOS ADICIONALES

- [Maven Documentation](https://maven.apache.org/)
- [Spring Boot Guide](https://spring.io/guides/gs/spring-boot/)
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)

---

## ✨ TIPS ÚTILES

### 1. Ejecutar solo una clase de test
```bash
mvn test -Dtest=LibroControllerTest
```

### 2. Saltar tests en compilación
```bash
mvn clean compile -DskipTests
```

### 3. Ver árbol de dependencias
```bash
mvn dependency:tree
```

### 4. Actualizar dependencias
```bash
mvn versions:display-dependency-updates
```

### 5. Crear servidor embebido con Maven
```bash
mvn jetty:run  # Si tuvieras Jetty configurado
```

---

## 🔐 SEGURIDAD

Por defecto, el proyecto tiene:
- Spring Security configurado (ver `SecurityConfig.java`)
- Passwords codificados con `BCryptPasswordEncoder`
- CORS habilitado para desarrollo

**IMPORTANTE:** Antes de llevar a producción:
1. Cambiar configuración de CORS
2. Implementar JWT o OAuth2
3. Configurar HTTPS
4. Usar base de datos real (PostgreSQL, MySQL, etc.)
5. Implementar rate limiting

---

## 📞 SOPORTE

Si encuentras problemas:

1. Verificar logs en consola
2. Revisar `RESUMEN_REFACTORIZACION.md`
3. Revisar `CAMBIOS_DETALLADOS.md`
4. Ejecutar `mvn clean compile` para limpiar

---

**Estado:** ✅ Listo para ejecutar  
**Última actualización:** 8 de mayo de 2026  
**Arquitectura:** Clean Architecture con Maven y Spring Boot

