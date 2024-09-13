package TP1_Paradigmas;

import TP1_Paradigmas.menu.MenuLogearse;
import TP1_Paradigmas.usuarios.Alumno;
import TP1_Paradigmas.usuarios.Coordinador;
import TP1_Paradigmas.usuarios.Profesor;
import TP1_Paradigmas.clases.Universidad;
import TP1_Paradigmas.DatosIniciales;;

public class app {
    public static void main(String[] args) {

        //creación de universidad y carreras
        Universidad UCP = new Universidad("Cuenca del Plata");

        //se llama a la función que creará las instancias iniciales
        DatosIniciales.iniciarDatos(UCP);

        // menu de logeo
        MenuLogearse menuLogeo = new MenuLogearse(UCP);
        menuLogeo.setBounds(0,0,400,300);
        menuLogeo.setVisible(true);
        menuLogeo.setLocationRelativeTo(null);
    }
}
