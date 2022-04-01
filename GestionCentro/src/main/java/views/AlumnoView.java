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

    private void crearAlumno(){

    }
}
