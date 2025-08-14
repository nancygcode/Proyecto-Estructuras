/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Controlador.CtrlCatalogo;
import Controlador.CtrlPedidos;
import Controlador.ListaCarrito;
import javax.swing.JOptionPane;

public class MenuPrincipal {

    ListaCarrito carrito = new ListaCarrito();
    CtrlCatalogo catalogo = new CtrlCatalogo(carrito);

    private String usuarioRegistrado = "";
    private String contrasenaRegistrada = "";

    public void opciones() {
      
        usuarioRegistrado = JOptionPane.showInputDialog("Cree su nombre de usuario:");
        contrasenaRegistrada = JOptionPane.showInputDialog("Cree su contraseña:");

        
        String usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

        if (!usuario.equals(usuarioRegistrado) || !contrasena.equals(contrasenaRegistrada)) {
            JOptionPane.showMessageDialog(null, "Acceso denegado. Usuario o contraseña incorrectos.");
            return; 
        }

        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "-------------------SIMULACION DE LIBRERIA 📚-----------------"
                + "\nSeleccione una opción:\n"
                + "1) Ingresar al Catalogo\n"
                + "2) Ver Carrito\n"
                + "3) Eliminar del carrito\n"
                + "4) Pagar Carrito\n"
                + "5) Salir"));

        switch (op) {
            case 1:
                catalogo.menucatalogo();
                opciones();
                break;
            case 2:
                carrito.mostrar();
                opciones();
                break;
            case 3:
                carrito.extraer();
                opciones();
                break;
            case 4:
                AccionComprar();
                opciones();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
                opciones();
                break;
        }
    }

    public void AccionComprar() {
        CtrlPedidos factura = new CtrlPedidos(carrito);
        int accion = Integer.parseInt(JOptionPane.showInputDialog("Desea: \n1. Efectivo \n2. Tarjeta"));
        switch (accion) {
            case 1:
                JOptionPane.showMessageDialog(null, "Serían: " + carrito.calcularTotal());
                factura.encolar();
                factura.generarFacturas();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Aquí tiene el datáfono");
                factura.encolar();
                factura.generarFacturas();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción incorrecta");
        }
    }
}
