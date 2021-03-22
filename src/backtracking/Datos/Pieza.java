package backtracking.Datos;

import java.awt.Point;
import java.util.ArrayList;

public class Pieza {

    private int posicionX;
    private int posicionY;
    private ArrayList<Point> movimientos = new ArrayList<>();
    private String imagen;
    
    public Pieza(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public ArrayList<Point> getMovimientos() {
        return movimientos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setMovimientos(Point movimiento) {
        this.movimientos.add(movimiento);
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
