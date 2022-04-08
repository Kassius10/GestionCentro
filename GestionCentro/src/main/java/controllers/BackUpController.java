package controllers;

import models.Alumno;
import models.BackUp;
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
            System.out.println("Datos exportados con éxito en: " + backUpStorage.getBackupPath());
        } else {
            System.out.println("Ha existido un problema al exportar los datos");
        }
    }

}
