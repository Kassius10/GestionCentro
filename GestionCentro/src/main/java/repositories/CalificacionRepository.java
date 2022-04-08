package repositories;

import exceptions.AlumnoException;
import models.Calificacion;
import utils.FormatRounding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Clase repositorio de calificaciones
 */
public class CalificacionRepository {
    private final List<Calificacion> calificaciones = new ArrayList<>();

    /**
     * Constructor sin parametros
     */
    public CalificacionRepository() {
    }

    /**
     * Getter del repositorio de calificaciones
     *
     * @return devuelve el repositorio
     */
    public List<Calificacion> findAll() {
        return this.calificaciones;
    }

    /**
     * Función para buscar una calificacion por dni
     *
     * @param dni Dni que se requiere
     * @return Devuelve la calificacion
     * @throws AlumnoException Si no existe ninguna calificacion con dicho dni
     */
    public Calificacion findByDni(String dni) throws AlumnoException {
        return calificaciones.stream()
                .filter(c -> c.getStudent().getDni().equals(dni))
                .findFirst().orElseThrow(() -> new AlumnoException("No se encuentra ningun alumno con dni" + dni));
    }

    /**
     * Función para añadir calificaciones al repositorio
     *
     * @param calificacion Calificación que queremos añadir
     * @return Devuelve la califiacion añadida
     */
    public Calificacion save(Calificacion calificacion) {
        calificaciones.add(calificacion);
        return calificacion;
    }

    /**
     * Procedimiento que muestra un informe del contenido de las calificaciones
     */
    public void mostrarInforme() {
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
        lista.forEach(c -> System.out.println("Alumno: " + c.getStudent().getName() + " - Nota: " + c.getQualification()));

    }

}
