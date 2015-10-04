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
public class Automata {
    
    private final String Listo="Listo";
    private final String Ejecucion="Ejecucion";
    private final String inicio="Inicio";
    private final String fin="Final";
    private final String bloqueo="Bloqueo";
    private final int inicio_listo[]={80, 170, 120, 170};
    private final int listo_ejecucion[]={200, 170, 220, 80};
    private final int ejecucion_bloqueo[]={300, 80, 350,170};
    private final int listo_bloqueo[]={200, 170, 350, 170};
    private final int ejecucion_fin[]={300, 80, 350, 50};

    public Automata() {
    }

    public int[] getEjecucion_bloqueo() {
        return ejecucion_bloqueo;
    }

    public String getEjecucion() {
        return Ejecucion;
    }

    public String getListo() {
        return Listo;
    }

    /**
     * @return the inicio
     */
    public String getInicio() {
        return inicio;
    }

    /**
     * @return the fin
     */
    public String getFin() {
        return fin;
    }

    public String getBloqueo() {
        return bloqueo;
    }

    /**
     * @return the inicio_listo
     */
    public int[] getInicio_listo() {
        return inicio_listo;
    }

    /**
     * @return the listo_ejecucion
     */
    public int[] getListo_ejecucion() {
        return listo_ejecucion;
    }

    /**
     * @return the listo_bloqueo
     */
    public int[] getListo_bloqueo() {
        return listo_bloqueo;
    }

    /**
     * @return the ejecucion_fin
     */
    public int[] getEjecucion_fin() {
        return ejecucion_fin;
    }
}
