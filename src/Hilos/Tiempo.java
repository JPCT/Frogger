/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.applet.AudioClip;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Tiempo implements Runnable{
    
    int x;
    int y;
    int ancho;
    int alto;
    AudioClip Time=Time = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Time.wav"));

    public Tiempo() {
    }

    public Tiempo(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    
    
    
    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    @Override
    public void run() {
        while(true){
            if(this.ancho>=0){
                this.ancho = this.ancho - 1;
                
                if(this.ancho%60==0||this.ancho==10||this.ancho==2||this.ancho==5){
                    Time.play();
                }    
            }
            try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
}
