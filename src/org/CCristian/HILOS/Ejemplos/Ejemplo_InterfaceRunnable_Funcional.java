package org.CCristian.HILOS.Ejemplos;

public class Ejemplo_InterfaceRunnable_Funcional {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();

        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++){
                System.out.println(i +" - "+ Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(main.getState());
            System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
        };
        /*Runnable con expresión LAMBDA*/

        Thread v1 = new Thread(viaje, "Isla de Pascua");    /*new Thread(Instancia de Runnable, Nombre del Thread)*/
        Thread v2 = new Thread(viaje,"Robinson Crusoe");
        Thread v3 = new Thread(viaje, "Juan Fernandez");
        Thread v4 = new Thread(viaje, "Isla de Chiloe");

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        v1.join();  /*Se une el Thread principal('main') con el Thread v1*/
        v2.join();
        v3.join();
        v4.join();

        /*Ahora el Thread principal 'main' espera a que finalicen el resto de Thread´s para continuar*/
        //Thread.sleep(10000);    /*Pausa en el 'main'*/
        System.out.println("--------------------------------------------------\n"+"Continuando con la ejecución del método main: " + main.getName() +"\n--------------------------------------------------");
    }
}
