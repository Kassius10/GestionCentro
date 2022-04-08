<<<<<<< HEAD


import controllers.DataBaseManager;
import exceptions.AlumnoException;
import utils.ApplicationProperties;
import views.MainView;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

=======
import views.MainView;

>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
/**
 * Proyecto Gestión del centro
 *
 * @author Daniel Carmona, Jeremy Ramos
 * @version 1.0
 */
public class Main {
<<<<<<< HEAD
    public static void main(String[] args) throws SQLException {


        System.out.println("Hola mundo");
        checkServer();
        MainView mainView = new MainView();
        mainView.menu();
    }

    private static void checkServer() {
        System.out.println("Comprobamos la conexión al Servidor BD");
        DataBaseManager controller = DataBaseManager.getInstance();
        try {
            controller.open();
            Optional<ResultSet> rs = controller.select("SELECT 'Hello world'");
            if (rs.isPresent() && rs.get().next()) {
                controller.close();
                System.out.println("Conexión con la Base de Datos realizada con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
            System.exit(1);
        }
=======
    public static void main(String[] args) {
        MainView view = new MainView();
        MainView.menu();
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
    }
}



