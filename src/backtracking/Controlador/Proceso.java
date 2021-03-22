/*
 * Proceso de cálculo. Simula un cálculo cambiando los datos de la parte
    del modelo Mvc.
 */
package backtracking.Controlador;

import backtracking.Datos.Datos;


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
        while (seguir) {
            dad.cambiarEstado();
            esperar();
        }
    }

    public void parar() {
        seguir = false;
    }
    
    //Espera de x/360 milisegundos
    private void esperar() {
        try {
            Thread.sleep(1000/360);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
