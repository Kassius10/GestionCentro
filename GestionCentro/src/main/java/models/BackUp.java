package models;

import java.time.LocalDateTime;
import java.util.List;

public class BackUp {
    private final String createAt = LocalDateTime.now().toString();
    private List<Alumno> alumnos;
    private List<Categories> categories;


    public BackUp(List<Alumno> alumnos, List<Categories> categories) {
        this.alumnos = alumnos;
        this.categories=categories;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
}
