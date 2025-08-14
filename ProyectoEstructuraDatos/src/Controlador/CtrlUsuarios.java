
package Controlador;
import Modelo.Cliente;
import Controlador.ListaCircularClientes;
import Principal.MenuPrincipal;
import javax.swing.JOptionPane;

public class CtrlUsuarios {

        private ListaCircularClientes lista = new ListaCircularClientes();
        private Cliente sesionActual = null;

        public void registrarUsuario() {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String correo = JOptionPane.showInputDialog("Correo:");
            String pass = JOptionPane.showInputDialog("Contraseña:");

            if (lista.buscarPorCorreo(correo) != null) {
                JOptionPane.showMessageDialog(null, "Correo ya registrado.");
                return;
            }

            lista.insertar(new Cliente(id, nombre, correo, pass));
            JOptionPane.showMessageDialog(null, "Usuario registrado.");
        }

        public void iniciarSesion() {
            String correo = JOptionPane.showInputDialog("Correo:");
            String pass = JOptionPane.showInputDialog("Contraseña:");

            Cliente c = lista.buscarPorCorreo(correo);
            if (c != null && c.getPass().equals(pass)) {
                sesionActual = c;
                JOptionPane.showMessageDialog(null, "Bienvenido, " + c.getNombre());
             
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
            }
        }

        public void cerrarSesion() {
            if (sesionActual != null) {
                JOptionPane.showMessageDialog(null, "Sesión cerrada de " + sesionActual.getNombre());
                sesionActual = null;
            } else {
                JOptionPane.showMessageDialog(null, "No hay sesión activa.");
            }
        }

        public void eliminarUsuario() {
            String correo = JOptionPane.showInputDialog("Correo a eliminar:");
            boolean eliminado = lista.eliminarPorCorreo(correo);
            JOptionPane.showMessageDialog(null, eliminado ? "Usuario eliminado" : "No se encontró ese correo.");
        }

        public void mostrarUsuarios() {
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }
