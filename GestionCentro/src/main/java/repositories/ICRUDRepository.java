package repositories;

import java.util.List;

/**
 * Interfaz de Gestión CRUD
 * @param <T> Tipo de dato
 * @param <ID> Identificador del Objeto
 */

public interface ICRUDRepository<T, ID> {
    List<T> findAll();

    T save(T entity);

    T updated(T entity);

    T findByName(ID id);

//    boolean isEmpty(T entity);


}
