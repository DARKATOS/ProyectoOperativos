/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.PosicionesProcesosGrafico;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Jorge Alejandro
 */
public class PanelGrafico extends javax.swing.JPanel {

    /**
     * Creates new form PanelGrafico
     */
    int contadorenx;
    int auxiliar;

    public PanelGrafico() {
        initComponents();
        contadorenx = 150;
        auxiliar=0;
    }

    
    //Me tocaria mirar el porque no me muestra el color rojo del bloqueo en la grafica.
    //Aca en este metodo hay que hacer un debugging, para mirar el porque no quiere funcionar
    //Porque en el array de pintar todo esta bien.
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        if (FrameMenu.controladora != null) {
            int numeroprocesos = FrameMenu.controladora.getProcesos().length;
            g.drawLine(150, 10, 150, this.getHeight() - 100);
            g.drawLine(150, this.getHeight() - 100, this.getWidth() - 200, this.getHeight() - 100);
            int y = this.getHeight() - 100;
            for (int i = 0; i < numeroprocesos; i++) {
                y = y - 20;
                FrameMenu.controladora.getPosiciones().add(new PosicionesProcesosGrafico(FrameMenu.controladora.getProcesos()[i].getNombre(), 100, y));
                g.drawString(FrameMenu.controladora.getProcesos()[i].getNombre(), 100, y);
            }
            g.setFont(new Font("Arial",0,10));
            for(int i=0; i<100*2;i+=10)
            {
                
                g.drawString(String.valueOf(i), contadorenx, this.getHeight()-80);
                contadorenx+=10*2;
            }
            contadorenx=150;
            int yp = 0;
            for (int i = 0; i < FrameMenu.controladora.getCiclos().size(); i++) {
                for (int j = 0; j < FrameMenu.controladora.getCiclos().get(i).getPintar().size(); j++) {
                    for (int k = 0; k < FrameMenu.controladora.getPosiciones().size(); k++) {
                        if (FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getProceso().equals(FrameMenu.controladora.getPosiciones().get(k).getProceso())) {
                            yp = FrameMenu.controladora.getPosiciones().get(k).getY();
                        }
                    }
                    //Amarillo: Ejecucion, Azul: Espera. Rojo:bloqueo
                    if ("espera".equals(FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getTipo())) {
                        g.setColor(Color.blue);
                        if(FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getQuantum()!=-1)
                        {
                            g.fillRoundRect(contadorenx, yp, FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getQuantum()*2, 10, 2, 2);
                        }
                        else
                        {
                            g.fillRoundRect(contadorenx, yp, FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getAuxiliar()*2, 10, 2, 2);
//                            contadorenx=contadorenx-FrameMenu.controladora.getQuantum()+FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getAuxiliar()*2;
                            contadorenx=contadorenx+(FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getAuxiliar()*2);
                            auxiliar=1;
                        }
                        
                    } else if ("ejecucion".equals(FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getTipo())) {
                        g.setColor(Color.yellow);
                        if(FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getQuantum()!=-1)
                        {
                            g.fillRoundRect(contadorenx, yp, FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getQuantum()*2, 10, 2, 2);
                        }
                        else
                        {
                            g.fillRoundRect(contadorenx, yp, FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getAuxiliar()*2, 10, 2, 2);
//                            contadorenx=contadorenx-FrameMenu.controladora.getQuantum()+FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getAuxiliar()*2;
                            contadorenx=contadorenx+(FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getAuxiliar()*2);
                            auxiliar=1;
                 
                        }
                        
                    } else {
                        g.setColor(Color.red);
                        if(FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getQuantum()!=-1)
                        {
                            g.fillRoundRect(contadorenx, yp, FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getQuantum()*2, 10, 2, 2);
                        }
                        else
                        {
                            g.fillRoundRect(contadorenx, yp, FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getAuxiliar()*2, 10, 2, 2);
//                            contadorenx=contadorenx-(FrameMenu.controladora.getQuantum()+(FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getAuxiliar()*2));
                            contadorenx=contadorenx+(FrameMenu.controladora.getCiclos().get(i).getPintar().get(j).getAuxiliar()*2);
                            auxiliar=1;
                        }
                    }
                    if (j==FrameMenu.controladora.getCiclos().get(i).getPintar().size()-1 &&auxiliar==0)
                    {
                        contadorenx=contadorenx+(FrameMenu.controladora.getQuantum()*2);
                    }
                    else
                    {
                        auxiliar=0;
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
