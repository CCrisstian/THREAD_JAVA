package org.CCristian.HILOS.EjemplosSYNC;

import java.util.concurrent.ThreadLocalRandom;

public class Ejemplo_ProductorConsumidor_JAVA8 {
    public static void main(String[] args) {

        Panaderia panaderia = new Panaderia();

        new Thread(() -> {  /*PANADERO*/
            for (int i = 0; i < 10; i++){
                panaderia.Hornear("Pan n°: "+ i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {  /*CONSUMIDOR*/
            for (int i = 0; i < 10; i++){
                panaderia.Consumir();
            }
        }).start();

    }
}
