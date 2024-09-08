package TP1_Paradigmas;

import TP1_Paradigmas.menu.MenuLogearse;
import TP1_Paradigmas.usuarios.Alumno;
import TP1_Paradigmas.clases.Universidad;

public class app {
    public static void main(String[] args) {
        //creación de universidad y carreras
        Universidad UCP = new Universidad("Cuenca del Plata");
        UCP.crearCarrera(1, "Ingeniería en Sistemas", 5, 50000, 25000);
        UCP.crearCarrera(2, "Licenciatura en Nutrición", 4, 50000, 25000);
        
        // menu de logeo
        MenuLogearse menuLogeo = new MenuLogearse(UCP);
        menuLogeo.setBounds(0,0,400,300);
        menuLogeo.setVisible(true);
        menuLogeo.setLocationRelativeTo(null);

        // UCP.listarCarreras();

        Alumno alumno1 = new Alumno(555, "Francisco","Bagneres",
        "f@gmail.com", "Hombre", 376425, 4623, UCP);

        alumno1.inscribirCarrera(1);

        // UCP.getCarreraByID(1).listarAlumnos();
        // UCP.getCarreraByID(1).listarMaterias();
    }
}
