package TP1_Paradigmas.usuarios;

import TP1_Paradigmas.clases.Materia;
import TP1_Paradigmas.clases.Universidad;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario{
    private Universidad universidad;
    private List<Materia> materias;

    
    public Profesor(int n_legajo, String nombre, String apellido,
    String email, String sexo, String n_telefono, int dni, Universidad universidad) {
        super(n_legajo, nombre, apellido, email, sexo, n_telefono, dni);
        this.universidad = universidad;
        universidad.añadirProfesor(this);
        materias = new ArrayList<>();
    }

    public Profesor(){
        materias = new ArrayList<>();
    }

    // Setter y Getter de universidad
    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        universidad.añadirProfesor(this);
        this.universidad = universidad;
    }

    public Materia[] getMaterias(){
        return materias.toArray(new Materia[0]);
    }

    public Materia getMateriaByNombre(String nombre){
        for(int i = 0; i < materias.size(); i++){
            if(materias.get(i).getNombre() == nombre){
                return materias.get(i);
            }
        }
        return null; //si no se encuentra una materia con ese nombre devuelve null
    }

    public void setMaterias(Materia materia){
        materias.add(materia);
    }

    public void gestionarSituacionAlumno(Materia materia, int id_alumno, String situacion){
        materia.cambiarSituacionAlumno(id_alumno, situacion);
    }

    public void gestionarAsistencia(Materia materia, int id_alumno, double porcentajeAsistencias){
        materia.cargarAsistencias(id_alumno, porcentajeAsistencias);
    }

    public String[][] verAlumnos(Materia materia) {

        Alumno[] alumnos = materia.getAlumnos();
        
        if(alumnos == null || alumnos.length == 0) {
            return null;
        }

        String[][] datosAlumnos = new String[alumnos.length][5];
        
        for (int i = 0; i < alumnos.length; i++) {
            Alumno alumno = alumnos[i];
            String nombre = alumno.getNombre();
            String apellido = alumno.getApellido();
            String nLegajo = String.valueOf(alumno.getN_legajo());
            Double asistencia = materia.getAsistenciaByNLegajo(alumno.getN_legajo());
            String situacion = materia.getSituacionByNLegajo(alumno.getN_legajo());
    
            datosAlumnos[i][0] = nLegajo;
            datosAlumnos[i][1] = nombre;
            datosAlumnos[i][2] = apellido;
            datosAlumnos[i][3] = asistencia != null ? asistencia.toString() + "%" : "Sin datos";
            datosAlumnos[i][4] = situacion != null ? situacion : "Sin datos";
        }
    
        return datosAlumnos;
    }

    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApellido();
    }
}    
