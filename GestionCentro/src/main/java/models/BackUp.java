package models;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase Backup
 */
public class BackUp {
    private final String createAt = LocalDateTime.now().toString();
    private final List<Alumno> alumnos;
    private final List<Categoria> categories;
    private final List<PruebaEvaluacion> pruebas;

    /**
     * Constructor de backup con parametros
     *
     * @param alumnos    lista de alumnos que requiere
     * @param categories lista de categorias que requiere
     * @param pruebas    lista de pruebas que requiere
     */
    public BackUp(List<Alumno> alumnos, List<Categoria> categories, List<PruebaEvaluacion> pruebas) {
        this.alumnos = alumnos;
        this.categories = categories;
        this.pruebas = pruebas;
    }

    /**
     * Función que devuelve una lista de pruebas
     *
     * @return devuelve una lista de pruebas
     */
    public List<PruebaEvaluacion> getPruebas() {
        return pruebas;
    }

    /**
     * Función que devuelve una lista de categorias
     *
     * @return devuelve una lista de categorias
     */
    public List<Categoria> getCategories() {
        return categories;
    }

    /**
     * Función que devuelve una lista de alumnos
     *
     * @return devuelve una lista de alumnos
     */
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
}
