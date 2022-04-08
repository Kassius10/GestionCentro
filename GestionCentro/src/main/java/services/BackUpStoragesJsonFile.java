package services;
<<<<<<< HEAD
=======

>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.BackUp;

<<<<<<< HEAD

=======
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BackUpStoragesJsonFile implements IBackUpStorage {

<<<<<<< HEAD
        private static BackUpStoragesJsonFile instance;

        private final Path currentRelativePath = Paths.get("");
        private final String rutaRelativa = currentRelativePath.toAbsolutePath().toString();
        private final String directory= rutaRelativa + File.separator + "BackUp";
        private final String backupFile = directory + File.separator + "backup.json";


        /**
         * Método el cual inicia el directorio con los archivos respectivos en JSON
         */

        public BackUpStoragesJsonFile(){
                init();
        }



        public static BackUpStoragesJsonFile getInstance(){
                if (instance == null){
                        instance = new BackUpStoragesJsonFile();
                }
                return instance;
        }


        /**
         * Configuración de inicio de nuestro Json
         * Donde creamos el directorio que otra opción es hacerla con mkdir.
         */
        private void init() {
                Path path = Paths.get(directory);
                if(!Files.exists(path)){
                        try{
                            Files.createDirectories(path);
                        }catch(IOException e){
                                System.err.println("Error: " + e.getMessage());
                        }
                }
        }


        /**
         * Función que guarda dentro del fichero el conjunto de datos dentro del archivo JSON
         * Escribimos dentro del fichero JSON
         * @param backup Conjunto de datos a introducir
         * @return Sí se ha guardado la lista.
         */
        @Override
        public boolean save(BackUp backup) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                boolean res = false;
                PrintWriter g = null;
                try {
                        g = new PrintWriter(new FileWriter(backupFile));
                        g.println(gson.toJson(backup));
                        res= true;
                }catch (Exception e){
                        System.err.println("Error: " + e.getMessage());

                }finally {
                        if (g != null){
                                g.close();
                        }

                }
                return res;
        }



        /**
         * Función que nos lee el fichero alumnos.json y lo cargará en nuestro programa
         * @return la lista de los alumnos sacados desde el fichero en formato json
         */
        @Override
        public BackUp load() {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                BackUp backup = null;
                Reader reader = null;
                try {
                      reader = Files.newBufferedReader(Paths.get(backupFile));
                     //En este caso aplicaremos la lectura de datos de forma dinámicamente. Utilizamos el TypeToken
                      backup = gson.fromJson(reader, new TypeToken<BackUp>(){}.getType());
                }catch (Exception e){
                        System.err.println("Error: " + e.getMessage());

                }finally {
                        if (reader != null){
                                try{
                                        reader.close();
                                }catch (IOException e){
                                        System.err.println("Error: " + e.getMessage());
                                }
                        }

                }

        return backup ;
        }


        /**
         * Función que nos devuelve el patron de ruta de nuestro fichero
         * @return Ruta en donde se encuentra el
         */
        @Override
        public String getBackupPath() {
                return backupFile;
        }
=======
    private static BackUpStoragesJsonFile instance;

    private final Path currentRelativePath = Paths.get("");
    private final String rutaRelativa = currentRelativePath.toAbsolutePath().toString();
    private final String directory = rutaRelativa + File.separator + "BackUp";
    private final String backupFile = directory + File.separator + "backup.json";


    /**
     * Método el cual inicia el directorio con los archivos respectivos en JSON
     */

    public BackUpStoragesJsonFile() {
        init();
    }


    public static BackUpStoragesJsonFile getInstance() {
        if (instance == null) {
            instance = new BackUpStoragesJsonFile();
        }
        return instance;
    }


    /**
     * Configuración de inicio de nuestro Json
     * Donde creamos el directorio que otra opción es hacerla con mkdir.
     */
    private void init() {
        Path path = Paths.get(directory);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }


    /**
     * Función que guarda dentro del fichero el conjunto de datos dentro del archivo JSON
     * Escribimos dentro del fichero JSON
     *
     * @param backup Conjunto de datos a introducir
     * @return Sí se ha guardado la lista.
     */
    @Override
    public boolean save(BackUp backup) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        boolean res = false;
        PrintWriter g = null;
        try {
            g = new PrintWriter(new FileWriter(backupFile));
            g.println(gson.toJson(backup));
            res = true;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        } finally {
            if (g != null) {
                g.close();
            }

        }
        return res;
    }


    /**
     * Función que nos lee el fichero alumnos.json y lo cargará en nuestro programa
     *
     * @return la lista de los alumnos sacados desde el fichero en formato json
     */
    @Override
    public BackUp load() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BackUp backup = null;
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(backupFile));
            //En este caso aplicaremos la lectura de datos de forma dinámicamente. Utilizamos el TypeToken
            backup = gson.fromJson(reader, new TypeToken<BackUp>() {
            }.getType());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }

        }

        return backup;
    }


    /**
     * Función que nos devuelve el patron de ruta de nuestro fichero
     *
     * @return Ruta en donde se encuentra el
     */
    @Override
    public String getBackupPath() {
        return backupFile;
    }
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

}

