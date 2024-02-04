package org.CCristian.HILOS.EjemplosSYNC;

import org.CCristian.HILOS.EjemplosSYNC.Runnable.Consumidor;
import org.CCristian.HILOS.EjemplosSYNC.Runnable.Panadero;

public class Ejemplo_ProductorConsumidor {
    public static void main(String[] args) {

        Panaderia panaderia = new Panaderia();
        new Thread(new Panadero(panaderia)).start();
        new Thread((new Consumidor(panaderia))).start();
    }
}
