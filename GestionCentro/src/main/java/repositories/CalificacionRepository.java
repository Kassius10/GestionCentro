package repositories;

import exceptions.AlumnoException;
import models.Alumno;
import models.Calificacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalificacionRepository{
    private final List<Calificacion> calificaciones= new ArrayList<>();

    public CalificacionRepository(){
    }

    public List<Calificacion> findAll() {
        return this.calificaciones;
    }

    public Optional<Calificacion> findByDni(String dni) {
        return calificaciones.stream()
                .filter(c-> c.getStudent().getDni().equals(dni))
                .findFirst();
    }

    public Optional save(Calificacion calificacion) {
        calificaciones.add(calificacion);
        return Optional.of(calificacion);
    }

    public Optional delete(Calificacion calificacion) {
        calificaciones.remove(calificacion);
        return Optional.of(calificacion);
    }
}
