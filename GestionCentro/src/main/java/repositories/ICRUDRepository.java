package repositories;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de Gestión CRUD. No contiene el delete.
 * @param <T> Tipo de dato
 * @param <ID> Identificador del Objeto
 */
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

}
