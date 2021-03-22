/*
 * Implementación del Modelo de Datos del patrón de diseño MVC.
   Extiende una clase Observable. De esta forma la Interfaz Observer puede
    vigilar el comportamiento del modelo de datos.
 */
package backtracking.Datos;

import java.util.Observable;

/**
 *
 * @author mascport
 */
public class Datos extends Observable {

    //Variables que mantienen el estado del modelo de datos de MVC
    private int num;

    //Constructor que inicializa el modelo de datos
    public Datos() {
        inicializar();
    }

    //Métodos que modifican el estado del modelo
    //gets, sets, ...     Ejemplo:
    public void cambiarEstado() {
        num++;
        if (num == 360) {
            num = 0;
        }
        notificarCambio();  //Notifica del cambio del modelo de datos a todos los objetos OBSERVADORES
    }
    
    public int getNum() {
        return num;
    }
    
    public void inicializar() {
        num = -1;
    }
    
    //Método que avisa a los Observadores
    private void notificarCambio() {
        setChanged();  //Marca al modelo de datos como MODIFICADO
        notifyObservers();  //Notifica a los observadores que miren si el modelo (el observado) ha cambiado
    }
}
