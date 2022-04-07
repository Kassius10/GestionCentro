package repositories;

import exceptions.AlumnoException;
import models.Alumno;
import models.Calificacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalificacionRepositoryTest {
    private final Calificacion calificacion = new Calificacion(
            new Alumno(
                    "12345678a",
                    "dani",
                    "lopez sanchez",
                    "d@d.com",
                    "666-666666",
                    true,
                    true
            ),
            8.5
    );
    private CalificacionRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new CalificacionRepository();
        repository.save(calificacion);
    }

    @Test
    void findAllTest() {
        var lista = repository.findAll();

        assertAll(
                () -> assertEquals(lista.size(), 1),
                () -> assertTrue(lista.contains(calificacion)),
                () -> assertEquals(lista.get(0).getStudent(), calificacion.getStudent()),
                () -> assertEquals(lista.get(0).getDeliveryDate(), calificacion.getDeliveryDate()),
                () -> assertEquals(lista.get(0).getQualification(), calificacion.getQualification())
        );
    }

    @Test
    void findByDniTest() throws AlumnoException {
        var nota = repository.findByDni(calificacion.getStudent().getDni());
        assertEquals("12345678a", nota.getStudent().getDni());
    }

    @Test
    void saveTest() {
        var cal = new Calificacion(
                new Alumno(),
                8
        );
        var nota = repository.save(cal);
        assertEquals(8, cal.getQualification());
    }
}