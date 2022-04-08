package repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz de Gestión CRUD. No contiene el delete.
 * @param <T> Tipo de dato
 * @param <ID> Identificador del Objeto
 */
<<<<<<< HEAD

public interface ICRUDRepository<T, ID> {
    List<T> findAll() throws SQLException;

    Optional<T> save(T entity) throws SQLException;

    Optional<T> updated(ID id, T entity) throws SQLException;

    Optional<T> findByName(ID id) throws SQLException;




=======
public interface ICRUDRepository<T,ID> {
    /**
     * Devuelve una lista de todos los elementos que tenga el repositorio
     * @return Devuelve una lista con los elementos.
     */
    List<T> findAll();

    /**
     * Función para salvar un elemento en el repositorio
     * @param entity Elemento que insertaremos en el repositorio.
     * @return Devuelve el objeto que hemos salvado.
     */
    Optional<T> save(T entity);

    /**
     *  Función que actualiza un elemento del repositorio.
     *
     * @param id Id del elemento que vamos a actualizar.
     * @param entity Elemento ya actualizado.
     * @return Devuelve el elemento actualizado.
     */
    Optional<T> updated(ID id, T entity);

>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
}
