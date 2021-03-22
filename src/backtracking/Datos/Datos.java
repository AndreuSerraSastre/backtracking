package backtracking.Datos;

import java.util.ArrayList;
import java.util.Observable;

public class Datos extends Observable {

    private int N = 7;
    private ArrayList<Pieza> piezas = new ArrayList<>();

    //Constructor que inicializa el modelo de datos
    public Datos() {
        inicializar();
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public void inicializar() {
    }

    public ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    //Método que avisa a los Observadores
    private void notificarCambio() {
        setChanged();  //Marca al modelo de datos como MODIFICADO
        notifyObservers();  //Notifica a los observadores que miren si el modelo (el observado) ha cambiado
    }

    public void setPiezas(Pieza pieza) {
        this.piezas.add(pieza);
        notificarCambio();
    }
    
    public void changePositionPieza(Pieza pieza, int x, int y){
        pieza.setPosicionX(x);
        pieza.setPosicionY(y);
        notificarCambio();
    }

}
