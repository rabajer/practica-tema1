package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

// TODO: documentar la clase y todos sus métodos con Javadoc.
@Service
public class ArticuloService {

    private final ArticuloRepository repositorio;

    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Articulo> listarTodos() {
        return repositorio.findAll();
    }

    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        return repositorio.findById(id).map(articulo -> {
            Map<String, Object> datos = new LinkedHashMap<>();
            datos.put("id", articulo.getId());
            datos.put("nombre", articulo.getNombre());
            datos.put("stock", articulo.getStock());
            if (articulo.getStock() == 0) {
                datos.put("mensaje", "Agotado");
            }
            return datos;
        });
    }
}
