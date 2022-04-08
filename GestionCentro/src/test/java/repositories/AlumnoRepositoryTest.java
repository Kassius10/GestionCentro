package repositories;

import exceptions.AlumnoException;
import models.Alumno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.alumnos.AlumnoRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyInt;

class AlumnoRepositoryTest {
    private final AlumnoRepository repository = new AlumnoRepository();

    private final Alumno alumno = new Alumno(
            "12345678a",
            "Dani",
            "A p",
            "d@d.com",
            "666-666666",
            true,
            true
    );

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void findAllTest() {
        var lista1 = repository.findAll();

        repository.save(alumno);
        var lista2 = repository.findAll();

        assertAll(
                () -> assertEquals(lista1.size(), 0),
                () -> assertEquals(lista2.size(), 1),
                () -> assertTrue(lista2.contains(alumno)),
                () -> assertEquals(lista2.get(0).getId(), alumno.getId()),
                () -> assertEquals(lista2.get(0).getDni(), alumno.getDni()),
                () -> assertEquals(lista2.get(0).getName(), alumno.getName()),
                () -> assertEquals(lista2.get(0).getSurNames(), alumno.getSurNames()),
                () -> assertEquals(lista2.get(0).getEmail(), alumno.getEmail()),
                () -> assertEquals(lista2.get(0).getPhone(), alumno.getPhone()),
                () -> assertEquals(lista2.get(0).getRegistrationDate(), alumno.getRegistrationDate()),
                () -> assertEquals(lista2.get(0).isHasLoseEvaluation(), alumno.isHasLoseEvaluation())

        );
    }

    @Test
    void findByDniTest() {
        repository.save(alumno);
        Optional<Alumno> alumnoEncontrado = repository.findByDni(alumno.getDni());
        assertAll(
                () -> assertEquals(alumnoEncontrado.get().getId(), alumno.getId()),
                () -> assertEquals(alumnoEncontrado.get().getName(), alumno.getName()),
                () -> assertEquals(alumnoEncontrado.get().getSurNames(), alumno.getSurNames()),
                () -> assertEquals(alumnoEncontrado.get().getDni(), alumno.getDni()),
                () -> assertEquals(alumnoEncontrado.get().getEmail(), alumno.getEmail()),
                () -> assertEquals(alumnoEncontrado.get().getPhone(), alumno.getPhone()),
                () -> assertEquals(alumnoEncontrado.get().getRegistrationDate(), alumno.getRegistrationDate()),
                () -> assertEquals(alumnoEncontrado.get().isHasLoseEvaluation(), alumno.isHasLoseEvaluation())
        );
    }

    @Test
    void findByDniExcpetionTest() {
        Optional<Alumno> alumnoEncontrado = repository.findByDni(alumno.getDni());
        assertFalse(alumnoEncontrado.isPresent());

    }

    @Test
    void findByIdTest() throws AlumnoException {
        repository.save(alumno);
        Optional<Alumno> alumnoEncontrado = repository.findById(alumno.getId());
        assertAll(
                () -> assertEquals(alumnoEncontrado.get().getId(), alumno.getId()),
                () -> assertEquals(alumnoEncontrado.get().getName(), alumno.getName()),
                () -> assertEquals(alumnoEncontrado.get().getSurNames(), alumno.getSurNames()),
                () -> assertEquals(alumnoEncontrado.get().getDni(), alumno.getDni()),
                () -> assertEquals(alumnoEncontrado.get().getEmail(), alumno.getEmail()),
                () -> assertEquals(alumnoEncontrado.get().getPhone(), alumno.getPhone()),
                () -> assertEquals(alumnoEncontrado.get().getRegistrationDate(), alumno.getRegistrationDate()),
                () -> assertEquals(alumnoEncontrado.get().isHasLoseEvaluation(), alumno.isHasLoseEvaluation())
        );
    }

    @Test
    void findByIdExceptionTest() throws AlumnoException {
        Exception thrown = assertThrows(Exception.class, () -> repository.findById(anyInt()));
        assertTrue(thrown.getMessage().contains("No existe el alumno"));
    }

    @Test
    void saveTest() throws AlumnoException {
        var aux = repository.save(alumno);
        Optional<Alumno> alumnoEncontrado = repository.findById(alumno.getId());
        assertAll(
                () -> assertEquals(aux.get().getId(), alumno.getId()),
                () -> assertEquals(aux.get().getDni(), alumno.getDni()),
                () -> assertEquals(aux.get().getName(), alumno.getName()),
                () -> assertEquals(aux.get().getSurNames(), alumno.getSurNames()),
                () -> assertEquals(aux.get().getEmail(), alumno.getEmail()),
                () -> assertEquals(aux.get().getPhone(), alumno.getPhone()),
                () -> assertEquals(aux.get().getRegistrationDate(), alumno.getRegistrationDate()),
                () -> assertEquals(alumno.getDni(), alumnoEncontrado.get().getDni()),
                () -> assertTrue(alumnoEncontrado.isPresent())
        );
    }

    @Test
    void updateTest() throws AlumnoException {
        repository.save(alumno);
        alumno.setDni("12345678a");
        alumno.setName("manolo");
        alumno.setSurNames("lopez sanchez");
        alumno.setEmail("d@d.com");
        alumno.setPhone("666-666666");
        alumno.setHasLoseEvaluation(false);

        var aux = repository.update(alumno.getId(), alumno);

        Optional<Alumno> alumnoEncontrado = repository.findById(alumno.getId());

        assertAll(
                () -> assertEquals(aux.get().getId(), alumno.getId()),
                () -> assertEquals(aux.get().getDni(), alumno.getDni()),
                () -> assertEquals(aux.get().getName(), alumno.getName()),
                () -> assertEquals(aux.get().getSurNames(), alumno.getSurNames()),
                () -> assertEquals(aux.get().getEmail(), alumno.getEmail()),
                () -> assertEquals(aux.get().getPhone(), alumno.getPhone()),
                () -> assertEquals(aux.get().getRegistrationDate(), alumno.getRegistrationDate()),
                () -> assertTrue(alumnoEncontrado.isPresent())
        );
    }

    @Test
    void deleteTest() throws AlumnoException {
        repository.save(alumno);
        var aux = repository.delete(alumno.getId());

        assertAll(
                () -> assertEquals(aux.get().getId(), alumno.getId()),
                () -> assertEquals(aux.get().getDni(), alumno.getDni()),
                () -> assertEquals(aux.get().getName(), alumno.getName()),
                () -> assertEquals(aux.get().getSurNames(), alumno.getSurNames()),
                () -> assertEquals(aux.get().getEmail(), alumno.getEmail()),
                () -> assertEquals(aux.get().getPhone(), alumno.getPhone()),
                () -> assertEquals(aux.get().getRegistrationDate(), alumno.getRegistrationDate())
        );

    }

    @Test
    void size() {
        repository.save(alumno);
        assertEquals(1, repository.size());
    }


}