package com.tiendadigital.backend.controller;

import com.tiendadigital.backend.model.Producto;
import com.tiendadigital.backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de los Productos.
 * <p>
 * Expone los endpoints de la API para interactuar con la lógica de negocio
 * a través de la capa de servicio {@link ProductoService}.
 */
@RestController
@RequestMapping("/api/productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    /**
     * Endpoint para obtener todos los productos.
     * HTTP GET /api/productos
     *
     * @return ResponseEntity con la lista de productos y estado HTTP 200 .
     */
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    /**
     * Endpoint para obtener un producto por su ID.
     * HTTP GET /api/productos/{id}
     *
     * @param id El ID del producto a buscar.
     * @return ResponseEntity con el producto encontrado y estado 200 ,
     * o estado 404 (Not Found) si no se encuentra.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok) // Si el Optional contiene un producto, devuelve 200 OK con el producto.
                .orElse(ResponseEntity.notFound().build()); // Si el Optional está vacío, devuelve 404 Not Found.
    }

    /**
     * Endpoint para crear un nuevo producto.
     * HTTP POST /api/productos
     *
     * @param producto El producto a crear, recibido en el cuerpo de la petición.
     * @return ResponseEntity con el nuevo producto y estado 201 (Created).
     */
    
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.save(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    /**
     * Endpoint para eliminar un producto por su ID.
     * HTTP DELETE /api/productos/{id}
     *
     * @param id El ID del producto a eliminar.
     * @return ResponseEntity con estado 204 (No Content) si se elimina correctamente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}