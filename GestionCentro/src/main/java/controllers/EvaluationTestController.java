package controllers;

import exceptions.CategoriesException;
import exceptions.PruebaException;
import models.Categoria;
import models.PruebaEvaluacion;
import repositories.pruebas.IPruebaRepository;

import java.util.List;

public class EvaluationTestController {
    private static EvaluationTestController instance;
    private final IPruebaRepository pruebas;

    private EvaluationTestController(IPruebaRepository pruebas) {
        this.pruebas = pruebas;
    }

    public static EvaluationTestController getInstance(IPruebaRepository pruebas) {
        if (instance == null) {
            instance = new EvaluationTestController(pruebas);
        }
        return instance;
    }

    public List<PruebaEvaluacion> getAllEvaluationTest() {
        return pruebas.findAll();
    }

    public PruebaEvaluacion createEvaluationTest(PruebaEvaluacion prueba) throws PruebaException {
        pruebas.save(prueba);
        return prueba;
    }

    public PruebaEvaluacion deleteEvaluationTestByCategory(Categoria categoria) throws CategoriesException, PruebaException {
        var prueba = pruebas.findById(categoria).get();
        pruebas.delete(prueba.getCategory());
        return prueba;

    }

    public PruebaEvaluacion deleteEvaluationTest(PruebaEvaluacion prueba) throws PruebaException, CategoriesException {
        var test = pruebas.findById(prueba.getCategory());
        pruebas.deleteByPrueba(prueba);
        return prueba;

    }

    public List<PruebaEvaluacion> findByCategory(Categoria category) throws PruebaException {
        return pruebas.findByCategory(category);
    }
}
