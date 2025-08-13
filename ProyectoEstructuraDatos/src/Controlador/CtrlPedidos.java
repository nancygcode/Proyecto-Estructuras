package Controlador;


import javax.swing.JOptionPane;

import Controlador.ListaCarrito;
import Modelo.Compra;
import Nodos.NodoCarrito;
import Nodos.NodoCola;

public class CtrlPedidos {
     private NodoCola inicio;
     private NodoCola fin;
     private ListaCarrito carrito;

    public CtrlPedidos(ListaCarrito carrito) {
  
        this.carrito = carrito;
    }
     
     
     
      public boolean vacia(){
         if(inicio== null){
             return true;
             
         }else{
             return false;
         }
     }
    
    public void encolar(){
        if (carrito.vacia()) {
            JOptionPane.showMessageDialog(null, "El carrito está vacío, no se puede generar pedido.");
            return;
        }
          Compra com = new Compra();
         com.setIdPedido(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la compra")));
         com.setDetalle(JOptionPane.showInputDialog("Ingrese el detalle del pedido"));
         com.setTotal(carrito.calcularTotal());
         
         //Agregamos el objeto estudiante en el nuevo nodo
         NodoCola nuevo= new NodoCola();
         //Agrego el estudiante al nodo nuevo
         nuevo.setObjeto(carrito);
         nuevo.setCompra( com);
         //Insertamos el nodo en la cola
 
         if (vacia()){
             inicio=nuevo;
             fin=nuevo;
             
         }else{
             fin.setSiguiente(nuevo);
             fin= nuevo;
             
         }
     }
   
      public void generarFacturas() {
        if (vacia()) {
            System.out.println("No hay pedidos.");
            return;
        }

        NodoCola auxCola = inicio;
        while (auxCola != null) {
            System.out.println("----- FACTURA -----");
            System.out.println("ID Compra: " + auxCola.getCompra().getIdPedido());
            System.out.println("ID Detalle: " + auxCola.getCompra().getDetalle());
            System.out.println("Total: " + auxCola.getCompra().getTotal());

            NodoCarrito auxCarrito = auxCola.getObjeto().getInicio();
            double total = 0;
            while (auxCarrito != null) {
                System.out.println(auxCarrito.getPedido().getObjeto().toString()); // llama a Libro.toString()
                total += auxCarrito.getPedido().getObjeto().getPrecio();
                auxCarrito = auxCarrito.getSiguiente();
            }
            System.out.println("Total: ₡" + total);
            System.out.println("------------------\n");

            auxCola = auxCola.getSiguiente();
        }
    }
     
     

   
}