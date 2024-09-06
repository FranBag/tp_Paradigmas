package TP1_Paradigmas.menu;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class menuLogearse extends JFrame implements ActionListener, ChangeListener{
    
    private JLabel label1;
    private JButton boton1;
    private JRadioButton radio1, radio2, radio3;
    private ButtonGroup bg;
    private int eleccion;

    public menuLogearse(){
        setLayout(null);
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
                    menuAlumno menuA = new menuAlumno();
                    menuA.setBounds(0,0,400,300);
                    menuA.setVisible(true);
                    menuA.setLocationRelativeTo(null);
                    this.setVisible(false);
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
                    break;
            }

        }
    }

    public static void main(String[] args) {
        menuLogearse menu = new menuLogearse();
        menu.setBounds(0,0,400,300);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }

}