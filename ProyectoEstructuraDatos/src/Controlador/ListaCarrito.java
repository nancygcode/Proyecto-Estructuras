package Controlador;

import Nodos.NodoCarrito;
import javax.swing.JOptionPane;
import Modelo.Pedido;
import Modelo.Libro;

public class ListaCarrito {

    private NodoCarrito inicio;

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarPedido( Libro elemento) {
        Pedido pedido = new Pedido(elemento);
        NodoCarrito nuevoNodo = new NodoCarrito(pedido);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            NodoCarrito aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevoNodo);
        }
        JOptionPane.showMessageDialog(null, "Libro agregrado con exito al carrito");
    }

    public void extraer(String titulo) {
        NodoCarrito actual = inicio;
        NodoCarrito anterior = null;
        titulo= JOptionPane.showInputDialog("Ingrese el nombre del libro que desea eliminar");

        while (actual != null) {
            if (actual.getPedido().getObjeto().getTitulo().equals(titulo)) {
                if (anterior == null) {
                    inicio = actual.getSiguiente();//elimina el nodo inicial
                } else {
                    anterior.setSiguiente(actual.getSiguiente());//elimina al nodo medio o final
                }
                JOptionPane.showMessageDialog(null, "Libro eliminado con exito del carrito");

            }
            anterior = actual;
            actual = actual.getSiguiente();
            JOptionPane.showMessageDialog(null, "El libro no se pudo eliminar");
        }

    }

    public void mostrar() {
        if (!vacia()) {
            String s = " ";
            NodoCarrito aux = inicio;
            while (aux != null) {
                //agrega los datos mostrados porque lo muestra por marca
                s += aux.getPedido().getObjeto().getTitulo()+"/"+
                        aux.getPedido().getObjeto().getAutor()+"\n"
                        +aux.getPedido().getObjeto().getEditorial()+"\n"
                        +aux.getPedido().getObjeto().getPrecio();
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Contenido de la lista\n\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "error: al mostrar la lista");
        }
    }

    @Override
    public String toString() {
        String s = "";
        NodoCarrito aux = inicio;
        if (!vacia()) {
            while (aux != null) {
                s += aux.getPedido().getObjeto() +"/"+
                        aux.getPedido().getObjeto().getAutor()+"\n"
                        +aux.getPedido().getObjeto().getEditorial()+"\n"
                        +aux.getPedido().getObjeto().getPrecio();
                aux = aux.getSiguiente();
            }
        } else {
            return "Imposible mostrar: Carrito Vacío";

        }
        return s;
    }
    
    public double calcularTotal() {
    double total = 0;
    NodoCarrito aux = inicio;

    while (aux != null) {
        total += aux.getPedido().getObjeto().getPrecio(); // sumamos el precio del libro
        aux = aux.getSiguiente();           // pasamos al siguiente nodo
    }

    
    return total;
}
    
    

    public NodoCarrito getInicio() {
        return inicio;
    }

 
    
    
    
}