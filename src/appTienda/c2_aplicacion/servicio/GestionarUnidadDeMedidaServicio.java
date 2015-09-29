/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c2_aplicacion.servicio;

import appTienda.c3_dominio.contrato.IUnidadDeMedidaDAO;
import appTienda.c3_dominio.entidad.UnidadDeMedida;
import appTienda.c4_persistencia.GestorJDBC;
import appTienda.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import appTienda.c4_persistencia.jdbcpostgre.UnidadDeMedidaDAOPostgre;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class GestionarUnidadDeMedidaServicio {
    GestorJDBC gestorJDBC;
    IUnidadDeMedidaDAO unidadDeMedidaDAO;

    public GestionarUnidadDeMedidaServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.unidadDeMedidaDAO = new UnidadDeMedidaDAOPostgre(gestorJDBC);
    }
    
    public int crear(UnidadDeMedida unidadDeMedida) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = unidadDeMedidaDAO.crear(unidadDeMedida);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int modificar(UnidadDeMedida unidadDeMedida) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = unidadDeMedidaDAO.modificar(unidadDeMedida);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    public int eliminar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = unidadDeMedidaDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    public UnidadDeMedida buscar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        UnidadDeMedida unidadDeMedida = unidadDeMedidaDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return unidadDeMedida;
    }
    
    public ArrayList<UnidadDeMedida> buscarPorNombre(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        ArrayList<UnidadDeMedida> listaUnidadDeMedida = unidadDeMedidaDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaUnidadDeMedida;
    }
    
}
