package org.CCristian.HILOS.EjemplosSYNC.Runnable;

import org.CCristian.HILOS.EjemplosSYNC.Panaderia;

public class Consumidor implements Runnable{

/*----------------------------ATRIBUTOS----------------------------*/
    private Panaderia panaderia;
/*----------------------------ATRIBUTOS----------------------------*/


/*----------------------------CONSTRUCTOR----------------------------*/
    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }
/*----------------------------CONSTRUCTOR----------------------------*/


/*----------------------------MÉTODO----------------------------*/
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            panaderia.Consumir();
        }
    }
/*----------------------------MÉTODO----------------------------*/
}
