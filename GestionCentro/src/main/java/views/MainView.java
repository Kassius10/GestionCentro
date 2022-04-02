package views;

import utils.Input;

public class MainView {

    public static void menu(){
        System.out.println("1- Gestionar Alumnos\n" +
                "2- Gestionar Categorias\n" +
                "3- Gestionar Pruebas de evaluación\n" +
                "0- Salir");

        var option= setOption();

        switch(option){
            case 1:
                AlumnoView view= AlumnoView.getInstance();
            break;

            default:
                System.out.println("Na");
            break;
        }

    }

    private static int setOption() {
        var regex= "[0-3]";
        String option;
        do {
            option= Input.readString("¿Qué desea hacer?: ");
            if (!option.matches(regex)) System.out.println("Error.");
        }while(!option.matches(regex));

        return Integer.parseInt(option);
    }
}
