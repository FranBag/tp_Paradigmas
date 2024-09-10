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
    HashMap<String, Double> asistencias = new HashMap<String, Double>();
    private List<Alumno> alumnos;

    public Materia(int id_materia, String nombre, int curso, int cuatrimestre){
        alumnos = new ArrayList<>();
        this.id_materia = id_materia;
        this.nombre = nombre;
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

    public Double getAsistenciaByNLegajo(int n_legajo) {
        String legajo = String.valueOf(n_legajo);
        if (asistencias.containsKey(legajo)) {
            return asistencias.get(legajo);
        } else {
            System.out.println("El alumno con legajo " + n_legajo + " no está inscrito en esta materia.");
            return null; // Si el alumno no está inscrito, se devuelve null
        }
    }
    

    public void inscribirAlumno(Alumno alumno) {
        String n_legajo = String.valueOf(alumno.getN_legajo());
        if (!situacion.containsKey(n_legajo)) {
            situacion.put(n_legajo, "Inscripto");
            asistencias.put(n_legajo, 0.0); // Iniciar con 0% de asistencia
            alumnos.add(alumno);
            System.out.println("Alumno " + n_legajo + " inscripto a la materia " + nombre);
        } else {
            System.out.println("El alumno ya está inscrito en esta materia.");
        }
    }

    public void cambiarSituacionAlumno(int id_alumno, String nuevaSituacion) {
        if (situacion.containsKey(String.valueOf(id_alumno))) {
            situacion.put(String.valueOf(id_alumno), nuevaSituacion);
            System.out.println("Situación del alumno " + id_alumno + " cambiada a " + nuevaSituacion);
        } else {
            System.out.println("El alumno no está inscrito en esta materia.");
        }
    }

    public void cargarAsistencias(int id_alumno, double porcentajeAsistencias) {
        if (asistencias.containsKey(String.valueOf(id_alumno))) {
            asistencias.put(String.valueOf(id_alumno), porcentajeAsistencias);
            System.out.println("Asistencias del alumno " + id_alumno + " actualizadas a " + porcentajeAsistencias + "%");
            actualizarSituacionAlumno(id_alumno); // Actualizar la situación en función de la asistencia
        } else {
            System.out.println("El alumno no está inscrito en esta materia.");
        }
    }

    private void actualizarSituacionAlumno(int id_alumno) {
        double asistencia = asistencias.get(String.valueOf(id_alumno));
        if (asistencia < 75.0) {
            situacion.put(String.valueOf(id_alumno), "Libre");
        } else {
            situacion.put(String.valueOf(id_alumno), "Regular");
        }
    }

    public List<String[]> listarAlumnos() {
        List<String[]> listaAlumnos = new ArrayList<>();
        if (situacion.isEmpty()) {
            System.out.println("No hay alumnos inscritos en la materia " + nombre);
        } else {
            for (String id_alumno : situacion.keySet()) {
                String estado = situacion.get(id_alumno);
                double asistencia = asistencias.get(id_alumno);
                String[] alumnoInfo = {id_alumno, asistencia + "%", estado};
                listaAlumnos.add(alumnoInfo);
            }
        }
        return listaAlumnos;
    }
}
