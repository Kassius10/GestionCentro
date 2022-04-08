package repositories;

import exceptions.AlumnoException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz CRUD para los repositorios. Contiene todas las opciones de un crud.
 * @param <T> El objeto que pasaremos o queremos devolver.
 * @param <ID> Id del objeto.
 */
public interface CRUDRepository<T,ID> {
    /**
     * Devuelve una lista de todos los elementos que tenga el repositorio.
     *
     * @return Devuelve la lista de elementos.
     */
    List<T> findAll() throws SQLException;

    /**
     * Función para buscar por id
     *
     * @param id Id del elemento
     * @return Devuelve el elemento.
     */
    Optional<T> findById(ID id) throws AlumnoException, SQLException;

    /**
     * Función para salvar un elemento en el repositorio.
     *
     * @param entity Elemento que insertamos en el repositorio.
     * @return Devuelve el objeto que hemos salvado.
     */
    Optional<T> save(T entity) throws SQLException;

    /**
     *  Función que actualiza un elemento del repositorio.
     *
     * @param id Id del elemento que vamos a actualizar.
     * @param entity Elemento ya actualizado.
     * @return Devuelve el elemento actualizado.
     */
    Optional<T> update(ID id,T entity) throws AlumnoException, SQLException;

    /**
     * Función para eliminar un elemento del repositorio.
     *
     * @param id Id del elemento que vamos a eliminar.
     * @return Devuelve el elemento que hemos eliminado.
     */

    Optional<T> delete(ID id) throws SQLException;
}
