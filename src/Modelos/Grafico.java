/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Jorge Alejandro
 */
public class Grafico {
    private ArrayList<PintarQuantumGrafico>pintar;

    public Grafico() {
        this.pintar = new ArrayList<>();
    }
    /**
     * @return the pintar
     */
    public ArrayList<PintarQuantumGrafico> getPintar() {
        return pintar;
    }
    

    /**
     * @param pintar the pintar to set
     */
    public void setPintar(ArrayList<PintarQuantumGrafico> pintar) {
        this.pintar = pintar;
    }
    
}
