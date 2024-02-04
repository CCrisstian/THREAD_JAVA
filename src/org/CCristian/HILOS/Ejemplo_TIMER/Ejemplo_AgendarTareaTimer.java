package org.CCristian.HILOS.Ejemplo_TIMER;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Ejemplo_AgendarTareaTimer {
    public static void main(String[] args) {

        Timer timer = new Timer(); /*Nos permite agregar tareas y programarlas*/

        timer.schedule(new TimerTask() {    /*schedule(Tarea futura, fecha o delay)*/
            @Override
            public void run() {
                System.out.println("Tarea realizada en " + new Date() + " nombre del Thread: " + Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                timer.cancel();
            }

        }, 5000);

        System.out.println("Agendamos una tarea para 5 segundos más ....");
    }
}
