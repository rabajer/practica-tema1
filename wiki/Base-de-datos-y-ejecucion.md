# Base de datos y ejecución

Se requiere JDK 21. El perfil habitual usa PostgreSQL; el perfil `h2` permite ejecutar y probar la aplicación sin instalar una base externa.

## H2 en memoria

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=h2
```

En PowerShell:

```powershell
.\mvnw spring-boot:run "-Dspring-boot.run.profiles=h2"
```

## PostgreSQL

Configura `DB_PASSWORD`. Opcionalmente puedes definir `DB_HOST` (predeterminado `localhost`), `DB_NAME` (predeterminado `almacen`) y `DB_USER` (predeterminado `almacen`), y después arranca con `./mvnw spring-boot:run`.

El esquema y los datos de muestra están en `src/main/resources/schema.sql` y `data.sql`.

## Pruebas y Javadoc

Ejecuta compilación y pruebas con H2:

```bash
SPRING_PROFILES_ACTIVE=h2 ./mvnw verify
```

En PowerShell:

```powershell
$env:SPRING_PROFILES_ACTIVE = "h2"
.\mvnw verify
```

Genera la documentación del código con `./mvnw javadoc:javadoc`. El HTML queda en `target/reports/apidocs` o `target/site/apidocs`, según la versión del plugin.
