package Modelo;


public class Historial {
    private Pedido[] pedidos;
    private int cantidad;

    public Historial() {
        pedidos = new Pedido[100]; // capacidad máxima
        cantidad = 0;
    }

    public void agregarPedido(Pedido pedido) {
        if (cantidad < pedidos.length) {
            pedidos[cantidad] = pedido;
            cantidad++;
        }
    }

    public Pedido[] getPedidos() {
        return pedidos;
    }

    public int getCantidad() {
        return cantidad;
    }
}

