package TP1_Paradigmas.menu;

import TP1_Paradigmas.app;
import TP1_Paradigmas.clases.*;
import TP1_Paradigmas.usuarios.Alumno;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

//menu alumno
public class MenuAlumno extends JFrame implements ActionListener{
    
    private JLabel label1, label2, label3;
    private JButton boton1, boton2, boton3, boton4;

    String nombreCarrera;

    private MenuLogearse login;
    private Universidad universidad;
    private Alumno alumno;

    public MenuAlumno(MenuLogearse login, Universidad universidad, Alumno alumno){
        this.login = login;
        this.universidad = universidad;
        this.alumno = alumno;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1 = new JLabel("Alumno: " + alumno.getNombre() + " " + alumno.getApellido());
        label1.setBounds(10,10,200,30);
        add(label1);

        label2 = new JLabel("DNI: " + alumno.getDni());
        label2.setBounds(250,10,200,30);
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

        label3 = new JLabel("Carrera: " + comprobarCarrera());
        label3.setBounds(10,25,200,30);
        add(label3);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            MenuMatricularseCarrera menuMC = new MenuMatricularseCarrera(universidad, this, alumno);
            menuMC.setBounds(0,0,600,400);
            menuMC.setVisible(true);
            menuMC.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == boton2){
            MenuInscribirseMateria menuIM = new MenuInscribirseMateria(this, alumno);
            menuIM.setBounds(0,0,600,400);
            menuIM.setVisible(true);
            menuIM.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == boton3){
            MenuVerAsistencia menuVA = new MenuVerAsistencia(this, alumno);
            menuVA.setBounds(0,0,600,400);
            menuVA.setVisible(true);
            menuVA.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == boton4){
            login.setVisible(true);
            dispose();
        }
    }

    public String comprobarCarrera(){
        if(alumno.getCarreraMatriculada() != null){
            boton1.setEnabled(false);
            boton2.setEnabled(true);
            boton3.setEnabled(true);
            return alumno.getCarreraMatriculada().getNombre();
        }else{
            boton2.setEnabled(false);
            boton3.setEnabled(false);
            return "Ninguna";
        }
    }

    public void actualizarCarrera(){
        label3.setText("Carrera: " + comprobarCarrera());
    }
}


//menú de matriculación a una carrera
class MenuMatricularseCarrera extends JFrame implements ActionListener{
    private JLabel label1;
    private JButton boton1, boton2;
    private JTable tabla1;
    private String[][] filas;
    private JScrollPane scroll;

    private MenuAlumno menualumno;
    private Alumno alumno;
    private Universidad universidad;

    public MenuMatricularseCarrera(Universidad universidad, MenuAlumno menualumno, Alumno alumno){
        this.universidad = universidad;
        this.menualumno = menualumno;
        this.alumno = alumno;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Listado de carreras dentro de la universidad");
        label1.setBounds(5,5,300,30);
        add(label1);
        
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

    @Override
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


//menu para inscribirse a una o mas materias de una carrera
class MenuInscribirseMateria extends JFrame implements ActionListener{
    private JLabel label1, label2;
    private JButton boton1, boton2;
    private JTable tabla1;
    private JScrollPane scroll;

    private MenuAlumno menualumno;
    private Alumno alumno;
    private Carrera carrera;

    public MenuInscribirseMateria(MenuAlumno menualumno, Alumno alumno){
        this.carrera = alumno.getCarreraMatriculada();
        this.menualumno = menualumno;
        this.alumno = alumno;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Listado de materias dentro de la carrera " + carrera.getNombre());
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

        boton1 = new JButton("Matricularse");
        boton1.setBounds(10,280,120,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Volver");
        boton2.setBounds(10,320,80,30);
        add(boton2);
        boton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            int filaSeleccionada = tabla1.getSelectedRow();
            if(filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una materia.",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            }else{
                String resultado = alumno.inscribirMateria(Integer.valueOf(((String) tabla1.getValueAt(filaSeleccionada, 0))));
                switch(resultado) {
                    case "Éxito":
                        JOptionPane.showMessageDialog(null, "Inscripción realizada.");
                        break;
                
                    case "Ya inscripto":
                        JOptionPane.showMessageDialog(null, "Ya se encuentra inscripto en esta materia.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                        break;
                }

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

//menu encargado de mostrar la asistencia en distintas materias del alumno
class MenuVerAsistencia extends JFrame implements ActionListener{
    private JLabel label1;
    private JButton boton1;
    private JTable tabla1;
    private JScrollPane scroll;

    private MenuAlumno menualumno;
    private Alumno alumno;
    private Carrera carrera;

    
    public MenuVerAsistencia(MenuAlumno menualumno, Alumno alumno){
        this.menualumno = menualumno;
        this.alumno = alumno;
        this.carrera = alumno.getCarreraMatriculada();

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Listado de asistencias de " + alumno.getNombre() + " " + alumno.getApellido());
        label1.setBounds(5,5,300,30);
        add(label1);

        String[] columnas = {"Materia", "Porcentaje de Asistencia"};

        Materia[] listamaterias = alumno.getMateriasInscriptas().toArray(new Materia[0]);
        String[][] filas = new String[listamaterias.length][2];

        for(int i=0; i < listamaterias.length; i++){
            filas[i][0] = listamaterias[i].getNombre();
            filas[i][1] = alumno.verAsistencia(listamaterias[i].getId_materia());
        }
        tabla1 = new JTable(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla1.setRowHeight(30);
        tabla1.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabla1.getColumnModel().getColumn(1).setPreferredWidth(80);

        scroll = new JScrollPane(tabla1);
        scroll.setBounds(5,50,500,220);
        add(scroll);

        boton1 = new JButton("Volver");
        boton1.setBounds(10,320,80,30);
        add(boton1);
        boton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            menualumno.setVisible(true);
            dispose();
        }
    }
}
