package models;

import repositories.CalificacionRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase de Prueba de evaluación
 */
public class PruebaEvaluacion {
    private final LocalDateTime evaluationDate;
    private String description;
    private Categoria category;
    private CalificacionRepository qualifications;

    /**
     * Constructor sin parametros
     */
    public PruebaEvaluacion() {
        this.evaluationDate = LocalDateTime.now();
    }

    /**
     * Constructor con parametros
     *
     * @param description    Descripción que requiere
     * @param category       Categoria que se requiere
     * @param qualifications Repositorio de calificaciones que requiere
     */
    public PruebaEvaluacion(String description, Categoria category, CalificacionRepository qualifications) {
        this.description = description;
        this.category = category;
        this.qualifications = qualifications;
        this.evaluationDate = LocalDateTime.now();
    }

    /**
     * Devuelve la fecha de la prueba
     *
     * @return Devuelve la fecha
     */
    public LocalDateTime getEvaluationDate() {
        return evaluationDate;
    }

    /**
     * Devuelve la descripción
     *
     * @return Devuelve la descripción
     */
    public String getDescription() {
        return description;
    }

    /**
     * Procedimiento que introduce la descripción
     *
     * @param description Descripcion que se requiere
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve la categoria que tiene
     *
     * @return Devuelve la categoria
     */
    public Categoria getCategory() {
        return category;
    }

    /**
     * Procedimiento para introducir la categoria
     *
     * @param category Categoria que se requiere
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /**
     * Función para devolver el repositorio de calificaciones
     *
     * @return devuelve las calificaciones
     */
    public CalificacionRepository getQualifications() {
        return qualifications;
    }

    /**
     * Procedimiento para introducir el repositorio de calificaciones
     *
     * @param qualifications Devuelve las calificaciones
     */
    public void setQualifications(CalificacionRepository qualifications) {
        this.qualifications = qualifications;
    }

    /**
     * Metodo fluido para la introducción de descripcion
     *
     * @param description Descripcion que se requiere
     * @return devuelve la propia prueba
     */
    public PruebaEvaluacion description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Metodo fluido para la introducción de categoria
     *
     * @param category Categoria que se requiere
     * @return devuelve la propia prueba
     */
    public PruebaEvaluacion category(Categoria category) {
        this.category = category;
        return this;
    }

    /**
     * Metodo fluido para la introducción del repositorio de calificaciones
     *
     * @param qualifications Califiacaiones que se requiere
     * @return devuelve la propia prueba
     */
    public PruebaEvaluacion qualifications(CalificacionRepository qualifications) {
        this.qualifications = qualifications;
        return this;
    }

    /**
     * Función toString para devolver una cadena con el contenido de la clase
     *
     * @return Devuelve una cadena.
     */
    @Override
    public String toString() {
        return "PruebaEvaluacion{" +
                "evaluationDate=" + evaluationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")) +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", qualifications=" + qualifications.findAll() +
                '}';
    }


}
