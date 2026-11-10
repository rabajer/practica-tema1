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

// TODO: documentar la clase y todos sus métodos con Javadoc.
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Articulo> listarTodos() {
        return servicio.listarTodos();
    }

    @GetMapping("/{id}/basico")
    public ResponseEntity<Map<String, Object>> buscarBasico(@PathVariable Integer id) {
        return servicio.buscarBasico(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
