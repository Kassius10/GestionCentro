package views;

import controllers.AlumnoController;
import repositories.AlumnoRepository;

public class AlumnoView {
    private static AlumnoView instance;
    private final AlumnoController alumnoController= AlumnoController.getInstance(new AlumnoRepository());


    private AlumnoView(){
        
    }
    public static AlumnoView getInstance(){
        if(instance==null){
            instance = new AlumnoView();
        }
        return instance;
    }

    private void menu(){
        System.out.println("¿Qué desea hacer?:\n" +
                "1- Gestionar Alumnos\n" +
                "2- Gestionar Categorias\n" +
                "3- Gestionar Pruebas de evaluación" +
                "0- Salir");


    }

    private void crearAlumno(){
        System.out.println("Añadir alumno:");

    }
}
