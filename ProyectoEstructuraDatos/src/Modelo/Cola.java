package Modelo;

public class Cola {

    
    private static class Nodo {
        Pedido pedido;
        Nodo siguiente;
        Nodo(Pedido p) { this.pedido = p; }
    }

    private Nodo frente; 
    private Nodo fin;    

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Pedido p) {
        if (p == null) return;
        Nodo nuevo = new Nodo(p);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Pedido desencolar() {
        if (estaVacia()) return null;
        Pedido p = frente.pedido;
        frente = frente.siguiente;
        if (frente == null) fin = null; 
        return p;
    }

 
    public Pedido verFrente() {
        return estaVacia() ? null : frente.pedido;
    }

    public String recorrerComoTexto() {
        if (estaVacia()) return "No hay pedidos pendientes.";
        String texto = "";
        Nodo aux = frente;
        while (aux != null) {
            texto += aux.pedido.toString() + "\n"; 
            aux = aux.siguiente;
        }
        return texto;
    }
}
