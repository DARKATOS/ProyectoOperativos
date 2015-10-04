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
public class PintarQuantumGrafico {
    private String proceso;
    private String tipo;
    private int quantum;
    private int auxiliar;

    public PintarQuantumGrafico(String proceso, String tipo, int quantum, int auxiliar) {
        this.proceso = proceso;
        this.tipo = tipo;
        this.quantum=quantum;
        this.auxiliar=auxiliar;
    }

    public int getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(int auxiliar) {
        this.auxiliar = auxiliar;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    /**
     * @return the proceso
     */
    public String getProceso() {
        return proceso;
    }

    /**
     * @param proceso the proceso to set
     */
    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
