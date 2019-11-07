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
public class Nodo {
    Automovil Vehiculo;
    Nodo Sig;

    public Nodo() {
    }

    public Nodo(Automovil Vehiculo, Nodo Sig) {
        this.Vehiculo = Vehiculo;
        this.Sig = Sig;
    }

    public Nodo getSig() {
        return Sig;
    }

    public void setSig(Nodo Sig) {
        this.Sig = Sig;
    }

    public void setVehiculo(Automovil Vehiculo) {
        this.Vehiculo = Vehiculo;
    }

    public Automovil getVehiculo() {
        return Vehiculo;
    }
    
    
}
