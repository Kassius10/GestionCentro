package views;

import comparators.AlumnoNameComparator;
import comparators.AlumnoNumListComparator;
import controllers.AlumnoController;
import exceptions.AlumnoException;
import models.Alumno;
import repositories.AlumnoRepository;
import utils.AlumnoPatterns;
import utils.Input;

import java.util.List;

/**
 * Interfaz del control de alumnos.
 */
public class AlumnoView {
    private static AlumnoView instance;
    private final AlumnoController alumnoController= AlumnoController.getInstance(new AlumnoRepository());

    /**
     * Constructor privado de AlumnoView
     */
    private AlumnoView(){
        loadData();
        init();
    }

    /**
     * Método de creación de instancia con el patron Singleton.
     * @return devuelve la instancia.
     */
    public static AlumnoView getInstance(){
        if(instance==null){
            instance = new AlumnoView();
        }
        return instance;
    }

    /**
     * Método para iniciar.
     */
    public void init(){
        menu();

    }

    /**
     * Datos cargados.
     */
    private void loadData(){
        try {
            alumnoController.insertAlumno(new Alumno("50583789h","Dani","Ca Ro","d@d.com","654-987789",true));
            alumnoController.insertAlumno(new Alumno("50583469h","Wani","Ca Ro","d@d.com","654-987789",true));
            alumnoController.insertAlumno(new Alumno("50583459h","Fani","Ca Ro","d@d.com","654-987789",true));
            alumnoController.insertAlumno(new Alumno("50583179h","Gani","Ca Ro","d@d.com","654-987789",true));
            alumnoController.insertAlumno(new Alumno("50583159h","TYani","Ca Ro","d@d.com","654-987789",true));
        } catch (AlumnoException e) {
            e.printStackTrace();
        }
    }

    /**
     * Procedimiento de selección de menu.
     */
    private void menu(){
        int option;
        do {
            System.out.println("1- Añadir un Alumno\n" +
                    "2- Modificar datos de un Alumno\n" +
                    "3- Eliminar un Alumno\n" +
                    "4- Consultar lista de alumnos\n" +
                    "0- Salir");
            option= setOption();
            switch(option){
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    modificarAlumno();
                    break;
                case 3:
                    eliminarAlumno();
                    break;
                case 4:
                    showAlumnos();
                    break;

                default:
                    System.out.println("Na");
                    break;
            }


        }while(option!=0);

    }

    private void modificarAlumno() {
        System.out.println("Modificar alumno: ");
        var alumno= Input.readString("Indica el dni del alumno que desea modificar: ");
        System.out.println("Introduce los nuevos datos o deje en blanco para mantener los actuales.");

        try {
            var exist= alumnoController.getAlumnByDni(alumno);

            String name = Input.readString("Indica nuevo nombre del Alumno: (anterior: " + exist.getName() + "):");
            if (name.isEmpty()) name=exist.getName();
            else name= AlumnoPatterns.patternName(name);

            String surNames = Input.readString("Indica los nuevos apellidos del Alumno: (anterior: " + exist.getSurNames() + "):");
            surNames=(surNames.isEmpty())?exist.getSurNames() :AlumnoPatterns.patternSurnames(surNames);

            String email = Input.readString("Indica el nuevo email del Alumno: (anterior: " + exist.getEmail() + "):");
            email=(email.isEmpty())?exist.getEmail() :AlumnoPatterns.patternEmail(email);

            String phone = Input.readString("Indica el nuevo teléfono del Alumno: (anterior: " + exist.getPhone() + "):");
            phone= (phone.isEmpty())?exist.getPhone() :AlumnoPatterns.patternPhone(phone);

            String evaluation = Input.readString("Indica si ha perdido la evaluacion [si - no]: ");
            boolean ev = (evaluation.isEmpty())? exist.isHasLoseEvaluation(): AlumnoPatterns.patternBoolean(evaluation).equals("si");

            exist.name(name)
                    .surNames(surNames)
                    .email(email)
                    .phone(phone)
                    .hasLoseEvaluation(ev);

            var res = alumnoController.updateAlumno(exist.getId(), exist);
            System.out.println("País actualizado");
            System.out.println(res);

        } catch (AlumnoException e) {
            System.out.println("Error al modificar el alumno. " + e.getMessage());
        }

    }

    /**
     * Procedimiento para eliminar un alumno
     */
    private void eliminarAlumno() {
        System.out.println("Eliminar alumno:");
        var alumno= Input.readString("Introduzca el dni del alumno que desea eliminar: ");
        try {
            var res= alumnoController.deletAlumno(alumno);
            System.out.println("Alumno eliminado satisfactoriamente.");
            System.out.println(res);
        } catch (AlumnoException e) {
            System.out.println("Error al eliminar el alumno: " + e.getMessage());
        }
    }

    /**
     * Procedimiento para añadir un alumno
     */
    private void crearAlumno(){ //TODO hay que filtrar también el back
        System.out.println("Añadir alumno:");
        String dni = Input.readString("DNI del alumno: ");
        dni= AlumnoPatterns.patternDni(dni);

        String name = Input.readString("Nombre del alumno: ");
        name= AlumnoPatterns.patternName(name);

        String surNames = Input.readString("Apellidos del alumno: ");
        surNames= AlumnoPatterns.patternSurnames(surNames);

        String email = Input.readString("Email del alumno: ");
        email= AlumnoPatterns.patternEmail(email);

        String phone = Input.readString("Número de teléfono de contacto del alumno: ");
        phone= AlumnoPatterns.patternPhone(phone);

        String evaluation = Input.readString("Indica si ha perdido la evaluacion [si - no]: ");
        evaluation= AlumnoPatterns.patternBoolean(evaluation);

        System.out.println("Matriculando...");
        Alumno alumno = null;
        try {
            alumno = new Alumno()
                    .dni(dni)
                    .name(name)
                    .surNames(surNames)
                    .email(email)
                    .phone(phone)
                    .hasLoseEvaluation(evaluation.equals("si"));
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            var res= alumnoController.insertAlumno(alumno);
            System.out.println("El alumno ha sido matriculado perfectamente.");
            System.out.println(res);
        } catch (AlumnoException e) {
            System.out.println("Erros al añadir el alumno: "+ e.getMessage());
        }

    }

    /**
     * Procedimiento para consultar la lista de alumnos
     */
    private void showAlumnos(){
        List<Alumno> alumnos = alumnoController.getAllAlumnos();
        System.out.println("1- Por orden de lista\n" +
                "2- Por orden alfabético.");

        metodoOrdenacion(alumnos);

        System.out.println("\nLista de alumnos:");
        for(Alumno alumno : alumnos){
            System.out.println(alumno);
        }
        System.out.println("Hay "+ alumnos.size() + " alumnos.");
    }

    /**
     * Procedimiento para indicar como queremos ordenar la lista.
     * @param alumnos Lista de alumnos que queremos ordenar.
     */
    private void metodoOrdenacion(List<Alumno> alumnos) {
        boolean ok;
        do {
            var option= Input.readString("Como quieres ordenarlo: ");
            switch(option){
                case "1":
                    alumnos.sort(new AlumnoNumListComparator());
                    ok=true;
                    break;
                case "2":
                    alumnos.sort(new AlumnoNameComparator());
                    ok=true;
                    break;
                default:
                    System.out.println("Error");
                    ok=false;
                    break;
            }
        }while (!ok);
    }

    /**
     * Función para indicar la opción del menu.
     * @return Devuelve el número de la opción.
     */
    private static int setOption() {
        var regex= "[0-4]";
        String option;
        do {
            option= Input.readString("¿Qué desea hacer?: ");
            if (!option.matches(regex)) System.out.println("La opción seleccionada es incorrecta.");
        }while(!option.matches(regex));

        return Integer.parseInt(option);
    }
}
