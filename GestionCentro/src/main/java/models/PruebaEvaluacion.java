package models;

import repositories.CalificacionRepository;

import java.time.LocalDateTime;

public class PruebaEvaluacion {
    private LocalDateTime evaluationDate;
    private String description;
    private Categoria category;
    private CalificacionRepository qualifications;

    public PruebaEvaluacion(String description, Categoria category, CalificacionRepository qualifications) {
        this.description = description;
        this.category = category;
        this.qualifications=qualifications;
        this.evaluationDate = LocalDateTime.now();
    }

    public LocalDateTime getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDateTime evaluationDate) {
        this.evaluationDate = evaluationDate;
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

    @Override
    public String toString() {
        return "PruebaEvaluacion{" +
                "evaluationDate=" + evaluationDate +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", qualifications=" + qualifications +
                '}';
    }
}
