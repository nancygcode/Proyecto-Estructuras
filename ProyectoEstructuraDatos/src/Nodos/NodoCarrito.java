package Nodos;

import Modelo.Pedido;

public class NodoCarrito {

    private Pedido pedido;
    private NodoCarrito siguiente;

    public NodoCarrito(Pedido pedido) {
        this.pedido = pedido;
        this.siguiente = null;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public NodoCarrito getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCarrito siguiente) {
        this.siguiente = siguiente;
    }
    
    

}
