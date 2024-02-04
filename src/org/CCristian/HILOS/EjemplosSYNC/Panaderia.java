package org.CCristian.HILOS.EjemplosSYNC;

public class Panaderia {
/*----------------------------ATRIBUTOS----------------------------*/
    private String pan;
    private boolean disponible; /*boolean(primitivo) por defecto = false*/
/*----------------------------ATRIBUTOS----------------------------*/


/*----------------------------MÉTODO----------------------------*/
    public synchronized void Hornear(String masa){ /*Método para el PANADERO*/
        while (disponible){ /*Pone en espera al panadero hasta que el consumidor coma el pan */
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.pan = masa;
        System.out.println("El panadero hornea: " +this.pan);
        this.disponible = true;
        notify();
    }

    public synchronized String Consumir(){ /*Método para el CONSUMIDOR*/
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El Cliente consume: " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }
/*----------------------------MÉTODO----------------------------*/

}
