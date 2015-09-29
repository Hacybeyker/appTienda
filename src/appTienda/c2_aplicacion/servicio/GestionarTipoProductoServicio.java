/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c2_aplicacion.servicio;

import appTienda.c3_dominio.contrato.ITipoProductoDAO;
import appTienda.c3_dominio.entidad.TipoProducto;
import appTienda.c4_persistencia.GestorJDBC;
import appTienda.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import appTienda.c4_persistencia.jdbcpostgre.TipoProductoDAOPostgre;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class GestionarTipoProductoServicio {
    GestorJDBC gestorJDBC;
    ITipoProductoDAO tipoproductoDAO;

    public GestionarTipoProductoServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.tipoproductoDAO = new TipoProductoDAOPostgre(gestorJDBC);
    }

    
    public int crear(TipoProducto tipoProducto) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = tipoproductoDAO.crear(tipoProducto);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public int modificar(TipoProducto tipoProducto) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = tipoproductoDAO.modificar(tipoProducto);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public int eliminar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = tipoproductoDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public TipoProducto buscar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        TipoProducto tipoProducto = tipoproductoDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return tipoProducto;
    }

    
    public ArrayList<TipoProducto> buscarPorNombre(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        ArrayList<TipoProducto> listaTipoProducto = tipoproductoDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaTipoProducto;
    }
    
    
}
