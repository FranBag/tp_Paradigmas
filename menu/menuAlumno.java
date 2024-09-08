package TP1_Paradigmas.menu;

import javax.swing.*;
import javax.swing.event.*;

import TP1_Paradigmas.app;
import TP1_Paradigmas.clases.Universidad;

import java.awt.event.*;

public class MenuAlumno extends JFrame implements ActionListener{
    
    private JLabel label1, label2, label3;
    private JButton boton1, boton2, boton3, boton4;
    private MenuLogearse login;
    private Universidad universidad;

    public MenuAlumno(MenuLogearse login, Universidad universidad){
        this.universidad = universidad;
        this.login = login;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1 = new JLabel("Alumno: ...");
        label1.setBounds(10,10,200,30);
        add(label1);

        label2 = new JLabel("Carrera: ...");
        label2.setBounds(10,25,200,30);
        add(label2);
        

        boton1 = new JButton("Inscribirse Carrera");
        boton1.setBounds(10,60,150,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Inscribirse Materia");
        boton2.setBounds(10,100,150,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3 = new JButton("Ver Asistencia");
        boton3.setBounds(10,140,150,30);
        add(boton3);
        boton3.addActionListener(this);

        boton4 = new JButton("Volver");
        boton4.setBounds(5,220,80,30);
        add(boton4);
        boton4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            MenuInscribirseCarrera menuT = new MenuInscribirseCarrera(universidad);
            menuT.setBounds(0,0,600,400);
            menuT.setVisible(true);
            menuT.setLocationRelativeTo(null);
        }
        if(e.getSource() == boton2){
            setTitle("Materia");
        }
        if(e.getSource() == boton3){
            setTitle("Asistencia");
        }
        if(e.getSource() == boton4){
            // MenuLogearse menu = new MenuLogearse();
            // menu.setBounds(0,0,400,300);
            // menu.setVisible(true);
            // menu.setLocationRelativeTo(null);
            // this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        // MenuAlumno menuA = new MenuAlumno(null, null);
        // menuA.setBounds(0,0,400,300);
        // menuA.setVisible(true);
        // menuA.setLocationRelativeTo(null);

    }
}

class MenuInscribirseCarrera extends JFrame implements ActionListener{
    private JLabel label1, label2, label3;
    private JButton boton1, boton2;
    private JTable tabla1;
    private JScrollPane scroll;

    public MenuInscribirseCarrera(Universidad universidad){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Listado de carreras dentro de la universidad");
        label1.setBounds(5,5,300,30);
        add(label1);

        String[] columnas = {"Nombre", "Duración", "Precio Inscripción"};

        String[][] filas = universidad.listarCarreras();

        tabla1 = new JTable(filas, columnas);
        tabla1.setBounds(5,30,500,250);

        scroll = new JScrollPane(tabla1);
        add(tabla1);
    }

        public void actionPerformed(ActionEvent e){

        }
}