package models;

import exceptions.AlumnoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalificacionTest {
    Calificacion calificacion;

    @BeforeEach
    public void setUp() {
        calificacion = new Calificacion(
                new Alumno("12345678a",
                        "pepe",
                        "lopez sanchez",
                        "alumno@gmail.com",
                        "666-666666",
                        true,
                        true),
                8.45
        );
    }

    @Test
    void getStudentTest() {
        assertEquals("pepe", calificacion.getStudent().getName());
    }

    @Test
    void getDeliveryDateTest() {
        var day = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
        assertTrue(calificacion.getDeliveryDate().contains(day));
    }

    @Test
    void getQualification() {
        assertEquals(8.45, calificacion.getQualification());
    }

    @Test
    void setStudentTest() throws AlumnoException {
        calificacion.setStudent(new Alumno().name("marcos"));
        assertEquals("marcos", calificacion.getStudent().getName());
    }

    @Test
    void setQualification() {
        calificacion.setQualification(10);
        assertEquals(10, calificacion.getQualification());
        calificacion.setQualification(0.00);
        assertEquals(0.00, calificacion.getQualification());
        calificacion.setQualification(9.9);
        assertEquals(9.9, calificacion.getQualification());
    }

    @Test
    void studentTest() throws AlumnoException {
        var c = calificacion.student(new Alumno().name("juan"));
        assertEquals("juan", c.getStudent().getName());
    }

    @Test
    void qualificationTest() {
        var c = calificacion.qualification(0.00);
        assertEquals(0.00, c.getQualification());
        c = calificacion.qualification(10);
        assertEquals(10, c.getQualification());
        c = calificacion.qualification(4.2);
        assertEquals(4.2, c.getQualification());
    }

    @Test
    void toStringTest() {
        var day = LocalDateTime.now().getDayOfMonth();
        assertTrue(calificacion.toString().contains("pepe"));
        assertTrue(calificacion.toString().contains("8.45"));

    }

}