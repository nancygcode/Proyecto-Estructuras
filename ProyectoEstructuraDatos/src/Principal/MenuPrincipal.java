/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Controlador.CtrlCatalogo;
import Controlador.CtrlPedidos;
import Controlador.ListaCarrito;
import javax.swing.JOptionPane;


/**
 *
 * @author XSF
 */
public class MenuPrincipal {
    CtrlCatalogo catalogo = new CtrlCatalogo();
    CtrlPedidos Compra = new CtrlPedidos();
    ListaCarrito carrito = new ListaCarrito();
    
    public void opciones() {
       int op = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione una opción:\n"
                + "1) Ingresar al Catalogo\n"
                + "2) Ver Carrito\n"
                + "3) Pagar Carrito\n"+
                    "4) Salir"));

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
                AccionComprar();
                opciones();
                break;
             case 4:
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
        }

        opciones();
    }
    

        
        public void AccionComprar(){
        CtrlPedidos factura = new CtrlPedidos();
        int accion=Integer.parseInt(JOptionPane.showInputDialog("Desea: \n1.Efectivo \n 2. Tarjeta"));
        switch (accion){
            case 1:
                JOptionPane.showMessageDialog(null, "Serian: "+ carrito.calcularTotal());
                factura.encolar(carrito);
                factura.generarFacturas();
               
                break;
            case 2: 
                JOptionPane.showMessageDialog(null, "Aqui tiene el datafono");
                factura.encolar(carrito);
                factura.generarFacturas();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                
        }
              
    }
}
