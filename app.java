package TP1_Paradigmas;

import java.util.Scanner;

import TP1_Paradigmas.menu.menuLogearse;

import TP1_Paradigmas.clases.Universidad;

public class app {
    public static void main(String[] args) {
        //creación de universidad y carreras
        Universidad UCP = new Universidad("Cuenca del Plata");
        UCP.crearCarrera(1, "Ingeniería en Sistemas", 5, 50000, 25000);
        UCP.crearCarrera(2, "Licenciatura en Nutrición", 4, 50000, 25000);
        
        //menu de logeo
        menuLogearse menuLogeo = new menuLogearse();
        menuLogeo.setBounds(0,0,400,300);
        menuLogeo.setVisible(true);
        menuLogeo.setLocationRelativeTo(null);

        UCP.listarCarreras();

    }
}
