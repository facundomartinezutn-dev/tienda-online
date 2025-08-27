package com.tiendadigital.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Representa la entidad Producto en el sistema.
 * <p>
 * Esta clase es una entidad JPA que se mapea a la tabla 'producto' en la base de datos.
 * Utiliza Lombok (@Data) para generar automáticamente el código boilerplate como
 * getters, setters, y otros métodos esenciales.
 */
@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
}