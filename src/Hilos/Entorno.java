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
public class Entorno {
   
    ImageIcon Avenida;
    ImageIcon Inicio;
    ImageIcon Rio;
    ImageIcon Arbol;
    ImageIcon Farola;
    ImageIcon FenceCerrada;
    ImageIcon Muerto;
    ImageIcon Corazon;
    ImageIcon Perdio;
    ImageIcon Instrucciones;
    ImageIcon Pause;
    
    
    public Entorno() {
        this.Avenida = new ImageIcon(getClass().getResource("../Imagenes/Avenida.jpg"));
        this.Inicio = new ImageIcon(getClass().getResource("../Imagenes/Inicio.jpg"));
        this.Rio = new ImageIcon(getClass().getResource("../Imagenes/River.gif"));
        this.Arbol = new ImageIcon(getClass().getResource("../Imagenes/Arbol.png"));
        this.Farola = new ImageIcon(getClass().getResource("../Imagenes/Farola.png"));
        this.FenceCerrada = new ImageIcon(getClass().getResource("../Imagenes/FenceCerrada.png"));
        this.Muerto=new ImageIcon(getClass().getResource("../Imagenes/Muerto.png"));
        this.Corazon=new ImageIcon(getClass().getResource("../Imagenes/Corazon.png"));
        this.Perdio=new ImageIcon(getClass().getResource("../Imagenes/GameOver.gif"));
        this.Instrucciones=new ImageIcon(getClass().getResource("../Imagenes/Instrucciones.png"));
        this.Pause=new ImageIcon(getClass().getResource("../Imagenes/pause.png"));
    
        
    }

    public ImageIcon getPause() {
        return Pause;
    }

    public void setPause(ImageIcon Pause) {
        this.Pause = Pause;
    }

    
    public ImageIcon getInstrucciones() {
        return Instrucciones;
    }

    public void setInstrucciones(ImageIcon Instrucciones) {
        this.Instrucciones = Instrucciones;
    }
    

    public ImageIcon getPerdio() {
        return Perdio;
    }

    public void setPerdio(ImageIcon Perdio) {
        this.Perdio = Perdio;
    }

    
    
    public ImageIcon getCorazon() {
        return Corazon;
    }

    public void setCorazon(ImageIcon Corazon) {
        this.Corazon = Corazon;
    }

    
    
    
    public ImageIcon getMuerto() {
        return Muerto;
    }

    public void setMuerto(ImageIcon Muerto) {
        this.Muerto = Muerto;
    }

   
    

    
    
    
    

    public ImageIcon getFenceCerrada() {
        return FenceCerrada;
    }


    public void setFenceCerrada(ImageIcon FenceCerrada) {
        this.FenceCerrada = FenceCerrada;
    }

    
    
    public ImageIcon getFarola() {
        return Farola;
    }

    public void setFarola(ImageIcon Farola) {
        this.Farola = Farola;
    }

    
    public ImageIcon getArbol() {
        return Arbol;
    }

    public void setArbol(ImageIcon Arbol) {
        this.Arbol = Arbol;
    }
    
    

    public ImageIcon getRio() {
        return Rio;
    }

    public void setRio(ImageIcon Rio) {
        this.Rio = Rio;
    }

    
    public ImageIcon getInicio() {
        return Inicio;
    }

    public void setInicio(ImageIcon Inicio) {
        this.Inicio = Inicio;
    }


    public ImageIcon getAvenida() {
        return Avenida;
    }

    public void setAvenida(ImageIcon Avenida) {
        this.Avenida = Avenida;
    }
    
    
}
