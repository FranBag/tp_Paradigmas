package TP1_Paradigmas.usuarios;

import TP1_Paradigmas.clases.Materia;
import TP1_Paradigmas.clases.Universidad;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario{
    private List<Materia> materias;
    private Materia materia;

    
    public Profesor(int n_legajo, String nombre, String apellido,
    String email, String sexo, String n_telefono, int dni) {
        super(n_legajo, nombre, apellido, email, sexo, n_telefono, dni);
        materias = new ArrayList<>();
    }

    public Profesor(){
        
    }

    public void gestionarSituacionAlumno(int id_alumno, String situacion){
        materia.cambiarSituacionAlumno(id_alumno, situacion);
    }

    public void verAlumnos(int id_alumno, int porcentaje){
        List<String[]> alumnos = materia.listarAlumnos();
        
        for (String[] alumno : alumnos) {
            System.out.println("ID: " + alumno[0] + ", Asistencia: " + alumno[1] + ", Estado: " + alumno[2]);
        }
    }

    public void gestionarAsistencia(int id_alumno, double porcentajeAsistencias){
        materia.cargarAsistencias(id_alumno, porcentajeAsistencias);
    }
}
