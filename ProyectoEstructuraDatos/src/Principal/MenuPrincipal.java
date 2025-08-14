/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Controlador.CtrlCatalogo;
import Controlador.CtrlPedidos;
import Controlador.ListaCarrito;
import javax.swing.JOptionPane;
import Controlador.CtrlUsuarios;

public class MenuPrincipal {

    ListaCarrito carrito = new ListaCarrito();
    CtrlCatalogo catalogo = new CtrlCatalogo(carrito);

   CtrlUsuarios user = new CtrlUsuarios();
    
    public void Inicio(){
        int op = Integer.parseInt(JOptionPane.showInputDialog("Menu Usuario"
                + "\n Seleccione una opcion"
                +"\n1. Registrar Usuario"
        +"\n2.Iniciar Sesion"
        +"\n3. Cerrar Sesion"
        +"\n4. Eliminar Usuario"
        +"5. Salir"));
        
        switch (op) {
            case 1:
                user.registrarUsuario();
                Inicio();
                break;
            case 2:
                user.iniciarSesion();
                opciones();
                break;
                case 3:
                    user.cerrarSesion();
                break;
                case 4:
                    user.eliminarUsuario();
                break;
                case 5:
                    System.exit(0);
                break;
            default:
                throw new AssertionError();
        }
    }

    public void opciones() {

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
        opciones();
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
