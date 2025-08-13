
package Controlador;
import Modelo.Cliente;
import Modelo.Compra;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class CtrlUsuarios {
     private ArrayList<Cliente> usuarios = new ArrayList<>();
    private Cliente sesionActual = null;

    // Método 1: registrarUsuario()
    public void registrarUsuario() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID del usuario: "));
            String nombre = JOptionPane.showInputDialog("Nombre: ");
            String correo = JOptionPane.showInputDialog("Correo: ");
            String pass = JOptionPane.showInputDialog("Contraseña: ");

            if (correo == null || correo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Correo inválido.");
                return;
            }
            if (existeCorreo(correo)) {
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese correo.");
                return;
            }

            usuarios.add(new Cliente(id, nombre, correo, pass));
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Datos inválidos.");
        }
    }

    private boolean existeCorreo(String correo) {
        for (Cliente c : usuarios) {
            if (c.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }

    // Método 2: iniciarSesion()
    public void iniciarSesion() {
        String correo = JOptionPane.showInputDialog("Correo:");
        String pass = JOptionPane.showInputDialog("Contraseña:");

        for (Cliente c : usuarios) {
            if (c.getCorreo().equalsIgnoreCase(correo) && c.getPass().equals(pass)) {
                sesionActual = c;
                JOptionPane.showMessageDialog(null, "Bienvenido, " + c.getNombre());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
    }

    // Método 3: mostrarHistorial()
    public void mostrarHistorial() {
        if (sesionActual == null) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión primero.");
            return;
        }
        JOptionPane.showMessageDialog(null, sesionActual.getHistorial().recorrerComoTexto());
    }

    // Extra: registrar compra en la pila del usuario logueado
    public void registrarCompraActual() {
        if (sesionActual == null) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión primero.");
            return;
        }
        try {
            int idPed = Integer.parseInt(JOptionPane.showInputDialog("ID Pedido:"));
            String det = JOptionPane.showInputDialog("Detalle (ej: 'Libro X x2'):");
            double total = Double.parseDouble(JOptionPane.showInputDialog("Total:"));

            sesionActual.getHistorial().push(new Compra(idPed, det, total));
            JOptionPane.showMessageDialog(null, "Compra registrada en el historial.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos inválidos.");
        }
    }
}

