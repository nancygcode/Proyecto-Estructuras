package Controlador;

import Nodos.NodoCarrito;
import javax.swing.JOptionPane;
import Controlador.CtrlCatalogo;
import Modelo.Pedido;

public class ListaCarrito {

    private NodoCarrito inicio;

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarPedido(CtrlCatalogo elemento) {
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

    public void extraer(CtrlCatalogo elemento) {
        NodoCarrito actual = inicio;
        NodoCarrito anterior = null;

        while (actual != null) {
            if (actual.getPedido().getObjeto()==elemento) {
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
                s += aux.getPedido().getObjeto();
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
                s += aux.getPedido().getObjeto();
                aux = aux.getSiguiente();
            }
        } else {
            return "Imposible mostrar: Carrito Vacío";

        }
        return s;
    }
}