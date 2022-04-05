package repositories.pruebas;
import exceptions.PruebaException;

import models.Categoria;
import models.PruebaEvaluacion;

import java.util.*;

public class PruebaRepository implements IPruebaRepository {
    private final TreeMap<Categoria,PruebaEvaluacion> pruebas = new TreeMap<>(Comparator.comparing(Categoria::getName));

    @Override
    public List<PruebaEvaluacion> findAll() {
        return new ArrayList<>(this.pruebas.values());
    }

    @Override
    public Optional<PruebaEvaluacion> findById(Categoria categoria) throws PruebaException {
        var prueba= pruebas.get(categoria);
//        if(prueba==null){
//            Optional.empty();
//            throw new PruebaException("No existe ningúna prueba: " + categoria.getName());
//        }
//        return Optional.of(prueba);
        if (prueba!=null){
            return Optional.of(prueba);
        }
        return Optional.empty();
    }

    @Override
    public Optional<PruebaEvaluacion> save(PruebaEvaluacion prueba) {
        this.pruebas.put(prueba.getCategory(),prueba);
        return Optional.of(prueba);
    }

    @Override
    public Optional<PruebaEvaluacion> delete(Categoria categoria) {
        return Optional.of(this.pruebas.remove(categoria));
    }
}
