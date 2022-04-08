package repositories.alumnos;

import models.Alumno;
import repositories.CRUDRepository;

import java.sql.SQLException;
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
    Optional<Alumno> findByDni(String dni) throws SQLException;

    /**
     * Procedimiento para eliminar todos los elementos del repositorio.
     */
<<<<<<< HEAD:GestionCentro/src/main/java/repositories/IRepository.java
    void deleteAll() throws SQLException;
=======
    void deleteAll();

    int size();
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4:GestionCentro/src/main/java/repositories/alumnos/IAlumnoRepository.java
}
