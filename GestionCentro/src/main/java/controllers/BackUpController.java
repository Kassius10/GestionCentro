package controllers;

import models.Alumno;
import models.BackUp;
<<<<<<< HEAD
import models.Categories;
import repositories.AlumnoRepository;
import repositories.ICategoryRepository;
import repositories.IRepository;
import services.BackUpStoragesJsonFile;
import services.IBackUpStorage;

import java.sql.SQLException;
import java.util.List;


public class BackUpController {
    private final IRepository alumnosRepository;
    private final ICategoryRepository categoryRepository;
    private final IBackUpStorage backUpStorage;

    public BackUpController(IRepository alumnosRepository, BackUpStoragesJsonFile backUpStorage, ICategoryRepository categoryRepository){
        this.alumnosRepository = alumnosRepository;
        this.backUpStorage = backUpStorage;
        this.categoryRepository = categoryRepository;
    }



    public void importarDatos() throws SQLException {
=======
import models.Categoria;
import models.PruebaEvaluacion;
import repositories.alumnos.IAlumnoRepository;
import repositories.categorias.ICategoryRepository;
import repositories.pruebas.IPruebaRepository;
import services.IBackUpStorage;

/**
 * Clase controladora de BackUp
 */
public class BackUpController {
    private final IAlumnoRepository alumnosRepository;
    private final ICategoryRepository categoryRepository;
    private final IPruebaRepository pruebaRepository;
    private final IBackUpStorage backUpStorage;

    /**
     * Constructor con parametros
     *
     * @param alumnosRepository  repositorio de alumnos
     * @param backUpStorage      almacenamiento requerido
     * @param categoryRepository repositorio de categoria
     * @param pruebaRepository   repositorio de pruebas
     */
    public BackUpController(IAlumnoRepository alumnosRepository, IBackUpStorage backUpStorage, ICategoryRepository categoryRepository, IPruebaRepository pruebaRepository) {
        this.alumnosRepository = alumnosRepository;
        this.backUpStorage = backUpStorage;
        this.categoryRepository = categoryRepository;
        this.pruebaRepository = pruebaRepository;
    }

    /**
     * Procedimiento para importar los datos
     */
    public void importarDatos() {
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
        System.out.println("Importando datos de Backup: " + backUpStorage.getBackupPath());
        var backup = backUpStorage.load();

        System.out.println("Importando Alumnos...");
        if (backup.getAlumnos().size() > 0) {
            alumnosRepository.deleteAll();
            for (Alumno alumno : backup.getAlumnos()) {
                alumnosRepository.save(alumno);
            }
            System.out.println("Alumnos importados con éxito al BackUp: " + backup.getAlumnos().size() + " Alumn@s");
        } else {
            System.out.println("No se ha podido introducir los Alumnos");

        }

<<<<<<< HEAD
//        System.out.println("Importando Categorías...");
//        if (backup.getCategories().size() > 0) {
//            for (Categories category : backup.getCategories()) {
//                categoryRepository.save(category);
//            }
//            System.out.println("Categorías importadas con éxito al BackUp: " + backup.getCategories().size() + " Alumn@s");
//        } else {
//            System.out.println("No se ha podido introducir los Alumnos");
//
//        }


    }

    public void exportarDatos() throws SQLException {
        System.out.println("Exportando datos a fichero de Backup...");
        var alumnos = alumnosRepository.findAll();
        var categorías = categoryRepository.findAll();
        BackUp backup = new BackUp(alumnos, categorías);
        var res = backUpStorage.save(backup);
        if (res) {
            System.out.println("Exportando " + backup.getAlumnos().size() + " Alumn@s"
            + backup.getCategories().size() + "Categorías");
=======
        System.out.println("Importando Categorías...");
        if (backup.getCategories().size() > 0) {
            for (Categoria category : backup.getCategories()) {
                categoryRepository.save(category);
            }
            System.out.println("Categorías importadas con éxito al BackUp: " + backup.getCategories().size() + " Categorias");
        } else {
            System.out.println("No se ha podido introducir los Alumnos");

        }

        System.out.println("Importando Pruebas...");
        if (backup.getPruebas().size() > 0) {
            pruebaRepository.clear();
            for (PruebaEvaluacion prueba : backup.getPruebas()) {
                pruebaRepository.save(prueba);
            }
            System.out.println("Categorías importadas con éxito al BackUp: " + backup.getPruebas().size() + " Pruebas");
        } else {
            System.out.println("No se ha podido introducir los Alumnos");

        }
    }

    /**
     * Procedimiento para exportar los datos
     */
    public void exportarDatos() {
        System.out.println("Exportando datos a fichero de Backup...");
        var alumnos = alumnosRepository.findAll();
        var categorías = categoryRepository.findAll();
        var prueba = pruebaRepository.findAll();
        BackUp backup = new BackUp(alumnos, categorías, prueba);
        var res = backUpStorage.save(backup);
        if (res) {
            System.out.println("Exportando " + backup.getAlumnos().size() + " Alumn@s| "
                    + backup.getCategories().size() + " Categorías| "
                    + backup.getPruebas().size() + " Pruebas|");
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
            System.out.println("Datos exportados con éxito en: " + backUpStorage.getBackupPath());
        } else {
            System.out.println("Ha existido un problema al exportar los datos");
        }
    }

}
