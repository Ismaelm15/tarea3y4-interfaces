/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea2gui_ismael;

/**
 *
 * @author ismae
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Se implementa la interfaz
public class Saludo extends JPanel implements ActionListener {

    private JButton botonSaludar, botonDespedir, generarAleatorio;
    private JTextArea texto;
    private JLabel texto3;
    private Random rnd = new Random();


    public Saludo() {
        initComponents();
    }

    private void initComponents() {

        botonSaludar = new JButton("Nombre");
        botonDespedir = new JButton("Apellidos");
        generarAleatorio = new JButton("Generar Aleatorio");
        texto = new JTextArea(1, 25);
        texto.setBackground(Color.ORANGE);
        texto3 = new JLabel("Numero");
        
        this.setLayout(new FlowLayout());

        this.add(botonSaludar);
        // Añadimos el botón al panel
        this.add(botonDespedir);
        this.add(texto);
        this.add(generarAleatorio);
        this.add(texto3);

// Se le indica al objeto boton que escuche eventos tipo click
// y se pasa como argumento una referencia de tipo ActionListener
// En este caso se pasa this que es el panel sobre el 
// que está el botón y que implementa la interfaz ActionListener
        botonSaludar.addActionListener(this);
        botonDespedir.addActionListener(this);
        generarAleatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                texto3.setText(Integer.toString(rnd.nextInt(11)));
            }
        });
        
        generarAleatorio.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
          }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {
             generarAleatorio.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent me) {
             generarAleatorio.setBackground(Color.WHITE);
            }
        });
        
        
        
     

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // Si el botón pulsado es botonSaludar
        if (ae.getSource() == botonSaludar) {
            texto.setText("Ismael");
            texto.setBackground(Color.WHITE);
        } else {
            texto.setText("Melgar Villalta");
            texto.setBackground(Color.BLUE);
        }

    }
}
//    @Override
//    // Sobrescribimos el método de la interfaz
//    public void actionPerformed(ActionEvent ae) {
//
//        // Este ejemplo es tan básico que no hemos usado el objeto ae
//// Indicamos el texto que queremos mostrar en el área de texto
//        texto.setText("Hola amigos!!");
//    }
//
//}
