package TP1_Paradigmas.menu;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class menuAlumno extends JFrame implements ActionListener{
    
    private JLabel label1;
    private JButton boton1, boton2, boton3;

    public menuAlumno(){
        setLayout(null);
        label1 = new JLabel("Hola soy el alumno: ...");
        label1.setBounds(10,10,200,30);
        add(label1);

        boton1 = new JButton("Inscribirse Carrera");
        boton1.setBounds(10,50,150,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Inscribirse Materia");
        boton2.setBounds(10,90,150,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3 = new JButton("Ver Asistencia");
        boton3.setBounds(10,130,150,30);
        add(boton3);
        boton3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            setTitle("Carrera");
        }
        if(e.getSource() == boton2){
            setTitle("Materia");
        }
        if(e.getSource() == boton3){
            setTitle("Asistencia");
        }
    }

    public static void main(String[] args) {
        menuAlumno menuA = new menuAlumno();
        menuA.setBounds(0,0,400,300);
        menuA.setVisible(true);
        menuA.setLocationRelativeTo(null);
    }
}
