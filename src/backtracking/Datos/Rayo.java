package backtracking.Datos;

import java.awt.Point;

public class Rayo extends Pieza {

    public Rayo(int posicionX, int posicionY, boolean NB) {
        super(posicionX, posicionY);

        setMovimientos(new Point(1, 1));
        setMovimientos(new Point(2, 1));
        setMovimientos(new Point(2, 2));
        setMovimientos(new Point(3, 2));

        setMovimientos(new Point(-1, 1));
        setMovimientos(new Point(-2, 1));
        setMovimientos(new Point(-2, 2));
        setMovimientos(new Point(-3, 2));

        setMovimientos(new Point(-1, -1));
        setMovimientos(new Point(-2, -1));
        setMovimientos(new Point(-2, -2));
        setMovimientos(new Point(-3, -2));

        setMovimientos(new Point(1, -1));
        setMovimientos(new Point(2, -1));
        setMovimientos(new Point(2, -2));
        setMovimientos(new Point(3, -2));

        if (NB) {
            setImagen("imagenes/rayo-negro.png");
        } else {
            setImagen("imagenes/rayo-blanca.png");
        }
    }
}
