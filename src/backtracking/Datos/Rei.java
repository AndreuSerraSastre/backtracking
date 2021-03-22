package backtracking.Datos;

import java.awt.Point;

public class Rei extends Pieza {

    public Rei(int posicionX, int posicionY, boolean NB) {
        super(posicionX, posicionY);
        setMovimientos(new Point(-1, 1));
        setMovimientos(new Point(-1, 0));
        setMovimientos(new Point(-1, -1));
        setMovimientos(new Point(0, 1));
        setMovimientos(new Point(0, -1));
        setMovimientos(new Point(1, 1));
        setMovimientos(new Point(1, 0));
        setMovimientos(new Point(1, -1));
        if (NB) {
            setImagen("imagenes/rey-negro.png");
        } else {
            setImagen("imagenes/rey-blanco.png");
        }
    }

}
