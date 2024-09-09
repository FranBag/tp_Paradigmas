package TP1_Paradigmas.menu;

import TP1_Paradigmas.app;
import TP1_Paradigmas.clases.Universidad;
import TP1_Paradigmas.usuarios.Alumno;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

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

        label3 = new JLabel("Carrera: " + comprobarCarrera());
        label3.setBounds(10,25,200,30);
        add(label3);
        
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
            MenuMatricularseCarrera menuT = new MenuMatricularseCarrera(universidad, this, alumno);
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

    public String comprobarCarrera(){
        if(alumno.getCarreraMatriculada() != null){
            return alumno.getCarreraMatriculada().getNombre();
        }else{
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

        String[][] filas = universidad.listarCarreras();

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
                    System.out.println("HoLA");
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


// //menu para inscribirse a una o mas materias de una carrera
// class MenuInscribirseMateria extends JFrame implements ActionListener{
//     private JLabel label1, label2;
//     private JButton boton1, boton2;
//     private JTable tabla1;
//     private JScrollPane scroll;
//     private MenuAlumno menualumno;

//     public MenuInscribirseMateria(Universidad universidad, MenuAlumno menualumno){
//         this.menualumno = menualumno;
//         setLayout(null);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);

//         label1 = new JLabel("Listado de materias dentro de la carrera "+ this.carrera);
//         label1.setBounds(5,5,300,30);
//         add(label1);

//         label1 = new JLabel("Nombre / Duración / P.Inscripción");
//         label1.setBounds(5,25,600,30);
//         add(label1);
        
//         String[] columnas = {"Nombre", "Duración", "Precio Inscripción"};

//         String[][] filas = universidad.listarCarreras();

//         tabla1 = new JTable(filas, columnas){
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return false;
//             }
//         };
//         tabla1.setBounds(5,50,500,220);

//         scroll = new JScrollPane(tabla1);
//         add(tabla1);

//         boton1 = new JButton("Matricularse");
//         boton1.setBounds(10,280,120,30);
//         add(boton1);
//         boton1.addActionListener(this);

//         boton2 = new JButton("Volver");
//         boton2.setBounds(10,320,80,30);
//         add(boton2);
//         boton2.addActionListener(this);
//     }

//         public void actionPerformed(ActionEvent e){
//             if(e.getSource() == boton1){
//                 int filaSeleccionada = tabla1.getSelectedRow();
//                 if(filaSeleccionada == -1) {
//                     JOptionPane.showMessageDialog(null, "Debes seleccionar una carrera.",
//                     "Advertencia", JOptionPane.WARNING_MESSAGE);
//                 }else{
//                     JOptionPane.showMessageDialog(null, "Matriculación realizada.");
//                     menualumno.setVisible(true);
//                     menualumno.revalidate();
//                     dispose();
//                 }
//             }
//             if(e.getSource() == boton2){
//                 menualumno.repaint();
//                 menualumno.setVisible(true);
//                 menualumno.repaint();
//                 dispose();
//             }
//         }
// }