package repositories.categorias;

import models.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Repositorio donde se almacenaran
 * todas las categorías existentes y que se iran
 * añadiendo al mismo.
 */

public class CategoryRepository implements ICategoryRepository {

    private final TreeMap<String, Categoria> categoRep = new TreeMap<>();

    /**
     * Lista todas las Categorías existentes
     *
     * @return Lista de Categorías
     */
    @Override
    public List<Categoria> findAll() {
            return new ArrayList<>(this.categoRep.values());
    }

    /**
     * Introduce una Categoría en caso de tener una nueva
     *
     * @param category la categoría a introducir
     * @return caregoria a introducir
     */

    @Override
    public Optional<Categoria> save(Categoria category) {
        this.categoRep.put(category.getName(), category);
        return Optional.of(category);
    }

    /**
     * Actualiza la Categoría Según su Nombre
     *
     * @param category que categoría queremos actualizar
     * @return categoría actualizada
     */

    @Override
    public Optional<Categoria> updated(String s, Categoria category) {
        this.categoRep.put(s, category);

        return Optional.of(category);

    }

    /**
     * Actualiza la Categoría Según su Nombre
     *
     * @param category que categoría queremos actualizar
     * @return categoría actualizada
     */


    /**
     * Busca una Categoría por su nombre
     *
     * @param name nombre la categoría
     * @return la categoría encontraada
     */
    @Override
    public Optional<Categoria> findByName(String name ) {

        for (Categoria category: this.categoRep.values()){
            if(category.getName().equals(name)){
                return Optional.of(category);
            }
        }
        return Optional.empty();
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
