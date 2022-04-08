package models;

import exceptions.CategoriesException;

/**
 * Clase Categoría
 */
public class Categoria {
    private String name;
    private int id;

    public Categoria() {
    }


    public Categoria(String nombre) {
        this.name = nombre;
    }

    /**
     * Devuelve el Nombre de la Categoría
     */
    public String getName() {
        return name;
    }


    /**
     * Función para modificar el nombre de una Categoría
     */
    public void setName(String name) throws CategoriesException {
        var regex = "^[a-zA-Z]+$";
        if (name.matches(regex)) this.name = name;
        else throw new CategoriesException("Formato introducido incorrecto.");
    }


    /**
     * Método toString
     *
     * @return el formato de cada categoría
     */
    @Override
    public String toString() {
        return "Categorias{" +
                "name='" + name + '\'' +
                '}';
    }

<<<<<<< HEAD:GestionCentro/src/main/java/models/Categories.java

    public void setId(int id) {
        this.id = id;
    }
=======
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4:GestionCentro/src/main/java/models/Categoria.java
}
