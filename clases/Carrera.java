package TP1_Paradigmas.clases;

import java.util.ArrayList;
import java.util.List;

import TP1_Paradigmas.usuarios.Coordinador;
import TP1_Paradigmas.usuarios.Alumno;

public class Carrera {
    private int id_carrera;
    private String nombre;
    private int duracion;
    private int precio_inscripcion;
    private int precio_cuota;
    private Coordinador coordinador;
    private List<Materia> materias;
    private List<Alumno> alumnos;


    //constructor de carrera
    public Carrera(int id_carrera, String nombre, int duracion,
    int precio_inscripcion, int precio_cuota){
        materias = new ArrayList<>();
        alumnos = new ArrayList<>();
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio_inscripcion = precio_inscripcion;
        this.precio_cuota = precio_cuota;
    }

    //setters y getters
    public int getId_carrera() {
        return id_carrera;
    }
    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public int getPrecio_inscripcion() {
        return precio_inscripcion;
    }
    public void setPrecio_inscripcion(int precio_inscripcion) {
        this.precio_inscripcion = precio_inscripcion;
    }
    public int getPrecio_cuota() {
        return precio_cuota;
    }
    public void setPrecio_cuota(int precio_cuota) {
        this.precio_cuota = precio_cuota;
    }

    
    //matriculacion de alumnos
    public void matricularAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }

    public void eliminarAlumno(int n_legajo){
        for(int i = 0; i < alumnos.size(); i++){
            if(alumnos.get(i).getN_legajo() == n_legajo){
                alumnos.remove(i);
                break;
            }
        }
    }

    public void listarAlumnos(){
        for(int i = 0; i < alumnos.size(); i++){
            System.out.println(alumnos.get(i).getNombre());
        }
    }

    public void listarMaterias(){
        for(int i = 0; i < materias.size(); i++){
            System.out.println(materias.get(i).getNombre());
        }
    }

}
