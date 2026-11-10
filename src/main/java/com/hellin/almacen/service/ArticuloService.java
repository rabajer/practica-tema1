package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Lógica de consulta y transformación de artículos del almacén.
 */
@Service
public class ArticuloService {

    private final ArticuloRepository repositorio;

    /**
     * Crea el servicio con el repositorio de artículos.
     *
     * @param repositorio acceso a los artículos persistidos
     */
    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Obtiene todos los artículos almacenados.
     *
     * @return lista completa de artículos
     */
    public List<Articulo> listarTodos() {
        return repositorio.findAll();
    }

    /**
     * Busca un artículo y construye la vista básica con id, nombre y stock.
     * Incluye el mensaje {@code Agotado} si el stock es cero.
     *
     * @param id identificador del artículo
     * @return los datos básicos si existe el artículo; en caso contrario, vacío
     */
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
