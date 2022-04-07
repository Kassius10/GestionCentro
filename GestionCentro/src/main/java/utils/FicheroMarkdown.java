package utils;

import models.Calificacion;
import models.PruebaEvaluacion;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class FicheroMarkdown {
    private final String appPath = System.getProperty("user.dir");
    private final String dir = "data";
    private final String personasFile = dir + File.separator + "personas.md";
    private final Path filePath = Paths.get(appPath + File.separator + personasFile);
    private final PruebaEvaluacion prueba;


    public FicheroMarkdown(PruebaEvaluacion prueba) {
        init();
        this.prueba = prueba;
    }

    private void init() {
        File directory = new File(this.dir);
        if (!directory.exists()) {
            directory.mkdir();
        }

        System.out.println("Loading data from: " + filePath);
    }

    public void saveNotas() {
        File fichero = null;
        PrintWriter f = null;
        try {
            fichero = new File(personasFile);
            f = new PrintWriter(new FileWriter(personasFile));

            crearLineas(f);


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (f != null) {
                f.close();
            }
        }
    }

    private void crearLineas(PrintWriter f) {
        var calificaciones = prueba.getQualifications().getCalificaciones().stream()
                .sorted(Comparator.comparing(Calificacion::getQualification).reversed()).collect(Collectors.toList());
        DoubleSummaryStatistics estadisticas = calificaciones.stream().mapToDouble(Calificacion::getQualification).summaryStatistics();
        var notas = estadisticas.getCount();
        var numeroAprobados = calificaciones.stream().filter(a -> a.getQualification() >= 5).count();
        var numeroSuspensos = calificaciones.stream().filter(a -> a.getQualification() < 5).count();

        f.println("# **RESULTADO DE LA PRUEBA " + prueba.getCategory().getName().toUpperCase() + ": "
                + prueba.getDescription().toUpperCase() + "**");
        f.println("---");
        f.println("&nbsp;");
        f.println("## *Notas del alumnado:*");
        f.println("|Nombre Alumno|Apellidos|Nota de Prueba|");
        f.println("|-|-|-|");
        for (Calificacion calificacion : calificaciones) {
            f.println("|" + calificacion.getStudent().getName().toUpperCase() + "|" +
                    calificacion.getStudent().getSurNames() + "|" + calificacion.getQualification() + "|");
        }
        f.println("&nbsp;");
        f.println(" ");
        f.println("---");
        f.println("## *ESTADISTICAS*:");
        f.println("#### - NOTA MAXIMA: " + estadisticas.getMax());
        f.println("#### - NOTA MINIMA: " + estadisticas.getMin());
        f.println("#### - MEDIA DE NOTAS: " + FormatRounding.redondeo(estadisticas.getAverage()));
        f.println("#### *Porcentaje de aprobados*: " + FormatRounding.redondeo((100 / notas) * numeroAprobados) + "%");
        f.println("#### *Porcentaje de suspensos*: " + FormatRounding.redondeo((100 / notas) * numeroSuspensos) + "%");
        f.println("&nbsp;");
        f.println(" ");
        f.println("Informe generado el dia 05/10/2021 a las 12:14:34 en 7,45 segundos");
    }
}
