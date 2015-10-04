/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Jorge Alejandro
 */
public class EsperaYEjecucion {
    private static final String tw="Tiempo Espera";
    private static final String te="Tiempo Ejecucion";
    private Object matriz[][];

    public EsperaYEjecucion(Object matriz[][]) {
        this.matriz = matriz;
    }
    /**
     * @return the tw
     */
    public static String getTw() {
        return tw;
    }

    /**
     * @return the te
     */
    public static String getTe() {
        return te;
    }


   
    
    
}
