package backtracking.Datos;

import java.awt.Point;

public class Torre extends Pieza {

    public Torre(int posicionX, int posicionY, boolean NB, int N) {
        super(posicionX, posicionY);
        for (int i = 1; i < N; i++) {
            setMovimientos(new Point(0, i));
            setMovimientos(new Point(0, i * -1));
            setMovimientos(new Point(i, 0));
            setMovimientos(new Point(i * -1, 0));
        }
        if (NB) {
            setImagen("imagenes/torre-negra.png");
        } else {
            setImagen("imagenes/torre-blanca.png");
        }
    }

}
