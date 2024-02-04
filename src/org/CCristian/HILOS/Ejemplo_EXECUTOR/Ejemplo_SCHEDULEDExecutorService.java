package org.CCristian.HILOS.Ejemplo_EXECUTOR;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ejemplo_SCHEDULEDExecutorService {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main ....");

        executor.schedule(() -> {
            System.out.println("Hola mundo tarea ...(ANTES del TimeUnit.MILLISECONDS.sleep(timeout:1000))");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola mundo tarea ...(DESPUÉS del TimeUnit.MILLISECONDS.sleep)");
        }, 2000, TimeUnit.MILLISECONDS);

        System.out.println("Alguna otra tarea en el main ....");
        executor.shutdown();

    }
}
