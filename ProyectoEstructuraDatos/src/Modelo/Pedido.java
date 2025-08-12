package Modelo;

public class Pedido {

    private int idPedido;
    private Cliente nombre;
    private Elemento elemento;
    private Libro libro;
    private Compra compra;

    public Pedido() {
    }

    public Pedido(int idPedido, Cliente nombre, Elemento elemento, Libro libro) {
        this.idPedido = idPedido;
        this.nombre = nombre;
        this.elemento = elemento;
        this.libro = libro;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getNombre() {
        return nombre;
    }

    public void setNombre(Cliente nombre) {
        this.nombre = nombre;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    
}
