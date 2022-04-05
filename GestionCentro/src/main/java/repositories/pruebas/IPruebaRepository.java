package repositories.pruebas;

import models.Categoria;
import models.PruebaEvaluacion;
import repositories.CRDRepository;

public interface IPruebaRepository extends CRDRepository<PruebaEvaluacion, Categoria> {
}
