/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Hilos.Automovil;
import Hilos.Entorno;
import Hilos.Lista;
import Hilos.Meta;
import Hilos.Mosca;
import Hilos.Muerto;
import Hilos.Nenufar;
import Hilos.Nodo;
import Hilos.Rana;
import Hilos.Rio;
import Hilos.Tiempo;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BandedSampleModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Panel extends javax.swing.JPanel {

    /**
     * Creates new form Panel
     */
    
    //Banderas
    int BanderaInicio;
    int BanderaSonido;
    int BanderaMove;
    int BanderaAnim;
    int BanderaColisiones;
   
    //Sonidos
     AudioClip Inicio=Inicio = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Inicio.wav"));
     AudioClip InGame=InGame = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Cancion2.wav"));
     AudioClip Squash=Squash = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Squash.wav"));
     AudioClip Hop=Hop = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Hop.wav"));
     AudioClip Coin=Coin = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Coin.wav"));
     AudioClip Over=Over = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Over.wav"));
     AudioClip Victory=Victory = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Victory.wav"));
     AudioClip Vida=Vida = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Vida.wav"));
     AudioClip Comer=Comer = java.applet.Applet.newAudioClip(getClass().getResource("../Sonidos/Comer.wav"));

     //Scores
    int Puntuacion; 
    int MejorPuntuacion;
    int VidaMas;
    int yi=0;
    int Nivel;
    
    //Rana
    Rana R;
    //Mosca
    Mosca Mos;
    
    //Lista Carros
    Lista L = new Lista();
    
    
    //Elementos del rio
    Rio R8[]=new Rio[7];
    //--
    
    Nodo Aux3=this.L.getCabeza();
    Nenufar N[]=new Nenufar[8];
    
    //Nenufares para ganr
    Meta Me[]=new Meta[10];
    //Archivo puntuacion
    File f;
    
    Muerto M;
    Tiempo T;
    
    //Entorno, cosas que no son de objetos
    Entorno E;
    public Panel() {
        initComponents();
        E=new Entorno();
        BanderaInicio=0;
        BanderaSonido=0;
        BanderaMove=0;
        BanderaAnim=0;
        Puntuacion=0;
        MejorPuntuacion=0;
        BanderaColisiones=0;
        Nivel=1;
        Inicio.loop();
        
        //Nenufares
       int x=0;
       for(int i=0;i<8;i++){
           this.N[i]=new Nenufar(x);
           x=x+80;
           
      }
       
       //Crear Nenufares para ganr
       x=0;
       for(int m=0;m<10;m++){
           if(m%3==0){
           this.Me[m]=new Meta(x, "Vacio");
           }else
               this.Me[m]=new Meta(x, "Lleno");
           
           this.Me[m].Tipo();
           x=x+60;
           
           Thread Meta=new Thread(this.Me[m]);
           Meta.start();
           
           
       }
       
       
       this.Mos=new Mosca(0,0,"Viva");
  
       
       f=new File("MejorPuntuacion.txt");
       
       
       
       
       this.M=new Muerto(1000, 1000);
       Thread M=new Thread(this.M);
       M.start();
       
       this.T=new Tiempo(400, 630, 180, 20);
        
        this.R=new Rana(320, 562, 35, 35, 3);
        
        
        //Arreglo de las cosas del rio
        
        this.R8[0]=new Rio(1, 120, "Corto", "Izquierda",1);
        Thread HiloT1=new Thread(this.R8[0]);
        HiloT1.start();
        
        this.R8[1]=new Rio(300, 120, "Corto", "Izquierda",1);
        Thread HiloT2=new Thread(this.R8[1]);
        HiloT2.start();
        
        this.R8[2]=new Rio(0, 80, "Tortuga", "Derecha",1);
        Thread HiloT3=new Thread(this.R8[2]);
        HiloT3.start();
        
        this.R8[3]=new Rio(200, 80, "Tortuga", "Derecha",1);
        Thread HiloT4=new Thread(this.R8[3]);
        HiloT4.start();
        
        this.R8[4]=new Rio(150, 40, "Corto", "Izquierda",1);
        Thread HiloT5=new Thread(this.R8[4]);
        HiloT5.start();
        
        this.R8[5]=new Rio(450, 40, "Corto", "Izquierda",1);
        Thread HiloT6=new Thread(this.R8[5]);
        HiloT6.start();
        
        this.R8[6]=new Rio(400, 80, "Tortuga", "Derecha",1);
        Thread HiloT7=new Thread(this.R8[6]);
        HiloT7.start();
       
        //Calzada 1
            L.Ingresar(new Automovil(0, 520, "Carro1", "Derecha", true,28,1));
            L.Ingresar(new Automovil(200, 520,"Bombero", "Derecha", true,28,1));

            L.Ingresar(new Automovil(200, 480, "Carro2", "Derecha", true,26,1));
            L.Ingresar(new Automovil(500, 480, "Carro3", "Derecha", true,26,1));
            
            L.Ingresar(new Automovil(200, 440, "Camion", "Derecha", true,24,1));
            L.Ingresar(new Automovil(600, 440, "Carro1", "Derecha", true,24,1));
            
            L.Ingresar(new Automovil(0, 400, "Camion", "Derecha", true,22,1));
            L.Ingresar(new Automovil(400, 400, "Bombero", "Derecha", true,22,1));
            
        //Calzada 2
            L.Ingresar(new Automovil(0, 320, "Carro2", "Izquierda", true,22,1));
            L.Ingresar(new Automovil(200, 320,"Bombero", "Izquierda", true,22,1));

            L.Ingresar(new Automovil(200, 280, "Carro2", "Izquierda", true,24,1));
            L.Ingresar(new Automovil(500, 280, "Carro1", "Izquierda", true,24,1));
            
            L.Ingresar(new Automovil(200, 240, "Bombero", "Izquierda", true,26,1));
            L.Ingresar(new Automovil(600, 240, "Carro2", "Izquierda", true,26,1));
            
            L.Ingresar(new Automovil(0, 200, "Camion", "Izquierda", true,28,1));
            L.Ingresar(new Automovil(400, 200, "Bombero", "Izquierda", true,28,1));
        
            
            
            //Hilo de los Vehiculos
            Nodo Aux=this.L.getCabeza();
            while(Aux!=null){
            Thread Hilo1 = new Thread(Aux.getVehiculo());
            Hilo1.start();
            Aux = Aux.getSig();
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

    //Metodo para las imagenes de inicio
    public void sonido(){
        
        if(BanderaInicio>=2){
            Inicio.stop();
            Thread Ti=new Thread(this.T);
            Ti.start();
            InGame.loop();
        }
        
        BanderaSonido++;
   
    }

    //Animaciones de la rana
    public void Animaciones(int A){
        
        if(BanderaAnim==1){
        
        if(A==1){
            this.R.setDibujo(new ImageIcon(getClass().getResource(this.R.getRutas()[0])));
        }
            if(A==2){
            this.R.setDibujo(new ImageIcon(getClass().getResource(this.R.getRutas()[5])));
        }
            if(A==3){
            this.R.setDibujo(new ImageIcon(getClass().getResource(this.R.getRutas()[7])));
        }
            if(A==4){
            this.R.setDibujo(new ImageIcon(getClass().getResource(this.R.getRutas()[6])));
        }
        }
        BanderaAnim=1;
            
    }
    
    //Movimiento de la rana
    public void Movimiento(int M){
        
        if(BanderaMove==1){
        
        this.R.setDibujo(new ImageIcon(getClass().getResource(this.R.getRutas()[M])));

        //Arriba
        if(M==1){
            if((!(this.R.getY()-40==362&&this.R.getX()==320))&&(!(this.R.getY()-40==362&&this.R.getX()==120))&&(!(this.R.getY()-40==362&&this.R.getX()==520))&&(!(this.R.getY()-40==162&&(this.R.getX()==80||this.R.getX()==120||this.R.getX()==160||this.R.getX()==200)))&&(!(this.R.getY()-40==162&&(this.R.getX()==360||this.R.getX()==400||this.R.getX()==440||this.R.getX()==480)))){
            this.R.setY(this.R.getY()-40);
            this.Puntuacion+=10;
            this.VidaMas+=10;
            Hop.play();
            }
        }
        
        //Abajo
        if(M==2){
            if(this.R.getY()+40>=600){
                this.M.setX(this.R.getX());
                this.M.setY(560);
                this.R.setX(320);
                this.R.setY(562);
                this.R.setVidas(this.R.getVidas() - 1);
                Squash.play();
                
            }else{
                
            //Condidiciones para saber hacia donde puede saltar
            if((!(this.R.getY()+40>560&&this.R.getX()==0))&&(!(this.R.getY()+40>560&&this.R.getX()==400))&&(!(this.R.getY()+40>560&&this.R.getX()==560))&&(!(this.R.getY()+40>560&&this.R.getX()==120))&&(!(this.R.getY()+40==362&&this.R.getX()==320))&&(!(this.R.getY()+40==362&&this.R.getX()==120))&&(!(this.R.getY()+40==362&&this.R.getX()==520))&&(!(this.R.getY()+40==202&&(this.R.getX()==80||this.R.getX()==120||this.R.getX()==160||this.R.getX()==200)))&&(!(this.R.getY()+40==202&&(this.R.getX()==360||this.R.getX()==400||this.R.getX()==440||this.R.getX()==480)))){
                this.R.setY(this.R.getY()+40);
                this.Puntuacion-=10;
                this.VidaMas-=10;
                Hop.play();
            }   
            }
        }
        
        
        //Derecha
        if(M==3){
            if(this.R.getX()+40>=600){
                this.M.setX(560);
                this.M.setY(this.R.getY());
                this.R.setX(320);
                this.R.setY(562);
                this.R.setVidas(this.R.getVidas() - 1);
                Squash.play();
            }
            
            //Condidiciones para saber hacia donde puede saltar
            if((!(this.R.getY()==562&&this.R.getX()==360))&&(!(this.R.getY()==562&&this.R.getX()==520))&&(!(this.R.getY()==562&&this.R.getX()==80))&&(!(this.R.getY()==362&&this.R.getX()==280))&&(!(this.R.getY()==362&&this.R.getX()==80))&&(!(this.R.getY()==362&&this.R.getX()==480))){
                this.R.setX(this.R.getX()+40);
                Hop.play();
            }   
            
        }
        
        //Izquierda
        if(M==4){
            if(this.R.getX()-40<0){
                this.M.setX(0);
                this.M.setY(this.R.getY());
                this.R.setX(320);
                this.R.setY(562);
                this.R.setVidas(this.R.getVidas() - 1);
                Squash.play();
            }
            //Condiciones para saber donde saltar
            if((!(this.R.getY()==562&&this.R.getX()==40))&&(!(this.R.getY()==562&&this.R.getX()==440))&&(!(this.R.getY()==562&&this.R.getX()==160))&&(!(this.R.getY()==362&&this.R.getX()==360))&&(!(this.R.getY()==362&&this.R.getX()==160))&&(!(this.R.getY()==362&&this.R.getX()==560))){
            this.R.setX(this.R.getX()-40);
            Hop.play();
            }
        }
        }
        
        BanderaMove=1;
    }
    
    public void Juego(){
       
        //Comprobar si paso de nivel
        if((this.Me[0].getEstado().equalsIgnoreCase("Lleno"))&&(this.Me[3].getEstado().equalsIgnoreCase("Lleno"))&&(this.Me[6].getEstado().equalsIgnoreCase("Lleno"))&&(this.Me[9].getEstado().equalsIgnoreCase("Lleno"))){
            this.Puntuacion+=500;
            this.VidaMas+=500;
            this.Me[0].setEstado("Vacio");
            this.Me[3].setEstado("Vacio");
            this.Me[6].setEstado("Vacio");
            this.Me[9].setEstado("Vacio");
            
            for(Nodo Auxlvl=this.L.getCabeza(); Auxlvl!=null&&this.Nivel<10;Auxlvl=Auxlvl.getSig()){
                Auxlvl.getVehiculo().setVelocidad(Auxlvl.getVehiculo().getVelocidad() - 2);   
            }
            
            this.Nivel++;
            this.T.setAncho(180-(this.Nivel*10));
            Victory.play();
        }
        
        //Perder por tiempo
        if(this.T.getAncho()<=0&&this.T.getAncho()!=-10){
            this.T.setAncho(180-(this.Nivel*10));
                this.M.setX(this.R.getX());
                this.M.setY(this.R.getY());
                this.R.setX(320);
                this.R.setY(562);
                this.R.setVidas(this.R.getVidas() - 1);
                Squash.play();
        }
        
        //Dar una vida mas 
        if(this.VidaMas>=1000){
            this.R.setVidas(this.R.getVidas() + 1);
            this.VidaMas=this.VidaMas - 1000;
            Vida.play();
        }
        
        
        //Mejor puntuacion
        
        try {
            Scanner fileScan=new Scanner(f);
            while(fileScan.hasNextInt()){
                String nextLine = fileScan.nextLine();
                Scanner lineScan = new Scanner(nextLine);
                this.MejorPuntuacion = lineScan.nextInt();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try{    
        if(this.Puntuacion > this.MejorPuntuacion){

            String CadenaPuntaje = Integer.toString(this.Puntuacion);
            PrintWriter pw = new PrintWriter(new FileOutputStream(f, false));
            pw.write(CadenaPuntaje);
            pw.close();
            
            }
        }catch (FileNotFoundException e){
            
            }
        
        
        //Mosca
        if(this.Mos.getY()<200){
            this.Mos.Coordenadas();
        }
        
        //Perder
        if(this.R.getVidas()<=0){
            BanderaInicio=-1;
            InGame.stop();
            Over.play();
        }
    }
    
    
    public void Colisiones(){
        
        
        
        Rectangle Rana=new Rectangle(this.R.getX(), this.R.getY(), this.R.getAncho(), this.R.getAlto());
        Rectangle Nenu[]=new Rectangle[8];
        Rectangle Met[]=new Rectangle[10];
        Rectangle Ri[]=new Rectangle[7];
        
        
        
        //Mosca
        if(Rana.intersects(new Rectangle(this.Mos.getX(), this.Mos.getY(), this.Mos.getAncho()+30, this.Mos.getAlto()+30))){
            this.Mos.setX(1000);
            Comer.play();
            this.Mos.setEstado("Muerta");
            this.Puntuacion+=100;
            this.VidaMas+=100;
        }
        
        //Meta
        for(int e=0;e<10;e++){
            if(e==0||e==3||e==6||e==9)
            Met[e]=new Rectangle(this.Me[e].getX()-10, this.Me[e].getY(), this.Me[e].getAncho()+10, this.Me[e].getAlto());
            
            else
                Met[e]=new Rectangle(this.Me[e].getX()+10, this.Me[e].getY(), this.Me[e].getAncho()-10, this.Me[e].getAlto());

        }
        
        //Nenufares rectangulos
        for(int i=0;i<8;i++){
            Nenu[i]=new Rectangle(this.N[i].getX(), this.N[i].getY(), this.N[i].getAncho(), this.N[i].getAlto());
        }
        
        //Rio---
        for(int i=0;i<7;i++){
            Ri[i]=new Rectangle(this.R8[i].getX(), this.R8[i].getY(), this.R8[i].getAncho(), this.R8[i].getAlto());
            if(Rana.intersects(Ri[i])){
                this.R.setX(this.R8[i].getX());
            }
        }
       
        
         //Nenufares
        for(int v=0;v<8;v++){
            if(Rana.intersects(Nenu[v])){
                this.R.setX(this.N[v].getX());
            }
        }
        
        //Meta
        for(int o=0;o<10;o++){
            if((Rana.intersects(Met[o]))&&(this.Me[o].getEstado().equalsIgnoreCase("Vacio"))){
                this.Me[o].setEstado("Lleno");
                this.Puntuacion = this.Puntuacion + 100;
                this.VidaMas = this.VidaMas + 100;
                Coin.play();
                this.R.setX(320);
                this.R.setY(562);
                this.Mos.Coordenadas();
            }else if((Rana.intersects(Met[o]))&&(this.Me[o].getEstado().equalsIgnoreCase("Lleno"))){
                this.M.setX(this.R.getX());
                this.M.setY(this.R.getY());
                this.R.setX(320);
                this.R.setY(562);
                this.R.setVidas(this.R.getVidas() - 1);
                Squash.play();
            }
        }
        
        //Cae al rio donde los nenufares
        if((this.R.getY()==162)&&(this.R.getX()!=this.N[0].getX())&&(this.R.getX()!=this.N[1].getX())&&(this.R.getX()!=this.N[2].getX())&&(this.R.getX()!=this.N[3].getX())&&(this.R.getX()!=this.N[4].getX())&&(this.R.getX()!=this.N[5].getX())&&(this.R.getX()!=this.N[6].getX())&&(this.R.getX()!=this.N[7].getX())){
                this.M.setX(this.R.getX());
                this.M.setY(this.R.getY());
                this.R.setX(320);
                this.R.setY(562);
                this.R.setVidas(this.R.getVidas() - 1);
                Squash.play();
        }
         
        
        //Cae al rio
        if((this.R.getY()<160&&this.R.getY()>40)&&(this.R.getX()!=this.R8[0].getX())&&(this.R.getX()!=this.R8[1].getX())&&(this.R.getX()!=this.R8[2].getX())&&(this.R.getX()!=this.R8[3].getX())&&(this.R.getX()!=this.R8[4].getX())&&(this.R.getX()!=this.R8[5].getX())&&(this.R.getX()!=this.R8[6].getX())){
                this.M.setX(this.R.getX());
                this.M.setY(this.R.getY());
                this.R.setX(320);
                this.R.setY(562);
                this.R.setVidas(this.R.getVidas() - 1);
                Squash.play();
        }
            
         
         
        //Automoviles
        
        
        Aux3=this.L.getCabeza();
        while(Aux3!=null){
            if(Rana.intersects(new Rectangle(Aux3.getVehiculo().getX(), Aux3.getVehiculo().getY(), Aux3.getVehiculo().getAncho(), Aux3.getVehiculo().getAlto()))){
                this.M.setX(this.R.getX());
                this.M.setY(this.R.getY());
                this.R.setX(320);
                this.R.setY(562);
                this.R.setVidas(this.R.getVidas() - 1);
                Squash.play();
            }
            Aux3=Aux3.getSig();
        }
        
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
       
        
        
        //Inicio y Cambio de Imagen
        if(BanderaInicio==0){
        g.drawImage(this.E.getInicio().getImage(), 0, 0, 600, 660, this);
  
        //En el juego
        }else if(BanderaInicio>=2){ 
            //Avenida y Rio
            g.drawImage(this.E.getAvenida().getImage(), 0, 0, 600, 640, this);
            g.drawImage(this.E.getRio().getImage(),0 , 0, 600, 199, this);
              
            //Troncos y Tortuga
            for(int i=0;i<7;i++){
                g.drawImage(this.R8[i].getDibujo().getImage(), this.R8[i].getX(), this.R8[i].getY(), this.R8[i].getAncho(), this.R8[i].getAlto(), this);

            }
          
            //Nenufares
            for(int h=0;h<8;h++){
                g.drawImage(this.N[h].getDibujo().getImage(), this.N[h].getX(), this.N[h].getY(), this.N[h].getAncho(), this.N[h].getAlto(), this);
            }
            
            //Meta
            for(int p=0;p<10;p++){
                g.drawImage(this.Me[p].getDibujo().getImage(), this.Me[p].getX(), this.Me[p].getY(), this.Me[p].getAncho(), this.Me[p].getAlto(), this);
            }
            
            //Dibujo Rana
            if(this.R!=null){
                g.drawImage(this.R.getDibujo().getImage(), this.R.getX(), this.R.getY(), this.R.getAncho(), this.R.getAlto(), this);
            }
            
            //Mosca
            g.drawImage(this.Mos.getDibujo().getImage(), this.Mos.getX(), this.Mos.getY(), this.Mos.getAncho(), this.Mos.getAlto(), this);
            
            //Vehiculos
            Nodo Aux2=this.L.getCabeza();
            while(Aux2!=null){
            g.drawImage(Aux2.getVehiculo().getDibujo().getImage(), Aux2.getVehiculo().getX(), Aux2.getVehiculo().getY(), Aux2.getVehiculo().getAncho(), Aux2.getVehiculo().getAlto(), this);
            Aux2 = Aux2.getSig();
            }
            
            
            //Entorno
            g.drawImage(this.E.getArbol().getImage(), 100, 470, this);
            g.drawImage(this.E.getArbol().getImage(), 300, 270, this);
            g.drawImage(this.E.getFarola().getImage(), 60, 270, this);
            g.drawImage(this.E.getFarola().getImage(), 460, 270, this);
            g.drawImage(this.E.getFenceCerrada().getImage(), 80, 180, 160, 20, this);
            g.drawImage(this.E.getFenceCerrada().getImage(), 360, 180, 160, 20, this);
            
            //Colisiones y metodos del juego
            Juego();
            if(this.R.getVidas()>=0&&BanderaColisiones==0){
            Colisiones();
            }
            
            //Muerte
            if(this.M.getX()!=1000&&this.M.getY()!=1000){
            g.drawImage(this.M.getDibujo().getImage(), this.M.getX(), this.M.getY(), this.M.getAncho(), this.M.getAlto(), this);
            }
            
            //HUD
            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            g.drawString("Vidas:", 0, 620);
            
            int xv=0;
            for(int v=1;v<=this.R.getVidas();v++){
                g.drawImage(this.E.getCorazon().getImage(), xv, 625, 20, 20, this);
                xv=xv+20;
            }
            
            g.setColor(Color.WHITE);
            g.drawString("Puntuación", 150, 620);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(""+this.Puntuacion, 150, 640);
            
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            g.drawString("Mejor Puntuación", 250, 620);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(""+this.MejorPuntuacion, 250, 640);
      
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            g.drawString("Nivel:", 500, 620);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(""+this.Nivel, 550, 620);
            
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            g.drawString("Tiempo", this.T.getX(), 620);
            g.setColor(Color.YELLOW);
            g.drawRect(this.T.getX(), this.T.getY(), this.T.getAncho(), this.T.getAlto());
            g.fillRect(this.T.getX(), this.T.getY(), this.T.getAncho(), this.T.getAlto());
            
            
            //Instrucciones
        }else if(BanderaInicio==1){
            g.drawImage(this.E.getInstrucciones().getImage(), 0, 0,600,660, this);
        
            //Game Over
        }else if(BanderaInicio==-1){
            
            
            g.drawImage(this.E.getPerdio().getImage(), 0, 0, 600, 660, this);
            
            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            g.drawString("Tu Puntuación", 25, 300);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString(""+this.Puntuacion, 25, 340);
            
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            g.drawString("Mejor Puntuación", 325, 300);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString(""+this.MejorPuntuacion, 325, 340);
            
            
        }
        repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
