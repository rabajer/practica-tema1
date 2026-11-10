# API y endpoints

La API escucha en `http://localhost:8080`.

## Listar artículos

`GET /api/articulos` devuelve todos los artículos con sus campos: `id`, `nombre`, `precio`, `stock` y `categoria`.

```bash
curl http://localhost:8080/api/articulos
```

Respuesta: `200 OK` con una lista JSON.

## Consultar datos básicos

`GET /api/articulos/{id}/basico` devuelve `id`, `nombre` y `stock`.

```bash
curl http://localhost:8080/api/articulos/1/basico
```

Cuando el stock vale cero, el JSON añade `"mensaje": "Agotado"`. Si no hay un artículo con ese id, la API devuelve `404 Not Found` sin cuerpo.
