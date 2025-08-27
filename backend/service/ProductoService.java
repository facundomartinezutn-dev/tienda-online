package com.tiendadigital.backend.service;

import com.tiendadigital.backend.model.Producto;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz para el servicio de gestión de Productos.
 * <p>
 * Define el contrato para las operaciones de negocio relacionadas con los productos,
 * abstrayendo la implementación concreta.
 */
public interface ProductoService {

 /**
     * Obtiene una lista de todos los productos.
     * @return una lista con todos los productos.
     */
    List<Producto> findAll();

    /**
     * Busca un producto por su ID.
     * @param id el ID del producto a buscar.
     * @return un {@link Optional} que contiene el producto si se encuentra, o vacío si no.
     */
    Optional<Producto> findById(Long id);

    /**
     * Guarda un nuevo producto o actualiza uno existente.
     * @param producto el producto a guardar o actualizar.
     * @return el producto guardado.
     */
    Producto save(Producto producto);

    /**
     * Elimina un producto por su ID.
     * @param id el ID del producto a eliminar.
     */
    void deleteById(Long id);
}