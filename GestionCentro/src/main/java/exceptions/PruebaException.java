package exceptions;

/**
 * Clase de excepciones de pruebas.
 */
public class PruebaException extends Exception {
    /**
     * Constructor de la clase
     * @param message Mensaje que le pasaremos para indicar el problema de la excepción.
     */
    public PruebaException(String message){
        super(message);
    }
}
