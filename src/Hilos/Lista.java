/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

/**
 *
 * @author ASUS
 */
public class Lista {
    Nodo Cabeza;
    Nodo Aux;

    public Lista() {
    }

    public Lista(Nodo Cabeza, Nodo Aux) {
        this.Cabeza = Cabeza;
        this.Aux = Aux;
    }

    public void Ingresar(Automovil Vehiculo){
        if(this.Cabeza==null){
            this.Cabeza=new Nodo(Vehiculo, Aux);
            this.Aux = this.Cabeza;
        }else{
            this.Aux.setSig(new Nodo(Vehiculo, null));
            this.Aux = this.Aux.getSig();
        }
        
    }
    
    
    
    
    public Nodo getAux() {
        return Aux;
    }

    public Nodo getCabeza() {
        return Cabeza;
    }

    public void setAux(Nodo Aux) {
        this.Aux = Aux;
    }

    public void setCabeza(Nodo Cabeza) {
        this.Cabeza = Cabeza;
    }
    
    
}
