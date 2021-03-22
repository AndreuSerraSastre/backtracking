/*
 * Proceso de cálculo. Simula un cálculo cambiando los datos de la parte
    del modelo Mvc.
 */
package backtracking.Controlador;

import backtracking.Datos.Datos;
import backtracking.Datos.Pieza;
import backtracking.Datos.Rei;
import backtracking.Datos.Reina;
import backtracking.Datos.Torre;

public class Proceso extends Thread {

    //Puntero a los datos del programa.
    private Datos dad;
    private boolean seguir;

    //Constructor del proceso que guarda un puntero a los datos del programa
    public Proceso(Datos d) {
        dad = d;
    }

    //Bucle de ejecución que cambia el estado del Modelo de datos.
    public void run() {
        seguir = true;

        dad.setPiezas(new Rei(4, 2, false));
        dad.setPiezas(new Rei(1, 2, true));
        
        dad.setPiezas(new Reina(5, 5, true));
        dad.setPiezas(new Reina(1, 5, false));

        dad.setPiezas(new Torre(1, 0, false, dad.getN()));
        
        Pieza pieza = new Torre(3, 3, true, dad.getN());
        dad.setPiezas(pieza);

        while (seguir) {
            dad.changePositionPieza(pieza, pieza.getPosicionX() + 1, pieza.getPosicionY() + 1);
            if (pieza.getPosicionX() == dad.getN()) {
                dad.changePositionPieza(pieza, 0, 0);
            }
            esperar();
        }
    }

    public void parar() {
        seguir = false;
    }

    //Espera de x/360 milisegundos
    private void esperar() {
        try {
            Thread.sleep(200000 / 360);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
