package backtracking.Datos;

import java.awt.Point;

public class Reina extends Pieza {

    public Reina(int posicionX, int posicionY, boolean NB, int N) {
        super(posicionX, posicionY);
        for (int i = 1; i < N; i++) {
            setMovimientos(new Point(0, i));
            setMovimientos(new Point(0, i * -1));
            setMovimientos(new Point(i, 0));
            setMovimientos(new Point(i * -1, 0));
            setMovimientos(new Point(i, i));
            setMovimientos(new Point(i, i * -1));
            setMovimientos(new Point(i * -1, i));
            setMovimientos(new Point(i * -1, i * -1));
        }
        if (NB) {
            setImagen("imagenes/reina-negra.png");
        } else {
            setImagen("imagenes/reina-blanca.png");
        }
    }
}
