
package Controlador;
import Modelo.Cliente;
import Modelo.Compra;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CtrlUsuarios {
    private ArrayList<Cliente> usuarios = new ArrayList<>();
    private Cliente sesionActual = null;

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


   
    }
