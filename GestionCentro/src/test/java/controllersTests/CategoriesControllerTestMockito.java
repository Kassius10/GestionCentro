package controllersTests;

import controllers.CategoriesController;
import exceptions.CategoriesException;
import models.Categories;
import models.Exam;
import models.Exercise;
import models.Practice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Isolated;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import repositories.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
    @Isolated

public class CategoriesControllerTestMockito {

   @Mock
    CategoryRepository categoryRepository;

   @InjectMocks
   CategoriesController categoriesController;

    //Distintas Categorías de Prueba
    Categories cat1 = new Exam("Examen_01_DAM");
    Categories cat2 = new Exercise("Ejercicio_02_DAM");
    Categories cat3 = new Practice("Práctica_03_DAM");


    @Test
    void checkIsOk()  {
        var result = assertThrows(CategoriesException.class, () -> categoriesController.checkIsOk(new Categories("")));
        assertEquals("No es posible introducir el nombre de esta categoría el espacio está vacío", result.getMessage());

    }

    @Test
    void save() throws CategoriesException{



        assertAll(
                () -> assertEquals(result.getName(), secondCategory.getName()),
                () -> assertEquals(founded.getName(), result.getName())

        );
    }




}
