/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class Rana {
    private int x;
    private int y;
    private int alto;
    private int ancho;
    private int vidas;
    private ImageIcon Dibujo;
    private String Rutas[] = new String [8];

    public Rana() {
    }

    public Rana(int x, int y, int alto, int ancho, int vidas) {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;
        this.vidas = vidas;
        this.Rutas[0]="../Imagenes/REstatica.png";
        this.Rutas[1]="../Imagenes/RArriba.png";
        this.Rutas[2]="../Imagenes/RAbajo.png";
        this.Rutas[3]="../Imagenes/RDerecha.png";
        this.Rutas[4]="../Imagenes/RIzquierda.png";
        this.Rutas[5]="../Imagenes/REAbajo.png";
        this.Rutas[6]="../Imagenes/REIzquierda.png";
        this.Rutas[7]="../Imagenes/REDerecha.png";
        
        this.Dibujo = new ImageIcon(getClass().getResource(this.getRutas()[0]));
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
     * @return the vidas
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * @param vidas the vidas to set
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
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
     * @return the Rutas
     */
    public String[] getRutas() {
        return Rutas;
    }

    /**
     * @param Rutas the Rutas to set
     */
    public void setRutas(String[] Rutas) {
        this.Rutas = Rutas;
    }

    
    
    
    
}
