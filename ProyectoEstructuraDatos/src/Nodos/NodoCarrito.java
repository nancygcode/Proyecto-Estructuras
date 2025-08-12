package Nodos;

import Modelo.Pedido;
import javax.swing.JOptionPane;

public class NodoCarrito {

    private Pedido pedido;
    private NodoCarrito siguiente;

    public NodoCarrito(Pedido pedido, NodoCarrito siguiente) {
        this.pedido = pedido;
        this.siguiente = null;
    }

}
