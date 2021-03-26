package backtracking.Datos;

import java.awt.Point;

public class Araña extends Pieza {

    public Araña(int posicionX, int posicionY, boolean NB) {
        super(posicionX, posicionY);

        setMovimientos(new Point(0, 2));
        setMovimientos(new Point(1, 2));
        setMovimientos(new Point(2, 2));
        setMovimientos(new Point(1, 1));
        setMovimientos(new Point(2, 1));
        setMovimientos(new Point(2, 0));

        setMovimientos(new Point(1, -1));
        setMovimientos(new Point(2, -1));
        setMovimientos(new Point(1, -2));
        setMovimientos(new Point(2, -2));

        setMovimientos(new Point(0, -2));
        setMovimientos(new Point(-1, -2));
        setMovimientos(new Point(-2, -2));
        setMovimientos(new Point(-2, -1));
        setMovimientos(new Point(-1, -1));
        setMovimientos(new Point(-2, 0));

        setMovimientos(new Point(-2, -1));
        setMovimientos(new Point(-1, 1));
        setMovimientos(new Point(-2, 2));
        setMovimientos(new Point(-1, 2));

        if (NB) {
            setImagen("imagenes/araña-negra.png");
        } else {
            setImagen("imagenes/araña-blanca.png");
        }
    }
}
