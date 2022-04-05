package views;

import controllers.EvaluationTestController;
import exceptions.PruebaException;
import models.Categoria;
import models.PruebaEvaluacion;
import repositories.CalificacionRepository;
import repositories.pruebas.PruebaRepository;
import utils.Input;

import java.util.List;

public class EvaluationView {
    private static EvaluationView instance;
    private final EvaluationTestController evaluationController= EvaluationTestController.getInstance(new PruebaRepository());

    private EvaluationView() {
        loadData();
    }
    public static EvaluationView getInstance(){
        if(instance==null){
            instance = new EvaluationView();
        }
        return instance;
    }

    private void loadData() {
        try {
            evaluationController.createEvaluationTest(new PruebaEvaluacion("Examene de lengua",new Categoria("examen"),new CalificacionRepository()));
            evaluationController.createEvaluationTest(new PruebaEvaluacion("Lectura",new Categoria("lectura"),new CalificacionRepository()));
            evaluationController.createEvaluationTest(new PruebaEvaluacion("Examen de mates",new Categoria("examen_Ma"),new CalificacionRepository()));
            evaluationController.createEvaluationTest(new PruebaEvaluacion("Prueba",new Categoria("prueba"),new CalificacionRepository()));

        } catch (PruebaException e) {
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
                    "2- Consultar una Prueba de Evaluación\n" +
                    "3- Eliminar una Prueba de Evaluación\n" +
                    "0- Salir");
            option= setOption();
            switch(option){
                case 1:
                    addNewEvaluationTest();
                    break;
                case 2:
                    getAllEvaluationTest();
                    break;
                case 3:
                    deleteEvaluationTest();
                    break;

                default:
                    System.out.println("Na");
                    break;
            }


        }while(option!=0);
    }

    private void deleteEvaluationTest() {
        System.out.println("Eliminar prueba de evaluación...");
        String category= Input.readString("Indica que tipo de prueba quiere eliminar: ");
        Categoria c = new Categoria(category);

        try {
            var res= evaluationController.deleteEvaluationTest(c);
            System.out.println("Prueba borrada correctamente.");
            System.out.println(res);
        } catch (PruebaException e) {
            System.out.println("Error al eliminar la prueba "+ e.getMessage());
        }
    }

    private void getAllEvaluationTest() {
        List<PruebaEvaluacion> pruebas = evaluationController.getAllEvaluationTest();
        System.out.println("\nLista de Pruebas");
        pruebas.forEach(System.out::println);
        System.out.println("Hay "+ pruebas.size()+" pruebas.");
    }

    private void addNewEvaluationTest() {
        System.out.println("Creando Nueva Prueba...");

        String category= Input.readString("Indica que tipo de prueba va a ser: ");
        Categoria c = new Categoria(category);
        String description= Input.readString("Indica una breve descripción de la prueba: ");

        System.out.println("\nGenerando Prueba...");
        PruebaEvaluacion prueba= new PruebaEvaluacion(description,c,new CalificacionRepository());

        try {
            var res= evaluationController.createEvaluationTest(prueba);
            System.out.println("La prueba ha sido creada correctamente.");
            System.out.println(res);
        } catch (PruebaException e) {
            System.out.println("Error al crear la prueba. " + e.getMessage());
        }


    }

    private static int setOption() {
        var regex= "[0-3]";
        String option;
        do {
            option= Input.readString("¿Qué desea hacer?: ");
            if (!option.matches(regex)) System.out.println("La opción seleccionada es incorrecta.");
        }while(!option.matches(regex));

        return Integer.parseInt(option);
    }

}
