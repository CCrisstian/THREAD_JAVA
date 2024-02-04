package org.CCristian.HILOS.Ejemplo_EXECUTOR;

import java.util.concurrent.*;

public class Ejemplo_EXECUTOR_Future {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = () -> {
        /*Callable<Cualquier tipo de dato que queramos devolver>*/
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea ...");
            return "Algún resultado importante de la tarea";
        };

        Future<String> resultado_future = executor.submit(tarea); /*Devuelve un objeto future de la operación asíncrona*/
        /*Future< > acepta variables del tipo "Runnable" y "Callable"*/
        /*Como tarea es del tipo Runnable no devuelve nada, por lo tanto, va Future<?>*/
        /*Como tarea es del tipo Callable devuelve un valor, en consecuencia, va Future<String>*/

        executor.shutdown();    /*Finaliza el executor una vez que todas las tareas que realiza se completan*/
        System.out.println("Continuando con la ejecución del método main 1");

        while (!resultado_future.isDone()){
            System.out.println("Ejecutando tarea ...");
            TimeUnit.MILLISECONDS.sleep(1500);   /*Tiempo de demora (1,5 sec) entre cada ejecución del while*/
            /*Evita que se imprima muchas veces el mensaje, ya que el while se ejecutará hasta que termine el proceso de resultado_future*/
        }

        System.out.println("Obtenemos el resultado de la tarea: " + resultado_future.get());
        /*get(debe demorar X tiempo, TimeUnit.(Unidad de Tiempo)*/
        /*Obtener el resultado futuro*/
        /*get() Bloquea el thread actual hasta que la tarea asignada al future termine y devuelva un valor*/

        System.out.println("resultado_future.isDone() -> " + resultado_future.isDone());

    }
}
