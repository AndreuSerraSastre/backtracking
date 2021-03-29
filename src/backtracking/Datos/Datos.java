package backtracking.Datos;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

public class Datos extends Observable {

    private int N = 7;
    private int contador;
    private boolean[][] visitadas;
    private int[][] orden;
    private int velocidad = 7;
    private boolean run = false;
    private boolean turbo = false;
    private ArrayList<Pieza> piezas;

    //Constructor que inicializa el modelo de datos
    public Datos() {
        inicializar();
    }

    public boolean isTurbo() {
        return turbo;
    }

    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
    }

    public int getN() {
        return N;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void setN(int N) {
        this.N = N;
        visitadas = new boolean[N][N];
        orden = new int[N][N];
        notificarCambio();
    }

    public void inicializar() {
        contador = 1;
        piezas = new ArrayList<>();
        visitadas = new boolean[N][N];
        orden = new int[N][N];
        run = false;
        notificarCambio();
    }

    public ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    //Método que avisa a los Observadores
    private void notificarCambio() {
        setChanged();  //Marca al modelo de datos como MODIFICADO
        notifyObservers();  //Notifica a los observadores que miren si el modelo (el observado) ha cambiado
    }

    public void notificarCambioFin() {
        notificarCambio();
    }

    public void setPiezas(Pieza pieza) {
        if (!visitadas[pieza.getPosicionX()][pieza.getPosicionY()]) {
            piezas.add(pieza);
            visitadas[pieza.getPosicionX()][pieza.getPosicionY()] = true;
            orden[pieza.getPosicionX()][pieza.getPosicionY()] = contador;
            contador++;
            notificarCambio();
        }
    }

    public void changePositionPieza(Pieza pieza, Point p) {
        pieza.setPosicionX(p.x);
        pieza.setPosicionY(p.y);
        visitadas[p.x][p.y] = true;
        orden[p.x][p.y] = contador;
        contador++;
        if (!turbo) {
            notificarCambio();
        }
    }

    public boolean visitada(Point p) {
        return visitadas[p.x][p.y];
    }

    public boolean todasVisitadas() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitadas[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getOrden(int i, int j) {
        return orden[i][j];
    }

    public void quitarVisita(Pieza pieza, Point anteriorPos) {
        orden[pieza.getPosicionX()][pieza.getPosicionY()] = 0;
        visitadas[pieza.getPosicionX()][pieza.getPosicionY()] = false;
        pieza.setPosicionX(anteriorPos.x);
        pieza.setPosicionY(anteriorPos.y);
        contador--;
        if (!turbo) {
            notificarCambio();
        }
    }
}
