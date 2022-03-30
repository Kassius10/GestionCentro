package repositories;

import java.util.List;

/**
 * Interfaz de Gestión CRUD
 * @param <T> Tipo de dato
 * @param <ID> Identificador del Objeto
 */

public interface ICRUDRepository<T, ID> {
    List<T> findAll();

    T insert(T entity);

    T update(T entity);

    T findByNombre(ID id);

}
