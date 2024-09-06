package TP1_Paradigmas.usuarios;

import TP1_Paradigmas.clases.Carrera;
import TP1_Paradigmas.clases.Materia;

public class Alumno extends Usuario{
    
    private Carrera carrera;
    private Materia materias[];


    public Alumno(){
        this.materias = new Materia[5];
    }
}
