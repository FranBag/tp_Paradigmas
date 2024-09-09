// package TP1_Paradigmas.usuarios;

// import TP1_Paradigmas.clases.Carrera;
// import TP1_Paradigmas.clases.Materia;

// import java.util.ArrayList;
// import java.util.List;

// public class Alumno extends Usuario{
    
//     private Carrera carrera;
//     private List<Materia> materias;


//     public Alumno(){
//         materias = new ArrayList<>();
//     }
// }

package TP1_Paradigmas.usuarios;

import TP1_Paradigmas.clases.Carrera;
import TP1_Paradigmas.clases.Materia;
import TP1_Paradigmas.clases.Universidad;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {
    private Carrera carreraMatriculada;
    private List<Materia> materiasInscriptas;
    private Universidad universidad;

    public Alumno(int n_legajo, String nombre, String apellido, String email,
    String sexo, String n_telefono, int dni, Universidad universidad) {
        super(n_legajo, nombre, apellido, email, sexo, n_telefono, dni);
        this.universidad = universidad;
        this.materiasInscriptas = new ArrayList<>();
    }

    public Alumno(){

    }

    //setter y getter de universidad
    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }


    // Método para inscribir al alumno en una carrera
    public void inscribirCarrera(int id_carrera) {
        Carrera carreraInscribir = universidad.getCarreraByID(id_carrera);
        carreraInscribir.matricularAlumno(this);
        this.carreraMatriculada = carreraInscribir;
    }

    // Método para inscribir al alumno en una materia
    public void inscribirMateria(Materia materia) {
        if (carreraMatriculada != null && carreraMatriculada.getmateria().contains(materia)) {
            if (!materiasInscriptas.contains(materia)) {
                materia.inscribirAlumno(getN_legajo());
                materiasInscriptas.add(materia);
                System.out.println("Alumno " + getNombre() + " inscrito en la materia " + materia.getNombre());
            } else {
                System.out.println("El alumno ya está inscrito en esta materia.");
            }
        } else {
            System.out.println("El alumno no está matriculado en la carrera correspondiente a la materia.");
        }
    }

    // Método para ver la asistencia del alumno en una materia
    public void verAsistencia(Materia materia) {
        if (materiasInscriptas.contains(materia)) {
            String asistencia = materia.getAsistencia(getN_legajo());
            System.out.println("Asistencias del alumno en " + materia.getNombre() + ": " + asistencia);
        } else {
            System.out.println("El alumno no está inscrito en esta materia.");
        }
    }

    public Carrera getCarreraMatriculada() {
        return carreraMatriculada;
    }

    public List<Materia> getMateriasInscriptas() {
        return materiasInscriptas;
    }
}