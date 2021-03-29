/*
 * Proceso de cálculo. Simula un cálculo cambiando los datos de la parte
    del modelo Mvc.
 */
package backtracking.Controlador;

import backtracking.Datos.Araña;
import backtracking.Datos.Caballo;
import backtracking.Datos.Datos;
import backtracking.Datos.Pieza;
import backtracking.Datos.Rayo;
import backtracking.Datos.Rei;
import backtracking.Datos.Reina;
import backtracking.Datos.Torre;
import java.awt.Point;

public class Proceso extends Thread {

    //Puntero a los datos del programa.
    private final Datos dad;
    private boolean seguir;

    //Constructor del proceso que guarda un puntero a los datos del programa
    public Proceso(Datos d) {
        dad = d;
    }

    //Bucle de ejecución que cambia el estado del Modelo de datos.
    @Override
    public void run() {
        seguir = true;

//        while (!seguir) {
        visitar(0);
//            esperar();
//        }
    }

    public void parar() {
        seguir = false;
    }

    //Espera de x/360 milisegundos
    private void esperar() {
        try {
            Thread.sleep(100000 / 360);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setPieza(int x, int y, String pieza) {
        switch (pieza) {
            case "Caballo":
                dad.setPiezas(new Caballo(x, y, false));
                break;
            case "Rei":
                dad.setPiezas(new Rei(x, y, false));
                break;
            case "Reina":
                dad.setPiezas(new Reina(x, y, false, dad.getN()));
                break;
            case "Torre":
                dad.setPiezas(new Torre(x, y, false, dad.getN()));
                break;
            case "Araña":
                dad.setPiezas(new Araña(x, y, false));
                break;
            case "Rayo":
                dad.setPiezas(new Rayo(x, y, false));
                break;
        }
    }

    private void visitar(int i) {
        Pieza pieza = dad.getPiezas().get(i);
        while (!seguir) {
            esperar();
        }
        if (!dad.todasVisitadas()) {
            for (Point movimiento : pieza.getMovimientos()) {
                Point siguientePos = mirarMovEnTablero(pieza.getPosicion(), movimiento);
                if (valida(siguientePos)) {
                    if (!dad.visitada(siguientePos)) {
                        Point anteriorPos = pieza.getPosicion();
                        dad.changePositionPieza(pieza, siguientePos);
                        esperar();
                        visitar((i + 1) % dad.getPiezas().size());
                        if (!dad.todasVisitadas()) {
                            dad.quitarVisita(pieza, anteriorPos);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private Point mirarMovEnTablero(Point posicion, Point movimiento) {
        return new Point(posicion.x + movimiento.x, posicion.y + movimiento.y);
    }

    private boolean valida(Point siguientePos) {
        return siguientePos.x >= 0 && siguientePos.x < dad.getN() && siguientePos.y >= 0 && siguientePos.y < dad.getN();
    }
}
