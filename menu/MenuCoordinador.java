package TP1_Paradigmas.menu;

import TP1_Paradigmas.clases.Carrera;
import TP1_Paradigmas.usuarios.Coordinador;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MenuCoordinador extends JFrame implements ActionListener{
    
    private JLabel label1, label2;
    private JButton boton1, boton2, boton3, boton4;
    private MenuLogearse login;
    private Coordinador coordinador;

    public MenuCoordinador(MenuLogearse login, Coordinador coordinador){
        this.login = login;
        this.coordinador = coordinador;

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
            MenuListarAlumnosCarrera menuLAC = new MenuListarAlumnosCarrera(this, coordinador);
            menuLAC.setBounds(0,0,600,400);
            menuLAC.setVisible(true);
            menuLAC.setLocationRelativeTo(null);
            this.setVisible(false);
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


//clase para listar los alumnos de una carrera
class MenuListarAlumnosCarrera extends JFrame implements ActionListener{
    private JLabel label1;
    private JButton boton1;
    private JTable tabla1;
    private JScrollPane scroll;

    private MenuCoordinador menucoordinador;
    private Coordinador coordinador;
    private Carrera carrera;

    
    public MenuListarAlumnosCarrera(MenuCoordinador menucoordinador, Coordinador coordinador){
        this.menucoordinador = menucoordinador;
        this.coordinador = coordinador;
        this.carrera = coordinador.getCarrera();

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Listado de alumnos dentro de la carrera " + this.comprobarCarrera());
        label1.setBounds(5,5,300,30);
        add(label1);

        String[] columnas = {"DNI", "N.Legajo", "Nombre", "Apellido", "Email", "N.Telefono"};

        String[][] filas = carrera.listarAlumnos();
        /*ARREGLAR, COORDINADOR NO TIENE  CARRERA AL INICIO, PRIMERO AÑADIR OPCION DE
         * SER DE UNA CARRERA PRIMERO. PUEDO REUTILIZAR MATRICULARSECARRERA DE MENUALUMNO
         * PERO ME CONVIENE YA CAMBIAR EL getCarreras DE UNIVERSIDDAD PARA QUE DEVUELVA
         * UNA LISTA DE CARRERAS EN VEZ DE LISTA DE ARRAYS ASI LO MANIPULO DESDE ACÁ.
        */
        tabla1 = new JTable(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setRowHeight(20);
        tabla1.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla1.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabla1.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla1.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla1.getColumnModel().getColumn(4).setPreferredWidth(200);
        tabla1.getColumnModel().getColumn(5).setPreferredWidth(100);

        scroll = new JScrollPane(tabla1);
        scroll.setBounds(5,50,650,220);
        add(scroll);

        boton1 = new JButton("Volver");
        boton1.setBounds(10,320,80,30);
        add(boton1);
        boton1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            menucoordinador.setVisible(true);
            dispose();
        }
    }

    public String comprobarCarrera(){
        if(coordinador.getCarrera() != null){
            boton1.setEnabled(false);
            return coordinador.getCarrera().getNombre();
        }else{
            return "Ninguna";
        }
    }

    public void actualizarCarrera(){
        label1.setText("Carrera: " + comprobarCarrera());
    }
}
