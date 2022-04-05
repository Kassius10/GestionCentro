package services;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Alumno;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StorageAlumnosJsonFile implements IStorageAlumnos{
        private final Path currentRelativePath = Paths.get("");
        private final String rutaRelativa = currentRelativePath.toAbsolutePath().toString();
        private final String directory= rutaRelativa + File.separator + "Alumnos";
        private final String studentsFile = directory + File.separator + "backup.json";


        /**
         * Método el cual inicia el directorio con los archivos respectivos en JSON
         */

        public StorageAlumnosJsonFile(){
                init();
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
         * Función que guarda dentro del fichero la lista de los alumnos dentro del archivo JSON
         * Escribimos dentro del fichero JSON
         * @param alumnos Lista de alumnos a introducir
         * @return Sí se ha guardado la lista.
         */
        @Override
        public boolean save(List<Alumno> alumnos) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                boolean res = false;
                PrintWriter g = null;
                try {
                        g = new PrintWriter(new FileWriter(studentsFile));
                        g.println(gson.toJson(alumnos));
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
        public List<Alumno> load() {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                List<Alumno> listOfStudents = new ArrayList<>();
                Reader reader = null;
                try {
                      reader = Files.newBufferedReader(Paths.get(studentsFile));
                     //En este caso aplicaremos la lectura de datos de forma dinámicamente. Utilizamos el TypeToken
                      listOfStudents = gson.fromJson(reader, new TypeToken<List<Alumno>>(){}.getType());
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

        return listOfStudents;
        }


        /**
         * Función que nos devuelve el patron de ruta de nuestro fichero
         * @return Ruta en donde se encuentra el
         */
        @Override
        public String getBackupPath() {
                return studentsFile;
        }

}

