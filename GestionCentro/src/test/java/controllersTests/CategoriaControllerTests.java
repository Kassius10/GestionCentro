package controllersTests;

import controllers.CategoriesController;
import exceptions.CategoriesException;
import models.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.categorias.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class CategoriaControllerTests {


    CategoryRepository catRepo = new CategoryRepository();
    Categoria cat1 = new Exam("Examen_01_DAM");
    Categoria cat2 = new Exercise("Ejercicio_02_DAM");
    Categoria cat3 = new Practice("Práctica_03_DAM");

    CategoriesController categoriesController = CategoriesController.getInstance(catRepo);


    @BeforeEach
    void setUp() {
        catRepo.save(cat1);
        catRepo.save(cat2);
        catRepo.save(cat3);
    }


    @Test
    void checkIsOk() {

        var result = assertThrows(CategoriesException.class, () -> categoriesController.checkIsOk(new Categoria("")));
        assertEquals("No es posible introducir el nombre de esta categoría el espacio está vacío", result.getMessage());

    }

    @Test
    void save() throws CategoriesException{

        Categoria secondCategory = new Practice("Práctica_04_Dam");

        var result = categoriesController.save(secondCategory);
        var founded = categoriesController.getCategoryByName(secondCategory.getName());

        assertAll(
                () -> assertEquals(result.getName(), secondCategory.getName()),
                () -> assertEquals(founded.getName(), result.getName())

        );
    }

    @Test
    void getCategoryByName() throws CategoriesException{

        var fakeResult = new Exercise("Ejercicio3_DAM");
        var result = categoriesController.getCategoryByName(cat1.getName());
        var result2 = categoriesController.getCategoryByName(cat2.getName());

        assertAll(
                () -> assertEquals(result.getName(), cat1.getName()),
                () -> assertNotEquals(result2.getName(), fakeResult.getName())
        );

    }


    @Test
    void getAllCategories(){
        var listCategories = categoriesController.getAllCategories();
        assertAll(
                () -> assertEquals(listCategories.size(), 3),
                () -> assertNotEquals(listCategories.size(), 8)
        );
    }


    @Test
    void updateCategory() throws CategoriesException{

        var toUpdateCategory = categoriesController.updateCategory(any(),cat1);
        var toCompare = categoriesController.getCategoryByName(cat1.getName());

        assertAll(
                () -> assertEquals(toUpdateCategory.getName(), toCompare.getName())

        );
    }



}
