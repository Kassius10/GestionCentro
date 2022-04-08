package repositories.pruebas;

import models.Categoria;
import models.PruebaEvaluacion;
import repositories.CRDRepository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que añade funciones al repositorio
 */
public interface IPruebaRepository extends CRDRepository<PruebaEvaluacion, Categoria> {
    /**
     * Función para buscar por categoria y devuelve una lista
     *
     * @param category Categoria por la cual queremos buscar
     * @return Devuelve una lista de las pruebas que sean de esa categoria
     */
    List<PruebaEvaluacion> findByCategory(Categoria category);

    /**
     * Función para eliminar una prueba dandole prueba.
     *
     * @param prueba Prueba que queremos eliminar
     * @return Devuelve un optional si existe esa prueba o no
     */
    Optional<PruebaEvaluacion> deleteByPrueba(PruebaEvaluacion prueba);

    int size();

    void clear();

}
