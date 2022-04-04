package comparators;

import models.Alumno;

import java.util.Comparator;

/**
 * Comparador de alumnos por su nombre.
 */
public class AlumnoNameComparator implements Comparator<Alumno> {

    /**
     * Método de comparar un alumno con otro por nombre.
     * @param o1 Primer Alumno
     * @param o2 Segundo Alumno
     * @return devuelve un número que sera la respuesta de quien es mayor.
     */
    @Override
    public int compare(Alumno o1, Alumno o2) {
        return o1.getName().compareTo(o2.getName());
    }

    /**
     * Método para obtener el orden inverso al compare
     * @return Devuelve la comparación al inverso de alumno.
     */
    @Override
    public Comparator<Alumno> reversed() {
        return Comparator.super.reversed();
    }
}
