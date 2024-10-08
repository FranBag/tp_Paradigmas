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
    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public Materia getMateriaByID(int id_materia){
        for(int i = 0; i < materias.size(); i++){
            if(materias.get(i).getId_materia() == id_materia){
                return materias.get(i);
            }
        }
        return null; //si no se encuentra una materia con ese id devuelve null
    }

    public Materia getMateriaByNombre(String nombre){
        for(int i = 0; i < materias.size(); i++){
            if(materias.get(i).getNombre() == nombre){
                return materias.get(i);
            }
        }
        return null; //si no se encuentra una materia con ese nombre devuelve null
    }

    //matriculacion de alumnos
    public void matricularAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }

    public void eliminarAlumno(int n_legajo_alumno){
        for(int i = 0; i < alumnos.size(); i++){
            if(alumnos.get(i).getN_legajo() == n_legajo_alumno){
                alumnos.remove(i);
                break;
            }
        }
    }

    public void crearMateria(int id_materia, String nombre, int curso, int cuatrimestre){
        Materia materianueva = new Materia(id_materia, nombre, curso, cuatrimestre);
        materias.add(materianueva);
    }

    public Alumno[] listarAlumnos(){
        return alumnos.toArray(new Alumno[0]);
        // int tamaño_alumnos = alumnos.size();
        // String[][] lista_alumnos = new String[tamaño_alumnos][6];
        // for(int i = 0; i < tamaño_alumnos; i++){
        //     lista_alumnos[i][0] = String.valueOf(alumnos.get(i).getDni());
        //     lista_alumnos[i][1] = String.valueOf(alumnos.get(i).getN_legajo());
        //     lista_alumnos[i][2] = alumnos.get(i).getNombre();
        //     lista_alumnos[i][3] = alumnos.get(i).getApellido();
        //     lista_alumnos[i][4] = alumnos.get(i).getEmail();
        //     lista_alumnos[i][5] = alumnos.get(i).getN_telefono();
        // }
        // return lista_alumnos;
    }

    public Materia[] listarMaterias(){
        return materias.toArray(new Materia[0]);
    }

}
