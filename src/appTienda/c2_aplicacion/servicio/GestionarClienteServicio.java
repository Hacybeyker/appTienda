/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c2_aplicacion.servicio;

import appTienda.c3_dominio.contrato.IClienteDAO;
import appTienda.c3_dominio.entidad.Cliente;
import appTienda.c4_persistencia.GestorJDBC;
import appTienda.c4_persistencia.jdbcpostgre.ClienteDAOPostgre;
import appTienda.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class GestionarClienteServicio{

    GestorJDBC gestorJDBC;
    IClienteDAO clienteDAO;

    public GestionarClienteServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.clienteDAO = new ClienteDAOPostgre(gestorJDBC);
    }
    
    public int crear(Cliente cliente) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = clienteDAO.crear(cliente);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public int modificar(Cliente cliente) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = clienteDAO.modificar(cliente);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public int eliminar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = clienteDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public Cliente buscar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return cliente;
    }
    
    public Cliente buscarPorDni(String dni) throws Exception {
        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAO.buscarPorDni(dni);
        gestorJDBC.cerrarConexion();
        return cliente;
    }

    
    public ArrayList<Cliente> buscarPorNombre(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        ArrayList<Cliente> listaCliente = clienteDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaCliente;
    }
    
}
