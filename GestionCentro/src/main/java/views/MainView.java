package views;

import controllers.BackUpController;
import repositories.alumnos.AlumnoRepository;
import repositories.categorias.CategoryRepository;
import repositories.pruebas.PruebaRepository;
import services.BackUpStoragesJsonFile;
import utils.Patterns;

/**
 * Clase interfaz del programa.
 */
public class MainView {
    private static final BackUpController backupManager = new BackUpController(
            AlumnoRepository.getInstance(),
            BackUpStoragesJsonFile.getInstance(),
            CategoryRepository.getInstance(),
            PruebaRepository.getInstance());

    public MainView() {
        AlumnoView view = AlumnoView.getInstance();
        CategoriesView viewCat = CategoriesView.getInstance();
        EvaluationView viewEv = EvaluationView.getInstance();
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
                    importarDatos();
                    break;
                case 5:
                    exportarDatos();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;


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

    private static void importarDatos() {
        try {
            backupManager.importarDatos();
        } catch (Exception e) {
            System.out.println("Error al exportar datos: " + e.getMessage());
        }

    }

    private static void exportarDatos() {
        try {
            backupManager.exportarDatos();
        } catch (Exception e) {
            System.err.println("Error al exportar datos: " + e.getMessage());


        }
    }
}
