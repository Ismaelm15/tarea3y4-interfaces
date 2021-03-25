/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author ismael
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion, resultado = 0, operando1;
    private String buffer = "";

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);
        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón
        if (o instanceof JButton) {

            if (((JButton) o).getText().equals("+")) {
                botonera.grupoBotones[11].setEnabled(false);
                botonera.grupoBotones[12].setEnabled(false);
                botonera.grupoBotones[13].setEnabled(false);
            }else if (((JButton) o).getText().equals("-")) {
                botonera.grupoBotones[10].setEnabled(false);
                botonera.grupoBotones[12].setEnabled(false);
                botonera.grupoBotones[13].setEnabled(false);
            }else if (((JButton) o).getText().equals("*")) {
                botonera.grupoBotones[10].setEnabled(false);
                botonera.grupoBotones[11].setEnabled(false);
                botonera.grupoBotones[13].setEnabled(false);
            }else if (((JButton) o).getText().equals("/")) {
                botonera.grupoBotones[10].setEnabled(false);
                botonera.grupoBotones[11].setEnabled(false);
                botonera.grupoBotones[12].setEnabled(false);
            }

            if (!((JButton) o).getText().equals("=")) {
                if (((JButton) o).getText().equals("C")) {
                    resultado = 0;
                    buffer = "";
                    areaTexto.setText(buffer);
                } else {
                    System.out.println(((JButton) o).getText());
                    buffer += ((JButton) o).getText();
                    areaTexto.setText(buffer);
                }
            } else {
                botonera.grupoBotones[10].setEnabled(true);
                botonera.grupoBotones[11].setEnabled(true);
                botonera.grupoBotones[12].setEnabled(true);
                botonera.grupoBotones[13].setEnabled(true);
                if (buffer.contains("+")) {
                    buffer = buffer.replace('+', 's');
                    String[] trozos = buffer.split("s");
                    for (int i = 0; i < trozos.length; i++) {
                        resultado += Integer.parseInt(trozos[i]);

                    }
                    areaTexto.setText(Integer.toString(resultado));
                    buffer = Integer.toString(resultado);

                } else if (buffer.contains("-")) {
                    buffer = buffer.replace('-', 'r');
                    String[] trozos = buffer.split("r");
                    resultado = Integer.parseInt(trozos[0]);
                    for (int i = 1; i < trozos.length; i++) {
                        resultado -= Integer.parseInt(trozos[i]);
                    }
                    areaTexto.setText(Integer.toString(resultado));
                    buffer = Integer.toString(resultado);
                } else if (buffer.contains("*")) {
                    resultado = 1;
                    buffer = buffer.replace('*', 'm');
                    String[] trozos = buffer.split("m");
                    for (int i = 0; i < trozos.length; i++) {
                        resultado *= Integer.parseInt(trozos[i]);
                    }
                    areaTexto.setText(Integer.toString(resultado));
                    buffer = Integer.toString(resultado);
                } else if (buffer.contains("/")) {
                    buffer = buffer.replace(('/'), 'd');
                    String[] trozos = buffer.split("d");
                    resultado = Integer.parseInt(trozos[0]);
                    for (int i = 1; i < trozos.length; i++) {
                        resultado /= Integer.parseInt(trozos[i]);
                    }
                    areaTexto.setText(Integer.toString(resultado));
                    buffer = Integer.toString(resultado);
                }

            }

        }

    }

    // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
}
