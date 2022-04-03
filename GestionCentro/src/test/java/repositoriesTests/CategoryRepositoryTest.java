package repositoriesTests;

import models.Categories;
import models.Exam;
import models.Practice;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest {

        CategoryRepository categoryRepository = new CategoryRepository();

        Categories category = new Exam("Examen_01_2021");

    /**
     * Configuracion para que cada vez que haga el test pcomo minimo guarde 1 dato presentado
     */
    @BeforeEach
        void setUp(){
            categoryRepository.save(category);
        }




    /**
     * @Test para mostrar todas las categorías del repositorio
     */
        @Test
        void findAll(){
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
        void save(){

                Categories secondCategory = new Practice("Práctica_02_Dam");

                var result = categoryRepository.save(secondCategory);
                var founded = categoryRepository.findByName(secondCategory.getName());

            assertAll(
                    () -> assertEquals(result.getName(), secondCategory.getName()),
                    () -> assertEquals(founded.getName(), result.getName())

            );
        }


    /**
     * @Test para actualizar el nombre de una categoría
     */
    @Test
        void update(){
            category.setName("Examen_02_2022");
            //Actualizamos el nombre de la categoría
                var result = categoryRepository.updated(category);

            assertAll(
                    () -> assertEquals(result.getName(), category.getName())
            );

    }

    /**
     * @Test encontrar una categoria por el nombre
     */
    @Test
    void findByName(){

        var result = categoryRepository.findByName(category.getName());


        assertAll(
                () -> assertEquals(result.getName(), category.getName()),
                () -> assertTrue(result.toString().equals(category.toString()))
        );

    }





}
