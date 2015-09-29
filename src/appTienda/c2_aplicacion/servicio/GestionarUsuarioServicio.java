/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c2_aplicacion.servicio;

import appTienda.c3_dominio.contrato.IUsuarioDAO;
import appTienda.c3_dominio.entidad.Usuario;
import appTienda.c4_persistencia.GestorJDBC;
import appTienda.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import appTienda.c4_persistencia.jdbcpostgre.UsuarioDAOPostgre;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class GestionarUsuarioServicio {
    GestorJDBC gestorJDBC;
    IUsuarioDAO usuarioDAO;

    public GestionarUsuarioServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.usuarioDAO = new UsuarioDAOPostgre(gestorJDBC);
    }

    
    public int crear(Usuario usuario) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = usuarioDAO.crear(usuario);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    
    public int modificar(Usuario usuario) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = usuarioDAO.modificar(usuario);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    
    public int eliminar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = usuarioDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    
    public Usuario buscar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        Usuario usuario = usuarioDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return usuario;
    }

    public Usuario IngresoUsuario(String user,String tipo, String password) throws Exception {
        gestorJDBC.abrirConexion();
        Usuario usuario = usuarioDAO.IngresoUsuario(user, tipo, password);
        gestorJDBC.cerrarConexion();
        return usuario;
    }
    
    public ArrayList<Usuario> buscarPorApellido(String apellido) throws Exception {
        gestorJDBC.abrirConexion();
        ArrayList<Usuario> listaUsuario = usuarioDAO.buscarPorApellido(apellido);
        gestorJDBC.cerrarConexion();
        return listaUsuario;
    }
}
