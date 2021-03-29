package backtracking;

import backtracking.Controlador.Proceso;
import backtracking.Datos.Datos;
import backtracking.GUI.Gui;

public class Principal {

    // punteros al proceso de cambio de datos y a la GUI
    private Proceso proc;
    private Datos dad;
    private Gui gui;

    //Método de inicio de programa
    private void inicio() {
        dad = new Datos();
        gui = new Gui(dad, this);
        proc = null;
        dad.addObserver(gui.getCentro()); //Añade al panel de dibujo como Observador de los cambios en el modelo de datos.
        gui.setVisible(true);
    }

    public void notificar(String s) {
        if (s.contentEquals("gui" + ":" + gui.BOTON01)) {
            if (proc == null) {
                proc = new Proceso(dad);
                proc.start();
            } else {
                proc = new Proceso(dad);
                proc.start();
            }
        } else if (s.contentEquals("gui" + ":" + gui.BOTON02) && proc != null) {
            proc.parar();
            proc = null;
        } else if (s.contentEquals("gui" + ":" + "Borrar Piezas") && proc != null) {
            dad.inicializar();
        } else if (s.startsWith("setPieza" + ":")) {
            s = s.split(":")[1];
            int x = Integer.parseInt(s.split("/")[0]);
            int y = Integer.parseInt(s.split("/")[1]);
            String pieza = s.split("/")[2];
            if (proc == null) {
                proc = new Proceso(dad);
                proc.setPieza(x, y, pieza);
            } else {
                proc.setPieza(x, y, pieza);
            }
        } else if (s.startsWith("gui" + ":" + gui.BOTON04)) {
            int N = Integer.parseInt(s.split("/")[1]);
            dad.setN(N);
            dad.inicializar();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal aux = new Principal();
        aux.inicio();
    }

}
