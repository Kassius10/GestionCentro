package repositories.alumnos;

import models.Alumno;
import repositories.CRUDRepository;

import java.util.Optional;

/**
 * Interfaz que añade funciones al repositorio.
 */
public interface IAlumnoRepository extends CRUDRepository<Alumno, Integer> {
    /**
     * Función para buscar un Alumno por el dni.
     *
     * @param dni Dni del alumno por el que buscaremos en el repositorio.
     * @return Devuelve el Alumno encontrado en el repositorio.
     */
    Optional<Alumno> findByDni(String dni);

    /**
     * Procedimiento para eliminar todos los elementos del repositorio.
     */
    void deleteAll();

    int size();
}
