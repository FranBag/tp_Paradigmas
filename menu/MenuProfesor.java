package TP1_Paradigmas.menu;

import javax.swing.*;
import javax.swing.event.*;

import TP1_Paradigmas.clases.Materia;
import TP1_Paradigmas.clases.Universidad;
import TP1_Paradigmas.usuarios.Profesor;

import java.awt.event.*;

public class MenuProfesor extends JFrame implements ActionListener, ItemListener{

    private JLabel label1;
    private JButton boton1, boton2, boton3;
    private JComboBox<Profesor> combo1;

    private MenuLogearse login;
    private Universidad universidad;
    private Profesor profesor;

    public MenuProfesor(MenuLogearse login, Universidad universidad, Profesor profesor){
        this.login = login;
        this.universidad = universidad;
        this.profesor = profesor;


        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1 = new JLabel("Profesor: ");
        label1.setBounds(10,10,100,30);
        add(label1);

        combo1 = new JComboBox();
        combo1.setBounds(100,15,200,20);
        add(combo1);

        Profesor[]listaprofes = universidad.listarProfesores();

        for (int i = 0; i < listaprofes.length; i++) {
            combo1.addItem(listaprofes[i]);
        }
        
        combo1.addItemListener(this);
        combo1.setSelectedItem(profesor);

        boton1 = new JButton("Gestionar Alumnos");
        boton1.setBounds(10,70,150,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Listar Materias a Cargo");
        boton2.setBounds(10,130,180,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3 = new JButton("Volver");
        boton3.setBounds(5,220,80,30);
        add(boton3);
        boton3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            MenuGestionarAlumnos menuGA = new MenuGestionarAlumnos(this, profesor);
            menuGA.setBounds(0,0,600,400);
            menuGA.setVisible(true);
            menuGA.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == boton2){
            MenuListarMateriasACargo menuLMC = new MenuListarMateriasACargo(this, profesor);
            menuLMC.setBounds(0,0,600,400);
            menuLMC.setVisible(true);
            menuLMC.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == boton3){
            login.setVisible(true);
            dispose();
        }
    }

    public void itemStateChanged(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED) {
            profesor = (Profesor) combo1.getSelectedItem();
       }
    }
}

class MenuGestionarAlumnos extends JFrame implements ActionListener, ItemListener{
    private JLabel label1;
    private JButton boton1, boton2;
    private JTable tabla1;
    private JComboBox combo1;
    private String[][] filas;
    private JScrollPane scroll;

    private Materia materia;
    private MenuProfesor menuprofesor;
    private Profesor profesor;

    public MenuGestionarAlumnos(MenuProfesor menuprofesor, Profesor profesor){
        this.menuprofesor = menuprofesor;
        this.profesor = profesor;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Listado de alumnos dentro de la materia ");
        label1.setBounds(5,5,250,30);
        add(label1);
        
        combo1 = new JComboBox();
        combo1.setBounds(300,5,200,20);
        add(combo1);

        Materia[]listamaterias = profesor.getMaterias();

        for(int i=0; i < listamaterias.length; i++){
            combo1.addItem(listamaterias[i].getNombre());
        }
        combo1.addItemListener(this);

        String[] columnas = {"N.Legajo", "Nombre", "Apellido", "Inasistencias", "Situación"};

        String[][] filas = new String[0][5];
        if(materia != null) {
            filas = profesor.verAlumnos(materia);
        }
        tabla1 = new JTable(filas, columnas);

        tabla1.setRowHeight(20);
        tabla1.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla1.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabla1.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla1.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabla1.getColumnModel().getColumn(4).setPreferredWidth(80);

        scroll = new JScrollPane(tabla1);
        scroll.setBounds(5,50,400,220);
        add(scroll);

        boton1 = new JButton("Guardar");
        boton1.setBounds(180,320,80,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Volver");
        boton2.setBounds(10,320,80,30);
        add(boton2);
        boton2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            for(int i = 0; i < filas.length; i++){
                profesor.gestionarAsistencia(materia, Integer.valueOf(tabla1.getValueAt(i, 1).toString()),
                Double.valueOf(tabla1.getValueAt(i, 3).toString()));
            }
        }
        if(e.getSource() == boton2){
            menuprofesor.setVisible(true);
            dispose();
        }
    }

    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == combo1){
            materia = profesor.getMateriaByNombre(combo1.getSelectedItem().toString());
        }
    }
}


//menu en donde se muestran las materias de un profesor
class MenuListarMateriasACargo extends JFrame implements ActionListener{
    private JLabel label1;
    private JButton boton1;
    private JTable tabla1;
    private JScrollPane scroll;

    private MenuProfesor menuprofesor;
    private Profesor profesor;

    public MenuListarMateriasACargo(MenuProfesor menuprofesor, Profesor profesor){
        this.menuprofesor = menuprofesor;
        this.profesor = profesor;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        label1 = new JLabel("Listado de materias a cargo de " + profesor);
        label1.setBounds(5,5,300,30);
        add(label1);

        String[] columnas = {"ID", "Nombre", "Año", "Cuatrimestre", "Alumnos"};

        Materia[] listamaterias = profesor.getMaterias();
        String[][] filas = new String[listamaterias.length][5];

        for(int i=0; i < listamaterias.length; i++){
            filas[i][0] = String.valueOf(listamaterias[i].getId_materia());
            filas[i][1] = listamaterias[i].getNombre();
            filas[i][2] = String.valueOf(listamaterias[i].getCurso());
            filas[i][3] = String.valueOf(listamaterias[i].getCuatrimestre());
            filas[i][4] = String.valueOf(listamaterias[i].getAlumnos().length);
        }
        System.out.println(listamaterias.length);

        tabla1 = new JTable(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setRowHeight(20);
        tabla1.getColumnModel().getColumn(0).setPreferredWidth(25);
        tabla1.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabla1.getColumnModel().getColumn(2).setPreferredWidth(25);
        tabla1.getColumnModel().getColumn(3).setPreferredWidth(25);
        tabla1.getColumnModel().getColumn(4).setPreferredWidth(25);

        scroll = new JScrollPane(tabla1);
        scroll.setBounds(5,50,500,220);
        add(scroll);

        boton1 = new JButton("Volver");
        boton1.setBounds(10,320,80,30);
        add(boton1);
        boton1.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            menuprofesor.setVisible(true);
            dispose();
        }
    }
}