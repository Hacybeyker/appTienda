/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.contrato;

import appTienda.c3_dominio.entidad.Pedido;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public interface IPedidoDAO {      
    public int crear(Pedido pedido)throws Exception; 
    
    public int IngresarNuevoCodigo(long empezarDesdeEsteCodigo) throws Exception;//me retorna un int para saber si se registros o no
    public long obtenerUltimoCodigoRegistrado() throws Exception;
    public long obtenerNuevoCodigoIngresado()throws Exception;
    public long obtenerSiguienteCodigo() throws Exception;  
    
}
