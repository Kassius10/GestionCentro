package models;

import java.time.LocalDateTime;

public class Prueba {
    private Alumno student;
    private double qualification;
    private LocalDateTime deliveryDate;

    /**
     * Función que devuelve el id del alumno.
     * @return Devuelve el alumno.
     */
    public Alumno getStudent() {
        return student;
    }

    /**
     * Procedimiento que permite establecer al Alumno
     * @param student Alumno nuevo
     */

    public void setStudent(Alumno student) {
        this.student = student;
    }

    /**
     * Función que devuelve una Calificación.
     * @return Devuelve la Calificación de la prueba
     */

    public double getQualification() {
        return qualification;
    }

    /**
     * Procedimiento que permite establecerle la nota a una prueba
     * @param qualification Nueva nota para la prueba
     */

    public void setQualification(double qualification) {
        this.qualification = qualification;
    }

    /**
     * Función que devuelve la fecha de entrega de una prueba.
     * @return Devuelve la Fecha de Entrega de la prueba
     */

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Método toString
     * @return el formato de cada categoría
     */
    @Override
    public String toString() {
        return "Prueba{" +
                "student=" + student +
                ", qualification=" + qualification +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
