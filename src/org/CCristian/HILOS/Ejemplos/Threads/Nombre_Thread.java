package org.CCristian.HILOS.Ejemplos.Threads;

public class Nombre_Thread extends Thread{

    public Nombre_Thread(String name) {
        super(name);    /*Darle un nombre personalizado*/
    }

    @Override
    public void run() {
        System.out.println("Se INICIA el método run del hilo " + getName());
        for (int i = 0; i < 10; i++){
            System.out.println(this.getName());
        }
        System.out.println("FINALIZA el hilo " + getName());
    }
}
