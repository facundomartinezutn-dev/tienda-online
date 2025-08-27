package com.tiendadigital.backend.service.impl;

import com.tiendadigital.backend.model.Producto;
import com.tiendadigital.backend.repository.ProductoRepository;
import com.tiendadigital.backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz {@link ProductoService}.
 * <p>
 * Contiene la lógica de negocio para la gestión de productos y se comunica
 * con la capa de repositorio.
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    // Inyección de dependencias: Spring nos proporciona automáticamente una instancia
    // de ProductoRepository para que podamos usarla.
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}