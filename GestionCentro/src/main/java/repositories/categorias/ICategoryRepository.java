package repositories.categorias;

import models.Categoria;
import repositories.ICRUDRepository;

import java.util.Optional;

/**
 * Interfaz que regula el comportamiento del repositorio de Categorías
 */
public interface ICategoryRepository extends ICRUDRepository<Categoria,String> {
    /**
     * Función para buscar un nombre de categoría en el repositorio.
     * @param name Nombre por el que buscaremos en el repositorio.
     * @return Devuelve un optional de la categoría.
     */
    Optional<Categoria> findByName(String name);
}
