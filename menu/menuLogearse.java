package TP1_Paradigmas.menu;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

import TP1_Paradigmas.clases.Universidad;
import TP1_Paradigmas.usuarios.Alumno;
import TP1_Paradigmas.usuarios.Coordinador;
import TP1_Paradigmas.usuarios.Profesor;



public class MenuLogearse extends JFrame implements ActionListener, ChangeListener{
    
    private JLabel label1;
    private JButton boton1;
    private JRadioButton radio1, radio2, radio3;
    private ButtonGroup bg;
    private int eleccion;
    private Universidad universidad;

    public MenuLogearse(Universidad universidad){
        this.universidad = universidad;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bg = new ButtonGroup();

        label1 = new JLabel("Elija su rol dentro de la universidad");
        label1.setBounds(5,20,200,30);
        add(label1);

        radio1 = new JRadioButton("Alumno");
        radio1.setBounds(10,50,100,30);
        radio1.addChangeListener(this);
        add(radio1);
        bg.add(radio1);

        radio2 = new JRadioButton("Profesor");
        radio2.setBounds(10,70,100,30);
        radio2.addChangeListener(this);
        add(radio2);
        bg.add(radio2);

        radio3 = new JRadioButton("Coordinador");
        radio3.setBounds(10,90,100,30);
        radio3.addChangeListener(this);
        add(radio3);
        bg.add(radio3);

        boton1 = new JButton("Continuar");
        boton1.setBounds(150,150,100,30);
        add(boton1);
        boton1.addActionListener(this);

    }

    public void stateChanged(ChangeEvent e){
        if(radio1.isSelected()){
            eleccion = 0;
        }
        if(radio2.isSelected()){
            eleccion = 1;
        }
        if(radio3.isSelected()){
            eleccion = 2;
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            switch(eleccion){
                case 0:
                    Alumno alumno = new Alumno();
                    MenuCrear menuCrear1 = new MenuCrear(this, universidad, alumno);
                    menuCrear1.setBounds(0,0,500,300);
                    menuCrear1.setVisible(true);
                    menuCrear1.setLocationRelativeTo(null);
                    this.setVisible(false);
                    break;
                    // MenuAlumno menuA = new MenuAlumno(this, universidad);
                    // menuA.setBounds(0,0,400,300);
                    // menuA.setVisible(true);
                    // menuA.setLocationRelativeTo(null);
                    // this.setVisible(false);
                    // break;
                case 1:
                    Profesor profesor = new Profesor();
                    MenuCrear menuCrear2 = new MenuCrear(this, universidad, profesor);
                    menuCrear2.setBounds(0,0,500,300);
                    menuCrear2.setVisible(true);
                    menuCrear2.setLocationRelativeTo(null);
                    this.setVisible(false);
                    break;
                    // MenuProfesor menuP = new MenuProfesor(this);
                    // menuP.setBounds(0,0,400,300);
                    // menuP.setVisible(true);
                    // menuP.setLocationRelativeTo(null);
                    // this.setVisible(false);
                    // break;
                case 2:
                    Coordinador coordinador = new Coordinador();
                    MenuCrear menuCrear3 = new MenuCrear(this, universidad, coordinador);
                    menuCrear3.setBounds(0,0,500,300);
                    menuCrear3.setVisible(true);
                    menuCrear3.setLocationRelativeTo(null);
                    this.setVisible(false);
                    break;
                    // MenuCoordinador menuC = new MenuCoordinador(this);
                    // menuC.setBounds(0,0,400,300);
                    // menuC.setVisible(true);
                    // menuC.setLocationRelativeTo(null);
                    // this.setVisible(false);
                    // break;
            }

        }
    }
}