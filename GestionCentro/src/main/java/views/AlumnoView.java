package views;

import controllers.AlumnoController;
import exceptions.AlumnoException;
import models.Alumno;
import repositories.alumnos.AlumnoRepository;
import utils.Input;
import utils.Patterns;

import java.util.Comparator;
import java.util.List;

/**
 * Interfaz del control de alumnos.
 */
public class AlumnoView {
    private static AlumnoView instance;
    private final AlumnoController alumnoController = AlumnoController.getInstance(AlumnoRepository.getInstance());
    private int cont = 0;

    /**
     * Constructor privado de AlumnoView
     */
    private AlumnoView() {
        loadData();
    }

    /**
     * Método de creación de instancia con el patron Singleton.
     *
     * @return devuelve la instancia.
     */
    public static AlumnoView getInstance() {
        if (instance == null) {
            instance = new AlumnoView();
        }
        return instance;
    }

    public AlumnoController getAlumnoController() {
        return alumnoController;
    }

    /**
     * Método para iniciar.
     */
    public void init() {
        menu();
    }

    /**
     * Datos cargados.
     */
    private void loadData() {
        try {
            alumnoController.insertAlumno(new Alumno("11111111a", "dani", "carmona rodriguez", "dani@alumno.org", "611-111111", true, true).id(++cont));
            alumnoController.insertAlumno(new Alumno("22222222b", "jeremy", "ramos segura", "jeremy@alumno.org", "622-222222", true, true).id(++cont));
            alumnoController.insertAlumno(new Alumno("33333333c", "nuria", "gonzalez margallo", "nuria@alumno.org", "633-333333", true, true).id(++cont));
            alumnoController.insertAlumno(new Alumno("44444444d", "marta", "sanchez perez", "marta@alumno.org", "644-444444", true, true).id(++cont));
            alumnoController.insertAlumno(new Alumno("55555555e", "luis", "lopez lopez", "luis@alumno.org", "655-555555S", true, true).id(++cont));
        } catch (AlumnoException e) {
            e.printStackTrace();
        }
    }

    /**
     * Procedimiento de selección de menu.
     */
    public void menu() {
        int option;
        do {
            System.out.println("\n1- Añadir un Alumno\n" +
                    "2- Modificar datos de un Alumno\n" +
                    "3- Eliminar un Alumno\n" +
                    "4- Consultar lista de alumnos\n" +
                    "0- Salir");
            option = Patterns.setOption(0, 4);
            switch (option) {
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
                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Na");
                    break;
            }


        } while (option != 0);

    }

    /**
     * Procedimiento de modificacion de alumno.
     */
    private void modificarAlumno() {
        System.out.println("\n-------------");
        System.out.println("Modificar alumno: ");
        var alumno = Input.readString("Indica el dni del alumno que desea modificar: ");

        try {
            Alumno exist = getAlumno(alumno);

            var res = alumnoController.updateAlumno(exist.getId(), exist);
            System.out.println("\nActualizando Alumno " + exist.getName());
            Thread.sleep(1000);
            System.out.println(res);

        } catch (AlumnoException e) {
            System.out.println("Error al modificar el alumno. " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Función que devuelve el alumno modificado
     *
     * @param alumno Alumno el cual queremos modificar
     * @return Devuelve el alumno con la modificacion de datos
     * @throws AlumnoException Si el alumno no existe
     */
    private Alumno getAlumno(String alumno) throws AlumnoException {
        var exist = alumnoController.getAlumnByDni(alumno);
        System.out.println("\n-> Introduce los nuevos datos o deje en blanco para mantener los actuales.");
        String name = Input.readString("Indica nuevo nombre del Alumno: (anterior: " + exist.getName() + "):");
        if (name.isEmpty()) name = exist.getName();
        else name = Patterns.patternName(name);

        String surNames = Input.readString("Indica los nuevos apellidos del Alumno: (anterior: " + exist.getSurNames() + "):");
        surNames = (surNames.isEmpty()) ? exist.getSurNames() : Patterns.patternSurnames(surNames);

        String email = Input.readString("Indica el nuevo email del Alumno: (anterior: " + exist.getEmail() + "):");
        email = (email.isEmpty()) ? exist.getEmail() : Patterns.patternEmail(email);

        String phone = Input.readString("Indica el nuevo teléfono del Alumno: (anterior: " + exist.getPhone() + "):");
        phone = (phone.isEmpty()) ? exist.getPhone() : Patterns.patternPhone(phone);

        String evaluation = Input.readString("Indica si ha perdido la evaluacion [si - no]: ");
        boolean ev = (evaluation.isEmpty()) ? exist.isHasLoseEvaluation() : Patterns.patternBoolean(evaluation).equals("si");

        String enabled = Input.readString("Indica si esta disponible el alumno [si - no]: (anterior:  " + exist.isEnabled() + "):");
        boolean disponible = (enabled.isEmpty()) ? exist.isEnabled() : Patterns.patternBoolean(enabled).equals("si");

        exist.name(name)
                .surNames(surNames)
                .email(email)
                .phone(phone)
                .hasLoseEvaluation(ev)
                .enabled(disponible)
                .id(++cont);
        return exist;
    }

    /**
     * Procedimiento para eliminar un alumno
     */
    private void eliminarAlumno() {
        System.out.println("\n-------------");
        System.out.println("Eliminar alumno:");
        var alumno = Input.readString("Introduzca el dni del alumno que desea eliminar: ");
        try {
            var res = alumnoController.getAlumnByDni(alumno);
            if (res.isEnabled()) {
                alumnoController.deletAlumno(alumno);
                System.out.println("\nAlumno eliminado satisfactoriamente.");
                System.out.println(res);
            } else System.out.println("No se puede eliminar el alumno, se encuentra no disponible.");
        } catch (AlumnoException e) {
            System.out.println("Error al eliminar el alumno: " + e.getMessage());
        }
    }

    /**
     * Procedimiento para añadir un alumno
     */
    private void crearAlumno() {
        System.out.println("\n--------------");
        System.out.println("Añadir alumno:");
        String dni = Input.readString("DNI del alumno: Formato: [NNNNNNNNL]");
        dni = Patterns.patternDni(dni);

        String name = Input.readString("Nombre del alumno: ");
        name = Patterns.patternName(name);

        String surNames = Input.readString("Apellidos del alumno: [Separado por espacio]");
        surNames = Patterns.patternSurnames(surNames);

        String email = Input.readString("Email del alumno: Formato: [loquesea@correo.com - loquesea@correo.dominio.es]");
        email = Patterns.patternEmail(email);

        String phone = Input.readString("Número de teléfono de contacto del alumno: Formato: [NNN-NNNNNNN] el número debe empezar entre 6-9.");
        phone = Patterns.patternPhone(phone);

        String evaluation = Input.readString("Indica si ha perdido la evaluacion [si - no]: ");
        evaluation = Patterns.patternBoolean(evaluation);

        String enabled = Input.readString("Indica si el usuario esta disponible. [si - no]: ");
        enabled = Patterns.patternBoolean(enabled);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nMatriculando...");
        Alumno alumno = null;
        try {
            alumno = new Alumno()
                    .dni(dni)
                    .name(name)
                    .surNames(surNames)
                    .email(email)
                    .phone(phone)
                    .hasLoseEvaluation(evaluation.equals("si"))
                    .enabled(enabled.equals("si"));
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            var res = alumnoController.insertAlumno(alumno);
            System.out.println("El alumno ha sido matriculado perfectamente.");
            System.out.println(res);
        } catch (AlumnoException e) {
            System.out.println("Erros al añadir el alumno: " + e.getMessage());
        }

    }

    /**
     * Procedimiento para consultar la lista de alumnos
     */
    private void showAlumnos() {
        List<Alumno> alumnos = alumnoController.getAllAlumnos();
        System.out.println("\n1- Por orden de lista\n" +
                "2- Por orden alfabético.");

        metodoOrdenacion(alumnos);
        System.out.println("Hay " + alumnos.size() + " alumnos.");
    }

    /**
     * Procedimiento para indicar como queremos ordenar la lista.
     *
     * @param alumnos Lista de alumnos que queremos ordenar.
     */
    private void metodoOrdenacion(List<Alumno> alumnos) {
        boolean ok;
        do {
            var option = Input.readString("Como quieres ordenarlo: ");
            System.out.println("-> Lista de alumnos:");
            switch (option) {
                case "1":
                    //alumnos.sort(new AlumnoNumListComparator());
                    alumnos.stream().sorted(Comparator.comparing(Alumno::getId)).forEach(System.out::println);
                    ok = true;
                    break;
                case "2":
                    //alumnos.sort(new AlumnoNameComparator());
                    alumnos.stream().sorted(Comparator.comparing(Alumno::getName)).forEach(System.out::println);
                    ok = true;
                    break;
                default:
                    System.out.println("Error");
                    ok = false;
                    break;
            }
        } while (!ok);
    }
}
