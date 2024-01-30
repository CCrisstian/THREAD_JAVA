package org.CCristian.HILOS.Ejemplos;

import org.CCristian.HILOS.Ejemplos.Threads.Nombre_Thread;

public class Ejemplo_EXTEDER_Thread {
    public static void main(String[] args) {
        Thread hilo = new Nombre_Thread("Jhon Doe");
        /*Cuando se crea la instancia es un hilo nuevo, que todavía no se ha ejecutado*/
        System.out.println("hilo:'"+hilo.getName()+"' estado: "+hilo.getState());

        hilo.start();
        /*El hilo trabaja de forma asíncrona*/

        Thread hilo2 = new Nombre_Thread("Maria");
        hilo2.start();

        Nombre_Thread hilo3 = new Nombre_Thread("Pepe");
        hilo3.start();
        System.out.println("hilo:'"+hilo.getName()+"' estado: "+hilo.getState());

    }
}
