package org.CCristian.HILOS.Ejemplo_EXECUTOR;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ejemplo_EXECUTOR {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea ...");
        };

        executor.submit(tarea); /*Devuelve un objeto future de la operación asíncrona*/
        executor.shutdown();    /*Finaliza el executor una vez que todas las tareas que realiza se completan*/
        System.out.println("Continuando con la ejecución del método main 1");
        executor.awaitTermination(2,TimeUnit.SECONDS);  /*Espera X tiempo a que finalicen las tareas para continuar con el 'main'*/
        System.out.println("Continuando con la ejecución del método main 2");

    }
}
