package controllers;

import repositories.IRepository;

/**
 * Clase que controla los alumnos.
 */
public class AlumnoController {
    private static AlumnoController instance;
    private IRepository alumnos;

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
}
