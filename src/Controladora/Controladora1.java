/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelos.Automata;
import Modelos.EsperaYEjecucion;
import Modelos.Grafico;
import Modelos.PintarQuantumGrafico;
import Modelos.PosicionesProcesosGrafico;
import Modelos.Proceso;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Jorge Alejandro
 */
public class Controladora1 {

    private Automata automata;
    private EsperaYEjecucion eye;
    private Proceso procesos[];
    private ArrayList<Grafico> ciclos;
    private ArrayList<PosicionesProcesosGrafico> posiciones;
    private ArrayList<Proceso>bloqueados;
    private int quantum;

    public Controladora1() {
        automata = new Automata();
        eye = null; //Lo setee  y cree en frame principal
        procesos = null; //Lo seteo y creo en Fame Menu
        ciclos = new ArrayList<>();
        posiciones = new ArrayList<>();
        quantum = 0;
    }

    public ArrayList<PosicionesProcesosGrafico> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<PosicionesProcesosGrafico> posiciones) {
        this.posiciones = posiciones;
    }

    public ArrayList<Grafico> getCiclos() {
        return ciclos;
    }

    public void setCiclos(ArrayList<Grafico> ciclos) {
        this.ciclos = ciclos;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getQuantum() {
        return quantum;
    }

    /**
     * @return the automata
     */
    public Automata getAutomata() {
        return automata;
    }

    /**
     * @param automata the automata to set
     */
    public void setAutomata(Automata automata) {
        this.automata = automata;
    }

    /**
     * @return the eye
     */
    public EsperaYEjecucion getEye() {
        return eye;
    }

    /**
     * @param eye the eye to set
     */
    public void setEye(EsperaYEjecucion eye) {
        this.eye = eye;
    }

    /**
     * @return the procesos
     */
    public Proceso[] getProcesos() {
        return procesos;
    }

    /**
     * @param procesos the procesos to set
     */
    public void setProcesos(Proceso[] procesos) {
        this.procesos = procesos;
    }

    private void organizarProcesos() {
        Proceso aux;
        int pos;
        for (int i = 0; i < procesos.length; i++) {
            aux = procesos[i];
            pos = i;
            for (int j = i + 1; j < procesos.length; j++) {

                if (aux.getLlegada() > procesos[j].getLlegada()) {
                    aux = procesos[j];
                    pos = j;
                }
            }
            Proceso aux2 = procesos[i];
            procesos[i] = aux;
            procesos[pos] = aux2;
        }
    }    
    
    public ArrayList<Proceso> roundRobin() {
        organizarProcesos();
        int contadortiempo = 0;
        int contadortiempotemporal = -1;
        int salida = 1;
        int estado = 0;
        LinkedList<Proceso> colaprocesos = new LinkedList<>();
        ArrayList<Proceso> procesosejecutados = new ArrayList<>();
        ArrayList<Proceso> procesosbloqueados = new ArrayList<>();
        Proceso temporal;
        this.bloqueados=procesosbloqueados;
        
        while (salida == 1) {
            //estado 0=inicio
            //estado 1=listo
            //estado 2=ejecucion
            //estado 3=bloqueado
            Grafico ciclo = new Grafico();
            switch (estado) {
                case 0: { //Case de inicio hace una transicion al estado 1
                    estado = 1;
//                    break;
                }
                //Verificar que procesos han llegado al procesador y los guarda en una cola
                //Verifica si hay procesos que van iniciar una etapa de bloqueo. y los guarda en un lista de procesos bloqueados
                //Hace una transicion al estado 2
                case 1: {
                    for (int i = 0; i < procesos.length; i++) {
                        if (procesos[i].getLlegada() == contadortiempo) {
                            colaprocesos.addLast(procesos[i]);
                        }//esto es para añadir a lo ultimoademas pra entender los machetazos de jorge
                    }

                    for (int i = 0; i < colaprocesos.size(); i++) {
                        //Problema porque si hay procesos que son menores a contadortiempo pero se bloquean que se hace?
                        if (colaprocesos.get(i).getBloqueoinicial() == contadortiempo && colaprocesos.get(i).getBloqueofinal() > contadortiempo) {
                            procesosbloqueados.add(colaprocesos.get(i));
                            colaprocesos.remove(i);
                        }
                    }

                    estado = 2;
//                    break;
                }
                //Obtengo un proceso
                //Verifico que la duracion del proceso en CPU sea mayor que el quantum, si, si le resto el quantum a la duracion aumentandole el tiempo de ejecucion
                //Si no entonces le resto lo que queda y mando el proceso a una lista de procesos ya ejecutados
                //Luego recorro los demas procesos de la pila y les aumento el tiempo de espera
                //Luego hago una transicion al estado 3
                case 2: {
                    if (!colaprocesos.isEmpty()) {
                        temporal = colaprocesos.removeFirst();
                        if (temporal.getDuracion() - temporal.getTiempoejecucion() > quantum) {
                            contadortiempotemporal = quantum;
                            temporal.setTiempoejecucion(temporal.getTiempoejecucion() + contadortiempotemporal);
                            //Para pintar en la grafica
                            ciclo.getPintar().add(new PintarQuantumGrafico(temporal.getNombre(), "ejecucion", contadortiempotemporal, 0,temporal.getDuracion(),temporal.getTiempoejecucion()));

                            for (Proceso proceso : colaprocesos) {
                                proceso.setTiempoespera(proceso.getTiempoespera() + contadortiempotemporal);

                                //Para pintar grafico
                                ciclo.getPintar().add(new PintarQuantumGrafico(proceso.getNombre(), "espera", contadortiempotemporal, 0,proceso.getDuracion(),proceso.getTiempoejecucion()));
                            }
                            colaprocesos.addLast(temporal);
                            contadortiempo += quantum;

                        } else {
                            contadortiempotemporal = temporal.getDuracion() - temporal.getTiempoejecucion();
                            contadortiempo += contadortiempotemporal;
                            temporal.setTiempoejecucion(temporal.getTiempoejecucion() + contadortiempotemporal);

                            ciclo.getPintar().add(new PintarQuantumGrafico(temporal.getNombre(), "ejecucion", contadortiempotemporal, 0,temporal.getDuracion(),temporal.getTiempoejecucion()));

                            procesosejecutados.add(temporal);
                            for (Proceso proceso : colaprocesos) {
                                proceso.setTiempoespera(proceso.getTiempoespera() + contadortiempotemporal);

                                //Para pintar
                                ciclo.getPintar().add(new PintarQuantumGrafico(proceso.getNombre(), "espera", contadortiempotemporal, 0,proceso.getDuracion(),proceso.getTiempoejecucion()));
                            }
                        }
                    }

                    contadortiempotemporal = quantum;
                    estado = 3;
//                    break;
                }
                //Aumento el tiempodebloqueo de acuerdo al contador de tiempo temporal si la duracion restante es mayor al contador de tiempo temporal.
                //Si no el tiempo de bloqueo es igual a su duracion y si llega a quedar un resto de contador de tiempo temporal se le aumenta al tiempo de espera
                //Hago una transicion al estado 4
                case 3: {
                    for (int i = 0; i < procesosbloqueados.size(); i++) {
                        if (procesosbloqueados.get(i).getDuracionbloqueo() - procesosbloqueados.get(i).getTiempobloqueado() > contadortiempotemporal) {
                            procesosbloqueados.get(i).setTiempobloqueado(procesosbloqueados.get(i).getTiempobloqueado() + contadortiempotemporal);

                            //Para pintar.
                            ciclo.getPintar().add(new PintarQuantumGrafico(procesosbloqueados.get(i).getNombre(), "bloqueo", contadortiempotemporal, 0,procesosbloqueados.get(i).getDuracion(),procesosbloqueados.get(i).getTiempoejecucion()));

                        } else {
                            int aux = contadortiempotemporal - (procesosbloqueados.get(i).getDuracionbloqueo() - procesosbloqueados.get(i).getTiempobloqueado());
                            contadortiempotemporal = procesosbloqueados.get(i).getDuracionbloqueo() - procesosbloqueados.get(i).getTiempobloqueado();
                            procesosbloqueados.get(i).setTiempobloqueado(procesosbloqueados.get(i).getTiempobloqueado() + contadortiempotemporal);

                            //para pintar
                            ciclo.getPintar().add(new PintarQuantumGrafico(procesosbloqueados.get(i).getNombre(), "bloqueo", -1, contadortiempotemporal,procesosbloqueados.get(i).getDuracion(),procesosbloqueados.get(i).getTiempoejecucion()));

                            if (!colaprocesos.isEmpty()) {
                                procesosbloqueados.get(i).setTiempoespera(procesosbloqueados.get(i).getTiempoespera() + aux);

                                //para pintar
                                ciclo.getPintar().add(new PintarQuantumGrafico(procesosbloqueados.get(i).getNombre(), "espera", -1, aux,procesosbloqueados.get(i).getDuracion(),procesosbloqueados.get(i).getTiempoejecucion()));

                            } else {
                                procesosbloqueados.get(i).setTiempoejecucion(procesosbloqueados.get(i).getTiempoejecucion() + aux);

                                //para pintar
                                ciclo.getPintar().add(new PintarQuantumGrafico(procesosbloqueados.get(i).getNombre(), "ejecucion", -1, aux,procesosbloqueados.get(i).getDuracion(),procesosbloqueados.get(i).getTiempoejecucion()));
                            }
                            colaprocesos.addLast(procesosbloqueados.get(i));
                            procesosbloqueados.remove(i);
                            contadortiempo += contadortiempotemporal;
                        }
                    }
                    estado = 4;
//                    break;
                }
                //Verifico si la cola de procesos esta vacia, quiere decir que ya todos los procesos se ejecutaron
                case 4: {
                    if (colaprocesos.isEmpty() && procesosbloqueados.isEmpty()) {
                        salida = 0;
                    } else {
                        estado = 1;
                    }
//                    break;
                }
            }
            ciclos.add(ciclo);
        }
        return procesosejecutados;
    }
    
    public LinkedList<Proceso> Procesos()
    {
        LinkedList<Proceso> procesos=new LinkedList();
        procesos.addAll(Arrays.asList(this.procesos));
        return procesos;
    }

    public ArrayList<Proceso> getBloqueados() {
        return bloqueados;
    }
    
    
}
