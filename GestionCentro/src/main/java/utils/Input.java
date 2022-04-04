package utils;

import java.util.Scanner;

/**
 * Clase scanner
 */
public class Input {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Método de lectura de String
     * @param message Mensaje que queremos que imprima antes de la lectura.
     * @return Devuelve la cadena leida.
     */
    public static String readString(String message){
        System.out.println(message);
        return sc.nextLine().trim().toLowerCase();
    }
}
