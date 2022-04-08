package controllers;

import exceptions.AlumnoException;
import models.Alumno;
import repositories.IRepository;
import services.IBackUpStorage;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase que controla los alumnos.
 */
public class AlumnoController {
    private static AlumnoController instance;
    private final IRepository alumnos;


    /**
     * Constructor privado para solo poder generarse una instancia.
     * @param alumnos Repositorio que le daremos para almacenar los alumnos.
     */
    public AlumnoController(IRepository alumnos) {
        this.alumnos = alumnos;

    }

    /**
     * Método que nos permite crear una única instancia de la clase, si la instancia es null.
     *
     * @return Devuelve la instancia creada.
     */
    public static AlumnoController getInstance(IRepository alumnos) {
        if(instance == null){
            instance = new AlumnoController(alumnos);
        }
        return instance;
    }

    /**
     * Función que devuelve el alumno con el dni indicado.
     * @param dni Dni del alumno.
     * @return Devuelve el alumno si existe con el dni indicado.
     * @throws AlumnoException Excepción si no existe un alumno con el dni.
     */
    public Alumno getAlumnByDni(String dni) throws AlumnoException, SQLException {
        return alumnos.findByDni(dni).orElseThrow(()-> new AlumnoException("No existe un alumno con dni " + dni));
    }

    /**
     * Función que devuelve una lista con todos los alumnos del repositorio.
     * @return Devuelve una lista de alumnos.
     */
    public List<Alumno> getAllAlumnos() throws SQLException {
        return alumnos.findAll();
    }

    /**
     * Función para añadir un alumno.
     * @param alumno Alumno que queremos añadir.
     * @return Devuelve el alumno que hemos añadido.
     * @throws AlumnoException Excepción si ya existe un alumno con el mismo dni.
     */
    public Alumno insertAlumno(Alumno alumno) throws AlumnoException, SQLException {
        var exist= alumnos.findByDni(alumno.getDni());
        if (exist.isEmpty()){
            alumnos.save(alumno);
            return alumno;
        }
        throw new AlumnoException("Ya existe un alumno con dni " + alumno.getDni());
    }

    /**
     * Función para actualizar los datos de un alumno.
     * @param id Id del alumno
     * @param alumno Alumno con los datos modificados.
     * @return Devuelve el alumno.
     * @throws AlumnoException Excepción si existe un alumno con el mismo dni.
     */
    public Alumno updateAlumno(int id, Alumno alumno) throws AlumnoException, SQLException {
        var alumn= alumnos.findByDni(alumno.getDni());
        if (alumn.isEmpty() || alumno.getId() == alumn.get().getId()){
            alumnos.update(id,alumno);
            return alumno;
        }
        throw new AlumnoException("Ya existe un alumno con dni "+ alumn.get().getDni());
    }

    /**
     * Función para eliminar un alumno con el dni indicado.
     * @param dni Dni del alumno
     * @return Devuelve el alumno eliminado.
     * @throws AlumnoException Excepción si no existe el alumno.
     *
     */
    public Alumno deletAlumno(String dni) throws AlumnoException, SQLException {
        var alumno= alumnos.findByDni(dni).orElseThrow(()-> new AlumnoException("No existe el alumno con dni " + dni));
        alumnos.delete(alumno.getId());
        return alumno;
    }

//    /**
//     * Exporta todos los alumnos al fichero BackUp
//     */
//    public void exportarDatos(){
//        System.out.println("Exportanto Backup de los Alumnos......");
//        var listOfStudents = alumnos.findAll();
//        var backup = alumnosStorage.save(listOfStudents);
//        if(backup){
//            System.out.println("Datos exportados al BackUp con éxito en: " +  alumnosStorage.getBackupPath() + "\nCon la cantidad de alumnos de: " + listOfStudents.size());
//        }else{
//            System.err.println("Error al exportar al backup. Intentelo denuevo más tarde");
//        }
//
//    }
//
//    /**
//     * Importar todos los alumnos al fichero BackUp
//     */
//    public void importarDatos(){
//        System.out.println("~~~~~~ Importando datos desde el Backup ~~~~~~");
//        System.out.println("Backup encontrado en: " + alumnosStorage.getBackupPath());
//        var listOfStudents = alumnosStorage.load();
//        //Sí la lista actual está llena que la vacíe
//        if(listOfStudents.size() >0){
//            alumnos.deleteAll();
//            for (Alumno alumno : listOfStudents){
//                alumnos.save(alumno);
//            }
//            System.out.println("Datos importados en el sistema con éxito." +
//                    "\nSe han insertado: " + listOfStudents.size() + "Alumn@s");
//        }else {
//            System.err.println("Ha ocurrido un problema al importar los datos desde" + alumnosStorage.getBackupPath() + "Inténtelo denuevo más tarde Gracias! ");
//        }

    }





