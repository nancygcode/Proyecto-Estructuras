package Modelo;


public class Elemento {
    
    public Pedido pedido;
    public Elemento siguiente;

    public Elemento(Pedido pedido) {
        this.pedido = pedido;
        this.siguiente = null;
    }
}


