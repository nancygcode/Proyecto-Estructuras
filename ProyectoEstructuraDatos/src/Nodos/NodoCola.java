package Nodos;


import Controlador.ListaCarrito;
import Modelo.Compra;


public class NodoCola {
   
    private ListaCarrito objeto;

    private Compra compra;
    private NodoCola siguiente;

    public NodoCola() {
        this.objeto = objeto;

        this.compra= compra;
        this.siguiente = null;
    }
    
    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public ListaCarrito getObjeto() {
        return objeto;
    }

    public void setObjeto(ListaCarrito objeto) {
        this.objeto = objeto;
    }

   

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    
}


