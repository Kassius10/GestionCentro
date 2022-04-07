package views;

import utils.Patterns;

/**
 * Clase interfaz del programa.
 */
public class MainView {
    public MainView() {
    }

    /**
     * Procedimiento de menu para gestionar.
     */
    public static void menu() {
        int option;
        do {
            System.out.println("1- Gestionar Alumnos\n" +
                    "2- Gestionar Categorías\n" +
                    "3- Gestionar Evaluación\n" +
                    "4- Importar datos\n" +
                    "5- Exportar datos\n" +
                    "0- Salir");

            option = Patterns.setOption(0, 5);

            switch (option) {
                case 1:
                    alumnoView();
                    break;

                case 2:
                    categoriesView();
                    break;

                case 3:
                    pruebaView();
                    break;
                case 4:
                    System.out.println("Aun falta");
                    break;
                case 5:
                    System.out.println("exportar");
                    break;

                case 0:
                    System.out.println("Saliendo...");


                default:
                    System.out.println("Error.");
                    break;
            }
        } while (option != 0);
        System.out.println("Vuelva pronto");

    }

    /**
     * Procedimiento para iniciar la view de alumno.
     */
    private static void alumnoView() {
        AlumnoView view = AlumnoView.getInstance();
        view.init();
    }

    /**
     * Procedimiento para iniciar la view de pruebas
     */
    private static void pruebaView() {
        EvaluationView view = EvaluationView.getInstance();
        view.init();
    }

    /**
     * Procedimiento para iniciar la view de categorías
     */
    private static void categoriesView() {
        CategoriesView view = CategoriesView.getInstance();
        view.init();
    }
}
