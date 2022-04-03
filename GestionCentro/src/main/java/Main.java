import models.*;
import views.MainView;


public class Main {
    public static void main(String[] args)  {
        System.out.println("Hola mundo");

        Alumno alumno = new Alumno()
                .name("Mateo")
                .phone("5645644");
        System.out.println(alumno);
        MainView.menu();



    }
}
