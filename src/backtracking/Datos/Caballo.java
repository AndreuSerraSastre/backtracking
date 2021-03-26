package backtracking.Datos;

import java.awt.Point;

public class Caballo extends Pieza {

    public Caballo(int posicionX, int posicionY, boolean NB) {
        super(posicionX, posicionY);
        setMovimientos(new Point(2, -1));
        setMovimientos(new Point(2, 1));
        setMovimientos(new Point(1, 2));
        setMovimientos(new Point(-1, 2));
        setMovimientos(new Point(-2, 1));
        setMovimientos(new Point(-2, -1));
        setMovimientos(new Point(1, -2));
        setMovimientos(new Point(-1, -2));
        if (NB) {
            setImagen("imagenes/caballo-negro.png");
        } else {
            setImagen("imagenes/caballo-blanco.png");
        }
    }

}
