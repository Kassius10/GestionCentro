package views;

import comparators.CategoriesComparator;
import controllers.CategoriesController;
import exceptions.CategoriesException;
import models.Categories;
import repositories.CategoryRepository;
import utils.Input;

import java.util.List;
import java.util.Scanner;

public class CategoriesView {
    private static CategoriesView instance;
    private final CategoriesController categoriesController = CategoriesController.getInstance(new CategoryRepository());


    /**
     * Constructor creado de forma privada de CategoriesView
     */
    private CategoriesView() {
        loadData();
        init();
    }


    /**
     * Método para crear la instancia de nuestra vista
     *
     * @return devolvemos la instancia
     */
    public static CategoriesView getInstance() {
        if (instance == null) {
            instance = new CategoriesView();
        }
        return instance;
    }

    /**
     * Inyección de Datos variados
     */
    private void loadData() {
        try {
            categoriesController.save(new Categories("PRACTICA_03_DAM"));
            categoriesController.save(new Categories("EXAMEN_01_DAM"));
            categoriesController.save(new Categories("EXPOSICIÓN_06_DAM"));
            categoriesController.save(new Categories("EJERCICIO_04_DAM"));

        } catch (CategoriesException e) {
            e.printStackTrace();
        }
    }


    /**
     * Método que inicia el menú de la vista
     */
    private void init() {
        categoryMenu();

    }


    private void categoryMenu() {

        int option;

        do {
            System.out.println("-1- Añadir una Nueva Categoría \n"
                    + "-2- Modificar una Categoría\n"
                    + "-3- Consultar las Categorías Existentes\n"
                    + "-0- Salir");
            option = getOption();

            switch (option) {
                case 1:
                    addNewCategory();
                    break;
                case 2:
                    modifyCategory();
                    break;
                case 3:
                    getAllCategories();
                    break;
                default:
                    System.out.println(":D");
                    break;
            }

        } while (option != 0);

    }


    /**
     * Método el cual nos muestra todas las categorías existentes
     */
    private void getAllCategories() {
        List<Categories> categories = categoriesController.getAllCategories();

        categories.sort(new CategoriesComparator());

        System.out.println("Categorías Existentes \n");

        for (Categories category : categories) {
            System.out.println(category);
        }
        System.out.println();
        System.out.println("Existen " + categories.size() + " categorías");

    }


    /**
     * Método con el cual modificamos una categoría existente
     */
    private void modifyCategory() {
        System.out.println("Modificar Categoría Existente");

        getAllCategories();

        var category = Input.readStringUppercase("Indica el nombre de la categoría que desea modificar\n" + "\t Formato a introducir: Nombre_Número[NN]_CURSO(Iniciales)");


        try {
            var isThere = categoriesController.getCategoryByName(categoryItsOk(category));

            String newName = Input.readStringUppercase("Introduce el nuevo nombre de la categoría" + "(Anterior: " + isThere.getName() + ")");
            if (newName.isEmpty()) {
                System.out.println("Nombre no actualizado");
            } else {
                var categoryUptaded = categoriesController.updateCategory(newName, isThere);
                System.out.println();
                System.out.println(categoryUptaded);
                System.out.println("\t" + "Categoría Actualizada a: " + newName);

            }

        } catch (CategoriesException e) {
            System.out.println("Error al intentar modificar la categoría. " + e.getMessage());
        }

    }


    /**
     * Método con el cual podemos añadir una nueva categoría al programa
     */
    private void addNewCategory() {
        System.out.println("\nAñadiendo Categoría......");

        String name = Input.readStringUppercase("Introduce el nombre de la categoría\n" + "\t Formato a introducir: Nombre_Número[NN]_CURSO(Iniciales)");



        System.out.println("\nIntroduciendo la nueva categoría en el sistema");
        Categories newCategory = new Categories(categoryItsOk(name));
        try {
            var categoryCreated = categoriesController.save(newCategory);
            System.out.println("\t" + categoryCreated);
            System.out.println();
        } catch (CategoriesException e) {
            System.out.println("Error al añadir la categoría. " + e.getMessage());
        }

    }


    /**
     * Función que nos revisa la cadena de la opcion establecida y comprueba sí cuadra con la
     * requerida o no
     *
     * @return Devolvemos la opción elegida.
     */
    private static int getOption() {
        var regex = "[0-3]";
        String option;
        var ok = false;
        do {
            option = Input.readString("Dime la opción a elegír: ");
            if (option.matches(regex)) {
                System.out.println("Opción correcta");
                ok = true;
            } else {
                System.err.println("No existe esta opción en el sistema ");
            }
        } while (!ok);

        return Integer.parseInt(option);

    }

    /**
     * Función que aplica un formato determinado a una cadena
     *
     * @param name Nombre de la categoría a comprobar
     * @return Verdadero si la cadena supera la expresión regular.
     */
    private static String categoryItsOk(String name) {
        var regex = "^[a-zA-Z]{1,11}[_][\\d]{1,2}[_][a-zA-Z]{2,5}";
        while (!name.matches(regex)) {
            name = Input.readStringUppercase("Formato a introducir: Nombre_Número[NN]_CURSO(Iniciales)");
        }
        return name;
    }
}