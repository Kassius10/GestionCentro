package repositories;

import controllers.DataBaseManager;
import models.Alumno;
import models.Categories;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    private static CategoryRepository instance;
    private final DataBaseManager bd;

    private CategoryRepository(DataBaseManager dataBaseManager){
        this.bd = dataBaseManager;
    }

    public static CategoryRepository getInstance( DataBaseManager dataBaseManager) {
        if (instance == null) {
            instance = new CategoryRepository(dataBaseManager);
        }
        return instance;
    }


    /**
     * Lista todas las Categorías existentes
     *
     * @return Lista de Categorías
     */
    @Override
    public List<Categories> findAll() throws SQLException {
        String query = "SELECT * FROM Categoria";
        bd.open();
        ResultSet result = bd.select(query).orElseThrow(() -> new SQLException("Error al visualizar todas las categorias "));
        ArrayList<Categories> categories = new ArrayList<>();
        while (result.next()) {
            categories.add(
                    new Categories(
                            result.getString("nombre")));

        }
        bd.close();
        return categories;
    }

    /**
     * Introduce una Categoría en caso de tener una nueva
     *
     * @param category la categoría a introducir
     * @return caregoria a introducir
     */

    @Override
    public Optional<Categories> save(Categories category) throws SQLException {
        String query = "INSERT INTO Categoria VALUES (?)";
        ResultSet result = bd.insert(query, category.getName()).orElseThrow(() -> new SQLException("Error al insertar la categoría"));

        if (result.first()) {
            category.setId(result.getInt(1));
            bd.close();
            return Optional.of(category);
        }
        return Optional.empty();
    }

    /**
     * Actualiza la Categoría Según su Nombre
     *
     * @param category que categoría queremos actualizar
     * @return categoría actualizada
     */

    @Override
    public Optional<Categories> updated(String s, Categories category) throws SQLException {
        this.findByName(s).orElseThrow(() -> new SQLException("Error al actualizar la categoria. No se encuentra la categoria con nombre: " + s ));
        String query = "UPDATE alumno SET nombre = ?";
        bd.open();
        var res = bd.update(query, category.getName());
        bd.close();
        return Optional.of(category);


    }

    /**
     * Busca una Categoría por su nombre
     *
     * @param name nombre la categoría
     * @return la categoría encontraada
     */
    @Override
    public Optional<Categories> findByName(String name ) throws SQLException {
        String query = "SELECT * FROM Categoria Where nombre = ?";
        bd.open();
        ResultSet result = bd.select(query, name).orElseThrow(() -> new SQLException("No se ha encontrado categoria con el nombre: " + name));
        if (result.next()) {
            Categories category = new Categories(
                    result.getString("nombre"));

            bd.close();
            return Optional.of(category);
        }

        return Optional.empty();
    }



}
