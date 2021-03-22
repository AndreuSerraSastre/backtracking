package backtracking.Datos;

import java.awt.Point;

public class Torre extends Pieza {

    public Torre(int posicionX, int posicionY, boolean NB, int N) {
        super(posicionX, posicionY);
        for (int i = 1; i < N; i++) {
            setMovimientos(new Point(0, N));
            setMovimientos(new Point(0, N * -1));
            setMovimientos(new Point(N, 0));
            setMovimientos(new Point(N * -1, 0));
        }
        if (NB) {
            setImagen("imagenes/torre-negra.png");
        } else {
            setImagen("imagenes/torre-blanca.png");
        }
    }

}
