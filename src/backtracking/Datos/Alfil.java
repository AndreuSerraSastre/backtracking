package backtracking.Datos;

import java.awt.Point;

public class Alfil extends Pieza {

    public Alfil(int posicionX, int posicionY, boolean NB, int N) {
        super(posicionX, posicionY);

        for (int i = 1; i < N; i++) {
            setMovimientos(new Point(i, i));
            setMovimientos(new Point(i, i * -1));
            setMovimientos(new Point(i * -1, i));
            setMovimientos(new Point(i * -1, i * -1));
        }

        if (NB) {
            setImagen("imagenes/alfil-negro.png");
        } else {
            setImagen("imagenes/alfil-blanco.png");
        }
    }
}
