package repositories;

import models.Alumno;

/**
 * Interfaz que añade funciones al repositorio.
 */
public interface IRepository extends CRUDRepository<Alumno,Integer>{
    /**
     * Función para buscar un Alumno por el dni.
     *
     * @param dni Dni del alumno por el que buscaremos en el repositorio.
     * @return Devuelve el Alumno encontrado en el repositorio.
     */
    Alumno findByDni(String dni);

    /**
     * Procedimiento para eliminar todos los elementos del repositorio.
     */
    void deleteAll();
}
