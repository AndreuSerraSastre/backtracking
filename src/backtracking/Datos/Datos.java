package backtracking.Datos;

import java.util.ArrayList;
import java.util.Observable;

public class Datos extends Observable {

    private int N = 7;
    private Pieza pieza1;
    private Pieza pieza2;

    //Constructor que inicializa el modelo de datos
    public Datos() {
        inicializar();
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
        notificarCambio();
    }

    public void inicializar() {
        pieza1 = null;
        pieza2 = null;
        notificarCambio();
    }

    public ArrayList<Pieza> getPiezas() {
        ArrayList<Pieza> piezas = new ArrayList<>();
        if (pieza1 != null) {
            piezas.add(pieza1);
        }
        if (pieza2 != null) {
            piezas.add(pieza2);
        }
        return piezas;
    }

    //Método que avisa a los Observadores
    private void notificarCambio() {
        setChanged();  //Marca al modelo de datos como MODIFICADO
        notifyObservers();  //Notifica a los observadores que miren si el modelo (el observado) ha cambiado
    }

    public void setPiezas(Pieza pieza) {
        if (pieza1 == null && (pieza2 == null || pieza.getPosicionX() != pieza2.getPosicionX() || pieza.getPosicionY() != pieza2.getPosicionY())) {
            pieza1 = pieza;
        } else if (pieza2 == null && (pieza1 == null || pieza.getPosicionX() != pieza1.getPosicionX() || pieza.getPosicionY() != pieza1.getPosicionY())) {
            pieza2 = pieza;
        }
        notificarCambio();
    }

    public void changePositionPieza(Pieza pieza, int x, int y) {
        pieza.setPosicionX(x);
        pieza.setPosicionY(y);
        notificarCambio();
    }

}
