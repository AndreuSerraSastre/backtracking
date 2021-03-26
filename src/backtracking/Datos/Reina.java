package backtracking.Datos;

import java.awt.Point;

public class Reina extends Pieza {

    public Reina(int posicionX, int posicionY, boolean NB, int N) {
        super(posicionX, posicionY);
        for (int i = 1; i < N; i++) {
            setMovimientos(new Point(0, N));
            setMovimientos(new Point(0, N * -1));
            setMovimientos(new Point(N, 0));
            setMovimientos(new Point(N * -1, 0));
            setMovimientos(new Point(N, N));
            setMovimientos(new Point(N, N * -1));
            setMovimientos(new Point(N * -1, N));
            setMovimientos(new Point(N * -1, N * -1));
        }
        if (NB) {
            setImagen("imagenes/reina-negra.png");
        } else {
            setImagen("imagenes/reina-blanca.png");
        }
    }
}
