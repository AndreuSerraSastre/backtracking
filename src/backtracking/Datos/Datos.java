package backtracking.Datos;

import java.util.ArrayList;
import java.util.Observable;

public class Datos extends Observable {

    private int N = 7;
    private int contador;
    private Pieza pieza1;
    private Pieza pieza2;
    private boolean[][] visitadas;
    private int[][] orden;

    //Constructor que inicializa el modelo de datos
    public Datos() {
        inicializar();
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
        visitadas = new boolean[N][N];
        orden = new int[N][N];
        notificarCambio();
    }

    public void inicializar() {
        contador = 1;
        pieza1 = null;
        pieza2 = null;
        visitadas = new boolean[N][N];
        orden = new int[N][N];
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
        if (pieza1 == null && !visitadas[pieza.getPosicionX()][pieza.getPosicionY()]) {
            pieza1 = pieza;
            visitadas[pieza.getPosicionX()][pieza.getPosicionY()] = true;
            orden[pieza.getPosicionX()][pieza.getPosicionY()] = contador;
            contador++;
        } else if (pieza2 == null && !visitadas[pieza.getPosicionX()][pieza.getPosicionY()]) {
            pieza2 = pieza;
            visitadas[pieza.getPosicionX()][pieza.getPosicionY()] = true;
            orden[pieza.getPosicionX()][pieza.getPosicionY()] = contador;
            contador++;
        }
        notificarCambio();
    }

    public void changePositionPieza(Pieza pieza, int x, int y) {
        pieza.setPosicionX(x);
        pieza.setPosicionY(y);
        visitadas[x][y] = true;
        orden[x][y] = contador;
        contador++;
        notificarCambio();
    }

    public boolean todasVisitadas(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visitadas[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
