package utils;

/**
 * Clase util para redondeo a dos decimales
 */
public class FormatRounding {

    /**
     * Método de clase de redondeo
     *
     * @param num Número que queremos redondear
     * @return devuelve el número ya modificado
     */
    public static Double redondeo(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
}
