package TP1_Paradigmas.usuarios;

import TP1_Paradigmas.clases.Carrera;
import TP1_Paradigmas.clases.Materia;

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
        this. carrera = carrera;
    }

    public void asignarProfesor(int id_materia, Profesor profesor) {
        carrera.getMateriaByID(id_materia).setProfesor(profesor);
        System.out.println("Profesor asignado a la materia con ID: " + id_materia);
    }

}
