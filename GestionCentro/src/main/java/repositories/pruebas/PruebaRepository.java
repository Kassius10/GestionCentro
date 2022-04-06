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
    public Optional<PruebaEvaluacion> findById(Categoria categoria) {
        var prueba = pruebas.stream()
                .filter(c -> c.getCategory().getName().equals(categoria.getName()))
                .findFirst();
        if (!prueba.isEmpty()) {

            return prueba;
        }
        return Optional.empty();
    }

    @Override
    public Optional<PruebaEvaluacion> save(PruebaEvaluacion prueba) {
        this.pruebas.add(prueba);
        return Optional.of(prueba);
    }

    @Override
    public Optional<PruebaEvaluacion> delete(Categoria categoria) throws PruebaException {
        var prueba = findById(categoria).orElseThrow(() -> new PruebaException("No existe ninguna prueba con categoria " + categoria.getName()));
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
