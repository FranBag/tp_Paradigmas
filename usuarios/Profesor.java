package TP1_Paradigmas.usuarios;

import java.util.ArrayList;
import java.util.List;

import TP1_Paradigmas.clases.Materia;

public class Profesor extends Usuario{
    private List<Materia> materias;

    
    public Profesor(int n_legajo, String nombre, String apellido,
    String email, String sexo, int n_telefono, int dni) {
        super(n_legajo, nombre, apellido, email, sexo, n_telefono, dni);
        materias = new ArrayList<>();
    }

    public void gestionarSituacionAlumno(int id_alumno, String situacion){

    }

    public void gestionarAsistencia(int id_alumno, int porcentaje){
    }
}
