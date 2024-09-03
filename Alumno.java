package TP1_Paradigmas;

public class Alumno extends Usuario{
    
    private Carrera carrera;
    private Materia materias[];


    public Alumno(){
        this.materias = new Materia[5];
    }
}
