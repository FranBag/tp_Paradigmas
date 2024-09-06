package TP1_Paradigmas.clases;

import TP1_Paradigmas.usuarios.Coordinador;

public class Carrera {
    private int id_carrera;
    private String nombre;
    private int duracion;
    private int precio_inscripcion;
    private int precio_cuota;
    private Coordinador coordinador;
    private Materia materia;


    public Carrera(int id_carrera, String nombre, int duracion,
    int precio_inscripcion, int precio_cuota){
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio_inscripcion = precio_inscripcion;
        this.precio_cuota = precio_cuota;
    }

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
    public Materia getMateria() {
        return materia;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
