/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking.GUI;

import backtracking.Datos.Datos;
import backtracking.Datos.Pieza;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author mascport
 */
public class Tablero extends JPanel implements Observer, MouseListener {

    private final Datos dad;
    private final Gui gui;
    private final int LONG = 800;

    public Tablero(Datos d, Gui g) {
        this.setPreferredSize(new Dimension(LONG, LONG));
        this.setLayout(new BorderLayout());
        dad = d;
        gui = g;
        this.addMouseListener(this);
    }

    @Override
    public void repaint() {
        if (this.getGraphics() != null) {
            paint(this.getGraphics());
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int N = dad.getN();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, LONG, LONG);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY);

        // Crea tablero
        int radio = LONG / N;

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if ((j % 2) != 0) {
                    g2.fillRect(2 * radio * i, radio * j, radio, radio);
                }
                if ((i % 2 != 0)) {
                    g2.fillRect(radio * i, 2 * radio * j, radio, radio);
                }
            }
        }

        // Remarcar contorno
        Stroke pincel = new BasicStroke(2f);
        g2.setColor(Color.BLACK);
        g2.setStroke(pincel);
        g2.drawRect(0, 0, LONG - 1, LONG - 1);

        for (Pieza pieza : dad.getPiezas()) {
            dibujarPieza(g, radio, pieza);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    private void dibujarPieza(Graphics g, int radio, Pieza pieza) {
        try {
            BufferedImage image = ImageIO.read(new File(pieza.getImagen()));
            g.drawImage(image, radio * pieza.getPosicionX(), radio * pieza.getPosicionY(), radio, radio, this);
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int radio = LONG / dad.getN();
        gui.setPieza((int) me.getX() / radio, (int) me.getY() / radio);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
