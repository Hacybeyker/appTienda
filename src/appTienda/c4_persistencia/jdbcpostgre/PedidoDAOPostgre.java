/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.IPedidoDAO;
import appTienda.c3_dominio.entidad.ItemPedido;
import appTienda.c3_dominio.entidad.Pedido;
import appTienda.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class PedidoDAOPostgre implements IPedidoDAO{

    GestorJDBC gestorJDBC;

    public PedidoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public int crear(Pedido pedido) throws Exception {
        int registros_afectados = 0;
        String consulta1 = "insert into pedido(codigopedido,codigoempleado,codigocliente,fecha) values(?,?,?,?)";
        PreparedStatement sentencia1 = gestorJDBC.prepararSentencia(consulta1);
        sentencia1.setInt(1, pedido.getCodigo());
        sentencia1.setInt(2, pedido.getEmpleado().getCodigo());
        sentencia1.setInt(3, pedido.getCliente().getCodigo());
        sentencia1.setDate(4, pedido.getFecha());
        sentencia1.executeUpdate();
        
        for (ItemPedido itemPedido : pedido.getListaItemPedido()) {
            String consulta2 = "insert into itempedido(codigopedido,codigoproducto,cantidad,precioproducto) values(?,?,?,?)";
            PreparedStatement sentencia2 = gestorJDBC.prepararSentencia(consulta2);
            sentencia2.setInt(1, pedido.getCodigo());
            sentencia2.setInt(2, itemPedido.getProducto().getCodigo());
            sentencia2.setInt(3, itemPedido.getCantidad());
            sentencia2.setDouble(4, itemPedido.getProducto().getPrecio());
            sentencia2.executeUpdate();
            
            String consulta3 = "update producto set stockproducto=stockproducto-"+itemPedido.getCantidad()+" where codigoproducto = "+itemPedido.getProducto().getCodigo();
            PreparedStatement sentencia3 = gestorJDBC.prepararSentencia(consulta3);
            registros_afectados = sentencia3.executeUpdate();            
        }        
        return registros_afectados;
    }
    
    @Override
    public int IngresarNuevoCodigo(long empezarDesdeEsteCodigo) throws Exception {
        String consulta = "alter sequence pedido_codigopedido_seq  minvalue "+ empezarDesdeEsteCodigo+"  restart "+empezarDesdeEsteCodigo+" start "+empezarDesdeEsteCodigo+" increment by 1  maxvalue 9223372036854775807 cache 1";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }
    
    @Override
    public long obtenerUltimoCodigoRegistrado() throws Exception {        
        long codigoPedido = 0;
        String consulta = "select max(codigopedido) from pedido";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            codigoPedido = resultado.getLong(1);
        }
        return codigoPedido;
    }
    
    @Override
    public long obtenerNuevoCodigoIngresado() throws Exception {
        long codigoSiguientePedido = 0;
        String consulta = "select last_value from pedido_codigopedido_seq";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            codigoSiguientePedido = resultado.getLong(1);
        }
        return codigoSiguientePedido;
    }
    
    @Override
    public long obtenerSiguienteCodigo() throws Exception {
        long codigoSiguientePedido = 0;
        String consulta = "select last_value+1 from pedido_codigopedido_seq";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            codigoSiguientePedido = resultado.getLong(1);
        }
        return codigoSiguientePedido;
    }
    
    

    
    
}
