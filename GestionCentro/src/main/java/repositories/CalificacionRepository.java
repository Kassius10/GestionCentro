package repositories;

import exceptions.AlumnoException;
import models.Calificacion;
import models.PruebaEvaluacion;
import utils.FicheroMarkdown;
import utils.FormatRounding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class CalificacionRepository {
    private final List<Calificacion> calificaciones = new ArrayList<>();

    public CalificacionRepository() {
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public List<Calificacion> findAll() {
        return this.calificaciones;
    }

    public Calificacion findByDni(String dni) throws AlumnoException {
        return calificaciones.stream()
                .filter(c -> c.getStudent().getDni().equals(dni))
                .findFirst().orElseThrow(() -> new AlumnoException("No se encuentra ningun alumno con dni" + dni));
    }

    public Calificacion save(Calificacion calificacion) {
        calificaciones.add(calificacion);
        return calificacion;
    }

    public void mostrarInforme(PruebaEvaluacion prueba) {
        DoubleSummaryStatistics estadisticas = calificaciones.stream().mapToDouble(Calificacion::getQualification).summaryStatistics();
        System.out.println("\nInforme del resumen de las notas de la prueba");
        System.out.println("----------------------------------------------");
        System.out.println("Media es: " + FormatRounding.redondeo(estadisticas.getAverage()));
        System.out.println("Máxima es: " + estadisticas.getMax());
        System.out.println("Mínima es: " + estadisticas.getMin());

        var notas = estadisticas.getCount();
        var numeroAprobados = calificaciones.stream().filter(a -> a.getQualification() >= 5).count();
        var numeroSuspensos = calificaciones.stream().filter(a -> a.getQualification() < 5).count();

        System.out.println("Porcentaje de aprobados " + FormatRounding.redondeo((100 / notas) * numeroAprobados) + "%");
        System.out.println("Porcentaje de suspensos " + FormatRounding.redondeo((100 / notas) * numeroSuspensos) + "%");

        System.out.println("\nListado de Notas de Alumnos.");

        var lista = calificaciones.stream().sorted(Comparator.comparingDouble(Calificacion::getQualification).reversed());
        lista.forEach(c -> {
            System.out.println("Alumno: " + c.getStudent().getName() + " - Nota: " + c.getQualification());
        });
        FicheroMarkdown f = new FicheroMarkdown(prueba);
        f.saveNotas();
    }
}
