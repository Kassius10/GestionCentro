package views;

import models.PruebaEvaluacion;
import utils.Input;

/**
 * Clase interfaz del programa.
 */
public class MainView {

    /**
     * Procedimiento de menu para gestionar.
     */
    public static void menu(){
        int option;
        do {
            System.out.println("1- Gestionar Alumnos\n" +
                    "2- Gestionar Categorías\n" +
                    "3- Gestionar Evaluación\n" +
                    "0- Salir");

            option= setOption();

            switch(option){
                case 1:
                    alumnoView();
                    break;

                case 3:
                    pruebaView();
                    break;
                case 2:
                    CategoriesView catView = CategoriesView.getInstance();
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
    private static void alumnoView(){
        AlumnoView view = AlumnoView.getInstance();
        view.init();
    }
    private static void pruebaView(){
        EvaluationView view = EvaluationView.getInstance();
        view.init();
    }
}
