package views;

import controllers.AlumnoController;
import controllers.BackUpController;
import controllers.DataBaseManager;
import exceptions.AlumnoException;
import models.Alumno;
<<<<<<< HEAD
import models.Categories;
import repositories.AlumnoRepository;
import repositories.CategoryRepository;
import services.BackUpStoragesJsonFile;
import utils.AlumnoPatterns;
=======
import repositories.alumnos.AlumnoRepository;
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
import utils.Input;
import utils.Patterns;

<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
import java.util.Comparator;
import java.util.List;

/**
 * Interfaz del control de alumnos.
 */
public class AlumnoView {
    private static AlumnoView instance;
<<<<<<< HEAD

    private final AlumnoController alumnoController = new AlumnoController(
            AlumnoRepository.getInstance(DataBaseManager.getInstance())
    );


=======
    private final AlumnoController alumnoController = AlumnoController.getInstance(AlumnoRepository.getInstance());
    private int cont = 0;
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

    /**
     * Constructor privado de AlumnoView
     */
<<<<<<< HEAD
    private AlumnoView()  {
        init();
=======
    private AlumnoView() {
        loadData();
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
    }

    /**
     * Método de creación de instancia con el patron Singleton.
     *
     * @return devuelve la instancia.
<<<<<<< HEAD
//     */
    public static AlumnoView getInstance()  {
        if(instance==null){
=======
     */
    public static AlumnoView getInstance() {
        if (instance == null) {
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
            instance = new AlumnoView();
        }
        return instance;
    }

<<<<<<< HEAD
//    /**
//     * Datos cargados.
//     */
//    private void loadData(){
//        try {
//            alumnoController.insertAlumno(new Alumno("50583789h","Dani","Ca Ro","d@d.com","654-987789",true));
//            alumnoController.insertAlumno(new Alumno("50583469h","Wani","Ca Ro","d@d.com","654-987789",true));
//            alumnoController.insertAlumno(new Alumno("50583459h","Fani","Ca Ro","d@d.com","654-987789",true));
//            alumnoController.insertAlumno(new Alumno("50583179h","Gani","Ca Ro","d@d.com","654-987789",true));
//            alumnoController.insertAlumno(new Alumno("50583159h","TYani","Ca Ro","d@d.com","654-987789",true));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
=======
    public AlumnoController getAlumnoController() {
        return alumnoController;
    }
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

    /**
     * Método para iniciar.
     */
    public void init() {
        menu();
    }

    /**
<<<<<<< HEAD
     * Procedimiento de selección de menu.
     */
    private void menu()  {
=======
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
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
        int option;
        do {
            System.out.println("\n1- Añadir un Alumno\n" +
                    "2- Modificar datos de un Alumno\n" +
                    "3- Eliminar un Alumno\n" +
                    "4- Consultar lista de alumnos\n" +
                    "5- Exportar Datos a Backup\n" +
                    "6- Importar desde el BackUp\n" +
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

        } catch (AlumnoException | SQLException e) {
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
<<<<<<< HEAD
            var res= alumnoController.deletAlumno(alumno);
            System.out.println("Alumno eliminado satisfactoriamente.");
            System.out.println(res);
        } catch (AlumnoException | SQLException e) {
=======
            var res = alumnoController.getAlumnByDni(alumno);
            if (res.isEnabled()) {
                alumnoController.deletAlumno(alumno);
                System.out.println("\nAlumno eliminado satisfactoriamente.");
                System.out.println(res);
            } else System.out.println("No se puede eliminar el alumno, se encuentra no disponible.");
        } catch (AlumnoException e) {
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
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

<<<<<<< HEAD
        String enable = Input.readString("Indica si está permitido [si - no]");
        enable= AlumnoPatterns.patternBoolean(enable);

        System.out.println("Matriculando...");
=======
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nMatriculando...");
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
        Alumno alumno = null;
        try {
            alumno = new Alumno()
                    .dni(dni)
                    .name(name)
                    .surNames(surNames)
                    .email(email)
                    .phone(phone)
                    .hasLoseEvaluation(evaluation.equals("si"))
<<<<<<< HEAD
                    .enabled(enable.equals("si"));
=======
                    .enabled(enabled.equals("si"));
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            var res = alumnoController.insertAlumno(alumno);
            System.out.println("El alumno ha sido matriculado perfectamente.");
            System.out.println(res);
<<<<<<< HEAD
        } catch (AlumnoException | SQLException e) {
            System.out.println("Erros al añadir el alumno: "+ e.getMessage());
=======
        } catch (AlumnoException e) {
            System.out.println("Erros al añadir el alumno: " + e.getMessage());
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
        }

    }

    /**
     * Procedimiento para consultar la lista de alumnos
     */
    private void showAlumnos() {
<<<<<<< HEAD
        try {

            List<Alumno> alumnos = alumnoController.getAllAlumnos();
            System.out.println("1- Por orden de lista\n" +
                    "2- Por orden alfabético.");

            metodoOrdenacion(alumnos);

            System.out.println("\nLista de alumnos:");
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
            }
            System.out.println("Hay " + alumnos.size() + " alumnos.");
        }catch (Exception e){
            System.err.println("Error al obtener los alumnos");
        }
=======
        List<Alumno> alumnos = alumnoController.getAllAlumnos();
        System.out.println("\n1- Por orden de lista\n" +
                "2- Por orden alfabético.");

        metodoOrdenacion(alumnos);
        System.out.println("Hay " + alumnos.size() + " alumnos.");
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
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
<<<<<<< HEAD
        }while (!ok);
    }

    /**
     * Función para indicar la opción del menu.
     * @return Devuelve el número de la opción.
     */
    private static int setOption() {
        var regex= "[0-6]";
        String option;
        do {
            option= Input.readString("¿Qué desea hacer?: ");
            if (!option.matches(regex)) System.out.println("La opción seleccionada es incorrecta.");
        }while(!option.matches(regex));

        return Integer.parseInt(option);
=======
        } while (!ok);
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
    }

}
