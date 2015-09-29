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
public class Producto {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;
    TipoProducto tipoProducto;
    UnidadDeMedida unidadDeMedida;
    Marca marca;

    public Producto() {
    }

    public Producto(int codigo, String nombre, String descripcion, int stock, double precio, TipoProducto tipoProducto,UnidadDeMedida unidadDeMedida,Marca marca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.unidadDeMedida = unidadDeMedida;
        this.marca = marca;
    }

    public Producto(String nombre, String descripcion, int stock, double precio, TipoProducto tipoProducto,UnidadDeMedida unidadDeMedida,Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.unidadDeMedida = unidadDeMedida;
        this.marca = marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }   
    
    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public UnidadDeMedida getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }    
    
    public double calcularSubTotal(int cantidad){
        return precio*cantidad;       
    }
    //sirve para validad el stock al momento de crear un producto
    public void verificarStock() throws ExcepcionRegla{
        if(stock<=0)
            throw ExcepcionRegla.crearErrorMENSAJE_STOCKINGRESADOINCORRECTO();
    }
    
}
