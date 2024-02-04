package org.CCristian.HILOS.Ejemplo_TIMER;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejemplo_AgendarTareaTimerPERIODO {
    public static void main(String[] args) {

        /*¡EXTRA!*/
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Timer timer = new Timer(); /*Nos permite agregar tareas y programarlas*/

        AtomicInteger contadorAtomic = new AtomicInteger(3);

        timer.schedule(new TimerTask() {    /*schedule(Tarea futura, fecha o delay)*/

            /*Atributo dentro de la implementación TimerTask()*/
            //private int contador = 3; /*Forma de controlar la cantidad de veces que se ejecuta*/

            @Override
            public void run() {
                int aux = contadorAtomic.getAndDecrement();
                if (aux > 0) {
                    toolkit.beep(); /*(SONIDO de ALERTA)*/
                    System.out.println("Tarea "+ aux +" periódica en " + new Date() + " nombre del Thread: " + Thread.currentThread().getName());
                    //contador --;
                } else {
                    ;
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }

        }, 0, 10000); /*schedule(Tarea, Delay, Periodo)*/

        System.out.println("Agendamos una tarea inmediata que se repite cada 10 segundos....");
    }
}
