package TP1_Paradigmas.usuarios;

import java.util.ArrayList;

import TP1_Paradigmas.clases.Carrera;

public class Coordinador extends Usuario{
    private Carrera carrera;

    public Coordinador(int n_legajo, String nombre, String apellido,
    String email, String sexo, int n_telefono, int dni) {
        super(n_legajo, nombre, apellido, email, sexo, n_telefono, dni);
    }

    public Coordinador(){
        
    }

    public void asignarProfesor(int n_legajo, int id_materia){

    }

    public void verMaterias(){

    }

    public void verAlumnos(){

    }

}

