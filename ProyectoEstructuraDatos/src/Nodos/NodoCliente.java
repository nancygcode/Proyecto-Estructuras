/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;
import Modelo.Cliente;

/**
 *
 * @author XSF
 */
public class NodoCliente {
    private Cliente dato;
    private NodoCliente siguiente;

    
    public NodoCliente(Cliente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }
    
}
