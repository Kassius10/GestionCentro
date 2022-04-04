package controllers;

import exceptions.AlumnoException;
import models.Alumno;
import repositories.IRepository;

import java.util.List;

/**
 * Clase que controla los alumnos.
 */
public class AlumnoController {
    private static AlumnoController instance;
    private final IRepository alumnos;

    /**
     * Constructor privado para solo poder generarse una instancia.
     * @param alumnos Repositorio que le daremos para almacenar los alumnos.
     */
    private AlumnoController(IRepository alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Método que nos permite crear una única instancia de la clase, si la instancia es null.
     *
     * @return Devuelve la instancia creada.
     */
    public static AlumnoController getInstance(IRepository alumnos) {
        if(instance == null){
            instance = new AlumnoController(alumnos);
        }
        return instance;
    }

    /**
     * Función que devuelve el alumno con el dni indicado.
     * @param dni Dni del alumno.
     * @return Devuelve el alumno si existe con el dni indicado.
     * @throws AlumnoException Excepción si no existe un alumno con el dni.
     */
    public Alumno getAlumnByDni(String dni) throws AlumnoException {
        var alumno = alumnos.findByDni(dni).orElseThrow(()-> new AlumnoException("No existe un alumno con dni " + dni));
        return alumno;
    }

    /**
     * Función que devuelve una lista con todos los alumnos del repositorio.
     * @return Devuelve una lista de alumnos.
     */
    public List<Alumno> getAllAlumnos(){
        return alumnos.findAll();
    }

    /**
     * Función para añadir un alumno.
     * @param alumno Alumno que queremos añadir.
     * @return Devuelve el alumno que hemos añadido.
     * @throws AlumnoException Excepción si ya existe un alumno con el mismo dni.
     */
    public Alumno insertAlumno(Alumno alumno) throws AlumnoException {
        var exist= alumnos.findByDni(alumno.getDni());
        if (exist.isEmpty()){
            alumnos.save(alumno);
            return alumno;
        }
        throw new AlumnoException("Ya existe un alumno con dni " + alumno.getDni());
    }

    /**
     * Función para actualizar los datos de un alumno.
     * @param id Id del alumno
     * @param alumno Alumno con los datos modificados.
     * @return Devuelve el alumno.
     * @throws AlumnoException Excepción si existe un alumno con el mismo dni.
     */
    public Alumno updateAlumno(int id, Alumno alumno) throws AlumnoException {
        var alumn= alumnos.findByDni(alumno.getDni());
        if (alumn.isEmpty() || alumno.getId() == alumn.get().getId()){
            alumnos.update(id,alumno);
            return alumno;
        }
        throw new AlumnoException("Ya existe un alumno con dni "+ alumn.get().getDni());
    }

    /**
     * Función para eliminar un alumno con el dni indicado.
     * @param dni Dni del alumno
     * @return Devuelve el alumno eliminado.
     * @throws AlumnoException Excepción si no existe el alumno.
     */
    public Alumno deletAlumno(String dni) throws AlumnoException {
        var alumno= alumnos.findByDni(dni).orElseThrow(()-> new AlumnoException("No existe el alumno con dni " + dni));
        alumnos.delete(alumno.getId());
        return alumno;
    }

}
