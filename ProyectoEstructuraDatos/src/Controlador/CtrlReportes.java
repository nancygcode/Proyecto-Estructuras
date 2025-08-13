package Controlador;
import javax.swing.JOptionPane;
import Modelo.Reportes;
import Modelo.Pedido;

/**
 *
 * @author Nancy
 */
public class CtrlReportes {
    // Usa la clase Reportes (con arreglos) del paquete Modelo
    private final Reportes reportes = new Reportes();

    // Lo llamará CtrlPedidos al atender un pedido
    public void registrarVenta(Pedido pedido, String idCliente) {
        reportes.registrarVenta(pedido, idCliente);
    }

    // Mostrar reportes (se delega al Modelo)
    public void mostrarLibrosMasVendidos() {
        reportes.mostrarLibrosMasVendidos();
    }

    public void mostrarClientesMasActivos() {
        reportes.mostrarClientesMasActivos();
    }

    // Menú simple (switch + break), mismo estilo que usas
    public void menu() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "REPORTES\n" +
                    "1) Libros más vendidos\n" +
                    "2) Clientes más activos\n" +
                    "0) Volver"));

            switch (op) {
                case 1:
                    mostrarLibrosMasVendidos();
                    break;
                case 2:
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

