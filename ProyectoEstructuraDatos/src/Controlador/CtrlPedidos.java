package Controlador;


import javax.swing.JOptionPane;
import Modelo.Cola;
import Modelo.Pedido;
import Modelo.Libro;

public class CtrlPedidos {

    private final Cola colaPedidos = new Cola();
    private final CtrlReportes reportes = new CtrlReportes();

    public void encolarManual() {
        try {
            String titulo = JOptionPane.showInputDialog("Título del libro:");
            String autor = JOptionPane.showInputDialog("Autor:");
            String editorial = JOptionPane.showInputDialog("Editorial:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));

            Libro libro = new Libro(0, titulo, autor, editorial, precio, 0);
            Pedido pedido = new Pedido(libro);

            colaPedidos.encolar(pedido);
            JOptionPane.showMessageDialog(null, "Pedido encolado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos inválidos.");
        }
    }

    public void mostrarPendientes() {
        JOptionPane.showMessageDialog(null, colaPedidos.recorrerComoTexto());
    }

    public void atenderSiguiente() {
        Pedido pedido = colaPedidos.desencolar();
        if (pedido == null) {
            JOptionPane.showMessageDialog(null, "No hay pedidos por atender.");
        } else {
            JOptionPane.showMessageDialog(null, "Pedido atendido:\n" + pedido.toString());
            reportes.registrarVenta(pedido, null);
        }
    }

    public void mostrarLibrosMasVendidos() { reportes.mostrarLibrosMasVendidos(); }
    public void mostrarClientesMasActivos() { reportes.mostrarClientesMasActivos(); }

    public void menu() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "GESTIÓN DE PEDIDOS\n" +
                    "1) Encolar pedido manual\n" +
                    "2) Mostrar pendientes\n" +
                    "3) Atender siguiente\n" +
                    "4) Reporte: Libros más vendidos\n" +
                    "5) Reporte: Clientes más activos\n" +
                    "0) Volver"));

            switch (op) {
                case 1:
                    encolarManual();
                    break;
                case 2:
                    mostrarPendientes();
                    break;
                case 3:
                    atenderSiguiente();
                    break;
                case 4:
                    mostrarLibrosMasVendidos();
                    break;
                case 5:
                    mostrarClientesMasActivos();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (op != 0);
    }
}