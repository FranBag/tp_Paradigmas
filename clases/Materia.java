package TP1_Paradigmas.clases;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import TP1_Paradigmas.usuarios.Alumno;
import TP1_Paradigmas.usuarios.Profesor;

public class Materia {
    private int id_materia;
    private String nombre;
    private Profesor profesor;
    private int curso;
    private int cuatrimestre;
    HashMap<String, String> situacion = new HashMap<String, String>();
    HashMap<String, String> asistencias = new HashMap<String, String>();
    private List<Alumno> alumnos;
    

    public Materia(int id_materia, String nombre, Profesor profesor, int curso, int cuatrimestre){
        alumnos = new ArrayList<>();
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.profesor = profesor;
        this.curso = curso;
        this.cuatrimestre = cuatrimestre;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    
    // Método para inscribir un alumno en la materia
    public void inscribirAlumno(int id_alumno) {
        if (!situacion.containsKey(String.valueOf(id_alumno))) {
            situacion.put(String.valueOf(id_alumno), "Inscripto");
            asistencias.put(String.valueOf(id_alumno), "0");
            System.out.println("Alumno " + id_alumno + " inscripto a la materia " + nombre);
        } else {
            System.out.println("El alumno ya está inscrito en esta materia.");
        }
        public List<Materia> getMaterias() {
        return materias;
    }
}
    }

    // Método para dar de baja a un alumno de la materia
    public void bajaAlumno(int id_alumno) {
        if (situacion.containsKey(String.valueOf(id_alumno))) {
            situacion.remove(String.valueOf(id_alumno));
            asistencias.remove(String.valueOf(id_alumno));
            System.out.println("Alumno " + id_alumno + " dado de baja de la materia " + nombre);
        } else {
            System.out.println("El alumno no está inscrito en esta materia.");
        }
    }

    // Método para cambiar la situación de un alumno
    public void cambiarSituacionAlumno(int id_alumno, String nuevaSituacion) {
        if (situacion.containsKey(String.valueOf(id_alumno))) {
            situacion.put(String.valueOf(id_alumno), nuevaSituacion);
            System.out.println("Situación del alumno " + id_alumno + " cambiada a " + nuevaSituacion);
        } else {
            System.out.println("El alumno no está inscrito en esta materia.");
        }
    }

    // Método para cargar las asistencias de un alumno
    public void cargarAsistencias(int id_alumno, int cantidadAsistencias) {
        if (asistencias.containsKey(String.valueOf(id_alumno))) {
            asistencias.put(String.valueOf(id_alumno), String.valueOf(cantidadAsistencias));
            System.out.println("Asistencias del alumno " + id_alumno + " actualizadas a " + cantidadAsistencias);
        } else {
            System.out.println("El alumno no está inscrito en esta materia.");
        }
    }

    // Método para listar los alumnos inscritos en la materia
    public void listarAlumnos() {
        if (situacion.isEmpty()) {
            System.out.println("No hay alumnos inscritos en la materia " + nombre);
        } else {
            System.out.println("Alumnos inscritos en la materia " + nombre + ":");
            for (String id_alumno : situacion.keySet()) {
                String estado = situacion.get(id_alumno);
                String asistencia = asistencias.get(id_alumno);
                System.out.println("Alumno ID: " + id_alumno + " - Estado: " + estado + " - Inasistencias: " + asistencia);
            }
        }
    }
}
