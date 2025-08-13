package Modelo;

import javax.swing.JOptionPane;



public class Reportes {

    // Arreglos simples para acumular datos
    private final String[] librosVendidos = new String[100];   // máx. 100
    private final String[] clientesActivos = new String[100];  // máx. 100
    private int contadorLibros = 0;
    private int contadorClientes = 0;

    // Registrar venta (usa tu Pedido con getObjeto())
    public void registrarVenta(Pedido pedido, String cliente) {
        // Guarda título del libro vendido
        if (pedido != null && pedido.getObjeto() != null) {
            if (contadorLibros < librosVendidos.length) {
                librosVendidos[contadorLibros++] = pedido.getObjeto().getTitulo();
            }
        }
        // Guarda identificador del cliente (correo, nombre, etc.)
        if (cliente != null && !cliente.trim().isEmpty()) {
            if (contadorClientes < clientesActivos.length) {
                clientesActivos[contadorClientes++] = cliente.trim();
            }
        }
    }

    // Mostrar libros vendidos
    public void mostrarLibrosMasVendidos() {
        if (contadorLibros == 0) {
            JOptionPane.showMessageDialog(null, "No hay ventas registradas.");
            return;
        }
        String texto = "Libros vendidos:\n";
        for (int i = 0; i < contadorLibros; i++) {
            texto += "- " + librosVendidos[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    // Mostrar clientes más activos (simplemente listados)
    public void mostrarClientesMasActivos() {
        if (contadorClientes == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }
        String texto = "Clientes activos:\n";
        for (int i = 0; i < contadorClientes; i++) {
            texto += "- " + clientesActivos[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }
}
