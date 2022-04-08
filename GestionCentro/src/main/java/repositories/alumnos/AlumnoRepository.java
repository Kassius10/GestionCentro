package repositories.alumnos;

import controllers.DataBaseManager;
import exceptions.AlumnoException;
import models.Alumno;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio de los alumnos.
 */
<<<<<<< HEAD:GestionCentro/src/main/java/repositories/AlumnoRepository.java

public class AlumnoRepository implements IRepository {
    private static AlumnoRepository instance;
    private final DataBaseManager bd;

    private AlumnoRepository(DataBaseManager dataBaseManager){
        this.bd = dataBaseManager;
    }

    public static AlumnoRepository getInstance(DataBaseManager dataBaseManager) {
        if (instance == null) {
            instance = new AlumnoRepository(dataBaseManager);
        }
        return instance;
    }



        /**
         * Devuelve una lista con todos los paises.
         * @return Devuelve la lista de alumnos.
         */
=======
public class AlumnoRepository implements IAlumnoRepository {
    private static AlumnoRepository instance;
    private final TreeMap<Integer, Alumno> alumnos = new TreeMap<>();

    public static AlumnoRepository getInstance() {
        if (instance == null) {
            instance = new AlumnoRepository();
        }
        return instance;
    }

    public int size() {
        return alumnos.size();
    }

    /**
     * Devuelve una lista con todos los paises.
     *
     * @return Devuelve la lista de alumnos.
     */
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4:GestionCentro/src/main/java/repositories/alumnos/AlumnoRepository.java
    @Override
    public List<Alumno> findAll() throws SQLException {
        String query = "SELECT * FROM Alumno";
        bd.open();
        ResultSet result = bd.select(query).orElseThrow(() -> new SQLException("Error al visualizar todos los alumnos "));
        ArrayList<Alumno> alumnos = new ArrayList<>();
        while (result.next()) {
            alumnos.add(

                    new Alumno(
                            result.getInt("id"),
                    result.getString("dni"),
                    result.getString("nombre"),
                    result.getString("apellidos"),
                    result.getString("email"),
                    result.getString("telefono"),
                    result.getBoolean("hasLoseEvaluation"),
                    result.getBoolean("enabled"),
                    result.getObject("fechaMatriculacion", LocalDateTime.class))
                );

        }
        bd.close();
        return alumnos;
    }

    /**
     * Buscar un alumno por su id
     *
     * @param id Id del elemento
     * @return Devuelve el alumno si se encuentra en el repositorio o null si no.
     */
    @Override
<<<<<<< HEAD:GestionCentro/src/main/java/repositories/AlumnoRepository.java
    public Optional<Alumno> findById(Integer id) throws SQLException {
        String query = "SELECT * FROM Alumno Where id = ?";
        bd.open();
        ResultSet result = bd.select(query, id).orElseThrow(() -> new SQLException("No se ha encontrado el Alumno con el id:" + id));
        if (result.next()) {
            Alumno alumno = new Alumno(
                    result.getInt("id"),
                    result.getString("dni"),
                    result.getString("nombre"),
                    result.getString("apellidos"),
                    result.getString("email"),
                    result.getString("telefono"),
                    result.getBoolean("hasLoseEvaluation"),
                    result.getBoolean("enabled"),
                    result.getObject("fechaMatriculacion", LocalDateTime.class));

            bd.close();
            return Optional.of(alumno);
=======
    public Optional<Alumno> findById(Integer id) throws AlumnoException {
        var alumno = alumnos.get(id);
        if (alumno == null) {
            Optional.empty();
            throw new AlumnoException("No existe el alumno con id " + id);
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4:GestionCentro/src/main/java/repositories/alumnos/AlumnoRepository.java
        }

        return Optional.empty();
    }

    /**
     * Función para añadir un alumno al repositorio.
     *
     * @param alumno Alumno que queremos añadir.
     * @return Devuelve el alumno que hemos añadido.
     */
    @Override
<<<<<<< HEAD:GestionCentro/src/main/java/repositories/AlumnoRepository.java
    public Optional<Alumno> save(Alumno alumno) throws SQLException {
        String query = "INSERT INTO Alumno Values(null,?,?,?,?,?,?,?,?)";
        bd.open();
        ResultSet res = bd.insert(query, alumno.getDni(), alumno.getName(), alumno.getSurNames(), alumno.getEmail(),
                alumno.getPhone(), alumno.isHasLoseEvaluation(), alumno.isEnabled(),alumno.getRegistrationDate()).orElseThrow(() -> new SQLException("Error al insertar el Alumno"));

        if(res.first()){
            alumno.setId(res.getInt(1));
            bd.close();
            return Optional.of(alumno);
        }
        return Optional.empty();
=======
    public Optional<Alumno> save(Alumno alumno) {
        this.alumnos.put(alumno.getId(), alumno);
        return Optional.of(alumno);
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4:GestionCentro/src/main/java/repositories/alumnos/AlumnoRepository.java
    }

    /**
     * Función para actualizar un alumno.
     *
     * @param id     Id del elemento que vamos a actualizar.
     * @param alumno Alumno ya modificado que queremos guardar.
     * @return Devuelve el alumno modificado.
     */
    @Override
<<<<<<< HEAD:GestionCentro/src/main/java/repositories/AlumnoRepository.java
    public Optional<Alumno> update(Integer id, Alumno alumno) throws  SQLException {
        this.findById(id).orElseThrow(() -> new SQLException("Error al actualizar el alumno. No se encuentra el alumno con id "+id + "."));
        String query = "UPDATE alumno SET dni = ?, nombre = ?, apellidos = ?, email = ?, telefono = ?, hasLoseEvaluation = ?, enabled = ?, fechaMatriculacion = ?" +
                "WHERE id = ?";
        bd.open();
        var res = bd.update(query, alumno.getDni(), alumno.getName(), alumno.getSurNames(), alumno.getEmail(),
                alumno.getPhone(), alumno.isHasLoseEvaluation(), alumno.isEnabled(), alumno.getRegistrationDate(), id);
        bd.close();
=======
    public Optional<Alumno> update(Integer id, Alumno alumno) {
        this.alumnos.put(id, alumno);
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4:GestionCentro/src/main/java/repositories/alumnos/AlumnoRepository.java
        return Optional.of(alumno);
    }

    /**
     * Función para eliminar un alumno del repositorio.
     *
     * @param id Id del elemento que vamos a eliminar.
     * @return Devuelve el alumno que hemos eliminado.
     */
    @Override
    public Optional<Alumno> delete(Integer id) throws SQLException {
        Alumno alumno = this.findById(id).orElseThrow(() -> new SQLException("Error al eliminar el Alumno con " + id + "no se encuentra en la BBDD"));
        String query = "DELETE FROM pais WHERE id = ?";
        bd.open();
        bd.delete(query, id);
        bd.close();
        return Optional.of(alumno);
    }

    /**
     * Función para buscar un alumno por su dni en el repositorio.
     *
     * @param dni Dni del alumno por el que buscaremos en el repositorio.
     * @return Devuelve el alumno si se encuentra o null si no.
     */
    @Override
<<<<<<< HEAD:GestionCentro/src/main/java/repositories/AlumnoRepository.java
    public Optional<Alumno> findByDni(String dni) throws SQLException {
        String query = "SELECT * FROM Alumno Where dni = ?";
        bd.open();
        ResultSet result = bd.select(query, dni).orElseThrow(() -> new SQLException("No se ha encontrado el Alumno con el dni:" + dni));
        if (result.next()) {
            Alumno alumno = new Alumno(
                    result.getInt("id"),
                    result.getString("dni"),
                    result.getString("nombre"),
                    result.getString("apellidos"),
                    result.getString("email"),
                    result.getString("telefono"),
                    result.getBoolean("hasLoseEvaluation"),
                    result.getBoolean("enabled"),
                    result.getObject("fechaMatriculacion", LocalDateTime.class));

            bd.close();
            return Optional.of(alumno);
=======
    public Optional<Alumno> findByDni(String dni) {
        for (Alumno alumno : this.alumnos.values()) {
            if (alumno.getDni().equals(dni)) {
                return Optional.of(alumno);
            }
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4:GestionCentro/src/main/java/repositories/alumnos/AlumnoRepository.java
        }

        return Optional.empty();
    }

    /**
     * Procedimiento para eliminar todo el repositorio.
     */
    @Override
    public void deleteAll() throws SQLException {
        String query = "DELETE FROM Alumno";
        bd.open();
        bd.delete(query);
        bd.close();

    }
}
