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

public class AlumnoView {
    private static AlumnoView instance;
    private final AlumnoController alumnoController= AlumnoController.getInstance(new AlumnoRepository());

    private AlumnoView(){
        init();
    }
    public static AlumnoView getInstance(){
        if(instance==null){
            instance = new AlumnoView();
        }
        return instance;
    }

    public void init(){
        menu();
    }

    private void menu(){
        int option;
        do {
            System.out.println("1- Añadir un Alumno\n" +
                    "2- Modificar datos de un Alumno\n" +
                    "3- Eliminar un Alumno\n" +
                    "4- Consultar lista de alumnos" +
                    "0- Salir");
            option= setOption();
            switch(option){
                case 1:
                    crearAlumno();
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
        Alumno alumno = new Alumno()
                .dni(dni)
                .name(name)
                .surNames(surNames)
                .email(email)
                .phone(phone)
                .hasLoseEvaluation(evaluation.equals("si"));

        try {
            var res= alumnoController.insertAlumno(alumno);
            System.out.println("El alumno ha sido matriculado perfectamente.");
            System.out.println(res);
        } catch (AlumnoException e) {
            System.out.println("Erros al añadir el alumno: "+ e.getMessage());
        }

    }
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


    private static int setOption() {
        var regex= "[0-4]";
        String option;
        do {
            option= Input.readString("¿Qué desea hacer?: ");
            if (!option.matches(regex)) System.out.println("Error.");
        }while(!option.matches(regex));

        return Integer.parseInt(option);
    }
}
