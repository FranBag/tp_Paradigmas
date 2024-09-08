package TP1_Paradigmas.menu;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MenuCoordinador extends JFrame implements ActionListener{
    
    private JLabel label1, label2;
    private JButton boton1, boton2, boton3, boton4;
    private MenuLogearse login;

    public MenuCoordinador(MenuLogearse login){
        this.login = login;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1 = new JLabel("Coordinador: ...");
        label1.setBounds(10,10,200,30);
        add(label1);

        label1 = new JLabel("Carrera: ...");
        label1.setBounds(10,25,200,30);
        add(label1);

        boton1 = new JButton("Asignar Profesor");
        boton1.setBounds(10,60,150,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Ver Alumnos");
        boton2.setBounds(10,100,150,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3 = new JButton("Ver Materias");
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
            setTitle("Carrera");
        }
        if(e.getSource() == boton2){
            setTitle("Materia");
        }
        if(e.getSource() == boton3){
            setTitle("Asistencia");
        }
        if(e.getSource() == boton4){
            login.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        MenuCoordinador menuC = new MenuCoordinador(null);
        menuC.setBounds(0,0,400,300);
        menuC.setVisible(true);
        menuC.setLocationRelativeTo(null);
    }
}
