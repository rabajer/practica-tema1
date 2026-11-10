# API del almacén de papelería

API REST construida con Spring Boot y Java 21 para consultar artículos de un almacén. Parte del proyecto base facilitado por el profesor.

## Funcionalidad

- Listado completo de artículos.
- Consulta de los datos básicos (id, nombre y stock) de un artículo.
- Mensaje `Agotado` cuando el stock es cero.
- Respuesta HTTP 404 cuando no existe el identificador solicitado.

## Requisitos

- JDK 21.
- PostgreSQL 17 para el perfil normal, o usar el perfil `h2` para trabajar con una base de datos en memoria.

## Arranque con H2

No requiere instalar ni configurar una base de datos externa.

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=h2
```

En Windows PowerShell:

```powershell
.\mvnw spring-boot:run "-Dspring-boot.run.profiles=h2"
```

La API estará disponible en `http://localhost:8080`.

## Arranque con PostgreSQL

Configura las variables de entorno `DB_PASSWORD` y, si es necesario, `DB_HOST`, `DB_NAME` o `DB_USER`. Los valores predeterminados para host, base de datos y usuario son `localhost`, `almacen` y `almacen`.

```bash
./mvnw spring-boot:run
```

La aplicación crea la tabla y carga los datos de ejemplo con `schema.sql` y `data.sql`.

## Endpoints

| Método | Ruta | Resultado |
|---|---|---|
| `GET` | `/api/articulos` | Todos los artículos con id, nombre, precio, stock y categoría (`200 OK`). |
| `GET` | `/api/articulos/{id}/basico` | Datos básicos del artículo (`200 OK`) o `404 Not Found`. |

Ejemplos:

```bash
curl http://localhost:8080/api/articulos
curl http://localhost:8080/api/articulos/1/basico
curl http://localhost:8080/api/articulos/3/basico
curl -i http://localhost:8080/api/articulos/99/basico
```

Para un artículo agotado, la consulta básica incluye `"mensaje": "Agotado"`.

## Comprobaciones

```bash
./mvnw verify
./mvnw javadoc:javadoc
```

En pruebas automáticas se usa H2 mediante `SPRING_PROFILES_ACTIVE=h2`.

## Estructura

- `controller`: rutas HTTP de la API.
- `service`: consultas y reglas de respuesta.
- `repository`: acceso a datos mediante Spring Data JPA.
- `model`: entidad `Articulo`.
- `src/main/resources`: configuración, esquema y datos de ejemplo.
- `wiki/`: copia versionada de las cuatro páginas de la Wiki del proyecto.

## Flujo de trabajo

El trabajo se organiza en una rama por tarea. Cada rama se integra mediante un Pull Request dirigido a `develop`. Cuando todas las tareas están terminadas, se abre y fusiona un único Pull Request de `develop` a `main`. Esta práctica no utiliza Issues ni GitHub Projects.

## Uso de IA

Se utilizó asistencia de IA para implementar los endpoints, preparar documentación y configuración de CI, y revisar la compilación, las pruebas y el Javadoc. No se incluyeron contraseñas ni claves.
