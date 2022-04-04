package models;

import exceptions.AlumnoException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa un Alumno.
 * Es una clase POJO, solo contiene getter and setters y una interfaz fluida.
 */
public class Alumno {
    private int id;
    private static int contador=1;
    private String dni;
    private String name;
    private String surNames;
    private String email;
    private String phone;
    private boolean hasLoseEvaluation;
<<<<<<< HEAD
    private final LocalDate registrationDate;
=======
    private LocalDateTime registrationDate;
>>>>>>> b6fed9e050ed2f64ea6f7dbffc3053c36cce9904

    /**
     * Método constructor de Alumno.
     */
    public Alumno(){
        this.id = contador++;
        registrationDate= LocalDateTime.now(); //TODO cambiar el formato de la fecha a DD/MM/YYYY
    }

    /**
     * Constructor de alumno con parámetros
     * @param dni Dni que le daremos.
     * @param name Nombre que tendrá el alumno
     * @param surNames Apellidos que tendrá el alumno.
     * @param email Email que tendrá el alumno.
     * @param phone Teléfono que tendrá el alumno.
     * @param hasLoseEvaluation Indicamos si ha perdido la evaluación o no.
     */
    public Alumno(String dni, String name, String surNames, String email, String phone, boolean hasLoseEvaluation){
        this.id = contador++;
        this.dni=dni;
        this.name=name;
        this.surNames = surNames;
        this.email=email;
        this.phone=phone;
        this.hasLoseEvaluation=hasLoseEvaluation;
        registrationDate= LocalDateTime.now(); //TODO cambiar el formato de la fecha a DD/MM/YYYY
    }

    /**
     * Función que devuelve el id del alumno.
     * @return Devuelve el id.
     */
    public int getId() {
        return id;
    }

    /**
     * Procedimiento que permite indicarle el id al alumno.
     * @param id Id que le daremos.
     */
//    public void setId(int id) {
//        this.id = id;
//    }

    /**
     * Función que devuelve el Dni del alumno
     * @return Devuelve el dni.
     */
    public String getDni() {
        return dni;
    }

    /**
     *  Procedimiento que permite indicarle el DNI al alumno.
     * @param dni Dni que le daremos.
     */
    public void setDni(String dni) throws AlumnoException {
        var regex= "^([1-9]{1}[0-9]{7}[a-z])$";
        if (dni.matches(regex)) this.dni=dni;
        else throw new AlumnoException("El dni es incorrecto.");
    }

    /**
     * Función que devuelve el nombre del alumno
     * @return Devuelve el nombre.
     */
    public String getName() {
        return name;
    }

    /**
     * Procedimiento que permite indicarle el nombre al alumno.
     * @param name Nombre que le daremos.
     */
    public void setName(String name) throws AlumnoException {
        var regex= "([a-záéíóú]{1}[a-zñáéíóú]*)$";
        if (name.matches(regex)) this.name=name;
        else throw new AlumnoException("El nombre es incorrecto.");
    }

    /**
     * Función que devuelve los apellidos del alumno.
     * @return Devuelve los apellidos.
     */
    public String getSurNames() {
        return surNames;
    }

    /**
     * Procedimiento que permite indicarle los apellidos del alumno.
     * @param surNames Apellidos que le daremos.
     */
    public void setSurNames(String surNames) throws AlumnoException {
        var regex= "^([a-záéíóú]{1}[a-zñáéíóú]*)\\s([a-záéíóú]{1}[a-zñáéíóú]*)$";
        if (surNames.matches(regex)) this.surNames=surNames;
        else throw new AlumnoException("Los apellidos son incorrectos.");
    }

    /**
     * Función que devuelve el email del alumno.
     * @return Devuelve el email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Procedimiento que permite indicarle el email del alumno.
     * @param email Email que le daremos.
     */
    public void setEmail(String email) throws AlumnoException {
        var regex= "^[\\w]+@{1}([\\w]+\\.)+[a-z]{2,3}$";
        if (email.matches(regex)) this.email=email;
        else throw new AlumnoException("El email es incorrecto.");
    }

    /**
     * Función que devuelve el teléfono del alumno.
     * @return Devuelve el teléfono.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Procedimiento que permite indicarle el teléfono del alumno.
     * @param phone Teléfono que le daremos.
     */
    public void setPhone(String phone) throws AlumnoException {
        var regex= "^[6-9]{1}[0-9]{2}[-][0-9]{6}$";
        if (phone.matches(regex)) this.phone=phone;
        else throw new AlumnoException("El teléfono es incorrecto.");

    }

    /**
     * Función que devuelve si ha perdido la evaluación el alumno.
     * @return Devuelve un boolean, true si la ha perdido, false si no.
     */
    public boolean isHasLoseEvaluation() {
        return hasLoseEvaluation;
    }

    /**
     * Procedimiento que permite indicar si ha perdido la evaluación el alumno.
     * @param hasLoseEvaluation Boolean para indicar si ha perdido o no la evaluación.
     */
    public void setHasLoseEvaluation(boolean hasLoseEvaluation) {
        this.hasLoseEvaluation = hasLoseEvaluation;
    }

    /**
     * Función que devuelve la fecha de matriculación del alumno.
     * @return Devuelve la fecha de matriculación.
     */
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Método fluido para añadirle una id al alumno.
     * @param id Id que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno id(int id) {
        this.id = id;
        return this;
    }

    /**
     * Método fluido para añadirle una dni al alumno.
     * @param dni Dni que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno dni(String dni) throws AlumnoException {
        var regex= "^([1-9]{1}[0-9]{7}[a-z])$";
        if (dni.matches(regex)) this.dni=dni;
        else throw new AlumnoException("El dni es incorrecto.");

        return this;
    }

    /**
     * Método fluido para añadirle una nombre al alumno.
     * @param name Nombre que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno name(String name) throws AlumnoException {
        var regex= "([a-záéíóú]{1}[a-zñáéíóú]*)$";
        if (name.matches(regex)) this.name=name;
        else throw new AlumnoException("El nombre es incorrecto.");
        return this;
    }

    /**
     * Método fluido para añadirle unos apellidos al alumno.
     * @param surNames Apellidos que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno surNames(String surNames) throws AlumnoException {
        var regex= "^([a-záéíóú]{1}[a-zñáéíóú]*)\\s([a-záéíóú]{1}[a-zñáéíóú]*)$";
        if (surNames.matches(regex)) this.surNames=surNames;
        else throw new AlumnoException("Los apellidos son incorrectos.");
        return this;
    }

    /**
     * Método fluido para añadirle una email al alumno.
     * @param email Email que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno email(String email) throws AlumnoException {
        var regex= "^[\\w]+@{1}([\\w]+\\.)+[a-z]{2,3}$";
        if (email.matches(regex)) this.email=email;
        else throw new AlumnoException("El email es incorrecto.");
        return this;
    }

    /**
     * Método fluido para añadirle una teléfono al alumno.
     * @param phone Teléfono que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno phone(String phone) throws AlumnoException {
        var regex= "^[6-9]{1}[0-9]{2}[-][0-9]{6}$";
        if (phone.matches(regex)) this.phone=phone;
        else throw new AlumnoException("El teléfono es incorrecto.");

        return this;
    }

    /**
     * Método fluido para indicar si el alumno ha perdido la evaluación.
     * @param hasLoseEvaluation Boolean que le indicaremos al alumno si ha perdido la evaluación.
     * @return devuelve el propio alumno.
     */
    public Alumno hasLoseEvaluation(boolean hasLoseEvaluation) {
        this.hasLoseEvaluation = hasLoseEvaluation;
        return this;
    }

    /**
     * Método toString para devolver una cadena mostrando los datos del alumno.
     * @return Devuelve una cadena con todos los datos.
     */
    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", serNames='" + surNames + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hasLoseEvaluation=" + hasLoseEvaluation +
                ", registrationDate=" + registrationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id && hasLoseEvaluation == alumno.hasLoseEvaluation && dni.equals(alumno.dni) && name.equals(alumno.name) && surNames.equals(alumno.surNames) && email.equals(alumno.email) && phone.equals(alumno.phone) && registrationDate.equals(alumno.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, name, surNames, email, phone, hasLoseEvaluation, registrationDate);
    }

}