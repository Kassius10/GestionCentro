package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.CalificacionRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PruebaEvaluacionTest {
    @Mock
    private CalificacionRepository repository;
    @InjectMocks
    private PruebaEvaluacion pruebaEvaluacion;

    @BeforeEach
    public void setUp() {
        pruebaEvaluacion = new PruebaEvaluacion()
                .description("descripcion")
                .category(new Categoria("test"))
                .qualifications(repository);
    }

    @Test
    void getEvaluationDateTest() {
        assertEquals(LocalDateTime.now().getDayOfMonth(), pruebaEvaluacion.getEvaluationDate().getDayOfMonth());
    }

    @Test
    void getDescriptionTest() {
        assertEquals("descripcion", pruebaEvaluacion.getDescription());
    }

    @Test
    void getQualificationsTest() {
        assertEquals(repository, pruebaEvaluacion.getQualifications());
    }

    @Test
    void getCategoryTest() {
        assertEquals("test", pruebaEvaluacion.getCategory().getName());
    }

    @Test
    void setDescriptionTest() {
        pruebaEvaluacion.setDescription("nuevo");
        assertEquals("nuevo", pruebaEvaluacion.getDescription());
    }

    @Test
    void setQualificationsTest() {
        pruebaEvaluacion.setQualifications(repository);
        assertEquals(repository, pruebaEvaluacion.getQualifications());
    }

    @Test
    void setCategoryTest() {
        pruebaEvaluacion.setCategory(new Categoria("prueba"));
        assertEquals("prueba", pruebaEvaluacion.getCategory().getName());
    }

    @Test
    void descriptionTest() {
        var prueba = pruebaEvaluacion.description("nuevo");
        assertEquals("nuevo", prueba.getDescription());
    }

    @Test
    void qualificationsTest() {
        var prueba = pruebaEvaluacion.qualifications(repository);
        assertEquals(repository, prueba.getQualifications());
    }

    @Test
    void categoryTest() {
        var prueba = pruebaEvaluacion.category(new Categoria("prueba"));
        assertEquals("prueba", prueba.getCategory().getName());
    }

    @Test
    void toStringTest() {
        var cadena = pruebaEvaluacion.toString();

        assertAll(
                () -> assertTrue(cadena.contains(pruebaEvaluacion.getDescription())),
                () -> assertTrue(cadena.contains(pruebaEvaluacion.getCategory().getName())),
                () -> assertTrue(cadena.contains(pruebaEvaluacion.getEvaluationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))))
        );
    }
}