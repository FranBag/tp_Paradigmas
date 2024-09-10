package TP1_Paradigmas.clases;

import java.util.ArrayList;
import java.util.List;

import TP1_Paradigmas.usuarios.Coordinador;
import TP1_Paradigmas.usuarios.Profesor;

public class Universidad {
    private String nombre;
    private List<Carrera> carreras;
    private List<Profesor> profesores;
    
    //constructor de universidad
    public Universidad(String nombre){
        this.nombre = nombre;
        carreras = new ArrayList<>();
        profesores = new ArrayList<>();
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carrera getCarreraByID(int id_carrera) {
        for(int i = 0; i < carreras.size(); i++){
            if(carreras.get(i).getId_carrera() == id_carrera){
                return carreras.get(i);
            }
        }
        return null; //si no se encuentra una carrera con ese id devuelve null
    }

    public Carrera getCarreraByNombre(String nombreCarrera) {
        for(int i = 0; i < carreras.size(); i++){
            if(carreras.get(i).getNombre() == nombreCarrera){
                return carreras.get(i);
            }
        }
        return null; //si no se encuentra una carrera con ese nombre devuelve null
    }

    public Profesor getProfesorByNombre(String nombre) {
        for (Profesor profesor : profesores) {
            if ((profesor.getNombre() + " " + profesor.getApellido()).equals(nombre)) {
                return profesor;
            }
        }
        return null; // Si no se encuentra un profesor con ese nombre, devuelve null
    }

    public Profesor[] listarProfesores() {
        return profesores.toArray(new Profesor[0]);
    }

    // Añade un profesor a la universidad
    public void añadirProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    //crea una carrera
    public void crearCarrera(int id_carrera, String nombre, int duracion, int precio_inscripcion,
    int precio_cuota){
        Carrera carreraNueva = new Carrera(id_carrera, nombre, duracion, precio_inscripcion, precio_cuota);
        carreras.add(carreraNueva);
    }

    //elimina una carrera
    public void eliminarCarrera(int id_carrera){
        for(int i = 0; i < carreras.size(); i++){
            if(carreras.get(i).getId_carrera() == id_carrera){
                carreras.remove(i);
                break;
            }
        }
    }

    //lista todas las carreras
    public Carrera[] listarCarreras(){
        return carreras.toArray(new Carrera[0]);
    }

    public void asignarCoordinador(Coordinador coordinador, int id_carrera){
        for(int i = 0; i < carreras.size(); i++){
            if(carreras.get(i).getId_carrera() == id_carrera){
                carreras.get(i).setCoordinador(coordinador);
                break;
            }
        }
    }
}
