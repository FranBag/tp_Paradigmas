package TP1_Paradigmas.clases;

import java.util.HashMap;

import TP1_Paradigmas.usuarios.Profesor;

public class Materia {
    private int id_materia;
    private String nombre;
    private Profesor profesor;
    private int curso;
    private int cuatrimestre;
    HashMap<String, String> situacion = new HashMap<String, String>();
    HashMap<String, String> asistencias = new HashMap<String, String>();

    public void inscribirAlumno(int id_alumno){

    }

    public void bajaAlumno(int n_legajo){

    }

    public void cambiarSituacionAlumno(int id_alumno){

    }

    public void cargarAsistencias(){

    }
}