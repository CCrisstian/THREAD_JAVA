package org.CCristian.HILOS.Ejemplos;

import org.CCristian.HILOS.Ejemplos.Runnable.ImprimirFrases;

public class Ejemplo_SINCRONIZACION_Thread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimirFrases("Hola ","que tal!")).start();
        new Thread(new ImprimirFrases("¿Quién eres ","tu?")).start();

        Thread.sleep(100);
        /*De manera que cuando h3 quiera usar el método Imprimir_Frases este esté ocupado*/
        Thread h3 = new Thread(new ImprimirFrases("Muchas ","gracias amigo!"));
        h3.start();
        Thread.sleep(100);
        System.out.println("h3.getState: " + h3.getState());
    }

    /*Agregando 'synchronized' al método cada hilo lo utilizara en orden, uno a la vez*/
    public synchronized static void Imprimir_Frases(String frase1, String frase2){
        System.out.print(frase1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(frase2);
    }
}
