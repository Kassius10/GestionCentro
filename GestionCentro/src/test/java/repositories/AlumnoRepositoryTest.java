package repositories;

import models.Alumno;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoRepositoryTest {
    private final AlumnoRepository repository=new AlumnoRepository();

    private final Alumno alumno = new Alumno()
            .name("Dani")
            .dni("123456")
            .serNames("Apellido")
            .email("correo")
            .phone("123456")
            .hasLoseEvaluation(true);

    @BeforeEach
    void setUp(){
        repository.deleteAll();
    }

    @Test
    void findAllTest(){
        var lista1= repository.findAll();

        repository.save(alumno);
        var lista2= repository.findAll();

        assertAll(
                () -> assertEquals(lista1.size(), 0),
                () -> assertEquals(lista2.size(), 1),
                () -> assertTrue(lista2.contains(alumno)),
                () -> assertEquals(lista2.get(0).getId(), alumno.getId()),
                () -> assertEquals(lista2.get(0).getDni(), alumno.getDni()),
                () -> assertEquals(lista2.get(0).getName(), alumno.getName()),
                () -> assertEquals(lista2.get(0).getSerNames(), alumno.getSerNames()),
                () -> assertEquals(lista2.get(0).getEmail(), alumno.getEmail()),
                () -> assertEquals(lista2.get(0).getPhone(), alumno.getPhone()),
                () -> assertEquals(lista2.get(0).getRegistrationDate(), alumno.getRegistrationDate()),
                () -> assertEquals(lista2.get(0).isHasLoseEvaluation(), alumno.isHasLoseEvaluation())

        );
    }

    @Test
    void findByDniTest(){
        repository.save(alumno);
        Optional<Alumno> alumnoEncontrado = repository.findByDni(alumno.getDni());
        assertAll(
                ()-> assertEquals(alumnoEncontrado.get().getId(), alumno.getId()),
                ()-> assertEquals(alumnoEncontrado.get().getName(), alumno.getName()),
                ()->assertEquals(alumnoEncontrado.get().getSerNames(), alumno.getSerNames()),
                ()->assertEquals(alumnoEncontrado.get().getDni(), alumno.getDni()),
                ()->assertEquals(alumnoEncontrado.get().getEmail(), alumno.getEmail()),
                ()->assertEquals(alumnoEncontrado.get().getPhone(), alumno.getPhone()),
                ()->assertEquals(alumnoEncontrado.get().getRegistrationDate(), alumno.getRegistrationDate()),
                ()->assertEquals(alumnoEncontrado.get().isHasLoseEvaluation(), alumno.isHasLoseEvaluation())
        );
    }

    @Test
    void saveTest(){
        var aux= repository.save(alumno);
        Optional<Alumno> alumnoEncontrado = repository.findById(alumno.getId());
        assertAll(
                ()->assertEquals(aux.getId(),alumno.getId()),
                ()->assertEquals(aux.getDni(),alumno.getDni()),
                ()->assertEquals(aux.getName(),alumno.getName()),
                ()->assertEquals(aux.getSerNames(),alumno.getSerNames()),
                ()->assertEquals(aux.getEmail(),alumno.getEmail()),
                ()->assertEquals(aux.getPhone(),alumno.getPhone()),
                ()->assertEquals(aux.getRegistrationDate(),alumno.getRegistrationDate()),
                ()->assertEquals(alumno.getDni(),alumnoEncontrado.get().getDni()),
                ()->assertTrue(alumnoEncontrado.isPresent())
        );
    }

    @Test
    void updateTest(){
        repository.save(alumno);
        alumno.setDni("1234");
        alumno.setName("Manolo");
        alumno.setSerNames("Nuevo");
        alumno.setEmail("nuevocorreo");
        alumno.setPhone("45678");
        alumno.setHasLoseEvaluation(false);

        var aux = repository.update(alumno.getId(),alumno);

        Optional<Alumno> alumnoEncontrado= repository.findById(alumno.getId());

        assertAll(
                ()->assertEquals(aux.getId(),alumno.getId()),
                ()->assertEquals(aux.getDni(),alumno.getDni()),
                ()->assertEquals(aux.getName(),alumno.getName()),
                ()->assertEquals(aux.getSerNames(),alumno.getSerNames()),
                ()->assertEquals(aux.getEmail(),alumno.getEmail()),
                ()->assertEquals(aux.getPhone(),alumno.getPhone()),
                ()->assertEquals(aux.getRegistrationDate(),alumno.getRegistrationDate()),
                ()->assertTrue(alumnoEncontrado.isPresent())
        );
    }

    @Test
    void deleteTest(){
        repository.save(alumno);
        var aux= repository.delete(alumno.getId());

//        Optional<Alumno> alumnoEncontrado= repository.findById(alumno.getId()); TODO MIRAR BIEN ESTE TEST

        assertAll(
                ()->assertEquals(aux.getId(),alumno.getId()),
                ()->assertEquals(aux.getDni(),alumno.getDni()),
                ()->assertEquals(aux.getName(),alumno.getName()),
                ()->assertEquals(aux.getSerNames(),alumno.getSerNames()),
                ()->assertEquals(aux.getEmail(),alumno.getEmail()),
                ()->assertEquals(aux.getPhone(),alumno.getPhone()),
                ()->assertEquals(aux.getRegistrationDate(),alumno.getRegistrationDate())
        );

    }


}