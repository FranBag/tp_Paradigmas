package TP1_Paradigmas;

import java.util.Scanner;

import TP1_Paradigmas.util.limpiarPantalla;

public class Menu {
    static Scanner input = new Scanner(System.in);
    public static void logearse(){
        limpiarPantalla.limpiar();
        System.out.println("Elija su rol dentro de la Universidad:\n1- Alumno\n2-Profesor\n3-Coordinador");
        int rol = input.nextInt();

        switch(rol) {
            case 1:
                System.out.println("Sos un Alumno capo.");
                menuAlumno();
                break;
            case 2:
                System.out.println("Sos un Profesor capo.");  
                menuProfesor();
                break;
            case 3:
                System.out.println("Sos un Coordinador capo.");
                menuCoordinador();
                break;
            default:
                System.out.println("Sos un nose capo.");
                break;
        }
    }

    public static void menuAlumno(){
        System.out.println("¿Qué acción desea realizar?\n");

    }

    public static void menuProfesor(){

    }
    
    public static void menuCoordinador(){

    }

}
