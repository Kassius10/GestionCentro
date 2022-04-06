package models;

import exceptions.CategoriesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {
    Categoria category;

    @BeforeEach
    public void setUp() {
        category = new Categoria("test_01_dam");
    }

    @Test
    void getNameTest() {
        assertEquals("test_01_dam", category.getName());
    }

    @Test
    void setNameTest() throws CategoriesException {
        category.setName("test");
        assertEquals("test", category.getName());
    }

    @Test
    void setNameTestException() {
        CategoriesException thrown;
        thrown = assertThrows(CategoriesException.class, () -> {
            category.setName("1454562");
        });
        assertTrue(thrown.getMessage().contains("Formato introducido incorrecto"));
        thrown = assertThrows(CategoriesException.class, () -> {
            category.setName(" ");
        });
        assertTrue(thrown.getMessage().contains("Formato introducido incorrecto"));
        thrown = assertThrows(CategoriesException.class, () -> {
            category.setName("");
        });
        assertTrue(thrown.getMessage().contains("Formato introducido incorrecto"));
    }

    @Test
    void toStringTest() {
        var cadena = category.toString();
        assertTrue(cadena.contains(category.getName()));
    }
}