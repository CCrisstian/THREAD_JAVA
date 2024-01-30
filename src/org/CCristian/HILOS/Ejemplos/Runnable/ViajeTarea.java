package org.CCristian.HILOS.Ejemplos.Runnable;

public class ViajeTarea implements Runnable{
/*-------------ATRIBUTOS-------------*/
    private String nombre;
/*-------------ATRIBUTOS-------------*/


/*-------------GETTER-------------*/
    public String getNombre() {
        return nombre;
    }
/*-------------GETTER-------------*/


/*-------------CONSTRUCTOR-------------*/
    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }
/*-------------CONSTRUCTOR-------------*/


    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(i +" - "+nombre);
            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finalmente me voy de viaje a: " + nombre);
    }
}
