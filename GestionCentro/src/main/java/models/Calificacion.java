package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que contiene la calificación de los alumnos.
 */
public class Calificacion {
    private final String deliveryDate;
    private Alumno student;
    private double qualification;

    public Calificacion(Alumno student, double qualification) {
        this.student = student;
        this.qualification = qualification;
        deliveryDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }

    /**
     * Función que devuelve el alumno.
     *
     * @return devuelve el alumno.
     */
    public Alumno getStudent() {
        return student;
    }

    /**
     * Procedimiento para indicar el alumno
     *
     * @param student Alumno que indicamos.
     */
    public void setStudent(Alumno student) {
        this.student = student;
    }

    /**
     * Función que devuelve la nota del alumno.
     *
     * @return devuelve la nota del alumno.
     */
    public double getQualification() {
        return qualification;
    }

    /**
     * Procedimiento para darle una calificación al alumno
     *
     * @param qualification calificacion dada.
     */
    public void setQualification(double qualification) {
        this.qualification = qualification;
    }

    /**
     * Función que devuelve la fecha de entrega
     *
     * @return devuelve la fecha de entrega.
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Interfaz fluida para indicar el alumno.
     *
     * @param student Alumno que indicamos
     * @return devuelve la propia calificación.
     */
    public Calificacion student(Alumno student) {
        this.student = student;
        return this;
    }

    /**
     * Interfaz fluida para indicar la nota
     *
     * @param qualification nota que indicamos
     * @return devuelve la propia calificación
     */
    public Calificacion qualification(double qualification) {
        this.qualification = qualification;
        return this;
    }

    /**
     * ToString de la clase calificación
     *
     * @return devuelve una cadena con la información de la clase.
     */
    @Override
    public String toString() {
        return "| Alumno: " + student +
                "| Nota: " + qualification +
                "| Fecha de entrega: " + deliveryDate;
    }
}
