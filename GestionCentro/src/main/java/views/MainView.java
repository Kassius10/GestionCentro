package views;

import utils.Input;

public class MainView {

    public static void menu(){
        System.out.println("1- Gestionar Alumnos\n" +
                "2- Gestionar Categorias\n" +
                "3- Gestionar Pruebas de evaluación\n" +
                "0- Salir");

        boolean ok;
        do {
            var option= Input.readString("¿Qué desea hacer?: ");
            ok= setOption(option);

        }while(!ok);


    }

    private static boolean setOption(String option) {
        var regex= "[0-3]";
        if (option.matches(regex)){
            return true;
        }
        System.out.println("Error.");
        return false;
    }
}
