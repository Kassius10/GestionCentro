package models;

import java.time.LocalDateTime;
import java.util.List;

public class BackUp {
    private final String createAt = LocalDateTime.now().toString();
    private final List<Alumno> alumnos;
    private final List<Categoria> categories;
    private final List<PruebaEvaluacion> pruebas;


    public BackUp(List<Alumno> alumnos, List<Categoria> categories, List<PruebaEvaluacion> pruebas) {
        this.alumnos = alumnos;
        this.categories = categories;
        this.pruebas = pruebas;
    }

    public List<PruebaEvaluacion> getPruebas() {
        return pruebas;
    }

    public List<Categoria> getCategories() {
        return categories;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
}
