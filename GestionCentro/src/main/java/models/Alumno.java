package models;

import java.time.LocalDate;

/**
 * Clase que representa un Alumno.
 * Es una clase POJO, solo contiene getter and setters y una interfaz fluida.
 */
public class Alumno {
    private int id;
    private static int contador=1;
    private String dni;
    private String name;
    private String serNames;
    private String email;
    private String phone;
    private boolean hasLoseEvaluation;
    private final LocalDate registrationDate;

    /**
     * Método constructor de Alumno.
     */
    public Alumno(){
        this.id = contador++;
        registrationDate= LocalDate.now(); //TODO cambiar el formato de la fecha a DD/MM/YYYY
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
    public void setId(int id) {
        this.id = id;
    }

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
    public void setDni(String dni) {
        this.dni = dni;
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
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Función que devuelve los apellidos del alumno.
     * @return Devuelve los apellidos.
     */
    public String getSerNames() {
        return serNames;
    }

    /**
     * Procedimiento que permite indicarle los apellidos del alumno.
     * @param serNames Apellidos que le daremos.
     */
    public void setSerNames(String serNames) {
        this.serNames = serNames;
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
    public void setEmail(String email) {
        this.email = email;
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
    public void setPhone(String phone) {
        this.phone = phone;
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
    public LocalDate getRegistrationDate() {
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
    public Alumno dni(String dni) {
        this.dni = dni;
        return this;
    }

    /**
     * Método fluido para añadirle una nombre al alumno.
     * @param name Nombre que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Método fluido para añadirle unos apellidos al alumno.
     * @param serNames Apellidos que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno serNames(String serNames) {
        this.serNames = serNames;
        return this;
    }

    /**
     * Método fluido para añadirle una email al alumno.
     * @param email Email que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Método fluido para añadirle una teléfono al alumno.
     * @param phone Teléfono que le añadiremos al alumno
     * @return devuelve el propio alumno.
     */
    public Alumno phone(String phone) {
        this.phone = phone;
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
                ", serNames='" + serNames + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hasLoseEvaluation=" + hasLoseEvaluation +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
