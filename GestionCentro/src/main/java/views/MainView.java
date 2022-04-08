package views;


import controllers.BackUpController;
import controllers.DataBaseManager;
import repositories.AlumnoRepository;
import repositories.CategoryRepository;
import services.BackUpStoragesJsonFile;
import utils.Input;

import java.sql.SQLException;
import java.util.Locale;

/**
 * Clase interfaz del programa.
 */
public class MainView {

  private static final BackUpController backupManager = new BackUpController(
                    AlumnoRepository.getInstance(DataBaseManager.getInstance()),
                    BackUpStoragesJsonFile.getInstance(),
                    CategoryRepository.getInstance(DataBaseManager.getInstance()));


    /**
     * Procedimiento de menu para gestionar.
     */
    public  void menu() throws SQLException {
        int option;
        do {
            System.out.println("1- Gestionar Alumnos\n" +
                    "2- Gestionar Categorías\n" +
                    "3- Gestionar Pruebas de evaluación\n" +
                    "0- Salir");

            option= setOption();



            switch(option){
                case 1:
                    menuAlumnos();
                    break;
                case 2:
                    menuCategorias();
                    break;
                case 3:
                    importarExportar();
                    break;

                default:
                    System.out.println("Na");
                    break;
            }
        }while(option!=0);

    }

    /**
     * Función de selección de opción del menu.
     * @return devuelve el número de opción indicado.
     */
    private static int setOption() {
        var regex= "[0-3]";
        String option;
        do {
            option= Input.readString("¿Qué desea hacer?: ");
            if (!option.matches(regex)) System.out.println("Error.");
        }while(!option.matches(regex));

        return Integer.parseInt(option);
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
