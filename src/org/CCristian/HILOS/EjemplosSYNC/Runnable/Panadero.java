package org.CCristian.HILOS.EjemplosSYNC.Runnable;

import org.CCristian.HILOS.EjemplosSYNC.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{

/*----------------------------ATRIBUTOS----------------------------*/
    private Panaderia panaderia;
/*----------------------------ATRIBUTOS----------------------------*/


/*----------------------------CONSTRUCTOR----------------------------*/
    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }
/*----------------------------CONSTRUCTOR----------------------------*/


/*----------------------------MÉTODO----------------------------*/
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            panaderia.Hornear("Pan n°: "+ i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
/*ThreadLocalRandom proporciona una forma eficiente y segura de generar números aleatorios
en un entorno multihilo sin la necesidad de sincronización explícita.*/
/*----------------------------MÉTODO----------------------------*/

}
