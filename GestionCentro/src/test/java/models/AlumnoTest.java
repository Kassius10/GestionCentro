package models;

import exceptions.AlumnoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {
    Alumno alumno;
    @BeforeEach
    public void setUp(){
        alumno= new Alumno(
                "12345678a",
                "pepe",
                "lopez sanchez",
                "alumno@gmail.com",
                "666-666666",
                true,
                true);
        alumno.id(1);
    }


    @Test
    void constructorTest(){
        assertAll(
                ()-> assertEquals("12345678a",alumno.getDni()),
                ()-> assertEquals("pepe",alumno.getName()),
                ()-> assertEquals("lopez sanchez",alumno.getSurNames()),
                ()-> assertEquals("alumno@gmail.com",alumno.getEmail()),
                ()-> assertEquals("666-666666",alumno.getPhone()),
                ()-> assertTrue(alumno.isHasLoseEvaluation())
        );
    }
    @Test
    void getIdTest(){
        assertEquals(1,alumno.getId());
    }
    @Test
    void getDniTest(){
        assertEquals("12345678a",alumno.getDni());
    }
    @Test
    void getNameTest(){
        assertEquals("pepe",alumno.getName());
    }
    @Test
    void getSurNamesTest(){
        assertEquals("lopez sanchez",alumno.getSurNames());
    }
    @Test
    void getEmailTest(){
        assertEquals("alumno@gmail.com",alumno.getEmail());
    }
    @Test
    void getPhoneTest(){
        assertEquals("666-666666",alumno.getPhone());
    }
    @Test
    void isHasLoseEvaluationTest(){
        assertTrue(alumno.isHasLoseEvaluation());
    }
    //TODO MIRAR ESTE TEST MEJOR
//    @Test
//    void getRegistrationDateTest(){
//        assertEquals(LocalDateTime.now().,alumno.getRegistrationDate());
//        System.out.println(alumno.getRegistrationDate());
//    }

    @Test
    void setDniTest() throws AlumnoException {
        alumno.setDni("87654321a");
        assertEquals("87654321a",alumno.getDni());
    }
    @Test
    void setDniTestException() throws AlumnoException {
        AlumnoException thrown;

        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setDni("87654321");
        });
        assertTrue(thrown.getMessage().contains("El dni es incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setDni("07654321a");
        });
        assertTrue(thrown.getMessage().contains("El dni es incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setDni(" ");
        });
        assertTrue(thrown.getMessage().contains("El dni es incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setDni("");
        });
        assertTrue(thrown.getMessage().contains("El dni es incorrecto"));

    }
    @Test
    void setNameTest() throws AlumnoException {
        alumno.setName("paco");
        assertEquals("paco",alumno.getName());
    }
    @Test
    void setNameTestException(){
        AlumnoException thrown;
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setName("12");
        });
        assertTrue(thrown.getMessage().contains("El nombre es incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setName(" ");
        });
        assertTrue(thrown.getMessage().contains("El nombre es incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setName("");
        });
        assertTrue(thrown.getMessage().contains("El nombre es incorrecto"));
    }
    @Test
    void setSurNamesTest() throws AlumnoException {
        alumno.setSurNames("campos rodriguez");
        assertEquals("campos rodriguez",alumno.getSurNames());
    }
    @Test
    void setSurNamesTestException(){
        AlumnoException thrown;
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setSurNames("12");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setSurNames("ca 45");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setSurNames(" ");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setSurNames("");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
    }
    @Test
    void setEmailTest() throws AlumnoException {
        alumno.setEmail("nuevo@nuevo.es");
        assertEquals("nuevo@nuevo.es",alumno.getEmail());
    }
    @Test
    void setEmailTestException(){
        AlumnoException thrown;
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setEmail("d.com");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setEmail("d@d.comp");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setEmail("d@@d.com");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setEmail("d@com");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setEmail("d@d..com");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
    }
    @Test
    void setPhoneTest() throws AlumnoException {
        alumno.setPhone("914-564587");
        assertEquals("914-564587",alumno.getPhone());
    }
    @Test
    void setPhoneTestException(){
        AlumnoException thrown;
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setPhone("000-000000");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setPhone("666666666");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setPhone("598-989789");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setPhone("999-9999999");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.setPhone("9-99999999");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
    }
    @Test
    void setHasLoseEvaluationTest(){
        alumno.setHasLoseEvaluation(false);
        assertFalse(alumno.isHasLoseEvaluation());
        alumno.setHasLoseEvaluation(true);
        assertTrue(alumno.isHasLoseEvaluation());
    }

    @Test
    void dniTest() throws AlumnoException {
        var al= alumno.dni("11111111a");
        assertEquals("11111111a",al.getDni());
    }

    @Test
    void dniExceptionTest(){
        AlumnoException thrown;

        thrown= assertThrows(AlumnoException.class,()->{
            alumno.dni("87654321");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.dni("07654321a");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.dni(" ");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.dni("");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
    }
    @Test
    void nameTest() throws AlumnoException {
        var al= alumno.name("nuria");
        assertEquals("nuria",al.getName());
    }
    @Test
    void nameTestException(){
        AlumnoException thrown;
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.name("12");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.name(" ");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.name("");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
    }
    @Test
    void surNamesTest() throws AlumnoException {
        var al= alumno.surNames("gonzalez margallo");
        assertEquals("gonzalez margallo",al.getSurNames());
    }
    @Test
    void surNamesTestException(){
        AlumnoException thrown;
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.surNames("12");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.surNames("ca 45");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.surNames(" ");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.surNames("");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
    }
    @Test
    void emailTest() throws AlumnoException {
        var al= alumno.email("d@d.com");
        assertEquals("d@d.com",al.getEmail());
    }
    @Test
    void emailTestException(){
        AlumnoException thrown;
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.email("d.com");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.email("d@d.comp");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.email("d@@d.com");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.email("d@com");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.email("d@d..com");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
    }
    @Test
    void phoneTest() throws AlumnoException {
        var al= alumno.phone("999-999999");
        assertEquals("999-999999",al.getPhone());
    }
    @Test
    void phoneTestException(){
        AlumnoException thrown;
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.phone("000-000000");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.phone("666666666");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.phone("598-989789");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.phone("999-9999999");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
        thrown= assertThrows(AlumnoException.class,()->{
            alumno.phone("9-99999999");
        });
        assertTrue(thrown.getMessage().contains("incorrecto"));
    }
    @Test
    void hasLoseEvaluationTest() {
        var al= alumno.hasLoseEvaluation(false);
        assertFalse(al.isHasLoseEvaluation());
        al= alumno.hasLoseEvaluation(true);
        assertTrue(al.isHasLoseEvaluation());
    }
    //TODO FALTA TESTEAR 5 METODOS HASHCODE, EQUALS, TOSTRING,CONSTRUCTOR SIN PARAMETROS,LOCALDATETIME.
}