package utils;

import models.Calificacion;
import models.PruebaEvaluacion;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/**
 * Clase util para crear un fichero Markdown
 */
public class FicheroMarkdown {
    private final String appPath = System.getProperty("user.dir");
    private final PruebaEvaluacion prueba;
    private final String nameFile = "personas.md";
    private final String dir;
    private Path filePath;


    /**
     * Constructor de la clase con parametros
     *
     * @param prueba Prueba que necesitaremos para sacar la información
     * @param dir    Ruta de la carpeta donde se creara el fichero
     */
    public FicheroMarkdown(PruebaEvaluacion prueba, String dir) {
        this.dir = dir;
        this.prueba = prueba;
        init();

    }

    /**
     * Método de iniciar, comprobará si el directorio existe o no para crearlo y crea la ruta
     */
    private void init() {
        File directory = new File(this.dir);
        if (!directory.exists()) {
            directory.mkdir();
        }
        this.filePath = Paths.get(appPath + File.separator + dir + File.separator + nameFile);
        System.out.println("Importando resumen en: " + filePath);
    }

    /**
     * Método para almacenar las notas en el fichero
     */
    public void saveNotas() {
        File fichero = null;
        PrintWriter f = null;
        try {
            fichero = new File(String.valueOf(filePath));
            f = new PrintWriter(new FileWriter(String.valueOf(filePath)));
            crearLineas(f);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (f != null) {
                f.close();
            }
        }
    }

    /**
     * Método que crea las lineas del fichero
     *
     * @param f Fichero abierto a escritura.
     */
    private void crearLineas(PrintWriter f) {
        //Datos que necesitaremos para almacenar en el fichero.
        var iniTime = System.currentTimeMillis();
        var calificaciones = prueba.getQualifications().getCalificaciones().stream()
                .sorted(Comparator.comparing(Calificacion::getQualification).reversed()).collect(Collectors.toList());
        DoubleSummaryStatistics estadisticas = calificaciones.stream().mapToDouble(Calificacion::getQualification).summaryStatistics();
        var notas = estadisticas.getCount();
        var numeroAprobados = calificaciones.stream().filter(a -> a.getQualification() >= 5).count();
        var numeroSuspensos = calificaciones.stream().filter(a -> a.getQualification() < 5).count();
        var fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));


        //Impresión de datos en el fichero.
        f.println("# **RESULTADO DE LA PRUEBA " + prueba.getCategory().getName().toUpperCase() + ": "
                + prueba.getDescription().toUpperCase() + "**");
        f.println("---");
        f.println("&nbsp;");
        f.println("## *Notas del alumnado:*");
        f.println("|Nombre Alumno|Apellidos|Nota de Prueba|");
        f.println("|-|-|-|");
        for (Calificacion calificacion : calificaciones) {
            f.println("|" + calificacion.getStudent().getName().toUpperCase() + "|" +
                    calificacion.getStudent().getSurNames().toUpperCase() + "|" + calificacion.getQualification() + "|");
        }
        f.println("&nbsp;");
        f.println(" ");
        f.println("---");
        f.println("## *ESTADISTICAS*:");
        f.println("#### - NOTA MAXIMA: " + estadisticas.getMax());
        f.println("#### - NOTA MINIMA: " + estadisticas.getMin());
        f.println("#### - MEDIA DE NOTAS: " + FormatRounding.redondeo(estadisticas.getAverage()));
        f.println("#### *Porcentaje de aprobados*: " + FormatRounding.redondeo(((100 / notas) * numeroAprobados)) + "%");
        f.println("#### *Porcentaje de suspensos*: " + FormatRounding.redondeo(((100 / notas) * numeroSuspensos)) + "%");
        f.println("&nbsp;");
        f.println(" ");

        try {
            Thread.sleep(3450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var finalTime = System.currentTimeMillis();
        var seconds = Math.abs((iniTime - finalTime) / 1000);
        f.println("Informe generado el dia " + fecha + " a las " + time + " en " + seconds + " segundos");
    }
}
