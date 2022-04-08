package repositories.pruebas;

import exceptions.PruebaException;
import models.Categoria;
import models.PruebaEvaluacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase repositorio de pruebas
 */
public class PruebaRepository implements IPruebaRepository {
    private final List<PruebaEvaluacion> pruebas = new ArrayList<>();

    /**
     * Funcion que devuelve una lista de todos los elementos del repositorio
     *
     * @return Devuelve una lista de pruebas
     */
    @Override
    public List<PruebaEvaluacion> findAll() {
        return this.pruebas;
    }

    /**
     * Función para buscar una prueba segun la categoria
     *
     * @param categoria Categoria por la cual queremos buscar
     * @return Devuelve la prueba si existe.
     * @throws PruebaException Si no se encuentra ninguna prueba con dicha categoria
     */
    @Override
    public Optional<PruebaEvaluacion> findById(Categoria categoria) throws PruebaException {
        for (PruebaEvaluacion p : pruebas) {
            if (p.getCategory().getName().equals(categoria.getName())) {
                return Optional.of(p);
            }
        }
        throw new PruebaException("No se encuentra ninguna prueba con la categoria " + categoria.getName());
    }

    /**
     * Funcion que añade una prueba al repositorio
     *
     * @param prueba Prueba que queremos añadir
     * @return Devuelve la prueba
     */
    @Override
    public Optional<PruebaEvaluacion> save(PruebaEvaluacion prueba) {
        this.pruebas.add(prueba);
        return Optional.of(prueba);
    }

    /**
     * Función que elimina una prueba del repositorio segun su categoria
     *
     * @param categoria Categoria por la cual queremos buscar
     * @return Devuelve la prueba si se ha encontrado
     * @throws PruebaException Si no existe la prueba en el repositorio
     */
    @Override
    public Optional<PruebaEvaluacion> delete(Categoria categoria) throws PruebaException {
        var prueba = findById(categoria).get();
        pruebas.remove(prueba);
        return Optional.of(prueba);
    }

    /**
     * Función que elimina una prueba según la prueba
     *
     * @param prueba Prueba que queremos eliminar
     * @return devuelve la prueba
     */
    @Override
    public Optional<PruebaEvaluacion> deleteByPrueba(PruebaEvaluacion prueba) {
        pruebas.remove(prueba);
        return Optional.of(prueba);
    }

    /**
     * Función que devuelve una lista de pruebas según la categoria indicada
     *
     * @param category Categoria por la cual queremos buscar
     * @return Devuelve una lista de pruebas
     */
    @Override
    public List<PruebaEvaluacion> findByCategory(Categoria category) {
        List<PruebaEvaluacion> listas = pruebas.stream()
                .filter(p -> p.getCategory().getName().equals(category.getName()))
                .collect(Collectors.toList());

        return listas;
    }
}
