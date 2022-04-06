package repositories;

import exceptions.CategoriesException;
import models.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.categorias.CategoryRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest {

    CategoryRepository categoryRepository = new CategoryRepository();

    Categoria category = new Categoria("Examen");

    /**
     * Configuracion para que cada vez que haga el test pcomo minimo guarde 1 dato presentado
     */
    @BeforeEach
    void setUp() {
        categoryRepository.save(category);
    }


    /**
     * @Test para mostrar todas las categorías del repositorio
     */
    @Test
    void findAll() {
        var res = categoryRepository.findAll();

        assertAll(
                () -> assertEquals(res.size(), 1),
                () -> assertNotEquals(res.size(), 5),
                () -> assertTrue(res.contains(category)),
                () -> assertEquals(res.get(0).getName(), category.getName())
        );
    }


    /**
     * @Test para crear una nueva categoría
     */
    @Test
    void save() {

        Categoria secondCategory = new Categoria("Practica");

        var result = categoryRepository.save(secondCategory);
        var founded = categoryRepository.findByName(secondCategory.getName());

        assertAll(
                () -> assertEquals(result.get().getName(), secondCategory.getName()),
                () -> assertEquals(founded.get().getName(), result.get().getName())

        );
    }


    /**
     * @Test para actualizar el nombre de una categoría
     */
    @Test
    void update() throws CategoriesException {

        var name = category.getName();
        category.setName("Prueba");
        var result = categoryRepository.updated(name, category);

        Optional<Categoria> categoriesFound = categoryRepository.findByName("Prueba");

        assertEquals(categoriesFound.get().getName(), category.getName());


    }

    /**
     * @Test encontrar una categoria por el nombre
     */
    @Test
    void findByName() {

        var result = categoryRepository.findByName(category.getName());


        assertAll(
                () -> assertEquals(result.get().getName(), category.getName()),
                () -> assertTrue(result.get().getName().equals(category.getName()))
        );

    }

}
