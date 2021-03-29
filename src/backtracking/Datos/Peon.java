package backtracking.Datos;

import java.awt.Point;

public class Peon  extends Pieza {

    public Peon(int posicionX, int posicionY, boolean NB) {
        super(posicionX, posicionY);

        setMovimientos(new Point(0, 1));
        setMovimientos(new Point(0, -1));

        if (NB) {
            setImagen("imagenes/peon-negro.png");
        } else {
            setImagen("imagenes/peon-blanco.png");
        }
    }
}