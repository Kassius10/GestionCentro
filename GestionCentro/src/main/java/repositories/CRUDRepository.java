package repositories;

import java.util.List;

/**
 * Interfaz CRUD para los repositorios.
 * @param <T> El objeto que pasaremos o queremos devolver.
 * @param <ID> Id del objeto.
 */
public interface CRUDRepository<T,ID> {
    /**
     * Devuelve una lista de todos los elementos que tenga el repositorio.
     *
     * @return Devuelve la lista de elementos.
     */
    List<T> findAll();

    /**
     * Función para buscar por id
     *
     * @param id Id del elemento
     * @return Devuelve el elemento.
     */
    T findById(ID id);

    /**
     * Función para salvar un elemento en el repositorio.
     *
     * @param entity Elemento que insertamos en el repositorio.
     * @return Devuelve el objeto que hemos salvado.
     */
    T save(T entity);

    /**
     *  Función que actualiza un elemento del repositorio.
     *
     * @param id Id del elemento que vamos a actualizar.
     * @param entity Elemento ya actualizado.
     * @return Devuelve el elemento actualizado.
     */
    T update(ID id,T entity);

    /**
     * Función para eliminar un elemento del repositorio.
     *
     * @param id Id del elemento que vamos a eliminar.
     * @return Devuelve el elemento que hemos eliminado.
     */
    T delete(ID id);
}