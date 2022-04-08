package controllers;

import models.Alumno;
import models.BackUp;
import models.Categoria;
import models.PruebaEvaluacion;
import repositories.alumnos.IAlumnoRepository;
import repositories.categorias.ICategoryRepository;
import repositories.pruebas.IPruebaRepository;
import services.IBackUpStorage;

import java.sql.SQLException;


public class BackUpController {
    private final IAlumnoRepository alumnosRepository;
    private final ICategoryRepository categoryRepository;
    private final IPruebaRepository pruebaRepository;
    private final IBackUpStorage backUpStorage;

    public BackUpController(IAlumnoRepository alumnosRepository, IBackUpStorage backUpStorage, ICategoryRepository categoryRepository, IPruebaRepository pruebaRepository) {
        this.alumnosRepository = alumnosRepository;
        this.backUpStorage = backUpStorage;
        this.categoryRepository = categoryRepository;
        this.pruebaRepository = pruebaRepository;
    }


    public void importarDatos() throws SQLException {
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

    public void exportarDatos() throws SQLException {
        System.out.println("Exportando datos a fichero de Backup...");
        var alumnos = alumnosRepository.findAll();
        var categorías = categoryRepository.findAll();
        var prueba = pruebaRepository.findAll();
        BackUp backup = new BackUp(alumnos, categorías, prueba);
        var res = backUpStorage.save(backup);
        if (res) {
            System.out.println("Exportando " + backup.getAlumnos().size() + " Alumn@s| "
                    + backup.getCategories().size() + " Categorías| "
                    + backup.getPruebas().size() + "Pruebas|");
            System.out.println("Datos exportados con éxito en: " + backUpStorage.getBackupPath());
        } else {
            System.out.println("Ha existido un problema al exportar los datos");
        }
    }

}
