package models;

import exceptions.CategoriesException;

/**
 * Clase Categoría
 */
public class Categoria {
    private String name;

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

}
