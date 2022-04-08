package repositories;

import controllers.DataBaseManager;
import exceptions.AlumnoException;
import models.Alumno;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import utilities.DataBase;
import utilities.DataDB;
=======
import repositories.alumnos.AlumnoRepository;
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyInt;

class AlumnoRepositoryTest {
<<<<<<< HEAD
    private final AlumnoRepository repository= AlumnoRepository.getInstance(DataBaseManager.getInstance());
=======
    private final AlumnoRepository repository = new AlumnoRepository();
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

    private final Alumno alumno = new Alumno(
            "12345678a",
            "Dani",
            "A p",
            "d@d.com",
            "666-666666",
            true,
            true
    );
    @BeforeAll
    static void setUpAll(){
        DataBase.init();
    }

    @BeforeEach
<<<<<<< HEAD
    void setUp() throws SQLException {
        DataBase.deleteAll();
        DataDB.insertAlumno(alumno);
    }

    @Test
    void findAllTest() throws SQLException {
        var lista1= repository.findAll();
=======
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void findAllTest() {
        var lista1 = repository.findAll();
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

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
<<<<<<< HEAD
    void findByDniTest() throws SQLException {
=======
    void findByDniTest() {
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
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
<<<<<<< HEAD
    void findByDniExcpetionTest() throws SQLException {
=======
    void findByDniExcpetionTest() {
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
        Optional<Alumno> alumnoEncontrado = repository.findByDni(alumno.getDni());
        assertFalse(alumnoEncontrado.isPresent());

    }

    @Test
    void findByIdTest() throws AlumnoException, SQLException {
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
<<<<<<< HEAD
    void saveTest() throws AlumnoException, SQLException {
        var aux= repository.save(alumno);
        Optional<Alumno> alumnoEncontrado = repository.findById(alumno.getId());
        assertAll(
                ()->assertEquals(aux.get().getDni(),alumno.getDni()),
                ()->assertEquals(aux.get().getName(),alumno.getName()),
                ()->assertEquals(aux.get().getSurNames(),alumno.getSurNames()),
                ()->assertEquals(aux.get().getEmail(),alumno.getEmail()),
                ()->assertEquals(aux.get().getPhone(),alumno.getPhone()),
                ()->assertEquals(aux.get().getRegistrationDate(),alumno.getRegistrationDate()),
                ()->assertEquals(alumno.getDni(),alumnoEncontrado.get().getDni()),
                ()->assertTrue(alumnoEncontrado.isPresent())
=======
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
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
        );
    }

    @Test
    void updateTest() throws AlumnoException, SQLException {
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
    void deleteTest() throws SQLException {
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