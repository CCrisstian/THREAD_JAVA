package org.CCristian.HILOS.Ejemplo_EXECUTOR;

import org.CCristian.HILOS.EjemplosSYNC.Panaderia;
import org.CCristian.HILOS.EjemplosSYNC.Runnable.Consumidor;
import org.CCristian.HILOS.EjemplosSYNC.Runnable.Panadero;

import java.util.concurrent.*;

public class Ejemplo_EXECUTOR_ProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        /*Para este ejemplo debe ser de un tamaño mínimo de 2, por tratarse de 2 tareas "sincronizadas" y que se ejecutan en PARALELO*/

        System.out.println("----------------------------------------------------");
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        System.out.println("----------------------------------------------------\n");

        Panaderia panaderia = new Panaderia();
        Runnable productor = new Panadero(panaderia);
        Runnable consumidor = new Consumidor(panaderia);
        Future<?> resultado_futuro_1 = executor.submit(productor);
        Future<?> resultado_futuro_2 = executor.submit(consumidor);

        System.out.println("----------------------------------------------------");
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        System.out.println("----------------------------------------------------\n");

        executor.shutdown();    /*Finaliza el executor una vez que todas las tareas que realiza se completan*/

        System.out.println("Continuando con la ejecución del método main 1");

    }
}
