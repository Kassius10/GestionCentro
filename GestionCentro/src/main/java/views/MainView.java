package views;

<<<<<<< HEAD

import controllers.BackUpController;
import controllers.DataBaseManager;
import repositories.AlumnoRepository;
import repositories.CategoryRepository;
import services.BackUpStoragesJsonFile;
import utils.Input;
=======
import controllers.BackUpController;
import repositories.alumnos.AlumnoRepository;
import repositories.categorias.CategoryRepository;
import repositories.pruebas.PruebaRepository;
import services.BackUpStoragesJsonFile;
import utils.Patterns;
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

import java.sql.SQLException;
import java.util.Locale;

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

  private static final BackUpController backupManager = new BackUpController(
                    AlumnoRepository.getInstance(DataBaseManager.getInstance()),
                    BackUpStoragesJsonFile.getInstance(),
                    CategoryRepository.getInstance(DataBaseManager.getInstance()));


    /**
     * Procedimiento de menu para gestionar.
     */
<<<<<<< HEAD
    public  void menu() throws SQLException {
=======
    public static void menu() {
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
        int option;
        do {
            System.out.println("\n1- Gestionar Alumnos\n" +
                    "2- Gestionar Categorías\n" +
                    "3- Gestionar Evaluación\n" +
                    "4- Importar datos\n" +
                    "5- Exportar datos\n" +
                    "0- Salir");

            option = Patterns.setOption(0, 5);

<<<<<<< HEAD


            switch(option){
                case 1:
                    menuAlumnos();
=======
            switch (option) {
                case 1:
                    alumnoView();
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
                    break;

                case 2:
<<<<<<< HEAD
                    menuCategorias();
                    break;
                case 3:
                    importarExportar();
=======
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
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
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

    /**
     * Procedimiento para importar los datos.
     */
    private static void importarDatos() {
        System.out.println();
        try {
            backupManager.importarDatos();
        } catch (Exception e) {
            System.out.println("Error al exportar datos: " + e.getMessage());
        }

    }

    /**
     * Procedimiento para exportar los datos.
     */
    private static void exportarDatos() {
        System.out.println();
        try {
            backupManager.exportarDatos();
        } catch (Exception e) {
            System.err.println("Error al exportar datos: " + e.getMessage());


        }
    }

    private static void menuAlumnos() throws SQLException {

        AlumnoView view = AlumnoView.getInstance();
    }


    private static void menuCategorias() {

        CategoriesView view = CategoriesView.getInstance();

    }

    private static void importarExportar() {
        System.out.println("Eliga una Opción a Realizar");
        var regex = "importar|exportar";
        var opcion = "";
        do {
            opcion = Input.readString("Importar/Exportar datos: ").toLowerCase(Locale.getDefault());
            if (!opcion.matches(regex)) {
                System.out.println("Opción incorrecta");
            }
        } while (!opcion.matches(regex));

        switch (opcion) {
            case "importar":
                importarDatos();
                break;
            case "exportar":
                exportarDatos();
                break;
        }

    }

    /**
     * Exporta los datos de la base de datos a un fichero JSON
     */
    private static void exportarDatos() {
        try {
            backupManager.exportarDatos();
        } catch (Exception e) {
            System.err.println("Error al exportar datos: " + e.getMessage());


        }
    }
    /**
     * Importa los datos de un fichero de JSON
     */
    private static void importarDatos() {
        try {
            backupManager.importarDatos();
        } catch (Exception e) {
            System.out.println("Error al exportar datos: " + e.getMessage());
        }

    }

}
