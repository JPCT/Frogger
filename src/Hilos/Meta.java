/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class Meta implements Runnable{
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private String Estado;
    private ImageIcon Dibujo;

    public Meta() {
    }

    public Meta(int x,String Estado) {
        this.x = x;
        this.y = 0;
        this.ancho = 60;
        this.alto = 40;
        this.Estado = Estado;
    }

    public void Tipo(){
        if(this.Estado.equalsIgnoreCase("Vacio")){
            this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/Vacio.png"));
        }else if(this.Estado.equalsIgnoreCase("Lleno")){
            this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/Lleno.png"));
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

    @Override
    public void run() {
        while(true){
            Tipo();
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Meta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
