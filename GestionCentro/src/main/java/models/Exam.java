package models;
/**
 * Categoría Práctica
 */
public class Exam extends Categories implements ICategory {

    public Exam(String name) {
        super(name);
    }

    @Override
    public void aviso() {
        System.out.println("Soy un Exámen/**/");
    }
}
