package views;

import controllers.EvaluationTestController;
import exceptions.AlumnoException;
import exceptions.CategoriesException;
import exceptions.PruebaException;
import models.Alumno;
import models.Calificacion;
import models.Categoria;
import models.PruebaEvaluacion;
import repositories.CalificacionRepository;
import repositories.pruebas.PruebaRepository;
import utils.FicheroMarkdown;
import utils.Input;
import utils.Patterns;

import java.util.List;
import java.util.Optional;

public class EvaluationView {
    private static EvaluationView instance;
    private final EvaluationTestController evaluationController = EvaluationTestController.getInstance(new PruebaRepository());

    private EvaluationView() {
        loadData();
    }

    public static EvaluationView getInstance() {
        if (instance == null) {
            instance = new EvaluationView();
        }
        return instance;
    }

    private void loadData() {
        try {
            CalificacionRepository repository = new CalificacionRepository();
            repository.save(new Calificacion(
                    new Alumno()
                            .name("manuel")
                            .surNames("lopez lopez"), 8
            ));
            evaluationController.createEvaluationTest(new PruebaEvaluacion("Examen de lengua", new Categoria("examen"), repository));
            evaluationController.createEvaluationTest(new PruebaEvaluacion("Test Entornos", new Categoria("test"), new CalificacionRepository()));
            evaluationController.createEvaluationTest(new PruebaEvaluacion("Examen de mates", new Categoria("examen"), new CalificacionRepository()));
            evaluationController.createEvaluationTest(new PruebaEvaluacion("Prueba Programacion", new Categoria("ejercicio"), new CalificacionRepository()));

        } catch (AlumnoException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        menu();
    }

    private void menu() {
        int option;
        do {
            System.out.println("1- Crear una Prueba de Evaluación\n" +
                    "2- Consultar las Prueba de Evaluación\n" +
                    "3- Modificar las calificaciones de una Prueba de Evaluación\n" +
                    "4- Eliminar una Prueba de Evaluación\n" +
                    "5- Importar notas\n" +
                    "0- Salir");
            option = Patterns.setOption(0, 5);
            switch (option) {
                case 1:
                    addNewEvaluationTest();
                    break;
                case 2:
                    getAllEvaluationTest();
                    break;
                case 3:
                    alterQualifications();
                    break;
                case 4:
                    deleteEvaluationTest();
                    break;
                case 5:
                    importQualifications();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }

        } while (option != 0);
    }

    private void addNewEvaluationTest() {
        System.out.println("Creando Nueva Prueba...");

        showCategories();
        String category = Input.readString("\nIndica que tipo de prueba va a ser: ");

        category = Patterns.categoryItsOk(category);
        Categoria categoria = getCategoria(category);


        String description = Input.readString("Indica una breve descripción de la prueba: ");

        var next = Input.readString("Desea introducir las notas ahora mismo: [Si][No]");
        next = Patterns.patternBoolean(next);


        CalificacionRepository calificaciones = new CalificacionRepository();
        if (next.equals("si")) {
            getStudentAndNotes(calificaciones);

        }
        System.out.println("\nGenerando Prueba...");
        PruebaEvaluacion prueba = new PruebaEvaluacion()
                .description(description)
                .category(categoria)
                .qualifications(calificaciones);

        var res = evaluationController.createEvaluationTest(prueba);
        System.out.println("La prueba ha sido creada correctamente.");
        System.out.println(res);

    }

    private void getAllEvaluationTest() {
        List<PruebaEvaluacion> pruebas = evaluationController.getAllEvaluationTest();
        System.out.println("\nLista de Pruebas");
        pruebas.forEach(System.out::println);
        System.out.println("Hay " + pruebas.size() + " pruebas.");
    }

    private void deleteEvaluationTest() {
        System.out.println("Eliminar prueba de evaluación...");
        PruebaEvaluacion prueba = getPruebaEvaluation("\nIndica que tipo de prueba quiere eliminar: ", "Seleccione cual quiere eliminar.");

        try {
            PruebaEvaluacion res = null;
            res = evaluationController.deleteEvaluationTest(prueba);
            System.out.println("Prueba borrada correctamente.");
            System.out.println(res);
        } catch (PruebaException e) {
            System.out.println("Error al eliminar la prueba " + e.getMessage());
        }
    }

    private void importQualifications() {
        PruebaEvaluacion prueba = getPruebaEvaluation("\nSelecciona el tipo de prueba que desea importar: ", "Selecciona cual quiere importar: ");
        if (!prueba.getQualifications().findAll().isEmpty()) {
            prueba.getQualifications().mostrarInforme();

            var option = Input.readString("Desea importar el informe: [si][no]");
            option = Patterns.patternBoolean(option);

            if (option.equals("si")) {
                var dir = Input.readString("Donde desea guardar el archivo:");
                dir = Patterns.patternName(dir);
                System.out.println(dir);

                FicheroMarkdown f = new FicheroMarkdown(prueba, dir);
                f.saveNotas();
            }
        } else System.out.println("Esta prueba no contiene notas.");

    }

    private void alterQualifications() {
        PruebaEvaluacion prueba = getPruebaEvaluation("\nIndica que tipo de prueba quiere modificar: ", "Seleccione cual quiere modificar.");

        int option;
        do {
            System.out.println("1- Añadir nota\n" +
                    "2- Ver las notas\n" +
                    "0- Salir");
            option = Patterns.setOption(0, 2);
            switch (option) {
                case 1:
                    addNewQualifiactions(prueba);
                    break;
                case 2:
                    showQualifiactions(prueba);
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

    private void addNewQualifiactions(PruebaEvaluacion prueba) {
        var listaNotas = prueba.getQualifications();
        getStudentAndNotes(listaNotas);

    }


    private void showQualifiactions(PruebaEvaluacion prueba) {
        prueba.getQualifications().findAll().forEach(System.out::println);
    }

    private PruebaEvaluacion getPruebaEvaluation(String message, String message2) {
        showCategories();
        PruebaEvaluacion prueba = new PruebaEvaluacion();
        boolean ok = false;
        do {
            String category = Input.readString(message);
            Categoria c = getCategoria(category);
            try {
                List<PruebaEvaluacion> lista = evaluationController.findByCategory(c);
                if (!lista.isEmpty()) {
                    lista.forEach(l -> System.out.println((lista.indexOf(l) + 1) + ": " + l));
                    System.out.println(message2);
                    int option = Patterns.setOption(0, lista.size()) - 1;
                    prueba = lista.get(option);
                    ok = true;
                } else ok = false;
            } catch (PruebaException e) {
                System.out.println(e.getMessage());
            }
        } while (!ok);
        return prueba;
    }


    private void showCategories() {
        CategoriesView view = CategoriesView.getInstance();
        System.out.print("TIPOS: [ ");
        view.getCategoriesController().getAllCategories().forEach(c -> System.out.print(c.getName().toUpperCase() + " "));
        System.out.print("]");
    }

    private Categoria getCategoria(String category) {
        CategoriesView cat = CategoriesView.getInstance();
        boolean ok;
        Categoria categoria = new Categoria();
        do {
            category = Patterns.categoryItsOk(category);
            try {
                categoria = cat.getCategoriesController().getCategoryByName(category);
                ok = true;
            } catch (CategoriesException e) {
                System.out.println(e.getMessage());
                ok = false;
                category = Input.readString("Repita: ");
            }
        } while (!ok);
        return categoria;
    }

    private void getStudentAndNotes(CalificacionRepository listaNotas) {
        boolean salir = false;
        var notas = Input.readString("Introduce el dni del alumno y la nota, separado por coma: \nSi desea salir solo escriba salir.").split(",");
        do {
            if (!notas[0].equals("salir")) {
                var calificacion = getNotas(notas).orElse(null);
                if (calificacion != null) listaNotas.save(calificacion);
                notas = Input.readString("Siguiente: ").split(",");

            } else salir = true;

        } while (!salir);
    }

    private Optional<Calificacion> getNotas(String[] notas) {
        AlumnoView view = AlumnoView.getInstance();
        var regex = "([1-9]{1}[0-9]{7}[a-z])";
        var regex1 = "[0-9]|[0-9].[0-9]{1,2}|10";
        if (notas.length < 2 || !notas[0].trim().matches(regex) || !notas[1].trim().matches(regex1)) {
            System.out.println("Error.");
        } else {
            String dni = notas[0].trim();
            String nota = notas[1].trim();
            try {
                Alumno al = view.getAlumnoController().getAlumnByDni(dni);
                if (al.isEnabled() || !al.isHasLoseEvaluation()) {
                    al.enabled(false);
                    return Optional.of(new Calificacion(
                            al,
                            Double.parseDouble(nota)));
                } else System.out.println("El alumno no esta disponible.");

            } catch (AlumnoException e) {
                System.out.println(e.getMessage());
            }
        }
        return Optional.empty();
    }
}
