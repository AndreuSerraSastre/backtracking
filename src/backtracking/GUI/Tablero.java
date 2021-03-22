/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking.GUI;

import backtracking.Datos.Datos;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
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
public class Tablero extends JPanel implements Observer {

    private Datos dad;
    private BufferedImage bima;
    private int LONG = 800;
    private int N = 7;

    public Tablero(Datos d) {
        this.setPreferredSize(new Dimension(LONG, LONG));
        this.setLayout(new BorderLayout());
        dad = d;
        bima = null;
    }

    @Override
    public void repaint() {
        if (this.getGraphics() != null) {
            paint(this.getGraphics());
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

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

        dibujarPieza(g, radio);

        if (dad.getNum() == 0) {
            g.setColor(new Color(0, 0, 0));
            g.drawOval(200, 200, 150, 150);
            g.fillOval(200, 200, 150, 150);
        } else if (dad.getNum() > 0) {
            g.setColor(new Color(255, 0, 0));
            g.drawArc(200, 200, 150, 150, 0, dad.getNum());
            g.fillArc(200, 200, 150, 150, 0, dad.getNum());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    private void dibujarPieza(Graphics g, int radio) {
        try {
            int posicionx = 5; //informacion que tendra la pieza
            int posiciony = 6; //informacion que tendra la pieza
            BufferedImage image = ImageIO.read(new File("imagenes/torre-negra.png")); //informacion que tendra la pieza
            g.drawImage(image, radio * posicionx, radio * posiciony, radio, radio, this);
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
