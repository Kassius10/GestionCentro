package exceptions;

/**
 * Clase de excepciones de alumnos.
 */
public class AlumnoException extends Exception {
    /**
     * Constructor de la clase
     * @param message Mensaje que le pasaremos para indicar el problema de la excepción.
     */
    public AlumnoException(String message){
        super(message);
    }
}
