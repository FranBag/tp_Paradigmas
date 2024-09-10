package TP1_Paradigmas.usuarios;

import TP1_Paradigmas.clases.Carrera;
import TP1_Paradigmas.clases.Materia;
import TP1_Paradigmas.clases.Universidad;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {
    private Carrera carreraMatriculada;
    private List<Materia> materiasInscriptas;
    private Universidad universidad;

    public Alumno(int n_legajo, String nombre, String apellido, String email,
                  String sexo, String n_telefono, int dni, Universidad universidad) {
        super(n_legajo, nombre, apellido, email, sexo, n_telefono, dni);
        this.universidad = universidad;
        this.materiasInscriptas = new ArrayList<>();
    }

    public Alumno() {
    }

    // Setter y Getter de universidad
    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    // Método para inscribir al alumno en una carrera
    public void inscribirCarrera(int id_carrera) {
        Carrera carreraInscribir = universidad.getCarreraByID(id_carrera);
        carreraInscribir.matricularAlumno(this);
        this.carreraMatriculada = carreraInscribir;
    }

    // Método para inscribir al alumno en una materia
    public void inscribirMateria(int id_materia) {
        if (carreraMatriculada != null) {
            Materia materia = buscarMateriaPorID(id_materia);
            if (materia != null) {
                materia.inscribirAlumno(this);
                if (!materiasInscriptas.contains(materia)) {
                    materiasInscriptas.add(materia);
                    System.out.println("Alumno " + getNombre() + " inscrito en la materia " + materia.getNombre());
                } else {
                    System.out.println("El alumno ya está inscrito en esta materia.");
                }
            } else {
                System.out.println("La materia con ID " + id_materia + " no existe.");
            }
        } else {
            System.out.println("El alumno no está matriculado en ninguna carrera.");
        }
    }

    // Método para ver la asistencia del alumno en una materia
    public void verAsistencia(int id_materia) {
        if (carreraMatriculada != null) {
            Materia materia = buscarMateriaPorID(id_materia);
            if (materia != null && materiasInscriptas.contains(materia)) {
                String asistencia = String.valueOf(materia.getAsistenciaByNLegajo(getN_legajo()));
                System.out.println("Asistencias del alumno en " + materia.getNombre() + ": " + asistencia);
            } else {
                System.out.println("El alumno no está inscrito en esta materia o la materia no existe.");
            }
        } else {
            System.out.println("El alumno no está matriculado en ninguna carrera.");
        }
    }

    // Método para buscar una materia por ID
    private Materia buscarMateriaPorID(int id_materia) {
        if (carreraMatriculada != null) {
            for (Materia materia : carreraMatriculada.listarMaterias()) {
                if (materia.getId_materia() == id_materia) {
                    return materia;
                }
            }
        }
        return null;
    }

    public Carrera getCarreraMatriculada() {
        return carreraMatriculada;
    }

    public List<Materia> getMateriasInscriptas() {
        return materiasInscriptas;
    }
}