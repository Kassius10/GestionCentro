package comparators;

import models.Alumno;

import java.util.Comparator;

public class AlumnoNameComparator implements Comparator<Alumno> {

    @Override
    public int compare(Alumno o1, Alumno o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public Comparator<Alumno> reversed() {
        return Comparator.super.reversed();
    }
}
