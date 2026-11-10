package com.hellin.almacen.controller;

import com.hellin.almacen.service.ArticuloService;
import com.hellin.almacen.model.Articulo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * Endpoints REST para consultar artículos del almacén.
 */
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    /**
     * Crea el controlador con el servicio de artículos.
     *
     * @param servicio lógica de consulta de artículos
     */
    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    /**
     * Devuelve todos los artículos del almacén.
     *
     * @return todos los artículos disponibles
     */
    @GetMapping
    public List<Articulo> listarTodos() {
        return servicio.listarTodos();
    }

    /**
     * Devuelve el identificador, nombre y stock de un artículo.
     * Si el stock es cero, incluye el mensaje {@code Agotado}; si no existe,
     * responde con HTTP 404.
     *
     * @param id identificador del artículo
     * @return los datos básicos o una respuesta HTTP 404
     */
    @GetMapping("/{id}/basico")
    public ResponseEntity<Map<String, Object>> buscarBasico(@PathVariable Integer id) {
        return servicio.buscarBasico(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
