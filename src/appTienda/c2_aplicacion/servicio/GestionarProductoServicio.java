/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c2_aplicacion.servicio;

import appTienda.c3_dominio.contrato.IProductoDAO;
import appTienda.c3_dominio.entidad.Producto;
import appTienda.c4_persistencia.GestorJDBC;
import appTienda.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import appTienda.c4_persistencia.jdbcpostgre.ProdcutoDAOPostgre;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class GestionarProductoServicio {

    GestorJDBC gestorJDBC;
    IProductoDAO productoDAO;

    public GestionarProductoServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.productoDAO = new ProdcutoDAOPostgre(gestorJDBC);
    }
    
    
    public int crear(Producto producto) throws Exception {
        producto.verificarStock();
        gestorJDBC.abrirConexion();
        int estado = productoDAO.crear(producto);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public int modificar(Producto producto) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = productoDAO.modificar(producto);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public int eliminar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = productoDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public Producto buscar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        Producto producto = productoDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return producto;
    }

    
    public ArrayList<Producto> buscarPorNombre(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        ArrayList<Producto> listaProducto = productoDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaProducto;
    }
    
}
