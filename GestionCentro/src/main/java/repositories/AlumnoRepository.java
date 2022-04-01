package repositories;

import models.Alumno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Repositorio de los alumnos.
 */
public class AlumnoRepository implements IRepository {
    private final TreeMap<Integer,Alumno> alumnos = new TreeMap<>();

    /**
     * Devuelve una lista con todos los paises.
     * @return Devuelve la lista de alumnos.
     */
    @Override
    public List<Alumno> findAll() {
        return new ArrayList<>(this.alumnos.values());
    }

    /**
     * Buscar un alumno por su id
     * @param id Id del elemento
     * @return Devuelve el alumno si se encuentra en el repositorio o null si no.
     */
    @Override
    public Optional<Alumno> findById(Integer id) {
        return Optional.of(alumnos.get(id));
    }

    /**
     * Función para añadir un alumno al repositorio.
     * @param alumno Alumno que queremos añadir.
     * @return Devuelve el alumno que hemos añadido.
     */
    @Override
    public Alumno save(Alumno alumno) {
        this.alumnos.put(alumno.getId(),alumno);
        return alumno;
    }

    /**
     * Función para actualizar un alumno.
     * @param id Id del elemento que vamos a actualizar.
     * @param alumno Alumno ya modificado que queremos guardar.
     * @return Devuelve el alumno modificado.
     */
    @Override
    public Alumno update(Integer id, Alumno alumno) {
        this.alumnos.put(id,alumno);
        return alumno;
    }

    /**
     * Función para eliminar un alumno del repositorio.
     * @param id Id del elemento que vamos a eliminar.
     * @return Devuelve el alumno que hemos eliminado.
     */
    @Override
    public Alumno delete(Integer id) {
        return this.alumnos.remove(id);
    }

    /**
     * Función para buscar un alumno por su dni en el repositorio.
     * @param dni Dni del alumno por el que buscaremos en el repositorio.
     * @return Devuelve el alumno si se encuentra o null si no.
     */
    @Override
    public Optional<Alumno> findByDni(String dni) {
        for (Alumno alumno: this.alumnos.values()) {
            if (alumno.getDni().equals(dni)){
                return Optional.of(alumno);
            }
        }
        return Optional.empty();
    }

    /**
     * Procedimiento para eliminar todo el repositorio.
     */
    @Override
    public void deleteAll() {
        this.alumnos.clear();
    }
}
