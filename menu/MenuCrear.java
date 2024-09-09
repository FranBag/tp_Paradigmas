package TP1_Paradigmas.menu;

import javax.swing.*;
import java.awt.event.*;

import TP1_Paradigmas.clases.Universidad;
import TP1_Paradigmas.usuarios.*;

public class MenuCrear extends JFrame implements ActionListener, ItemListener{
    private JLabel label1, label2, label3, label4, label5, label6;
    private JTextField input1, input2, input3, input4, input5;
    private JButton boton1, boton2;
    private JComboBox combo1;

    private String seleccion = "Hombre";

    private MenuLogearse login;
    private Usuario usuario;
    private Universidad universidad;


    public MenuCrear(MenuLogearse login, Universidad universidad, Usuario usuario){
        this.login = login;
        this.universidad = universidad;
        this.usuario = usuario;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Nombre");
        label1.setBounds(10,5,80,30);
        add(label1);

        label2 = new JLabel("Email");
        label2.setBounds(10,45,80,30);
        add(label2);

        label3 = new JLabel("DNI");
        label3.setBounds(10,85,60,30);
        add(label3);

        label4 = new JLabel("Apellido");
        label4.setBounds(230,5,60,30);
        add(label4);

        label5 = new JLabel("Número de telefono");
        label5.setBounds(230,45,180,30);
        add(label5);

        label6 = new JLabel("Sexo");
        label6.setBounds(230,85,60,30);
        add(label6);

        setLayout(null);
        input1 = new JTextField();
        input1.setBounds(10,30,200,20);
        input1.setText("nombre");
        add(input1);

        setLayout(null);
        input2 = new JTextField();
        input2.setBounds(10,70,200,20);
        input2.setText("email@email.com");
        add(input2);

        setLayout(null);
        input3 = new JTextField();
        input3.setBounds(10,110,200,20);
        input3.setText("12345678");
        add(input3);

        setLayout(null);
        input4 = new JTextField();
        input4.setBounds(230,30,200,20);
        input4.setText("apellido");
        add(input4);

        setLayout(null);
        input5 = new JTextField();
        input5.setBounds(230,70,200,20);
        input5.setText("3764123456");
        add(input5);

        boton1 = new JButton("Crear");
        boton1.setBounds(90,200,80,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Volver");
        boton2.setBounds(5,200,80,30);
        add(boton2);
        boton2.addActionListener(this);

        combo1 = new JComboBox();
        combo1.setBounds(230,110,80,20);
        add(combo1);
        combo1.addItem("Hombre");
        combo1.addItem("Mujer");
        combo1.addItemListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            usuario.setNombre(input1.getText());
            usuario.setApellido(input4.getText());
            usuario.setEmail(input2.getText());
            usuario.setDni(Integer.valueOf(input3.getText()));
            usuario.setN_telefono(input5.getText());
            usuario.setSexo(seleccion);
            // System.out.println(usuario.getNombre());
            // System.out.println(usuario.getApellido());
            // System.out.println(usuario.getEmail());
            // System.out.println(usuario.getDni());
            // System.out.println(usuario.getN_telefono());
            // System.out.println(usuario.getSexo());
            System.out.println(usuario.getClass());
            switch(String.valueOf(usuario.getClass())) {
                case "class TP1_Paradigmas.usuarios.Alumno":
                    Alumno alumno = ((Alumno) usuario);
                    alumno.setUniversidad(universidad);
                    MenuAlumno menuA = new MenuAlumno(login, universidad, alumno);
                    menuA.setBounds(0,0,400,300);
                    menuA.setVisible(true);
                    menuA.setLocationRelativeTo(null);
                    dispose();
                    break;

                case "class TP1_Paradigmas.usuarios.Profesor":
                    MenuProfesor menuP = new MenuProfesor(login);
                    menuP.setBounds(0,0,400,300);
                    menuP.setVisible(true);
                    menuP.setLocationRelativeTo(null);
                    dispose();
                    break;

                case "class TP1_Paradigmas.usuarios.Coordinador":
                    Coordinador coordinador = ((Coordinador) usuario);
                    MenuCoordinador menuC = new MenuCoordinador(login, coordinador);
                    menuC.setBounds(0,0,400,300);
                    menuC.setVisible(true);
                    menuC.setLocationRelativeTo(null);
                    dispose();
                    break;    

                default:
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                    dispose();
                    break;
            }
        }
        if(e.getSource() == boton2){
            login.setVisible(true);
            dispose();
        }
    }

    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == combo1){
          seleccion = combo1.getSelectedItem().toString();
        }
       }
}
