package org.CCristian.HILOS.Ejemplos.Runnable;

import static org.CCristian.HILOS.Ejemplos.Ejemplo_SINCRONIZACION_Thread.Imprimir_Frases;

public class ImprimirFrases implements Runnable{
/*----------------------------ATRIBUTOS----------------------------*/
    private String frase1;
    private String frase2;
/*----------------------------ATRIBUTOS----------------------------*/


/*----------------------------CONSTRUCTOR----------------------------*/
    public ImprimirFrases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }
/*----------------------------CONSTRUCTOR----------------------------*/


    @Override
    public void run() {
        Imprimir_Frases(this.frase1,this.frase2);
    }
}
