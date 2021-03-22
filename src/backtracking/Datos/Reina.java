package backtracking.Datos;

import java.awt.Point;

public class Reina extends Pieza {

    public Reina(int posicionX, int posicionY, boolean NB) {
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
            setImagen("imagenes/reina-negra.png");
        } else {
            setImagen("imagenes/reina-blanca.png");
        }
    }
}
