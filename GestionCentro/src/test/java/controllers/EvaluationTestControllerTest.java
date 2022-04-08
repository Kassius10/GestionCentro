package controllers;

import exceptions.CategoriesException;
import exceptions.PruebaException;
import models.Categoria;
import models.PruebaEvaluacion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.CalificacionRepository;
import repositories.pruebas.IPruebaRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//TODO HAY UN PROBLEMA CON LAS BUSQUEDAS YA QUE NO ES UNICO
@ExtendWith(MockitoExtension.class)
class EvaluationTestControllerTest {
    private final PruebaEvaluacion prueba = new PruebaEvaluacion(
            "descripcion",
            new Categoria("examen"),
            new CalificacionRepository()
    );

    @Mock
    private IPruebaRepository repository;
    @InjectMocks
    private EvaluationTestController controller;

    @Test
    void getAllEvaluationTest() {
        when(repository.findAll()).thenReturn(List.of(prueba));
        var lista = controller.getAllEvaluationTest();

        assertAll(
                () -> assertEquals(lista.size(), 1),
                () -> assertTrue(lista.contains(prueba)),
                () -> assertEquals(lista.get(0).getCategory(), prueba.getCategory()),
                () -> assertEquals(lista.get(0).getDescription(), prueba.getDescription()),
                () -> assertEquals(lista.get(0).getQualifications(), prueba.getQualifications())

        );
        verify(repository, times(1)).findAll();
    }

    @Test
    void createEvaluationTest() throws PruebaException {
        when(repository.save(prueba)).thenReturn(Optional.of(prueba));

        var aux = controller.createEvaluationTest(prueba);

        assertAll(
                () -> assertEquals(aux.getCategory(), prueba.getCategory()),
                () -> assertEquals(aux.getQualifications(), prueba.getQualifications()),
                () -> assertEquals(aux.getDescription(), prueba.getDescription()),
                () -> assertEquals(aux.getEvaluationDate(), prueba.getEvaluationDate())
        );

        verify(repository, times(1)).save(prueba);
    }

    @Test
    void deleteEvaluationTestByCategoryTest() throws PruebaException, CategoriesException {
        when(repository.findById(prueba.getCategory())).thenReturn(Optional.of(prueba));
        when(repository.delete(prueba.getCategory())).thenReturn(Optional.of(prueba));

        var aux = controller.deleteEvaluationTestByCategory(prueba.getCategory());

        assertAll(
                () -> assertEquals(aux.getCategory(), prueba.getCategory()),
                () -> assertEquals(aux.getQualifications(), prueba.getQualifications()),
                () -> assertEquals(aux.getDescription(), prueba.getDescription()),
                () -> assertEquals(aux.getEvaluationDate(), prueba.getEvaluationDate())
        );

        verify(repository, times(1)).findById(prueba.getCategory());
        verify(repository, times(1)).delete(prueba.getCategory());
    }

    @Test
    void deleteEvaluationTest() throws PruebaException, CategoriesException {
        when(repository.findById(prueba.getCategory())).thenReturn(Optional.of(prueba));
        when(repository.deleteByPrueba(prueba)).thenReturn(Optional.of(prueba));

        var aux = controller.deleteEvaluationTest(prueba);

        assertAll(
                () -> assertEquals(aux.getCategory(), prueba.getCategory()),
                () -> assertEquals(aux.getQualifications(), prueba.getQualifications()),
                () -> assertEquals(aux.getDescription(), prueba.getDescription()),
                () -> assertEquals(aux.getEvaluationDate(), prueba.getEvaluationDate())
        );
        verify(repository, times(1)).findById(prueba.getCategory());
        verify(repository, times(1)).deleteByPrueba(prueba);
    }

    @Test
    void findByCategory() throws PruebaException {
        when(repository.findByCategory(prueba.getCategory())).thenReturn(List.of(prueba));
        var lista = controller.findByCategory(prueba.getCategory());

        assertAll(
                () -> assertTrue(lista.contains(prueba)),
                () -> assertEquals(lista.get(0).getCategory(), prueba.getCategory())
        );
        verify(repository, times(1)).findByCategory(prueba.getCategory());
    }
}