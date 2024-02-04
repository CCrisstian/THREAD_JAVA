package org.CCristian.HILOS.Ejemplo_EXECUTOR;

import java.util.concurrent.*;

public class Ejemplo_EXECUTOR_Future_2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        /*newSingleThreadExecutor() -> crea 1 hilo. Ejecuta una tarea a la vez, ejecución SECUENCIAL*/
        /*newFixedThreadPool(X cantidad) -> crea X hilos. Ejecuta las tareas asignadas todas a al mismo tiempo, ejecución PARALELO*/
        /*newFixedThreadPool(X cantidad) -> crea X hilos. No asegura la prioridad de ejecución*/

        System.out.println("----------------------------------------------------");
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        System.out.println("----------------------------------------------------\n");


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
            System.out.println("Finaliza la tarea: " + Thread.currentThread().getName());
            return "Algún resultado importante de la tarea";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Inicio de la tarea 2 ...");
            System.out.println("Nombre del thread " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Finaliza la tarea 2: " + Thread.currentThread().getName());
            return 10;
        };

        Future<String> resultado_future = executor.submit(tarea);
        /*submit() programará la tarea para su ejecución según la disponibilidad del hilo en el pool de hilos.*/
        /*Puede ocurrir inmediatamente si hay un hilo disponible, o puede esperar en una cola hasta que un hilo esté disponible.*/
        Future<String> resultado_future2 = executor.submit(tarea);
        Future<Integer> resultado_future3 = executor.submit(tarea2);
        /*Future< > acepta variables del tipo "Runnable" y "Callable"*/
        /*Como tarea es del tipo Callable devuelve un valor, en consecuencia, va Future<String>*/
        /*Como tarea2 es del tipo Callable devuelve un valor, en consecuencia, va Future<Integer>*/

        System.out.println("----------------------------------------------------");
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        System.out.println("----------------------------------------------------\n");

        executor.shutdown();    /*Finaliza el executor una vez que todas las tareas que realiza se completan*/

        System.out.println("Continuando con la ejecución del método main 1");

        while (!(resultado_future.isDone() && resultado_future2.isDone() && resultado_future3.isDone())){ /*Mientras no finalicen las 3 tareas*/

            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                resultado_future.isDone()? "Finalizó":"En proceso",
                    resultado_future2.isDone()? "Finalizó":"En proceso",
                        resultado_future3.isDone()? "Finalizó":"En proceso"));  /* %s es reemplazado por cada uno de los resultado_future*/

            TimeUnit.MILLISECONDS.sleep(1000);   /*Tiempo de demora (1 sec) entre cada ejecución del while*/
            /*Evita que se imprima muchas veces el mensaje, ya que el while se ejecutará hasta que termine el proceso de resultado_future*/
        }


        System.out.println("\nObtenemos el resultado de la tarea1: " + resultado_future.get());
        System.out.println("Obtenemos el resultado de la tarea2: " + resultado_future2.get());
        System.out.println("Obtenemos el resultado de la tarea3: " + resultado_future3.get());
        /*get(debe demorar X tiempo, TimeUnit.(Unidad de Tiempo)*/
        /*get() -> Obtener el resultado futuro*/
        /*get() Bloquea el thread actual hasta que la tarea asignada al future termine y devuelva un valor*/

        System.out.println("\nresultado_future.isDone() -> " + resultado_future.isDone());
        System.out.println("resultado_future2.isDone() -> " + resultado_future2.isDone());
        System.out.println("resultado_future3.isDone() -> " + resultado_future3.isDone());

    }
}
