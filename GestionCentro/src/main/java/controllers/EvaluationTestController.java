package controllers;

import exceptions.PruebaException;
import models.Categoria;
import models.PruebaEvaluacion;
import repositories.pruebas.IPruebaRepository;

import java.util.List;

/**
 * Clase controladora de pruebas de evaluación
 */
public class EvaluationTestController {
    private static EvaluationTestController instance;
    private final IPruebaRepository pruebas;

    /**
     * Constructor privado para solo poder generarse una instancia
     *
     * @param pruebas Repositorio que le daremos para almacenar las pruebas.
     */
    private EvaluationTestController(IPruebaRepository pruebas) {
        this.pruebas = pruebas;
    }

    /**
     * Método que nos permite crear una única instancia de la clase, si la instancia es null.
     *
     * @param pruebas Repositorio que necesita
     * @return Devuelve la instancia creada.
     */
    public static EvaluationTestController getInstance(IPruebaRepository pruebas) {
        if (instance == null) {
            instance = new EvaluationTestController(pruebas);
        }
        return instance;
    }

    /**
     * Función que devuelve una lista con todas las pruebas del repositorio
     *
     * @return Devuelve una lista de prueba
     */
    public List<PruebaEvaluacion> getAllEvaluationTest() {
        return pruebas.findAll();
    }

    /**
     * Función para añadir una prueba de evaluación al repositorio.
     *
     * @param prueba Prueba que queremos almacenar
     * @return devuelve la misma prueba
     */
    public PruebaEvaluacion createEvaluationTest(PruebaEvaluacion prueba) {
        pruebas.save(prueba);
        return prueba;
    }

    /**
     * Función para eliminar una prueba por su categoria
     *
     * @param categoria Categoria por la cual queremos eliminar la prueba
     * @return Devuelve la prueba eliminada
     * @throws PruebaException Si no hay una prueba con esa categoria
     */
    public PruebaEvaluacion deleteEvaluationTestByCategory(Categoria categoria) throws PruebaException {
        var prueba = pruebas.findById(categoria).get();
        pruebas.delete(prueba.getCategory());
        return prueba;

    }

    /**
     * Función para eliminar una prueba por su prueba
     *
     * @param prueba La prueba que queremos eliminar
     * @return devuelve la prueba
     * @throws PruebaException Si no se encuentra esa prueba en el repositorio
     */
    public PruebaEvaluacion deleteEvaluationTest(PruebaEvaluacion prueba) throws PruebaException {
        var test = pruebas.findById(prueba.getCategory());
        pruebas.deleteByPrueba(prueba);
        return prueba;

    }

    /**
     * Función que devuelve una lista de pruebas según la categoria
     *
     * @param category Categoria que se requiere
     * @return devuelve la lista de pruebas
     * @throws PruebaException Si no se encuentra una prueba de dicha categoria.
     */
    public List<PruebaEvaluacion> findByCategory(Categoria category) throws PruebaException {
        return pruebas.findByCategory(category);
    }


}
