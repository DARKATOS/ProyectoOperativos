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
public class Proceso {
    private String nombre;
    private int llegada;
    private int duracion;
    private int duracionbloqueo;
    private int bloqueoinicial;
    private int bloqueofinal;
    
    private int tiempoejecucion;
    private int tiempoespera;
    private int tiempobloqueado;

    public Proceso(String nombre, int llegada, int duracion, int bloqueinicial, int bloquefinal) {
        this.nombre = nombre;
        this.llegada = llegada;
        this.duracion = duracion;
        this.bloqueoinicial = bloqueinicial;
        this.bloqueofinal = bloquefinal;
        this.duracionbloqueo=bloqueofinal-bloqueoinicial;
        this.tiempoejecucion=0;
        this.tiempoespera=0;
        this.tiempobloqueado=0;
    }

    public int getDuracionbloqueo() {
        return duracionbloqueo;
    }

    public void setDuracionbloqueo(int duracionbloqueo) {
        this.duracionbloqueo = duracionbloqueo;
    }

    
    
    public int getTiempobloqueado() {
        return tiempobloqueado;
    }

    public int getTiempoejecucion() {
        return tiempoejecucion;
    }

    public int getTiempoespera() {
        return tiempoespera;
    }

    public void setTiempobloqueado(int tiempobloqueado) {
        this.tiempobloqueado = tiempobloqueado;
    }

    public void setTiempoejecucion(int tiempoejecucion) {
        this.tiempoejecucion = tiempoejecucion;
    }

    public void setTiempoespera(int tiempoespera) {
        this.tiempoespera = tiempoespera;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the llegada
     */
    public int getLlegada() {
        return llegada;
    }

    /**
     * @param llegada the llegada to set
     */
    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getBloqueofinal() {
        return bloqueofinal;
    }

    public int getBloqueoinicial() {
        return bloqueoinicial;
    }

    public void setBloqueofinal(int bloqueofinal) {
        this.bloqueofinal = bloqueofinal;
    }

    public void setBloqueoinicial(int bloqueoinicial) {
        this.bloqueoinicial = bloqueoinicial;
    }    
}
