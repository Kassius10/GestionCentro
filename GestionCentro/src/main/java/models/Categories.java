package models;
/**
 * Clase Categoría
 */
public class Categories {
    private String name;
    private static int contador=0;
    private final int id;
    public Categories(String nombre) {
        this.name = nombre;
        this.id = ++contador;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Categorias{"+
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
