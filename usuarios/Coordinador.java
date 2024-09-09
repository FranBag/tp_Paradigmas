package TP1_Paradigmas.usuarios;

import java.util.ArrayList;

import TP1_Paradigmas.clases.Carrera;

public class Coordinador extends Usuario{
    private Carrera carrera;

    public Coordinador(int n_legajo, String nombre, String apellido,
    String email, String sexo, String n_telefono, int dni) {
        super(n_legajo, nombre, apellido, email, sexo, n_telefono, dni);
    }

    public Coordinador(){
        
    }

    //getter y setter de carrera
    public Carrera getCarrera(){
        return carrera;
    }

    public void setCarrera(Carrera carrera){
        this.carrera = carrera;
    }


    public void asignarProfesor(int n_legajo, int id_materia){

    }

    public void verMaterias(){

    }

    public void verAlumnos(){

    }

}

