/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.entidad;

import appTienda.c6_transversal.excepcion.ExcepcionRegla;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class Pedido {
    private int codigo;
    private Date fecha;
    Cliente cliente;
    Empleado empleado;
    List<ItemPedido> listaItemPedidos;

    public Pedido() {
        this.listaItemPedidos = new ArrayList<>();
    }
    
    public Pedido(int codigo, Date fecha, Empleado empleado,Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.listaItemPedidos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<ItemPedido> getListaItemPedido() {
        return listaItemPedidos;
    }
    
    public ItemPedido getLisItemPedido(int index){        
        return listaItemPedidos.get(index);
    }
    
    public void agregarItemPedido(ItemPedido itemPedido) throws ExcepcionRegla{
        validarProducto(itemPedido.getProducto().getNombre());
        itemPedido.validarStock();        
        listaItemPedidos.add(itemPedido);
    }
    
   //Para cuando se modifique la cantidad desde la tabla
    public void actualizarStockPedido(ItemPedido itemPedido) throws Exception{          
        itemPedido.validarStock();
        for(ItemPedido itemPedidoExistente : listaItemPedidos){
            if(itemPedidoExistente.getProducto().getNombre().equals(itemPedido.getProducto().getNombre())){
                itemPedidoExistente.setCantidad(itemPedido.getCantidad());                        
                break;
            }
        }
    }
    
    //Para cuando se modifique la cantidad desde la tabla y el stock ingresado sea mayor al descuento, lo cual hace que la cantidad ingresada anteriormente vuelva
    public ItemPedido getItemPedido(String nombreProducto) {
        for(ItemPedido itemPedido : listaItemPedidos){
            if(itemPedido.getProducto().getNombre().equals(nombreProducto)){
                return itemPedido;
            }
        }
        return null;
    }
    
    private void validarProducto(String nombreProducto) throws ExcepcionRegla{
        for (ItemPedido listaItemPedido : listaItemPedidos) {
            if(listaItemPedido.getProducto().getNombre().equals(nombreProducto))
                throw ExcepcionRegla.crearErrorMENSAJE_PRODUCTOYAEXISTE();
        }
    }
    
    public void eliminarItemPedido(String nombreProducto){
        for (ItemPedido listaItemPedido : listaItemPedidos) {
            if(listaItemPedido.getProducto().getNombre().equals(nombreProducto)){
                listaItemPedidos.remove(listaItemPedido);
                break;
            }
        }
    }
    
    public double calcularSubTotalPedido(){
        double subtotalPedido = 0;
        for (ItemPedido listaItemPedido : listaItemPedidos) {
            subtotalPedido += listaItemPedido.calcularSubTotal();
        }
        return subtotalPedido;
    }
    
    public double calcularDescuentoPedido(){
        double descuento = 0.1;
        return calcularSubTotalPedido()*descuento;
    }
    
    public double calcularTotalPedido(){
        return calcularSubTotalPedido()-calcularDescuentoPedido();
    }
    
    public void validarPedido() throws ExcepcionRegla{
        if(calcularTotalPedido()<=0)
            throw ExcepcionRegla.crearErrorMENSAJE_PEDIDOINCORRECTO();                    
    }
    
}
