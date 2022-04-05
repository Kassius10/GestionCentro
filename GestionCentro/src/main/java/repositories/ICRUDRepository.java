package repositories;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de Gestión CRUD
 * @param <T> Tipo de dato
 * @param <ID> Identificador del Objeto
 */

public interface ICRUDRepository<T, ID> {
    List<T> findAll();

    Optional<T> save(T entity);

    Optional<T> updated(ID id, T entity);

    Optional<T> findByName(ID id);




}
