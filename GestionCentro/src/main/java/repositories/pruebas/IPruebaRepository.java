package repositories.pruebas;

import models.Categoria;
import models.PruebaEvaluacion;
import repositories.CRDRepository;

import java.util.List;
import java.util.Optional;

public interface IPruebaRepository extends CRDRepository<PruebaEvaluacion, Categoria> {
    List<PruebaEvaluacion> findByCategory(Categoria category);

    Optional<PruebaEvaluacion> deleteByPrueba(PruebaEvaluacion prueba);

}
