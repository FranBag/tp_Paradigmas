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
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {
    private Carrera carreraMatriculada;
    private List<Materia> materiasInscriptas;

    public Alumno(int n_legajo, String nombre, String apellido, String email, String sexo, int n_telefono, int dni) {
        super(n_legajo, nombre, apellido, email, sexo, n_telefono, dni);
        this.materiasInscriptas = new ArrayList<>();
    }

    // Método para inscribir al alumno en una carrera
    public void inscribirCarrera(Carrera carrera) {
        this.carreraMatriculada = carrera;
        System.out.println("Alumno " + getNombre() + " inscrito en la carrera " + carrera.getNombre());
        
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