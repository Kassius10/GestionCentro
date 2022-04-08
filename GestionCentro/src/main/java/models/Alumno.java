package models;

import exceptions.AlumnoException;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un Alumno.
 * Es una clase POJO, solo contiene getter and setters y una interfaz fluida.
 */
@Data
public class Alumno {
    private final LocalDateTime registrationDate;
    private int id;
    private String dni;
    private String name;
    private String surNames;
    private String email;
    private String phone;
    private boolean hasLoseEvaluation;
    private boolean enabled;
<<<<<<< HEAD
    private final LocalDateTime registrationDate;

//    /*private LocalDateTime registrationDate;*/


    public Alumno(){
        this.id = contador++;
        registrationDate= LocalDateTime.now(); //TODO cambiar el formato de la fecha a DD/MM/YYYY
=======

    /**
     * Método constructor de Alumno.
     */
    public Alumno() {
        registrationDate = LocalDateTime.now();
        this.enabled = true;
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
    }

    /**
     * Constructor de alumno con parámetros
     *
     * @param dni               Dni que le daremos.
     * @param name              Nombre que tendrá el alumno
     * @param surNames          Apellidos que tendrá el alumno.
     * @param email             Email que tendrá el alumno.
     * @param phone             Teléfono que tendrá el alumno.
     * @param hasLoseEvaluation Indicamos si ha perdido la evaluación o no.
     */
<<<<<<< HEAD
    public Alumno(String dni, String name, String surNames, String email, String phone, boolean hasLoseEvaluation, boolean enabled){
        this.id = contador++;
        this.dni=dni;
        this.name=name;
        this.surNames = surNames;
        this.email=email;
        this.phone=phone;
        this.hasLoseEvaluation=hasLoseEvaluation;
        this.enabled = enabled;
        registrationDate= LocalDateTime.now(); //TODO cambiar el formato de la fecha a DD/MM/YYYY
=======
    public Alumno(String dni, String name, String surNames, String email, String phone, boolean hasLoseEvaluation, boolean enabled) {
        this.dni = dni;
        this.name = name;
        this.surNames = surNames;
        this.email = email;
        this.phone = phone;
        this.hasLoseEvaluation = hasLoseEvaluation;
        this.enabled = enabled;
        registrationDate = LocalDateTime.now(); //TODO cambiar el formato de la fecha a DD/MM/YYYY
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
    }

    public Alumno(int id, String dni, String nombre, String apellidos, String email, String telefono, boolean hasLoseEvaluation, boolean enabled, LocalDateTime fecha) {
        this.id = id;
        this.dni = dni;
        this.name = nombre;
        this.surNames = apellidos;
        this.email = email;
        this.phone = telefono;
        this.hasLoseEvaluation = hasLoseEvaluation;
        this.enabled = enabled;
        this.registrationDate = LocalDateTime.now();
    }

    /**
     * Función que devuelve el id del alumno.
     *
     * @return Devuelve el id.
     */
    public int getId() {
        return id;
    }

<<<<<<< HEAD
    /**
     * Procedimiento que permite indicarle el id al alumno.
     * @param id Id que le daremos.
     */
    public void setId(int id) {
        this.id = id;
    }
=======
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

    /**
     * Función que devuelve el Dni del alumno
     *
     * @return Devuelve el dni.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Procedimiento que permite indicarle el DNI al alumno.
     *
     * @param dni Dni que le daremos.
     */
    public void setDni(String dni) throws AlumnoException {
        var regex = "^([1-9]{1}[0-9]{7}[a-z])$";
        if (dni.matches(regex)) this.dni = dni;
        else throw new AlumnoException("El dni es incorrecto.");
    }

    /**
     * Función que devuelve el nombre del alumno
     *
     * @return Devuelve el nombre.
     */
    public String getName() {
        return name;
    }

    /**
     * Procedimiento que permite indicarle el nombre al alumno.
     *
     * @param name Nombre que le daremos.
     */
    public void setName(String name) throws AlumnoException {
        var regex = "([a-záéíóú]{1}[a-zñáéíóú]*)$";
        if (name.matches(regex)) this.name = name;
        else throw new AlumnoException("El nombre es incorrecto.");
    }

    /**
     * Función que devuelve los apellidos del alumno.
     *
     * @return Devuelve los apellidos.
     */
    public String getSurNames() {
        return surNames;
    }

    /**
     * Procedimiento que permite indicarle los apellidos del alumno.
     *
     * @param surNames Apellidos que le daremos.
     */
    public void setSurNames(String surNames) throws AlumnoException {
        var regex = "^([a-záéíóú]{1}[a-zñáéíóú]*)\\s([a-záéíóú]{1}[a-zñáéíóú]*)$";
        if (surNames.matches(regex)) this.surNames = surNames;
        else throw new AlumnoException("Los apellidos son incorrectos.");
    }

    /**
     * Función que devuelve el email del alumno.
     *
     * @return Devuelve el email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Procedimiento que permite indicarle el email del alumno.
     *
     * @param email Email que le daremos.
     */
    public void setEmail(String email) throws AlumnoException {
        var regex = "^[\\w]+@{1}([\\w]+\\.)+[a-z]{2,3}$";
        if (email.matches(regex)) this.email = email;
        else throw new AlumnoException("El email es incorrecto.");
    }

    /**
     * Función que devuelve el teléfono del alumno.
     *
     * @return Devuelve el teléfono.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Procedimiento que permite indicarle el teléfono del alumno.
     *
     * @param phone Teléfono que le daremos.
     */
    public void setPhone(String phone) throws AlumnoException {
        var regex = "^[6-9]{1}[0-9]{2}[-][0-9]{6}$";
        if (phone.matches(regex)) this.phone = phone;
        else throw new AlumnoException("El teléfono es incorrecto.");

    }

    /**
     * Función que devuelve si ha perdido la evaluación el alumno.
     *
     * @return Devuelve un boolean, true si la ha perdido, false si no.
     */
    public boolean isHasLoseEvaluation() {
        return hasLoseEvaluation;
    }

    /**
     * Procedimiento que permite indicar si ha perdido la evaluación el alumno.
     *
     * @param hasLoseEvaluation Boolean para indicar si ha perdido o no la evaluación.
     */
    public void setHasLoseEvaluation(boolean hasLoseEvaluation) {
        this.hasLoseEvaluation = hasLoseEvaluation;
    }

    /**
     * Función que devuelve la fecha de matriculación del alumno.
     *
     * @return Devuelve la fecha de matriculación.
     */
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Función que indica si el usuario está disponible o no;
     *
     * @return devuelve true si esta, false si no esta disponible.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Procedimiento para indicar si el alumno esta disponible o no.
     *
     * @param enabled boolean que indicará si el usuario esta disponible o no.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Método fluido para añadirle una id al alumno.
     *
     * @param id Id que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno id(int id) {
        this.id = id;
        return this;
    }

    /**
     * Método fluido para añadirle una dni al alumno.
     *
     * @param dni Dni que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno dni(String dni) throws AlumnoException {
        var regex = "^([1-9]{1}[0-9]{7}[a-z])$";
        if (dni.matches(regex)) this.dni = dni;
        else throw new AlumnoException("El dni es incorrecto.");

        return this;
    }

    /**
     * Método fluido para añadirle una nombre al alumno.
     *
     * @param name Nombre que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno name(String name) throws AlumnoException {
        var regex = "([a-záéíóú]{1}[a-zñáéíóú]*)$";
        if (name.matches(regex)) this.name = name;
        else throw new AlumnoException("El nombre es incorrecto.");
        return this;
    }

    /**
     * Método fluido para añadirle unos apellidos al alumno.
     *
     * @param surNames Apellidos que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno surNames(String surNames) throws AlumnoException {
        var regex = "^([a-záéíóú]{1}[a-zñáéíóú]*)\\s([a-záéíóú]{1}[a-zñáéíóú]*)$";
        if (surNames.matches(regex)) this.surNames = surNames;
        else throw new AlumnoException("Los apellidos son incorrectos.");
        return this;
    }

    /**
     * Método fluido para añadirle una email al alumno.
     *
     * @param email Email que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno email(String email) throws AlumnoException {
        var regex = "^[\\w]+@{1}([\\w]+\\.)+[a-z]{2,3}$";
        if (email.matches(regex)) this.email = email;
        else throw new AlumnoException("El email es incorrecto.");
        return this;
    }

    /**
     * Método fluido para añadirle una teléfono al alumno.
     *
     * @param phone Teléfono que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno phone(String phone) throws AlumnoException {
        var regex = "^[6-9]{1}[0-9]{2}[-][0-9]{6}$";
        if (phone.matches(regex)) this.phone = phone;
        else throw new AlumnoException("El teléfono es incorrecto.");

        return this;
    }

    /**
     * Método fluido para indicar si el alumno ha perdido la evaluación.
     *
     * @param hasLoseEvaluation Boolean que le indicaremos al alumno si ha perdido la evaluación.
     * @return devuelve el propio alumno.
     */
    public Alumno hasLoseEvaluation(boolean hasLoseEvaluation) {
        this.hasLoseEvaluation = hasLoseEvaluation;
        return this;
    }

    /**
     * Método fluido para indicar si el alumno está disponible.
     *
     * @param enabled Boolean que le indicaremos al alumno si esta disponible o no.
     * @return devuelve el propio alumno.
     */
    public Alumno enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }


    /**
     * Método toString para devolver una cadena mostrando los datos del alumno.
     *
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
                ", enabled= " + enabled +
                ", registrationDate=" + registrationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                '}';
    }
<<<<<<< HEAD

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

    public boolean isEnabled() {
        return enabled;
    }

    public Alumno enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
=======
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
}
