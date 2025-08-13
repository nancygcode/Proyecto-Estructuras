package Controlador;

import Nodos.NodoCarrito;
import javax.swing.JOptionPane;


public class ListaCarrito {

    private NodoCarrito inicio;

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }


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

                aux = aux.getSiguiente();
            }
        } else {
            return "Imposible mostrar: Carrito Vacío";

        }
        return s;
    }
