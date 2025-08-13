package Controlador;

import Modelo.Libro;
import javax.swing.JOptionPane;
import Nodos.NodoArbol;

public class ArbolLibro {

   private NodoArbol raiz;

    public ArbolLibro() {
        this.raiz = null;
    }

    public boolean vacio() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }
    
    private String norm(String s) {
         if (s == null) return "";
    return s.trim().toLowerCase();
    }

    // Insertar
    private void insertarRec(NodoArbol actual, NodoArbol nuevo) {
        //normaliza las variables
        String tituloNuevo = norm(nuevo.getElemento().getTitulo());
        String tituloActual = norm(actual.getElemento().getTitulo());

        if (tituloNuevo.compareTo(tituloActual) <= 0) {
            if (actual.getEnlaceIzq() == null) {
                actual.setEnlaceIzq(nuevo);
            } else {
                insertarRec(actual.getEnlaceIzq(), nuevo);
            }
        } else {
            if (actual.getEnlaceDer() == null) {
                actual.setEnlaceDer(nuevo);
            } else {
                insertarRec(actual.getEnlaceDer(), nuevo);
            }
        }
    }

    public void insertarManual() {
        Libro l = new Libro();
        l.setIdLibro(Integer.parseInt(JOptionPane.showInputDialog("ID del libro:")));
        l.setTitulo(JOptionPane.showInputDialog("Título:"));
        l.setAutor(JOptionPane.showInputDialog("Autor:"));
        l.setEditorial(JOptionPane.showInputDialog("Editorial:"));
        l.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Precio:")));
        l.setStock(Double.parseDouble(JOptionPane.showInputDialog("Stock:")));

        NodoArbol nuevo = new NodoArbol();
        nuevo.setElemento(l);

        if (vacio()) {
            raiz = nuevo;
        } else {
            insertarRec(raiz, nuevo);
        }
    }

    public void insertar(Libro l) {
        NodoArbol nuevo = new NodoArbol();
        nuevo.setElemento(l);
        if (vacio()) {
            raiz = nuevo;
        } else {
            insertarRec(raiz, nuevo);
        }
    }

    // Mostrar inorden con string builder=acumula el resultado en una sola variable, JOptionPane
    private void inordenRec(NodoArbol n, StringBuilder sb) {
        if (n != null) {
            inordenRec(n.getEnlaceIzq(), sb);
            sb.append(n.getElemento().toString()).append("\n"); // usa toString()
            inordenRec(n.getEnlaceDer(), sb);
        }
    }

    public String mostrarInordenSB() {
        if (vacio()) {
            return "Árbol vacío";
        }
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString();
    }

    private void inordenRec(NodoArbol n) {  //para mostrar en consola
        if (n != null) {
            inordenRec(n.getEnlaceIzq());
            System.out.println(n.getElemento().toString()); // usa toString()
            inordenRec(n.getEnlaceDer());
        }
    }

    public void mostrarInorden() {
        if (vacio()) {
            System.out.println("Árbol vacío");
        } else {
            inordenRec(raiz);
        }
    }

    // Buscar por título
    public Libro buscarPorTitulo(String titulo) {
        String clave = norm(titulo);
        NodoArbol actual = raiz;
        while (actual != null) {
            String k = norm(actual.getElemento().getTitulo());
            int cmp = clave.compareTo(k);
            if (cmp == 0) {
                return actual.getElemento();
            } else if (cmp < 0) {
                actual = actual.getEnlaceIzq();
            } else {
                actual = actual.getEnlaceDer();
            }
        }
        return null;
    }

    // Modificar por título
    public boolean modificarPorTitulo(String titulo) {
        Libro l = buscarPorTitulo(titulo);
        if (l == null) {
            return false;
        }

        l.setAutor(JOptionPane.showInputDialog("Nuevo autor:", l.getAutor()));
        l.setEditorial(JOptionPane.showInputDialog("Nueva editorial:", l.getEditorial()));
        l.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:", l.getPrecio())));
        l.setStock(Double.parseDouble(JOptionPane.showInputDialog("Nuevo stock:", l.getStock())));
        return true;
    }

    // Eliminar por título
    private NodoArbol eliminarRec(NodoArbol nodo, String clave) {
        if (nodo == null) {
            return null;
        }

        String k = norm(nodo.getElemento().getTitulo());
        int cmp = clave.compareTo(k);

        if (cmp < 0) {
            nodo.setEnlaceIzq(eliminarRec(nodo.getEnlaceIzq(), clave));
        } else if (cmp > 0) {
            nodo.setEnlaceDer(eliminarRec(nodo.getEnlaceDer(), clave));
        } else {
            // Caso 0 o 1 hijo
            if (nodo.getEnlaceIzq() == null) {
                return nodo.getEnlaceDer();
            } else if (nodo.getEnlaceDer() == null) {
                return nodo.getEnlaceIzq();
            }

            // Caso 2 hijos
            NodoArbol sucesor = nodo.getEnlaceDer();
            while (sucesor.getEnlaceIzq() != null) {
                sucesor = sucesor.getEnlaceIzq();
            }
            nodo.setElemento(sucesor.getElemento());
            nodo.setEnlaceDer(eliminarRec(nodo.getEnlaceDer(), norm(sucesor.getElemento().getTitulo())));
        }
        return nodo;
    }

    public boolean eliminarPorTitulo(String titulo) {
        if (buscarPorTitulo(titulo) == null) {
            return false;
        }
        raiz = eliminarRec(raiz, norm(titulo));
        return true;
    }
}
