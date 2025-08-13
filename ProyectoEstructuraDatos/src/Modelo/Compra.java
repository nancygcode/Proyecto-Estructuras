/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author danie
 */
public class Compra {

    private int idPedido;
    private String detalle;
    private double total;
    private Libro objeto;
    
    

    public Compra() {
        this.idPedido = 0;
        this.detalle = " ";
        this.total = 0;
        
    }

    public Compra(Libro objeto) {
        this.objeto = objeto;
    }
    
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

}


