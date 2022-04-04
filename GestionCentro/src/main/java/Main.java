<<<<<<< HEAD
import models.*;
import views.MainView;


=======
import exceptions.AlumnoException;
import models.Alumno;
import views.MainView;

/**
 * Proyecto Gestión del centro
 * @author Daniel Carmona, Jeremy Ramos
 * @version 1.0
 *
 */
>>>>>>> b6fed9e050ed2f64ea6f7dbffc3053c36cce9904
public class Main {
    public static void main(String[] args)  {
        System.out.println("Hola mundo");

        Alumno alumno = new Alumno()
                .name("Mateo")
                .phone("5645644");
        System.out.println(alumno);
        MainView.menu();

<<<<<<< HEAD


=======
>>>>>>> b6fed9e050ed2f64ea6f7dbffc3053c36cce9904
    }
}
