package TP1_Paradigmas.clases;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Carrera> carreras;
    
    //constructor de universidad
    public Universidad(String nombre){
        this.nombre = nombre;
        carreras = new ArrayList<>();
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public void listarCarreras(){
        for(int i = 0; i < carreras.size(); i++){
            System.out.println(carreras.get(i).getNombre());
        }
    }

    public void asignarCoordinador(int n_legajo_coordinador, int id_carrera){
        for(int i = 0; i < carreras.size(); i++){
            if(carreras.get(i).getN_legajo() == n_legajo_alumno){
                alumnos.remove(i);
                break;
            }
        }
    }
}
