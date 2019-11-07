/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class Mosca implements Runnable{
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private ImageIcon Dibujo;
    private String Estado;

    public Mosca() {
        
    }

    public Mosca(int x, int y,String Estado) {
        this.x = x;
        this.y = y;
        this.ancho = 30;
        this.alto = 30;
        this.Dibujo = new ImageIcon(getClass().getResource("../Imagenes/Mosca.png"));
        this.Estado = Estado;
    }
    
    

    public void Coordenadas(){
        
        Random xe= new Random();
        Random ye=new Random();
        
        this.x=xe.nextInt(540);
        this.y=ye.nextInt(560);
    }
    
    
    @Override
    public void run() {
        while(true){
            
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mosca.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * @return the Dibujo
     */
    public ImageIcon getDibujo() {
        return Dibujo;
    }

    /**
     * @param Dibujo the Dibujo to set
     */
    public void setDibujo(ImageIcon Dibujo) {
        this.Dibujo = Dibujo;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    

    
    
}
