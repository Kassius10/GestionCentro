package models;
/**
 * Categoría Ejercicio
 */
public class Exercise extends Categories implements ICategory {
    public Exercise(String nombre) {
        super(nombre);
    }

    @Override
    public void aviso() {
        System.out.println("Soy un Ejercicio/**/");
    }
}
