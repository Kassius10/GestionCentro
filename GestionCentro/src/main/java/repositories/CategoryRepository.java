package repositories;

import models.Categories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Repositorio donde se almacenaran
 * todas las categorías existentes y que se iran
 * añadiendo al mismo.
 */

public class CategoryRepository extends TreeMap<String, Categories> implements ICategoryRepository {

    /**
     * Lista todas las Categorías existentes
     *
     * @return Lista de Categorías
     */
    @Override
    public List<Categories> findAll() {
            return new ArrayList<>(this.values());
    }

    /**
     * Introduce una Categoría en caso de tener una nueva
     *
     * @param category la categoría a introducir
     * @return caregoria a introducir
     */

    @Override
    public Categories insert(Categories category) {
        this.put(category.getName(), category);
        return category;
    }

    /**
     * Actualiza la Categoría Según su Nombre
     *
     * @param category que categoría queremos actualizar
     * @return categoría actualizada
     */

    @Override
    public Categories update(Categories category) {
        var categoryFound = this.get(category.getName());
        if (categoryFound != null){
            this.put(category.getName(), category);
        }
        return category;
    }

    /**
     * Busca una Categoría por su nombre
     *
     * @param name nombre la categoría
     * @return la categoría encontraada
     */
    @Override
    public Categories findByNombre(String name ) {
        return this.get(name);
    }
}
