package repositories.pruebas;

import exceptions.PruebaException;
import models.Categoria;
import models.PruebaEvaluacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PruebaRepository implements IPruebaRepository {
    private final List<PruebaEvaluacion> pruebas = new ArrayList<>();

    @Override
    public List<PruebaEvaluacion> findAll() {
        return this.pruebas;
    }

    @Override
    public Optional<PruebaEvaluacion> findById(Categoria categoria) throws PruebaException {
        for (PruebaEvaluacion p : pruebas) {
            if (p.getCategory().getName().equals(categoria.getName())) {
                return Optional.of(p);
            }
        }
        throw new PruebaException("No se encuentra ninguna prueba con la categoria " + categoria.getName());
    }

    @Override
    public Optional<PruebaEvaluacion> save(PruebaEvaluacion prueba) {
        this.pruebas.add(prueba);
        return Optional.of(prueba);
    }

    @Override
    public Optional<PruebaEvaluacion> delete(Categoria categoria) throws PruebaException {
        var prueba = findById(categoria).get();
        pruebas.remove(prueba);
        return Optional.of(prueba);
    }

    @Override
    public Optional<PruebaEvaluacion> deleteByPrueba(PruebaEvaluacion prueba) {
        pruebas.remove(prueba);
        return Optional.of(prueba);
    }

    @Override
    public List<PruebaEvaluacion> findByCategory(Categoria category) {
        List<PruebaEvaluacion> listas = pruebas.stream()
                .filter(p -> p.getCategory().getName().equals(category.getName()))
                .collect(Collectors.toList());

        return listas;
    }
}
