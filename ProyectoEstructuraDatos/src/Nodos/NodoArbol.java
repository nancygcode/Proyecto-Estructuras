 package Nodos;

import Modelo.Libro;


public class NodoArbol {
    private Libro elemento;
    private NodoArbol enlaceIzq;
    private NodoArbol enlaceDer;

    public NodoArbol() {
        this.enlaceIzq = null;
        this.enlaceDer = null;
    }

    public Libro getElemento() {
        return elemento;
    }

    public void setElemento(Libro elemento) {
        this.elemento = elemento;
    }

    public NodoArbol getEnlaceIzq() {
        return enlaceIzq;
    }

    public void setEnlaceIzq(NodoArbol enlaceIzq) {
        this.enlaceIzq = enlaceIzq;
    }

    public NodoArbol getEnlaceDer() {
        return enlaceDer;
    }

    public void setEnlaceDer(NodoArbol enlaceDer) {
        this.enlaceDer = enlaceDer;
    }

}

