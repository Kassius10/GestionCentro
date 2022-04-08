package repositoriesTests;

import controllers.DataBaseManager;
import models.Categories;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.CategoryRepository;
import utilities.DataBase;
import utilities.DataDB;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest {

        CategoryRepository categoryRepository = CategoryRepository.getInstance(DataBaseManager.getInstance());

        Categories category = new Categories("Examen_01_2021");

    @BeforeAll
    static void setUpAll(){
        DataBase.init();
    }

    @BeforeEach
    void setUp() throws SQLException {
        DataBase.deleteAll();
        DataDB.insertCategory(category);
    }




    /**
     * @Test para mostrar todas las categorías del repositorio
     */
        @Test
        void findAll() throws SQLException {
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
        void save() throws SQLException {

                Categories secondCategory = new Categories("Práctica_02_Dam");

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
        void update() throws SQLException {

        category.setName("Examen_05_DAM");
                var result = categoryRepository.updated( "Examen05_DAM", category);

                Optional<Categories> categoriesFound = categoryRepository.findByName("Examen_05_DAM");


                     assertEquals(categoriesFound.get().getName(), category.getName());


    }

    /**
     * @Test encontrar una categoria por el nombre
     */
    @Test
    void findByName() throws SQLException {

        var result = categoryRepository.findByName(category.getName());


        assertAll(
                () -> assertEquals(result.get().getName(), category.getName()),
                () -> assertTrue(result.get().getName().equals(category.getName()))
        );

    }





}
