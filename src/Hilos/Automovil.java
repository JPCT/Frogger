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
public class Automovil implements Runnable{
    ImageIcon Dibujo;
    private int x;
    private int y;
    private int alto;
    private int ancho;
    private String tipo;
    private int velocidad;
    private String direccion;
    private boolean bandera;
    private int pixel;

    public Automovil() {
    }

    public Automovil(int x, int y, String tipo, String direccion, boolean bandera, int velocidad,int pixel) {
        this.x = x;
        this.y = y;
        this.alto = 40;
        this.tipo = tipo;
        this.direccion = direccion;
        this.bandera = bandera;
        this.velocidad=velocidad;
        this.pixel=pixel;
    }

    public void Tipo(){
        if(this.tipo.equalsIgnoreCase("Carro1")){
            if(this.direccion.equalsIgnoreCase("Derecha"))
            this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/CarroVerdeDer.png"));
            else
                this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/CarroVerdeIzq.png"));

            this.ancho=80;
        }
        
        if(this.tipo.equalsIgnoreCase("Carro2")){
            if(this.direccion.equalsIgnoreCase("Derecha"))
            this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/CarroAzulDer.png"));
            else
                this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/CarroAzulIzq.png"));
            
            this.ancho=70;
        }
        
        if(this.tipo.equalsIgnoreCase("Carro3")){
            if(this.direccion.equalsIgnoreCase("Derecha"))
            this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/CarroAmarilloDer.png"));
            else
                this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/CarroAmarilloIzq.png"));
            
            this.ancho=80;
        }
        
        if(this.tipo.equalsIgnoreCase("Bombero")){
            if(this.direccion.equalsIgnoreCase("Derecha"))
            this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/BomberoDer.png"));
            else
                this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/BomberoIzq.png"));
            
            this.ancho=100;
        }
        
        if(this.tipo.equalsIgnoreCase("Camion")){
            if(this.direccion.equalsIgnoreCase("Derecha"))
            this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/CamionDer.png"));
            else
                this.Dibujo=new ImageIcon(getClass().getResource("../Imagenes/CamionIzq.png"));
            
            this.ancho=160;
        }
        
    }
    

    
    @Override
    public void run() {
        while(this.bandera){
            Tipo();
            if(this.direccion.equalsIgnoreCase("Derecha")){
            this.setX(this.getX()+this.pixel);
            
            if(this.getX()>=600){
                this.setX(-160);
            }
            
            }
            
            if(this.direccion.equalsIgnoreCase("izquierda")){
                this.setX(this.getX()-this.pixel);
                
                if(this.getX()<=-160){
                    this.setX(600);
                }
            }
            
            
            
            
            try {
                sleep(this.velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Automovil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    public int getPixel() {
        return pixel;
    }

    public void setPixel(int pixel) {
        this.pixel = pixel;
    }
    
    

    public ImageIcon getDibujo() {
        return Dibujo;
    }

    public void setDibujo(ImageIcon Dibujo) {
        this.Dibujo = Dibujo;
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
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the bandera
     */
    public boolean isBandera() {
        return bandera;
    }

    /**
     * @param bandera the bandera to set
     */
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
}
