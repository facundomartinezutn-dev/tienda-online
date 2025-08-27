package com.tiendadigital.backend.repository;

import com.tiendadigital.backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de la entidad {@link Producto} en la base de datos.
 * <p>
 * Esta interfaz extiende {@link JpaRepository}, lo que proporciona un conjunto completo
 * de operaciones CRUD para la entidad Producto sin necesidad de implementación explícita.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // El cuerpo de la interfaz permanece vacío, ya que Spring Data JPA
    // proporciona las implementaciones de los métodos CRUD estándar.
}