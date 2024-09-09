package TP1_Paradigmas.clases;

import java.util.ArrayList;
import java.util.List;

import TP1_Paradigmas.usuarios.Coordinador;

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
    public Carrera getCarreraByID(int id_carrera) {
        for(int i = 0; i < carreras.size(); i++){
            if(carreras.get(i).getId_carrera() == id_carrera){
                return carreras.get(i);
            }
        }
        return null; //si no se encuentra una carrera con ese id devuelve null
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
    public String[][] listarCarreras(){
        int tamaño_carreras = carreras.size();
        String[][] lista_carreras = new String[tamaño_carreras][4];
        for(int i = 0; i < tamaño_carreras; i++){
            lista_carreras[i][0] = String.valueOf(carreras.get(i).getId_carrera());
            lista_carreras[i][1] = carreras.get(i).getNombre();
            lista_carreras[i][2] = String.valueOf(carreras.get(i).getDuracion());
            lista_carreras[i][3] = String.valueOf(carreras.get(i).getPrecio_inscripcion());
        }
        return lista_carreras;
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
