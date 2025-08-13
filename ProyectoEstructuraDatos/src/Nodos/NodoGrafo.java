package Nodos;


public class NodoGrafo {
  
    private Object dato;
    private NodoGrafo siguiente;
    private NodoGrafo adyacente;

    public NodoGrafo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.adyacente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoGrafo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }

    public NodoGrafo getAdyacente() {
        return adyacente;
    }

    public void setAdyacente(NodoGrafo adyacente) {
        this.adyacente = adyacente;
    }
}
 

