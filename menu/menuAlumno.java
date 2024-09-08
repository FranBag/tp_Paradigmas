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
        

        boton1 = new JButton("Matricularse Carrera");
        boton1.setBounds(10,60,180,30);
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
            MenuInscribirseCarrera menuT = new MenuInscribirseCarrera(universidad, this);
            menuT.setBounds(0,0,600,400);
            menuT.setVisible(true);
            menuT.setLocationRelativeTo(null);
            this.setVisible(false);
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
}

class MenuInscribirseCarrera extends JFrame implements ActionListener{
    private JLabel label1, label2;
    private JButton boton1, boton2;
    private JTable tabla1;
    private JScrollPane scroll;
    private MenuAlumno menualumno;

    public MenuInscribirseCarrera(Universidad universidad, MenuAlumno menualumno){
        this.menualumno = menualumno;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Listado de carreras dentro de la universidad");
        label1.setBounds(5,5,300,30);
        add(label1);

        label1 = new JLabel("Nombre / Duración / P.Inscripción");
        label1.setBounds(5,25,600,30);
        add(label1);
        
        String[] columnas = {"Nombre", "Duración", "Precio Inscripción"};

        String[][] filas = universidad.listarCarreras();

        tabla1 = new JTable(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setBounds(5,50,500,220);

        scroll = new JScrollPane(tabla1);
        add(tabla1);

        boton1 = new JButton("Matricularse");
        boton1.setBounds(10,280,120,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Volver");
        boton2.setBounds(10,320,80,30);
        add(boton2);
        boton2.addActionListener(this);
    }

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == boton1){
                int filaSeleccionada = tabla1.getSelectedRow();
                if(filaSeleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar una carrera.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Matriculación realizada.");
                    menualumno.setVisible(true);
                    dispose();
                }
            }
            if(e.getSource() == boton2){
                menualumno.setVisible(true);
                dispose();
            }
        }
}