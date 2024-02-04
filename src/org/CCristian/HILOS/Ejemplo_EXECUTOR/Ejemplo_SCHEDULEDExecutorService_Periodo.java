package org.CCristian.HILOS.Ejemplo_EXECUTOR;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejemplo_SCHEDULEDExecutorService_Periodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main ....");

        //CountDownLatch lock = new CountDownLatch(5);    /*Para controlar cuanto tiempo se ejecutará una tarea*/
        /*Permitirá que otros hilos avancen cuando el método countDown() se haya llamado 5 veces en total.*/

        AtomicInteger contador = new AtomicInteger(5);  /*Para controlar cuanto tiempo se ejecutará una tarea*/


/*--------------------------------------------------------------------------------------------------------------*/
        Future<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Hola mundo tarea ...    contador.getAndDecrement() = " + contador.get());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //lock.countDown();           /*Cada llamada a countDown() decrementará el valor de lock en 1.*/
                contador.getAndDecrement(); /*decrementará el valor de contador en 1 hasta llegar a 0*/
                System.out.println("\tcontador.getAndDecrement() = " + contador.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 1000, 2000,TimeUnit.MILLISECONDS);
        /*Inicia en 0 segundos - delay de 1 segundo entre ejecuciones - Se repite cada 2 segundos*/
/*--------------------------------------------------------------------------------------------------------------*/

        //lock.await();   /*Bloquea el main para que el "executor" tenga tiempo de realizar la tarea*/
        /*Se ejecutará hasta que lock llegue a 0*/

        //TimeUnit.SECONDS.sleep(10); /*Para controlar cuanto tiempo se ejecutará una tarea*/
        /*Bloquea el main para que el "executor" tenga tiempo de realizar la tarea*/
        /*Pone en pausa el 'main' por 10 segundos*/

        //future.cancel(true); /*Forma más adecuada de detener la ejecución*/

        while (contador.get() > 0){ /*Controlador de cantidad de ejecuciones para "AtomicInteger"*/
            if (contador.get() == 0){
                future.cancel(true);
            }
        }

        System.out.println("Alguna otra tarea en el main ....");
        executor.shutdown();

    }
}
