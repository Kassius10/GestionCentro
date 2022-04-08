package utils;

/**
 * Clase especial para comprobación de patrones
 */
public class Patterns {
    /**
     * Método de clase que comprueba el patron de nombre
     *
     * @param name Cadena del nombre que será comprobada.
     * @return De vuelve la cadena si cumple la expresión.
     */
    public static String patternName(String name) {
        var regex = "([a-záéíóú]{1}[a-zñáéíóú]*)$";
        while (!name.matches(regex)) {
            name = Input.readString("Inténtelo de nuevo.");
        }
        return name;
    }

    /**
     * Método de clase que comprueba el patron de dni.
     *
     * @param dni Cadena del dni que será comprobada.
     * @return De vuelve la cadena si cumple la expresión.
     */
    public static String patternDni(String dni) {
        var regex = "^([1-9]{1}[0-9]{7}[a-z])$";
        while (!dni.matches(regex)) {
            dni = Input.readString("Inténtelo de nuevo.");
        }
        return dni;
    }

    /**
     * Método de clase que comprueba el patron de los apellidos
     *
     * @param surNames Cadena de los apellidos que será comprobada.
     * @return De vuelve la cadena si cumple la expresión.
     */
    public static String patternSurnames(String surNames) {
        var regex = "^([a-záéíóú]{1}[a-zñáéíóú]*)\\s([a-záéíóú]{1}[a-zñáéíóú]*)$";
        while (!surNames.matches(regex)) {
            surNames = Input.readString("Inténtelo de nuevo.");
        }
        return surNames;
    }

    /**
     * Método de clase que comprueba el patron del email.
     *
     * @param email Cadena del email que será comprobada.
     * @return De vuelve la cadena si cumple la expresión.
     */
    public static String patternEmail(String email) {
        var regex = "^[\\w]+@{1}([\\w]+\\.)+[a-z]{2,3}$";
        while (!email.matches(regex)) {
            email = Input.readString("Inténtelo de nuevo.");
        }
        return email;
    }

    /**
     * Método de clase que comprueba el patron del teléfono.
     *
     * @param phone Cadena del teléfono que será comprobada.
     * @return De vuelve la cadena si cumple la expresión.
     */
    public static String patternPhone(String phone) {
        var regex = "^[6-9]{1}[0-9]{2}[-][0-9]{6}$";
        while (!phone.matches(regex)) {
            phone = Input.readString("Inténtelo de nuevo.");
        }
        return phone;
    }

    /**
     * Método de clase que comprueba el patron de un boolean
     *
     * @param booleans Cadena del boolean que será comprobada.
     * @return De vuelve la cadena si cumple la expresión.
     */
    public static String patternBoolean(String booleans) {
        var regex = "^(si|no)$";
        while (!booleans.matches(regex)) {
            booleans = Input.readString("Inténtelo de nuevo.");
        }
        return booleans;
    }

    /**
     * Función que aplica un formato determinado a una cadena
     *
     * @param name Nombre de la categoría a comprobar
     * @return Verdadero si la cadena supera la expresión regular.
     */
    public static String categoryItsOk(String name) {
        var regex = "^[a-zA-Z]+$";
        while (!name.matches(regex)) {
            name = Input.readStringUppercase("El nombre es incorrecto");
        }
        return name;
    }

    /**
     * Función que aplica un formato determinado segun los datos
     *
     * @param num1 Numero mínimo
     * @param num2 Numero máximo
     * @return Devuelve la cadena
     */
    public static int setOption(int num1, int num2) {
        var regex = "[" + num1 + "-" + num2 + "]";
        String option;
        do {
            option = Input.readString("¿Qué desea hacer?: ");
            if (!option.matches(regex)) System.out.println("xx La opción seleccionada es incorrecta.");
        } while (!option.matches(regex));

        return Integer.parseInt(option);
    }

}
