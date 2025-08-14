/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Nodos.NodoCliente;
import Modelo.Cliente;
import javax.swing.JOptionPane;

public class ListaCircularClientes {
    private NodoCliente inicio;
    private NodoCliente fin;

    public ListaCircularClientes() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void insertar(Cliente c) {
        if (vacia()) {
            inicio = new NodoCliente(c);
            fin = inicio;
            fin.setSiguiente(inicio);
        } else if (c.getId() < inicio.getDato().getId()) {
            NodoCliente aux = new NodoCliente(c);
            aux.setSiguiente(inicio);
            inicio = aux;
            fin.setSiguiente(inicio);
        } else if (fin.getDato().getId() <= c.getId()) {
            fin.setSiguiente(new NodoCliente(c));
            fin = fin.getSiguiente();
            fin.setSiguiente(inicio);
        } else { // insertar en medio
            NodoCliente aux = inicio;
            while (aux.getSiguiente().getDato().getId() < c.getId()) {
                aux = aux.getSiguiente();
            }
            NodoCliente temp = new NodoCliente(c);
            temp.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temp);
        }
        fin.setSiguiente(inicio);
    }

    public void extraer() {
        if (!vacia()) {
            inicio = inicio.getSiguiente();
            fin.setSiguiente(inicio);
            JOptionPane.showMessageDialog(null, "Elemento extraído");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede extraer (lista vacía)");
        }
    }

    public Cliente buscarPorCorreo(String correo) {
        if (vacia()) return null;
        NodoCliente aux = inicio;
        do {
            if (aux.getDato().getCorreo().equalsIgnoreCase(correo)) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        } while (aux != inicio);
        return null;
    }

    public boolean eliminarPorCorreo(String correo) {
        if (vacia()) return false;

        NodoCliente actual = inicio;
        NodoCliente anterior = fin;

        do {
            if (actual.getDato().getCorreo().equalsIgnoreCase(correo)) {
                if (actual == inicio) { // si es el primero
                    if (inicio == fin) { // único nodo
                        inicio = null;
                        fin = null;
                    } else {
                        inicio = inicio.getSiguiente();
                        fin.setSiguiente(inicio);
                    }
                } else if (actual == fin) { // si es el último
                    anterior.setSiguiente(inicio);
                    fin = anterior;
                } else { // nodo intermedio
                    anterior.setSiguiente(actual.getSiguiente());
                }
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != inicio);

        return false;
    }

    @Override
    public String toString() {
        if (vacia()) return "Lista vacía";
        NodoCliente aux = inicio;
        String s = "Lista de clientes\n-----------------\n";
        do {
            s += aux.getDato().getId() + ", " + aux.getDato().getNombre() + ", " + aux.getDato().getCorreo() + "\n";
            aux = aux.getSiguiente();
        } while (aux != inicio);
        return s;
    }
}
