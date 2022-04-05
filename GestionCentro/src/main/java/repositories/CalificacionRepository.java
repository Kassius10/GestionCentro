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
        cargar();
    }

    public List<Calificacion> findAll() {
        return this.calificaciones;
    }
    private void cargar(){
        try {
            calificaciones.add(new Calificacion(new Alumno().dni("45645645a"),2));
            calificaciones.add(new Calificacion(new Alumno().dni("50583159h"),4));
            calificaciones.add(new Calificacion(new Alumno().dni("50583159h"),8));
            calificaciones.add(new Calificacion(new Alumno().dni("50583159q"),4));
        } catch (AlumnoException e) {
            e.printStackTrace();
        }
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
