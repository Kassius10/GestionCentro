package models;
/**
 * Categoría Exposicion
 */
public class Exposition extends Categories implements ICategory {
    public Exposition(String nombre) {
        super(nombre);
    }

    @Override
    public void aviso() {
        System.out.println("Soy una Exposición/**/");
    }
}
