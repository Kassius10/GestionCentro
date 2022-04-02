package comparators;

import models.Alumno;

import java.util.Comparator;

public class AlumnoNumListComparator implements Comparator<Alumno> {
    @Override
    public int compare(Alumno o1, Alumno o2) {
        return o1.getId()-o2.getId();
    }

    @Override
    public Comparator<Alumno> reversed() {
        return Comparator.super.reversed();
    }
}
