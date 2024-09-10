package TP1_Paradigmas.menu;

import TP1_Paradigmas.clases.*;
import TP1_Paradigmas.usuarios.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MenuCoordinador extends JFrame implements ActionListener, ItemListener{
    
    private JLabel label1;
    private JButton boton1, boton2, boton3, boton4;
    private JComboBox combo1;

    Universidad universidad;
    private MenuLogearse login;
    private Coordinador coordinador;

    public MenuCoordinador(Universidad universidad, MenuLogearse login, Coordinador coordinador){
        this.universidad = universidad;
        this.login = login;
        this.coordinador = coordinador;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1 = new JLabel("Alumno: " + coordinador.getNombre() + " " + coordinador.getApellido());
        label1.setBounds(10,10,200,30);
        add(label1);

        label1 = new JLabel("Carrera:");
        label1.setBounds(10,30,100,30);
        add(label1);

        boton1 = new JButton("Asignar Profesor");
        boton1.setBounds(10,65,150,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Ver Alumnos");
        boton2.setBounds(10,105,150,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3 = new JButton("Ver Materias");
        boton3.setBounds(10,145,150,30);
        add(boton3);
        boton3.addActionListener(this);

        boton4 = new JButton("Volver");
        boton4.setBounds(5,220,80,30);
        add(boton4);
        boton4.addActionListener(this);

        combo1 = new JComboBox();
        combo1.setBounds(65,35,200,20);
        add(combo1);

        Carrera[]listacarreras = universidad.listarCarreras();
        coordinador.setCarrera(listacarreras[0]);
        for(int i=0; i < listacarreras.length; i++){
            combo1.addItem(listacarreras[i].getNombre());
        }
        combo1.addItemListener(this);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            MenuAsignarProfesor menuAsignarProfesor = new MenuAsignarProfesor(universidad, this, coordinador);
            menuAsignarProfesor.setBounds(0, 0, 350, 170);
            menuAsignarProfesor.setVisible(true);
            menuAsignarProfesor.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == boton2){
            MenuListarAlumnosCarrera menuLAC = new MenuListarAlumnosCarrera(this, coordinador);
            menuLAC.setBounds(0,0,700,400);
            menuLAC.setVisible(true);
            menuLAC.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == boton3){
            MenuListarMateriasCarrera menuLMC = new MenuListarMateriasCarrera(this, coordinador);
            menuLMC.setBounds(0,0,600,400);
            menuLMC.setVisible(true);
            menuLMC.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == boton4){
            login.setVisible(true);
            dispose();
        }
    }

    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == combo1){
          coordinador.setCarrera(universidad.getCarreraByNombre(combo1.getSelectedItem().toString()));
        }
       }
}


class MenuAsignarProfesor extends JFrame implements ActionListener {
    private JLabel label1, label2, label3;
    private JComboBox<String> comboMaterias, comboProfesores;
    private JButton botonAsignar, botonVolver;

    private Coordinador coordinador;
    private Universidad universidad;
    private MenuCoordinador menuCoordinador;

    public MenuAsignarProfesor(Universidad universidad, MenuCoordinador menuCoordinador, Coordinador coordinador) {
        this.universidad = universidad;
        this.menuCoordinador = menuCoordinador;
        this.coordinador = coordinador;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Asignar Profesor a Materia");

        label1 = new JLabel("Materia:");
        label1.setBounds(10, 10, 100, 30);
        add(label1);

        comboMaterias = new JComboBox<>();
        comboMaterias.setBounds(120, 10, 200, 30);
        add(comboMaterias);

        label2 = new JLabel("Profesor:");
        label2.setBounds(10, 50, 100, 30);
        add(label2);

        comboProfesores = new JComboBox<>();
        comboProfesores.setBounds(120, 50, 200, 30);
        add(comboProfesores);

        botonAsignar = new JButton("Asignar");
        botonAsignar.setBounds(10, 90, 100, 30);
        add(botonAsignar);
        botonAsignar.addActionListener(this);

        botonVolver = new JButton("Volver");
        botonVolver.setBounds(120, 90, 100, 30);
        add(botonVolver);
        botonVolver.addActionListener(this);

        cargarDatos();
        setBounds(100, 100, 350, 170);
        setLocationRelativeTo(null);
    }

    private void cargarDatos() {
        // Cargar materias al comboMaterias
        Carrera carrera = coordinador.getCarrera();
        if (carrera != null) {
            Materia[] materias = carrera.listarMaterias();
            for (Materia materia : materias) {
                comboMaterias.addItem(materia.getNombre());
            }
        }

        // Cargar profesores al comboProfesores
        Profesor[] profesores = universidad.listarProfesores();
        for (Profesor profesor : profesores) {
            comboProfesores.addItem(profesor.getNombre() + " " + profesor.getApellido());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAsignar) {
            String materiaNombre = (String) comboMaterias.getSelectedItem();
            String profesorNombre = (String) comboProfesores.getSelectedItem();

            if (materiaNombre != null && profesorNombre != null) {
                Materia materia = coordinador.getCarrera().getMateriaByNombre(materiaNombre);
                Profesor profesor = universidad.getProfesorByNombre(profesorNombre);

                if (materia != null && profesor != null) {
                    coordinador.asignarProfesor(materia.getId_materia(), profesor);
                    JOptionPane.showMessageDialog(this, "Profesor asignado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Materia o Profesor no encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una materia y un profesor.");
            }
        }

        if (e.getSource() == botonVolver) {
            menuCoordinador.setVisible(true);
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

        Alumno[] listaalumnos = carrera.listarAlumnos();
        String[][] filas = new String[listaalumnos.length][6];

        for(int i=0; i < listaalumnos.length; i++){
            filas[i][0] = String.valueOf(listaalumnos[i].getDni());
            filas[i][1] = String.valueOf(listaalumnos[i].getN_legajo());
            filas[i][2] = listaalumnos[i].getNombre();
            filas[i][3] = listaalumnos[i].getApellido();
            filas[i][4] = listaalumnos[i].getEmail();
            filas[i][5] = listaalumnos[i].getN_telefono();
        }
        tabla1 = new JTable(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setRowHeight(20);
        tabla1.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabla1.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla1.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabla1.getColumnModel().getColumn(3).setPreferredWidth(110);
        tabla1.getColumnModel().getColumn(4).setPreferredWidth(150);
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
            return coordinador.getCarrera().getNombre();
        }else{
            return "Ninguna";
        }
    }

    public void actualizarCarrera(){
        label1.setText("Carrera: " + comprobarCarrera());
    }
}

class MenuListarMateriasCarrera extends JFrame implements ActionListener{
    private JLabel label1;
    private JButton boton1;
    private JTable tabla1;
    private JScrollPane scroll;

    private MenuCoordinador menucoordinador;
    private Coordinador coordinador;
    private Carrera carrera;

    public MenuListarMateriasCarrera(MenuCoordinador menucoordinador, Coordinador coordinador){
        this.menucoordinador = menucoordinador;
        this.coordinador = coordinador;
        this.carrera = coordinador.getCarrera();

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Listado de materias dentro de la carrera " + this.comprobarCarrera());
        label1.setBounds(5,5,300,30);
        add(label1);

        String[] columnas = {"ID", "Nombre", "Profesor", "Año", "Cuatrimestre"};

        Materia[] listamaterias = carrera.listarMaterias();
        String[][] filas = new String[listamaterias.length][5];

        String celdaprofe = "Nadie";
        for(int i=0; i < listamaterias.length; i++){
            if(listamaterias[i].getProfesor() != null){
                celdaprofe =  (listamaterias[i].getProfesor().getNombre() + " " +
                listamaterias[i].getProfesor().getApellido());
            }
            filas[i][0] = String.valueOf(listamaterias[i].getId_materia());
            filas[i][1] = listamaterias[i].getNombre();
            filas[i][2] = celdaprofe;
            filas[i][3] = String.valueOf(listamaterias[i].getCurso());
            filas[i][4] = String.valueOf(listamaterias[i].getCuatrimestre());
        }
        tabla1 = new JTable(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setRowHeight(20);
        tabla1.getColumnModel().getColumn(0).setPreferredWidth(25);
        tabla1.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabla1.getColumnModel().getColumn(2).setPreferredWidth(120);
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
            menucoordinador.setVisible(true);
            dispose();
        }
    }

    public String comprobarCarrera(){
        if(coordinador.getCarrera() != null){
            return coordinador.getCarrera().getNombre();
        }else{
            return "Ninguna";
        }
    }
}