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

public class CategoryRepository implements ICategoryRepository {

    private final TreeMap<String, Categories> categoRep = new TreeMap<>();

    /**
     * Lista todas las Categorías existentes
     *
     * @return Lista de Categorías
     */
    @Override
    public List<Categories> findAll() {
            return new ArrayList<>(this.categoRep.values());
    }

    /**
     * Introduce una Categoría en caso de tener una nueva
     *
     * @param category la categoría a introducir
     * @return caregoria a introducir
     */

    @Override
    public Categories save(Categories category) {
        this.categoRep.put(category.getName(), category);
        return category;
    }

    /**
     * Actualiza la Categoría Según su Nombre
     *
     * @param category que categoría queremos actualizar
     * @return categoría actualizada
     */

    @Override
    public Categories updated(Categories category) {
        var categoryFound = this.categoRep.get(category.getName());
        if (categoryFound != null){
            this.categoRep.put(category.getName(), category);
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
    public Categories findByName(String name ) {
        return this.categoRep.get(name);
    }

//    @Override
//    public boolean isEmpty(Categories category) {
//
//        var categoryFound = this.categoRep.get(category.getName());
//
//        return categoryFound.getName() == null;
//
//
//    }


}
