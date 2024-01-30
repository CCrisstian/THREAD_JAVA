package org.CCristian.HILOS.Ejemplos;

import org.CCristian.HILOS.Ejemplos.Runnable.ViajeTarea;

public class Ejemplo_InterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Isla de Pascua")).start();
        new Thread(new ViajeTarea("Robinson Crusoe")).start();
        new Thread(new ViajeTarea("Juan Fernandez")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();

    }
}
