/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c2_aplicacion.servicio;

import appTienda.c3_dominio.contrato.IMarcaDAO;
import appTienda.c3_dominio.entidad.Marca;
import appTienda.c4_persistencia.GestorJDBC;
import appTienda.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import appTienda.c4_persistencia.jdbcpostgre.MarcaDAOPostgre;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class GestionarMarcaServicio {
    GestorJDBC gestorJDBC;
    IMarcaDAO marcaDAO;

    public GestionarMarcaServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.marcaDAO = new MarcaDAOPostgre(gestorJDBC);
    }
    
    public int crear(Marca marca) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = marcaDAO.crear(marca);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int modificar(Marca marca) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = marcaDAO.modificar(marca);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    public int eliminar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = marcaDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    public Marca buscar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        Marca marca = marcaDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return marca;
    }
    
    public ArrayList<Marca> buscarPorNombre(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        ArrayList<Marca> listaMarca = marcaDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaMarca;
    }
    
}
