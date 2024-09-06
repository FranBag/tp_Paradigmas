package TP1_Paradigmas;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Universidad UCP = new Universidad("Cuenca del Plata");
        UCP.crearCarrera(1, "Ingeniería en Sistemas", 5, 50000, 25000);
        UCP.crearCarrera(2, "Licenciatura en Nutrición", 4, 50000, 25000);
        UCP.crearCarrera(3, "Licenciatura en Psicología", 4, 50000, 25000);
        Menu.logearse();
        UCP.listarCarreras();

    }
}
