package proyectoestructuradatos;


public class NodoArbol {
    private Libro elemento;
    private NodoLibro enlaceIzq;
    private NodoLibro enlaceDer;

    public NodoLibro() {
        this.enlaceIzq = null;
        this.enlaceDer = null;
    }

    public Libro getElemento() {
        return elemento;
    }

    public void setElemento(Libro elemento) {
        this.elemento = elemento;
    }

    public NodoLibro getEnlaceIzq() {
        return enlaceIzq;
    }

    public void setEnlaceIzq(NodoLibro enlaceIzq) {
        this.enlaceIzq = enlaceIzq;
    }

    public NodoLibro getEnlaceDer() {
        return enlaceDer;
    }

    public void setEnlaceDer(NodoLibro enlaceDer) {
        this.enlaceDer = enlaceDer;
    }

}

