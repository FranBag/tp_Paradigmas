package TP1_Paradigmas.menu;

import javax.swing.*;
import javax.swing.event.*;

import TP1_Paradigmas.clases.Universidad;
import TP1_Paradigmas.usuarios.Profesor;

import java.awt.event.*;

public class MenuProfesor extends JFrame implements ActionListener{

    private JLabel label1;
    private JButton boton1, boton2, boton3, boton4;

    private MenuLogearse login;
    private Profesor profesor;

    public MenuProfesor(MenuLogearse login, Profesor profesor){
        this.login = login;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1 = new JLabel("Profesor: " + profesor.getNombre() + " " + profesor.getApellido());
        label1.setBounds(10,10,200,30);
        add(label1);

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
            setTitle("Carrera");
        }
        if(e.getSource() == boton2){
            // MenuProfesor menuP = new MenuProfesor(null);
            // menuP.setBounds(0,0,400,300);
            // menuP.setVisible(true);
            // menuP.setLocationRelativeTo(null);
        }
        if(e.getSource() == boton3){
            login.setVisible(true);
            dispose();
        }
    }
}

class MenuGestionarAlumnos extends JFrame implements ActionListener{
    private JLabel label1;
    private JButton boton1, boton2;
    private JTable tabla1;
    private JComboBox combo1;
    private String[][] filas;
    private JScrollPane scroll;

    private MenuProfesor menuprofesor;
    private Profesor profesor;
    private Universidad universidad;

    public MenuGestionarAlumnos(Universidad universidad, MenuProfesor menuprofesor, Profesor profesor){
        this.universidad = universidad;
        this.menuprofesor = menuprofesor;
        this.profesor = profesor;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Listado de alumnos dentro de la materia ");
        label1.setBounds(5,5,250,30);
        add(label1);
        
        combo1 = new JComboBox();
        combo1.setBounds(65,35,200,20);
        add(combo1);

        Carrera[]listacarreras = universidad.listarCarreras();
        coordinador.setCarrera(listacarreras[0]);
        for(int i=0; i < listacarreras.length; i++){
            combo1.addItem(listacarreras[i].getNombre());
        }
        combo1.addItemListener(this);
        String[] columnas = {"ID", "Nombre", "Duración", "Precio Inscripción"};

        Carrera[]listacarreras = universidad.listarCarreras();
        String[][] filas = new String[listacarreras.length][4];
        
        for(int i=0; i < listacarreras.length; i++){
            filas[i][0] = String.valueOf(listacarreras[i].getId_carrera());
            filas[i][1] = listacarreras[i].getNombre();
            filas[i][2] = String.valueOf(listacarreras[i].getDuracion());
            filas[i][3] = String.valueOf(listacarreras[i].getPrecio_inscripcion());
        }

        tabla1 = new JTable(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setRowHeight(30);
        tabla1.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla1.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabla1.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabla1.getColumnModel().getColumn(3).setPreferredWidth(100);

        scroll = new JScrollPane(tabla1);
        scroll.setBounds(5,50,500,220);
        add(scroll);

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
                alumno.inscribirCarrera(Integer.valueOf(((String) tabla1.getValueAt(filaSeleccionada, 0))));
                JOptionPane.showMessageDialog(null, "Matriculación realizada.");
                menualumno.actualizarCarrera();
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
