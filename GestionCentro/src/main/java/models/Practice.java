package models;

/**
 * Categoría Práctica
 */
public class Practice extends Categories implements ICategory {

    public Practice(String nombre) {
        super(nombre);
    }

    @Override
    public void aviso() {
        System.out.println("Soy una Práctica");
    }
}
