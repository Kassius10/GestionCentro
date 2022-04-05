package models;
/**
 * Clase Categoría
 */
public class Categoria {
    private String name;

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
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Método toString
     * @return el formato de cada categoría
     */
    @Override
    public String toString() {
        return "Categorias{"+
                "name='" + name + '\'' +
                '}';
    }


}
