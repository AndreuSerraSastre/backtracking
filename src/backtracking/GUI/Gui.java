/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking.GUI;

import backtracking.Datos.Datos;
import backtracking.Principal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author mascport
 */
public class Gui extends JFrame implements ActionListener, ChangeListener {

    //Punteros al panel principal de la GUI y al Modelo de datos
    private final Principal prog;
    private final Tablero tablero;
    private final Datos dad;
    public final String BOTON01 = "Play";
    public final String BOTON02 = "Stop";
    public final String BOTON03 = "Borrar Piezas";
    public final String BOTON04 = "Crear NxN";
    public final String BOTON05 = "Reiniciar";
    private javax.swing.JComboBox<String> piezasComboBox;
    private JButton start;
    private JButton stop;
    private JButton deleteAll;
    private JButton setN;
    private JButton reiniciar;
    private TextField numero;

    //Constructor de la Interfaz gráfica de usuario
    public Gui(Datos d, Principal p) {
        super("Recorrido de una pieza por un panel de NxN");
        prog = p;
        dad = d;
        this.setLayout(new BorderLayout());
        tablero = new Tablero(dad, this);
        this.add(hacerComandos(), BorderLayout.NORTH);
        this.add(tablero, BorderLayout.CENTER);
        this.pack();
        JSlider barra = new JSlider(1, 70, 7);
        barra.setOpaque(true);
        barra.addChangeListener(this);
        this.add(BorderLayout.SOUTH, barra);
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

        start = new JButton(BOTON01);
        start.setName(BOTON01);
        start.setEnabled(false);
        start.addActionListener(this);
        pan.add(start);

        stop = new JButton(BOTON02);
        stop.setName(BOTON02);
        stop.addActionListener(this);
        pan.add(stop);
        stop.setEnabled(false);

        deleteAll = new JButton(BOTON03);
        deleteAll.setName(BOTON03);
        deleteAll.addActionListener(this);
        pan.add(deleteAll);
        deleteAll.setEnabled(true);

        reiniciar = new JButton(BOTON05);
        reiniciar.setName(BOTON05);
        reiniciar.addActionListener(this);
        pan.add(reiniciar);
        reiniciar.setEnabled(true);

        piezasComboBox = new javax.swing.JComboBox<>();
        piezasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Caballo", "Rei", "Reina", "Torre", "Araña", "Rayo"}));
        pan.add(piezasComboBox);

        numero = new TextField();
        numero.setPreferredSize(new Dimension(50, 24));
        pan.add(numero);
        setN = new JButton(BOTON04);
        setN.setName(BOTON04);
        setN.addActionListener(this);
        pan.add(setN);
        setN.setEnabled(true);

        return pan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent comp = (JComponent) e.getSource();
        switch (comp.getName()) {
            case BOTON01:
                start.setEnabled(false);
                stop.setEnabled(true);
                deleteAll.setEnabled(false);
                reiniciar.setEnabled(false);
                setN.setEnabled(false);
                prog.notificar("gui:" + BOTON01);
                dad.setRun(true);
                break;
            case BOTON02:
                start.setEnabled(true);
                stop.setEnabled(false);
                reiniciar.setEnabled(true);
                prog.notificar("gui:" + BOTON02);
                break;
            case BOTON03:
                start.setEnabled(false);
                stop.setEnabled(false);
                prog.notificar("gui:" + BOTON03);
                break;
            case BOTON04:
                try {
                    Integer.parseInt(numero.getText());
                } catch (NumberFormatException ex) {
                    System.out.println("Número incorrecto. " + ex);
                    return;
                }
                prog.notificar("gui:" + BOTON04 + "/" + numero.getText());
                break;
            case BOTON05:
                start.setEnabled(false);
                stop.setEnabled(false);
                deleteAll.setEnabled(true);
                setN.setEnabled(true);
                prog.notificar("gui:" + BOTON05);
                break;
            default:
                break;
        }
    }

    public void setPieza(int x, int y) {
        if (!dad.isRun()) {
            prog.notificar("setPieza:" + x + "/" + y + "/" + piezasComboBox.getSelectedItem().toString());
            start.setEnabled(true);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        prog.notificar("Velocitat:" + ((JSlider) e.getSource()).getValue());
    }

}
