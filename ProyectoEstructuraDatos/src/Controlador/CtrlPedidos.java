package Controlador;


import javax.swing.JOptionPane;

import Controlador.ListaCarrito;

import Modelo.Compra;
import Nodos.NodoCarrito;
import Nodos.NodoCola;

public class CtrlPedidos {
     private NodoCola inicio;
     private NodoCola fin;
     
     
      public boolean vacia(){
         if(inicio== null){
             return true;
             
         }else{
             return false;
         }
     }
    
    public void encolar(ListaCarrito carrito){
        
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
    public void generarFactura(NodoCarrito inicioCarrito) {
        if (inicioCarrito == null) {
            System.out.println("No hay productos en el carrito.");
            return;
        }

        NodoCarrito aux = inicioCarrito;
        double total = 0;

        System.out.println("----- FACTURA -----");
        while (aux != null) {
            System.out.println("Libro: " + aux.getPedido().getObjeto().getTitulo()+ " | Precio: " + aux.getPedido().getObjeto().getPrecio())
                    ;
          
            aux = aux.getSiguiente();
        }
   
        System.out.println("------------------");
    }
     
     

   
}