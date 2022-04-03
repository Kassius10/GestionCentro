package controllersTests;

import controllers.CategoriesController;
import exceptions.CategoriesException;
import models.Categories;
import models.Exam;
import models.Exercise;
import models.Practice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;

class CategoriesControllerTests {


    CategoryRepository catRepo = new CategoryRepository();
    Categories cat1 = new Exam("Examen_01_DAM");
    Categories cat2 = new Exercise("Ejercicio_02_DAM");
    Categories cat3 = new Practice("Práctica_03_DAM");

    CategoriesController categoriesController = CategoriesController.getInstance(catRepo);


    @BeforeEach
    void setUp() {
        catRepo.save(cat1);
        catRepo.save(cat2);
        catRepo.save(cat3);
    }


    @Test
    void checkIsOk() {

        var result = assertThrows(CategoriesException.class, () -> categoriesController.checkIsOk(new Categories("")));
        assertEquals("No es posible introducir el nombre de esta categoría el espacio está vacío", result.getMessage());

    }

    @Test
    void save() throws CategoriesException{

        Categories secondCategory = new Practice("Práctica_02_Dam");

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
        var toUpdateCategory = categoriesController.updateCategory(cat1);
        var toCompare = categoriesController.getCategoryByName(cat1.getName());

        assertAll(
                () -> assertEquals(toUpdateCategory.getName(), toCompare.getName())

        );
    }



}
