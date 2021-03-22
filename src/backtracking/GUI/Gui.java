/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking.GUI;

import backtracking.Datos.Datos;
import backtracking.Principal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mascport
 */
public class Gui extends JFrame implements ActionListener {
    
    //Punteros al panel principal de la GUI y al Modelo de datos
    private Principal prog;
    private Tablero tablero;
    private Datos dad;
    public final String BOTON01 = "Start01";
    public final String BOTON02 = "Stop01";
    
    //Constructor de la Interfaz gráfica de usuario
    public Gui(Datos d, Principal p) {
        super("Recorrido de una pieza por un panel de NxN");
        prog = p;
        dad = d;
        this.setLayout(new BorderLayout());
        tablero = new Tablero(dad);
        this.add(hacerComandos(), BorderLayout.NORTH);
        this.add(tablero, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setResizable(false);
    }
    
    //Devuelve un puntero al panel de dibujo
    public Tablero getCentro() {
        return tablero;
    }

    private JPanel hacerComandos() {
        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());
        JButton but = new JButton(BOTON01);
        but.setName(BOTON01);
        but.addActionListener(this);
        pan.add(but);
        but = new JButton(BOTON02);
        but.setName(BOTON02);
        but.addActionListener(this);
        pan.add(but);
        return pan;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent comp = (JComponent)e.getSource();
        if(comp.getName().contentEquals(BOTON01)) {
            prog.notificar("gui:" + BOTON01);
        } else if(comp.getName().contentEquals(BOTON02)) {
            prog.notificar("gui:" + BOTON02);
        }
    }
}
