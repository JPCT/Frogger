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
public class Rio implements Runnable{

    private int x;
    private int y;
    private int alto;
    private int ancho;
    private String tipo;
    private ImageIcon Dibujo;
    String Direccion;
    private int pixel;

    public Rio() {
    }

    public Rio(int x, int y, String tipo,String Direccion,int pixel) {
        this.x = x;
        this.y = y;
        this.alto = 40;
        this.tipo = tipo;
        this.Direccion=Direccion;
        this.pixel=pixel;
    }
    
    public void tipo(){
         
        if(this.tipo.equalsIgnoreCase("Corto")){
            this.ancho=40;
            this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/TroncoCorto.png"));
        }
        
        if(this.tipo.equalsIgnoreCase("Tortuga")){
            this.ancho=40;
            this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/Tortuga1.png"));
            
        }
    }
    
    
    
    @Override
    public void run() {
        tipo();
        int y=this.y;
        while(true){
        
            
        if(this.tipo.equalsIgnoreCase("Tortuga")){
                
            //Animacion Tortuga
            if(this.getX()==0){
                this.setDibujo(new ImageIcon(getClass().getResource("../Imagenes/Tortuga1.png")));
            }
            if(this.getX()==100){
                this.setDibujo(new ImageIcon(getClass().getResource("../Imagenes/Tortuga3.png")));
            }
            if(this.getX()==200){
                this.setDibujo(new ImageIcon(getClass().getResource("../Imagenes/Tortuga4.png")));
            }
            if(this.getX()==250){
                this.setDibujo(new ImageIcon(getClass().getResource("../Imagenes/Tortuga5.png")));
                this.setY(1000);
            }
            if(this.getX()==300){
                this.setY(y);
                this.setDibujo(new ImageIcon(getClass().getResource("../Imagenes/Tortuga5.png")));
            }
            if(this.getX()==350){
                this.setDibujo(new ImageIcon(getClass().getResource("../Imagenes/Tortuga4.png")));
               
            }
            if(this.getX()==400){
                this.setDibujo(new ImageIcon(getClass().getResource("../Imagenes/Tortuga3.png")));
                
            }
            
            if(this.getX()==500){
                this.setDibujo(new ImageIcon(getClass().getResource("../Imagenes/Tortuga1.png")));
            }
            if(this.getX()==600){
                this.setDibujo(new ImageIcon(getClass().getResource("../Imagenes/Tortuga1.png")));
            }
            
            
            try {
                sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Rio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
            
        if(this.tipo.equalsIgnoreCase("Corto")){
            try {
                sleep(8);
            } catch (InterruptedException ex) {
                Logger.getLogger(Rio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
           if(this.Direccion.equalsIgnoreCase("Derecha")){
                this.setX(this.getX()+this.pixel);
                if(this.getX()==600){
                    this.setX(-50);
                }
            }else if(this.Direccion.equalsIgnoreCase("Izquierda")){
                this.setX(this.getX()-this.pixel);
                if(this.getX()==-40){
                    this.setX(600);
                }
            }
            
            }
        
        
    }

    public int getPixel() {
        return pixel;
    }

    public void setPixel(int pixel) {
        this.pixel = pixel;
    }

    
    
    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
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
    
}
