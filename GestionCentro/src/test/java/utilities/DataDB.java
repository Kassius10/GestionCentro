package utilities;
import controllers.DataBaseManager;
import models.Alumno;
import models.Categories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DataDB {

    public static void insertAlumno(Alumno alumno) throws SQLException {
        String query = "INSERT INTO Alumno Values(null,?,?,?,?,?,?,?,?)";
        DataBaseManager bd = DataBaseManager.getInstance();
        bd.open();
        ResultSet res = bd.insert(query, alumno.getDni(), alumno.getName(), alumno.getSurNames(), alumno.getEmail(),
                alumno.getPhone(), alumno.isHasLoseEvaluation(), alumno.isEnabled(),alumno.getRegistrationDate()).orElseThrow(() -> new SQLException("Error al insertar el Alumno"));

        if(res.first()){
            alumno.setId(res.getInt(1));
            bd.close();
        }
        bd.close();
    }

    public static void insertCategory(Categories category) throws SQLException {

        String query = "INSERT INTO Categoria VALUES (?)";
        DataBaseManager bd = DataBaseManager.getInstance();
        ResultSet result = bd.insert(query, category.getName()).orElseThrow(() -> new SQLException("Error al insertar la categoría"));

        if (result.first()) {
            category.setId(result.getInt(1));
            bd.close();
        }
        bd.close();
    }
}

//    public static void insertAcuerdoTest(Acuerdo acuerdoTest) throws SQLException {
//        // OJO pongo null en el primer parámetro porque no inserto el ID, este se genera automático. Mira el DBMAnager
//        String query = "INSERT INTO acuerdo VALUES (null, ?, ?, ?)";
//        DataBaseManager db = DataBaseManager.getInstance();
//        // Es una transacción, por lo que si falla alguna de las dos, se cancela todo
//        db.open();
//        db.beginTransaction();
//        ResultSet res = db.insert(query, acuerdoTest.getNombre(), acuerdoTest.getFecha(), acuerdoTest.getAportacion())
//                .orElseThrow(() -> new SQLException("Error al insertar acuerdo"));
//
//        // Para obtener su ID que ha generado la BD
//        if (res.first()) {
//            acuerdoTest.setId(res.getInt(1));
//            // Ahora salvamos toda las lineas de acuerdo...
//            for (LineaAcuerdo linea : acuerdoTest.getLineas()) {
//                query = "INSERT INTO linea_acuerdo VALUES (?, ?, ?, ?)";
//                db.insert(query, acuerdoTest.getId(), linea.getPais().getId(), linea.getAño(), linea.getSubvencion())
//                        .orElseThrow(() -> new SQLException("Error al insertar linea de acuerdo"));
//            }
//
//            // Y finalmente cerramos la conexión y devolvemos el acuerdo
//            db.commit();
//            db.close();
//        }
//        db.rollback();
//    }
//}
