package controllers;

import exceptions.PruebaException;
import models.Categoria;
import models.PruebaEvaluacion;
import repositories.pruebas.IPruebaRepository;

import java.util.List;

public class EvaluationTestController {
    private static  EvaluationTestController instance;
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
    public List<PruebaEvaluacion> getAllEvaluationTest(){
        return pruebas.findAll();
    }
    public PruebaEvaluacion createEvaluationTest(PruebaEvaluacion prueba) throws PruebaException {
        var exist= pruebas.findById(prueba.getCategory());
        if (exist.isEmpty()){
            pruebas.save(prueba);
            return prueba;
        }
        throw new PruebaException("Ya existe una prueba de " + prueba.getCategory());
    }
    public PruebaEvaluacion deleteEvaluationTest(Categoria categoria) throws PruebaException {
        var prueba= pruebas.findById(categoria).orElseThrow(()-> new PruebaException("No existe ningúna prueba de "+ categoria.getName()));
        pruebas.delete(prueba.getCategory());
        return prueba;

    }
}
