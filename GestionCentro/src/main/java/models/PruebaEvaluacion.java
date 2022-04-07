package models;

import repositories.CalificacionRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PruebaEvaluacion {
    private final LocalDateTime evaluationDate;
    private String description;
    private Categoria category;
    private CalificacionRepository qualifications;

    public PruebaEvaluacion() {
        this.evaluationDate = LocalDateTime.now();
    }

    public PruebaEvaluacion(String description, Categoria category, CalificacionRepository qualifications) {
        this.description = description;
        this.category = category;
        this.qualifications = qualifications;
        this.evaluationDate = LocalDateTime.now();
    }

    public LocalDateTime getEvaluationDate() {
        return evaluationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public CalificacionRepository getQualifications() {
        return qualifications;
    }

    public void setQualifications(CalificacionRepository qualifications) {
        this.qualifications = qualifications;
    }

    public PruebaEvaluacion description(String description) {
        this.description = description;
        return this;
    }

    public PruebaEvaluacion category(Categoria category) {
        this.category = category;
        return this;
    }

    public PruebaEvaluacion qualifications(CalificacionRepository qualifications) {
        this.qualifications = qualifications;
        return this;
    }


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
