package repositories;

import exceptions.AlumnoException;
import exceptions.PruebaException;
import models.Categoria;
import models.PruebaEvaluacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.pruebas.PruebaRepository;

import static org.junit.jupiter.api.Assertions.*;

class PruebaRepositoryTest {

    private final PruebaRepository repository = PruebaRepository.getInstance();

    private final PruebaEvaluacion prueba = new PruebaEvaluacion(
            "descripcion",
            new Categoria("examen"),
            new CalificacionRepository()
    );

    @BeforeEach
    public void setUp() {
        repository.clear();
    }

    @Test
    void findAllTest() {

        repository.save(prueba);
        var lista1 = repository.findAll();

        assertAll(
                () -> assertEquals(lista1.size(), 1),
                () -> assertTrue(lista1.contains(prueba)),
                () -> assertEquals(lista1.get(0).getEvaluationDate(), prueba.getEvaluationDate()),
                () -> assertEquals(lista1.get(0).getDescription(), prueba.getDescription()),
                () -> assertEquals(lista1.get(0).getCategory(), prueba.getCategory())
        );
    }

    @Test
    void findByIdTest() throws PruebaException {
        repository.save(prueba);
        var alumnoEncontrado = repository.findById(prueba.getCategory());
        assertAll(
                () -> assertEquals(alumnoEncontrado.get().getCategory(), prueba.getCategory()),
                () -> assertEquals(alumnoEncontrado.get().getDescription(), prueba.getDescription()),
                () -> assertEquals(alumnoEncontrado.get().getEvaluationDate(), prueba.getEvaluationDate())
        );
    }

    @Test
    void findByIdExceptionTest() {
        Categoria c = new Categoria("prueba");
        Exception thrown = assertThrows(PruebaException.class, () -> repository.findById(c));
        assertTrue(thrown.getMessage().contains("No se encuentra"));
    }

    @Test
    void saveTest() throws AlumnoException, PruebaException {
        var aux = repository.save(prueba);
        assertAll(
                () -> assertEquals(aux.get().getQualifications(), prueba.getQualifications()),
                () -> assertEquals(aux.get().getDescription(), prueba.getDescription()),
                () -> assertEquals(aux.get().getEvaluationDate(), prueba.getEvaluationDate()),
                () -> assertEquals(aux.get().getCategory(), prueba.getCategory())
        );
    }

    @Test
    void deleteTest() throws PruebaException {
        repository.save(prueba);
        var aux = repository.delete(prueba.getCategory());

        assertAll(
                () -> assertEquals(aux.get().getQualifications(), prueba.getQualifications()),
                () -> assertEquals(aux.get().getDescription(), prueba.getDescription()),
                () -> assertEquals(aux.get().getEvaluationDate(), prueba.getEvaluationDate()),
                () -> assertEquals(aux.get().getCategory(), prueba.getCategory())
        );

    }

    @Test
    void deleteByPruebaTest() {
        repository.save(prueba);
        var aux = repository.deleteByPrueba(prueba);

        assertAll(
                () -> assertEquals(aux.get().getQualifications(), prueba.getQualifications()),
                () -> assertEquals(aux.get().getDescription(), prueba.getDescription()),
                () -> assertEquals(aux.get().getEvaluationDate(), prueba.getEvaluationDate()),
                () -> assertEquals(aux.get().getCategory(), prueba.getCategory())
        );

    }

    @Test
    void findByCategoryTest() {

        repository.save(prueba);
        var lista1 = repository.findByCategory(prueba.getCategory());

        assertAll(
                () -> assertEquals(lista1.size(), 1),
                () -> assertTrue(lista1.contains(prueba)),
                () -> assertEquals(lista1.get(0).getCategory(), prueba.getCategory())
        );
    }

    @Test
    void size() {
        repository.save(prueba);
        assertEquals(1, repository.size());
    }

}