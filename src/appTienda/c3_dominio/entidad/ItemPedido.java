/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.entidad;

import appTienda.c6_transversal.excepcion.ExcepcionRegla;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class ItemPedido {
    private Producto producto;
    private int cantidad;    
    private double precio;
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }        
    
    public double calcularSubTotal(){
        return producto.getPrecio()*cantidad;
    }
    
    //sirve para validar que la cantidad ingresada al momento de hacer un pedido de un producto determinado no sea mayor al stock existente        
    public  void validarStock() throws ExcepcionRegla{
        if(cantidad>producto.getStock())
            throw ExcepcionRegla.crearErrorMENSAJE_CANTIDADSUPERIORALSTOCK();
    }
    
}
