/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Hilos.Lista;
import Hilos.Nodo;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Tablero extends javax.swing.JFrame {

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new Interfaz.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(0, 0, 0));
        panel1.setPreferredSize(new java.awt.Dimension(600, 440));
        panel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                panel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        panel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                panel1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel1KeyPressed
       
    }//GEN-LAST:event_panel1KeyPressed

    private void panel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_panel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_panel1AncestorAdded

    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        //Banderas para imagenes
        if(panel1.R.getVidas()>0&&panel1.BanderaInicio!=1){
        panel1.BanderaInicio++;
        }
        
        //Menu de Game Over
        if(panel1.R.getVidas()<=0&&evt.getKeyCode()==KeyEvent.VK_S){
            System.exit(0);
        }else if(panel1.R.getVidas()<=0&&evt.getKeyCode()==KeyEvent.VK_R){
            panel1.BanderaInicio=2;
            panel1.InGame.loop();
            panel1.R.setVidas(3);
            panel1.Puntuacion=0;
            panel1.VidaMas=0;
            panel1.Me[0].setEstado("Vacio");
            panel1.Me[3].setEstado("Vacio");
            panel1.Me[6].setEstado("Vacio");
            panel1.Me[9].setEstado("Vacio");
            panel1.Nivel=1;
            panel1.T.setAncho(180-(panel1.Nivel*10));
            panel1.Mos.Coordenadas();
            
            //Reestablecer Velocidad
            int vel=28;
            int i=0;
            for(Nodo Aux=panel1.L.getCabeza();i<8;i++){
                if(i<4){
                Aux.getVehiculo().setVelocidad(vel);
                Aux.getSig().getVehiculo().setVelocidad(vel);
                vel=vel-2;
                Aux=Aux.getSig().getSig();
                
                }
                if(i>=4){
                    vel=22;
                    Aux.getVehiculo().setVelocidad(vel);
                    Aux.getSig().getVehiculo().setVelocidad(vel);
                    vel=vel+2;
                    Aux=Aux.getSig().getSig();

                }
              
            }
            
        }
        
        //Empezar
        if(panel1.BanderaInicio==1&&evt.getKeyCode()==KeyEvent.VK_ENTER){
            panel1.BanderaInicio=2;
           
        }
        //Sonidos de Comienzo
        if(panel1.BanderaSonido==0&&panel1.BanderaInicio>=2){
        panel1.sonido();
        }
        
        //Movimiento
        if(panel1.R.getVidas()>0&&panel1.BanderaInicio>=2){
        
        if(evt.getKeyCode()==KeyEvent.VK_UP){
            panel1.Movimiento(1);
        }
        
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            panel1.Movimiento(2);
        }
        
        if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
            panel1.Movimiento(3);
        }
        
        if(evt.getKeyCode()==KeyEvent.VK_LEFT){
            panel1.Movimiento(4);
        }
        
       }
        
        //Menu de Pausa
        if(evt.getKeyCode()==KeyEvent.VK_P){
                for(Nodo Aux=panel1.L.getCabeza();Aux!=null;Aux=Aux.getSig()){
                    Aux.getVehiculo().setPixel(0);
                }
                
                for(int i=0;i<7;i++){
                    panel1.R8[i].setPixel(0);
                }
                                
                
            int Tie=panel1.T.getAncho();
            panel1.T.setAncho(-10);
            String [] botones = { " Continuar", " Salir" , "MUSIC OFF", "MUSIC ON"};
            String [] botones1 = { " Continuar", " Salir" , "MUSIC OFF", "MUSIC ON"};
            
            int i = JOptionPane.showOptionDialog (null, "Menu de Pausa", "Juego Pausado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, panel1.E.getPause(), botones1, botones[0]);
            
            if(i==0){
                panel1.T.setAncho(Tie);
                for(Nodo Aux=panel1.L.getCabeza();Aux!=null;Aux=Aux.getSig()){
                    Aux.getVehiculo().setPixel(1);
                }
                
                 for(int j=0;j<7;j++){
                    panel1.R8[j].setPixel(1);
                }
                
            }else if(i==1){
                System.exit(0);
            }else if(i==2){
                panel1.InGame.stop();
                panel1.T.setAncho(Tie);  
                for(Nodo Aux=panel1.L.getCabeza();Aux!=null;Aux=Aux.getSig()){
                    Aux.getVehiculo().setPixel(1);
                }
                
                 for(int j=0;j<7;j++){
                    panel1.R8[j].setPixel(1);
                }
                
            }else if(i==3){
                panel1.InGame.loop();
                panel1.T.setAncho(Tie);
                for(Nodo Aux=panel1.L.getCabeza();Aux!=null;Aux=Aux.getSig()){
                    Aux.getVehiculo().setPixel(1);
                }
                
                 for(int j=0;j<7;j++){
                    panel1.R8[j].setPixel(1);
                }
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void panel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel1KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_panel1KeyReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        
        //Animaciones
        if(evt.getKeyCode()==KeyEvent.VK_UP){
            panel1.Animaciones(1);
        }
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            panel1.Animaciones(2);
        }
        if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
            panel1.Animaciones(3);
        }
        if(evt.getKeyCode()==KeyEvent.VK_LEFT){
            panel1.Animaciones(4);
        }
    }//GEN-LAST:event_formKeyReleased

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Interfaz.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
