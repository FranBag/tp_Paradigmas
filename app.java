package TP1_Paradigmas;

import TP1_Paradigmas.menu.MenuLogearse;
import TP1_Paradigmas.usuarios.Alumno;
import TP1_Paradigmas.usuarios.Profesor;
import TP1_Paradigmas.clases.Universidad;

public class app {
    public static void main(String[] args) {
        //creación de universidad y carreras
        Universidad UCP = new Universidad("Cuenca del Plata");
        UCP.crearCarrera(1, "Ingeniería en Sistemas", 5, 60000, 25000);
            UCP.getCarreraByID(1).crearMateria(1, "Algebra", 1, 1);
            UCP.getCarreraByID(1).crearMateria(2, "Paradigmas I", 2, 1);
            UCP.getCarreraByID(1).crearMateria(3, "Paradigmas II", 2, 2);
            UCP.getCarreraByID(1).crearMateria(4, "Analisis Numérico", 3, 1);
            UCP.getCarreraByID(1).crearMateria(5, "Ingeniería de Software III", 4, 1);
        UCP.crearCarrera(2, "Licenciatura en Nutrición", 4, 50000, 25000);
            UCP.getCarreraByID(2).crearMateria(1, "Cocina I", 1, 1);
            UCP.getCarreraByID(2).crearMateria(2, "Anatomía", 2, 1);
            UCP.getCarreraByID(2).crearMateria(3, "Panadería II", 3, 2);
            UCP.getCarreraByID(2).crearMateria(4, "Metabolismo", 4, 1);
            UCP.getCarreraByID(2).crearMateria(5, "Práctica Profesional", 4, 2);
        UCP.crearCarrera(3, "Licenciatura en Criminalística", 6, 75000, 35000);
            UCP.getCarreraByID(3).crearMateria(1, "Fisica I", 1, 1);
            UCP.getCarreraByID(3).crearMateria(2, "Matemáticas", 2, 1);
            UCP.getCarreraByID(3).crearMateria(3, "Psicología Criminal", 3, 1);
            UCP.getCarreraByID(3).crearMateria(4, "Balística", 4, 2);
            UCP.getCarreraByID(3).crearMateria(5, "Práctica Profesional", 4, 2);

        // menu de logeo
        MenuLogearse menuLogeo = new MenuLogearse(UCP);
        menuLogeo.setBounds(0,0,400,300);
        menuLogeo.setVisible(true);
        menuLogeo.setLocationRelativeTo(null);

        Alumno alumno1 = new Alumno(555, "Francisco","Bagneres",
        "f@gmail.com", "Hombre", "376425", 4623, UCP);
        alumno1.inscribirCarrera(1);

        Profesor profesor1 = new Profesor(222, "Jorge", "Roman", "romancito@hotmail.com",
        "Hombre", "3751556423", 25659645);

        UCP.getCarreraByID(1).getCoordinador().asignarProfesor(1, profesor1);
        UCP.getCarreraByID(1).getCoordinador().asignarProfesor(4, profesor1);


        // UCP.getCarreraByID(1).listarAlumnos();
        // UCP.getCarreraByID(1).listarMaterias();
    }
}
