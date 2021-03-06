/*
 * Proceso de cálculo. Simula un cálculo cambiando los datos de la parte
    del modelo Mvc.
 */
package backtracking.Controlador;

import backtracking.Datos.Alfil;
import backtracking.Datos.Araña;
import backtracking.Datos.Caballo;
import backtracking.Datos.Datos;
import backtracking.Datos.Peon;
import backtracking.Datos.Pieza;
import backtracking.Datos.Rayo;
import backtracking.Datos.Rei;
import backtracking.Datos.Reina;
import backtracking.Datos.Torre;
import java.awt.Point;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

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
        long tempsfuncio = System.nanoTime();
        visitar(0);
        tempsfuncio = System.nanoTime() - tempsfuncio;

        if (dad.todasVisitadas()) {
            JOptionPane.showMessageDialog(null, "Se ha finalizado el recorrido con un tiempo de: " + formatNano(tempsfuncio) + " s.", "¡FINALIZADO!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar ninguna solución.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        dad.notificarCambioFin();
    }

    private String formatNano(long temps) {
        long segundos = TimeUnit.SECONDS.convert(temps, TimeUnit.NANOSECONDS);
        long milisegundos = TimeUnit.MILLISECONDS.convert(temps - (segundos * 1000 * 1000 * 1000), TimeUnit.NANOSECONDS);

        return segundos + "." + milisegundos;
    }

    public void parar() {
        seguir = false;
        dad.notificarCambioFin();
    }

    //Espera de x/360 milisegundos
    private void esperar() {
        try {
            Thread.sleep(200000 / (100 * dad.getVelocidad()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setPieza(int x, int y, String pieza, boolean BN) {
        switch (pieza) {
            case "Caballo":
                dad.setPiezas(new Caballo(x, y, BN));
                break;
            case "Rei":
                dad.setPiezas(new Rei(x, y, BN));
                break;
            case "Reina":
                dad.setPiezas(new Reina(x, y, BN, dad.getN()));
                break;
            case "Torre":
                dad.setPiezas(new Torre(x, y, BN, dad.getN()));
                break;
            case "Araña":
                dad.setPiezas(new Araña(x, y, BN));
                break;
            case "Rayo":
                dad.setPiezas(new Rayo(x, y, BN));
                break;
            case "Peon":
                dad.setPiezas(new Peon(x, y, BN));
                break;
            case "Alfil":
                dad.setPiezas(new Alfil(x, y, BN, dad.getN()));
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
                        if (!dad.isTurbo()) {
                            esperar();
                        }
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
