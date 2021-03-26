/*
 * Proceso de cálculo. Simula un cálculo cambiando los datos de la parte
    del modelo Mvc.
 */
package backtracking.Controlador;

import backtracking.Datos.Araña;
import backtracking.Datos.Caballo;
import backtracking.Datos.Datos;
import backtracking.Datos.Rayo;
import backtracking.Datos.Rei;
import backtracking.Datos.Reina;
import backtracking.Datos.Torre;

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

        while (seguir) {
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
}
