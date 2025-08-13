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

    public Compra(int idPedido, String detalle, double total) {
        this.idPedido = idPedido;
        this.detalle = detalle;
        this.total = total;
    }

    public int getIdPedido() { return idPedido; }
    public String getDetalle() { return detalle; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "ID: " + idPedido + " - " + detalle + " - Total: " + total;
    }
}


