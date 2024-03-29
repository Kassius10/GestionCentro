package controllers;

import exceptions.CategoriesException;
import models.Categoria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Isolated;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.categorias.CategoryRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Isolated

public class CategoriaControllerTestMockito {

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoriesController categoriesController;

    //Distintas Categorías de Prueba
    Categoria cat1 = new Categoria("Examen_01_DAM");
    Categoria cat2 = new Categoria("Ejercicio_02_DAM");
    Categoria cat3 = new Categoria("Práctica_03_DAM");


    @Test
    void checkIsOk() {
        var result = assertThrows(CategoriesException.class, () -> categoriesController.checkIsOk(new Categoria("")));
        assertEquals("No es posible introducir el nombre de esta categoría el espacio está vacío", result.getMessage());

    }

    @Test
    void save() throws CategoriesException {
        when(categoryRepository.findByName(cat1.getName())).thenReturn(Optional.empty());
        when(categoryRepository.save(cat1)).thenReturn(Optional.of(cat1));

        var catAux = categoriesController.save(cat1);

        assertAll(

                () -> assertEquals(catAux.getName(), cat1.getName()),
                () -> assertNotEquals(catAux.getName(), cat2.getName())

        );

        verify(categoryRepository, times(1)).findByName(cat1.getName());
        verify(categoryRepository, times(1)).save(cat1);
    }


    @Test
    void saveExceptionTest() {

        when(categoryRepository.findByName(cat1.getName())).thenReturn(Optional.of(cat1));

        Exception exceptionToTrow =

                assertThrows(CategoriesException.class, () -> categoriesController.save(cat1));

        assertTrue(exceptionToTrow.getMessage().contains("Está categoría ya se encuentra dentro del sistema"));

        verify(categoryRepository, times(1)).findByName(cat1.getName());
    }


    @Test
    void getCategoryByName() throws CategoriesException {
        when(categoryRepository.findByName(cat1.getName())).thenReturn(Optional.of(cat1));

        var catAux = categoriesController.getCategoryByName(cat1.getName());

        assertAll(
                () -> assertEquals(catAux.getName(), cat1.getName()),
                () -> assertNotEquals(catAux.getName(), cat2.getName())
        );

        verify(categoryRepository, times(1)).findByName(cat1.getName());

    }


    @Test
    void getCategoryByNameExceptionTest() {
        when(categoryRepository.findByName(anyString())).thenReturn(Optional.empty());

        Exception exceptionToTrow =

                assertThrows(CategoriesException.class, () -> categoriesController.getCategoryByName(anyString()));

        assertTrue(exceptionToTrow.getMessage().contains("No existe esta categoría en la lista"));


        verify(categoryRepository, times(1)).findByName(anyString());

    }


    @Test
    void getAllCategories() {
        when(categoryRepository.findAll()).thenReturn(List.of(cat1));


        var list = categoriesController.getAllCategories();


        assertAll(
                () -> assertEquals(list.size(), 1),
                () -> assertTrue(list.contains(cat1))

        );

    }

    @Test
    void updateCategory() throws CategoriesException {
        when(categoryRepository.findByName(cat1.getName())).thenReturn(Optional.empty());
        when(categoryRepository.updated("Examen_03_DAM", cat1)).thenReturn(Optional.of(cat1));

        var catAux = categoriesController.updateCategory("Examen_03_DAM", cat1);

        assertAll(
                () -> assertEquals(catAux.getName(), cat1.getName())
                //....
        );


        verify(categoryRepository, times(1)).findByName(cat1.getName());
        verify(categoryRepository, times(1)).updated("Examen_03_DAM", cat1);
    }

//    @Test
//    void updateCategoryExceptionTest()  {
//        Categories newCat= new Categories("Exam_02_DAM");
//        newCat.setName("Examen_03_DAM");
//        when(categoryRepository.findByName(cat1.getName())).thenReturn(Optional.of(cat1));
//
//
//
//            CategoriesException exceptionToTrow =
//
//                    assertThrows(CategoriesException.class,()-> categoriesController.updateCategory("Examen_05_DAM",newCat));
//
//                    assertTrue(exceptionToTrow.getMessage().contains("No se puede actualizar una categoría inexistente"));
//
//
//
//        verify(categoryRepository, times(1)).findByName(cat1.getName());
//
//    }


}
