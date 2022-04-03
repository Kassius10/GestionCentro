package controllers;

import exceptions.AlumnoException;
import models.Alumno;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.AlumnoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlumnoControllerTest {
    @Mock
    private AlumnoRepository repository;

    @InjectMocks
    private AlumnoController controller;

    private final Alumno alumno = new Alumno(
            "12345678a",
            "dani",
            "lopez sanchez",
            "d@d.com",
            "666-666666",
            true
    );

    @Test
    void getAllAlumnos(){
        when(repository.findAll()).thenReturn(List.of(alumno));
        var lista1= controller.getAllAlumnos();

        assertAll(
                () -> assertEquals(lista1.size(), 1),
                () -> assertTrue(lista1.contains(alumno)),
                () -> assertEquals(lista1.get(0).getId(), alumno.getId()),
                () -> assertEquals(lista1.get(0).getDni(), alumno.getDni()),
                () -> assertEquals(lista1.get(0).getName(), alumno.getName()),
                () -> assertEquals(lista1.get(0).getSurNames(), alumno.getSurNames()),
                () -> assertEquals(lista1.get(0).getEmail(), alumno.getEmail()),
                () -> assertEquals(lista1.get(0).getPhone(), alumno.getPhone()),
                () -> assertEquals(lista1.get(0).getRegistrationDate(), alumno.getRegistrationDate()),
                () -> assertEquals(lista1.get(0).isHasLoseEvaluation(), alumno.isHasLoseEvaluation())

        );

        verify(repository,times(1)).findAll();

    }

    @Test
    void getAlumnByDniTest() throws AlumnoException {
        when(repository.findByDni(alumno.getDni())).thenReturn(Optional.of(alumno));

        var aux = controller.getAlumnByDni(alumno.getDni());

        assertAll(
                ()->assertEquals(aux.getDni(), alumno.getDni()),
                ()->assertEquals(aux.getName(), alumno.getName()),
                ()->assertEquals(aux.getSurNames(), alumno.getSurNames()),
                ()->assertEquals(aux.getEmail(), alumno.getEmail()),
                ()->assertEquals(aux.getPhone(), alumno.getPhone()),
                ()->assertEquals(aux.getRegistrationDate(), alumno.getRegistrationDate()),
                ()->assertEquals(aux.isHasLoseEvaluation(), alumno.isHasLoseEvaluation())
        );

        verify(repository,times(1)).findByDni(alumno.getDni());

    }

    @Test
    void getAlumnByDniExceptionTest(){
        when(repository.findByDni(anyString())).thenReturn(Optional.empty());

        Exception thrown= assertThrows(AlumnoException.class,()-> controller.getAlumnByDni(anyString()));
        assertTrue(thrown.getMessage().contains("No existe un alumno con dni"));

        verify(repository, times(1)).findByDni(anyString());
    }

    @Test
    void insertAlumnoTest() throws AlumnoException {
        when(repository.findByDni(alumno.getDni())).thenReturn(Optional.empty());
        when(repository.save(alumno)).thenReturn(Optional.of(alumno));

        var aux = controller.insertAlumno(alumno);

        assertAll(
                ()->assertEquals(aux.getDni(), alumno.getDni()),
                ()->assertEquals(aux.getName(), alumno.getName()),
                ()->assertEquals(aux.getSurNames(), alumno.getSurNames()),
                ()->assertEquals(aux.getEmail(), alumno.getEmail()),
                ()->assertEquals(aux.getPhone(), alumno.getPhone()),
                ()->assertEquals(aux.getRegistrationDate(), alumno.getRegistrationDate()),
                ()->assertEquals(aux.isHasLoseEvaluation(), alumno.isHasLoseEvaluation())
        );

        verify(repository,times(1)).findByDni(alumno.getDni());
        verify(repository,times(1)).save(alumno);
    }

    @Test
    void insertAlumnoExceptionTest(){
        when(repository.findByDni(alumno.getDni())).thenReturn(Optional.of(alumno));

        Exception thrown= assertThrows(AlumnoException.class,()-> controller.insertAlumno(alumno));
        assertTrue(thrown.getMessage().contains("Ya existe un alumno con dni"));

        verify(repository, times(1)).findByDni(alumno.getDni());

    }
    @Test
    void deleteAlumnoTest() throws AlumnoException {
        when(repository.findByDni(alumno.getDni())).thenReturn(Optional.of(alumno));
        when(repository.delete(alumno.getId())).thenReturn(Optional.of(alumno));

        var aux = controller.deletAlumno(alumno.getDni());

        assertAll(
                ()->assertEquals(aux.getDni(), alumno.getDni()),
                ()->assertEquals(aux.getName(), alumno.getName()),
                ()->assertEquals(aux.getSurNames(), alumno.getSurNames()),
                ()->assertEquals(aux.getEmail(), alumno.getEmail()),
                ()->assertEquals(aux.getPhone(), alumno.getPhone()),
                ()->assertEquals(aux.getRegistrationDate(), alumno.getRegistrationDate()),
                ()->assertEquals(aux.isHasLoseEvaluation(), alumno.isHasLoseEvaluation())
        );

        verify(repository,times(1)).findByDni(alumno.getDni());
        verify(repository,times(1)).delete(alumno.getId());
    }

    @Test
    void deleteAlumnoExceptionTest(){
        when(repository.findByDni(alumno.getDni())).thenReturn(Optional.empty());

        Exception thrown= assertThrows(AlumnoException.class,()-> controller.deletAlumno(alumno.getDni()));
        assertTrue(thrown.getMessage().contains("No existe el alumno con dni"));

        verify(repository, times(1)).findByDni(alumno.getDni());

    }

    @Test
    void updateAlumnoTest() throws AlumnoException {
        when(repository.findByDni(alumno.getDni())).thenReturn(Optional.empty());
        when(repository.update(alumno.getId(),alumno)).thenReturn(Optional.of(alumno));

        var aux = controller.updateAlumno(alumno.getId(),alumno);

        assertAll(
                ()->assertEquals(aux.getDni(), alumno.getDni()),
                ()->assertEquals(aux.getName(), alumno.getName()),
                ()->assertEquals(aux.getSurNames(), alumno.getSurNames()),
                ()->assertEquals(aux.getEmail(), alumno.getEmail()),
                ()->assertEquals(aux.getPhone(), alumno.getPhone()),
                ()->assertEquals(aux.getRegistrationDate(), alumno.getRegistrationDate()),
                ()->assertEquals(aux.isHasLoseEvaluation(), alumno.isHasLoseEvaluation())
        );

        verify(repository,times(1)).findByDni(alumno.getDni());
        verify(repository,times(1)).update(alumno.getId(),alumno);
    }

    @Test
    void updateAlumnoExistTest() throws AlumnoException {
        when(repository.findByDni(alumno.getDni())).thenReturn(Optional.of(alumno));
        when(repository.update(alumno.getId(),alumno)).thenReturn(Optional.of(alumno));

        var aux = controller.updateAlumno(alumno.getId(),alumno);

        assertAll(
                ()->assertEquals(aux.getDni(), alumno.getDni()),
                ()->assertEquals(aux.getName(), alumno.getName()),
                ()->assertEquals(aux.getSurNames(), alumno.getSurNames()),
                ()->assertEquals(aux.getEmail(), alumno.getEmail()),
                ()->assertEquals(aux.getPhone(), alumno.getPhone()),
                ()->assertEquals(aux.getRegistrationDate(), alumno.getRegistrationDate()),
                ()->assertEquals(aux.isHasLoseEvaluation(), alumno.isHasLoseEvaluation())
        );

        verify(repository,times(1)).findByDni(alumno.getDni());
        verify(repository,times(1)).update(alumno.getId(),alumno);
    }

    @Test
    void updateAlumnoExistsExceptionTest() throws AlumnoException {
        Alumno al = new Alumno();
        al.setDni("12345678a");
        when(repository.findByDni(alumno.getDni())).thenReturn(Optional.of(alumno));


        Exception thrown= assertThrows(AlumnoException.class,()-> controller.updateAlumno(al.getId(), al));
        assertTrue(thrown.getMessage().contains("Ya existe un alumno con dni"));

        verify(repository, times(1)).findByDni(al.getDni());

    }

}