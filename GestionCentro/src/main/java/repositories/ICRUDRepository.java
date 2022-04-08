package repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz de Gestión CRUD
 * @param <T> Tipo de dato
 * @param <ID> Identificador del Objeto
 */

public interface ICRUDRepository<T, ID> {
    List<T> findAll() throws SQLException;

    Optional<T> save(T entity) throws SQLException;

    Optional<T> updated(ID id, T entity) throws SQLException;

    Optional<T> findByName(ID id) throws SQLException;




}
