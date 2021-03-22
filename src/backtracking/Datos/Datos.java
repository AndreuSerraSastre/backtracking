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

    public void cambiarEstado() {
        notificarCambio();  //Notifica del cambio del modelo de datos a todos los objetos OBSERVADORES
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public void inicializar() {
        piezas.add(new Rei(4, 2, false));
        piezas.add(new Rei(1, 2, true));
        piezas.add(new Rei(6, 6, false));

        piezas.add(new Reina(0, 0, false));
        piezas.add(new Reina(5, 5, true));
        piezas.add(new Reina(1, 5, false));

        piezas.add(new Torre(3, 3, false, N));
        piezas.add(new Torre(1, 0, false, N));
    }

    public ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    //Método que avisa a los Observadores
    private void notificarCambio() {
        setChanged();  //Marca al modelo de datos como MODIFICADO
        notifyObservers();  //Notifica a los observadores que miren si el modelo (el observado) ha cambiado
    }
}
