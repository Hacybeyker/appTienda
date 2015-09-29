/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c2_aplicacion.servicio;

import appTienda.c3_dominio.contrato.IPedidoDAO;
import appTienda.c3_dominio.entidad.Pedido;
import appTienda.c4_persistencia.GestorJDBC;
import appTienda.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import appTienda.c4_persistencia.jdbcpostgre.PedidoDAOPostgre;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class RegistrarPedidoServicio{

    GestorJDBC gestorJDBC;
    IPedidoDAO pedidoDAOPostgre;

    public RegistrarPedidoServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.pedidoDAOPostgre = new PedidoDAOPostgre(gestorJDBC);
    }
    
    public int crear(Pedido pedido) throws Exception {
        int registros_afectado;
        pedido.validarPedido();
        gestorJDBC.abrirConexion();
        gestorJDBC.iniciarTransaccion();
        registros_afectado = pedidoDAOPostgre.crear(pedido);
        gestorJDBC.terminarTransaccion();
        gestorJDBC.cerrarConexion();
        return registros_afectado;
    }
    
    public int IngresarNuevoCodigo(long empezarDesdeEsteCodigo) throws Exception{
        int registros_afectado = 0;
        gestorJDBC.abrirConexion();
        registros_afectado = pedidoDAOPostgre.IngresarNuevoCodigo(empezarDesdeEsteCodigo);
        gestorJDBC.cerrarConexion();
        return registros_afectado;
    }
    
    public long obtenerUltimoCodigoRegistrado() throws Exception{
        long codigoPedido = 0;
        gestorJDBC.abrirConexion();
        codigoPedido = pedidoDAOPostgre.obtenerUltimoCodigoRegistrado();
        gestorJDBC.cerrarConexion();
        return codigoPedido;
    }
    
    public long obtenerNuevoCodigoIngresado() throws Exception{
        long codigoPedido = 0;
        gestorJDBC.abrirConexion();
        codigoPedido = pedidoDAOPostgre.obtenerNuevoCodigoIngresado();
        gestorJDBC.cerrarConexion();
        return codigoPedido;
    }
    
    public long obtenerSiguienteCodigo() throws Exception{
        long codigoSiguientePedido = 0;
        gestorJDBC.abrirConexion();
        codigoSiguientePedido = pedidoDAOPostgre.obtenerSiguienteCodigo();
        gestorJDBC.cerrarConexion();
        return codigoSiguientePedido;
    }
    
}
