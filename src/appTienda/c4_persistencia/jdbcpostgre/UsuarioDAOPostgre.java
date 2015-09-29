/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.IUsuarioDAO;
import appTienda.c3_dominio.entidad.Cargo;
import appTienda.c3_dominio.entidad.Empleado;
import appTienda.c3_dominio.entidad.Usuario;
import appTienda.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class UsuarioDAOPostgre implements IUsuarioDAO{
    GestorJDBC gestorJDBC;

    public UsuarioDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int crear(Usuario usuario) throws Exception {
        String consulta = "insert into usuario (usuariousuario,passwordusuario,codigoempleado) values(?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, usuario.getUsuario());
        sentencia.setString(2, usuario.getPassword());
        sentencia.setInt(3, usuario.getEmpleado().getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Usuario usuario) throws Exception {
        String consulta = "update usuario set usuariousuario=?,passwordusuario=?,codigoempleado=? where codigousuario=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, usuario.getUsuario());
        sentencia.setString(2, usuario.getPassword());
        sentencia.setInt(3, usuario.getEmpleado().getCodigo());
        sentencia.setInt(4, usuario.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from usuario where codigousuario="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Usuario buscar(int codigo) throws Exception {
        Empleado empleado;
        Cargo cargo;
        Usuario usuario = null;
        String consulta = "select c.codigocargo,c.nombrecargo,c.descripcioncargo,e.codigoempleado,e.nombreempleado,e.apellidoempleado,e.dniempleado,e.direccionempleado,e.telefonoempleado,e.celularempleado,e.correoempleado,e.activoempleado,e.fechainicioempleado,e.fechafinempleado,e.sueldoempleado,u.codigousuario,u.usuariousuario,u.passwordusuario from empleado e inner join cargo c on e.codigocargo=c.codigocargo inner join usuario u on e.codigoempleado=u.codigoempleado where e.codigoempleado="+codigo;        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            cargo = new Cargo();
            cargo.setCodigo(resultado.getInt(1));
            cargo.setNombre(resultado.getString(2));
            cargo.setDescripcion(resultado.getString(3));
            
            empleado = new Empleado();
            empleado.setCodigo(resultado.getInt(4));
            empleado.setNombre(resultado.getString(5));
            empleado.setApellido(resultado.getString(6));
            empleado.setDni(resultado.getString(7));
            empleado.setDireccion(resultado.getString(8));
            empleado.setTelefono(resultado.getString(9));
            empleado.setCelular(resultado.getString(10));
            empleado.setCorreo(resultado.getString(11));
            empleado.setActivo(resultado.getBoolean(12));
            empleado.setFechainicio(resultado.getDate(13));
            empleado.setFechafin(resultado.getDate(14));
            empleado.setSueldo(resultado.getDouble(15));
            empleado.setCargo(cargo);
            
            usuario = new Usuario();
            usuario.setCodigo(resultado.getInt(16));
            usuario.setUsuario(resultado.getString(17));
            usuario.setPassword(resultado.getString(18));
            usuario.setEmpleado(empleado);
        }
        return usuario;
    }

    @Override
    public ArrayList<Usuario> buscarPorApellido(String apellido) throws Exception {
        if(apellido == null){
            apellido = "";
        }
        Empleado empleado;
        Cargo cargo;
        Usuario usuario;
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        String consulta = "select c.codigocargo,c.nombrecargo,c.descripcioncargo,e.codigoempleado,e.nombreempleado,e.apellidoempleado,e.dniempleado,e.direccionempleado,e.telefonoempleado,e.celularempleado,e.correoempleado,e.activoempleado,e.fechainicioempleado,e.fechafinempleado,e.sueldoempleado,u.codigousuario,u.usuariousuario,u.passwordusuario from empleado e inner join cargo c on e.codigocargo=c.codigocargo inner join usuario u on e.codigoempleado=u.codigoempleado where e.apellidoempleado like '%"+apellido+"%'";       
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            cargo = new Cargo();
            cargo.setCodigo(resultado.getInt(1));
            cargo.setNombre(resultado.getString(2));
            cargo.setDescripcion(resultado.getString(3));
            
            empleado = new Empleado();
            empleado.setCodigo(resultado.getInt(4));
            empleado.setNombre(resultado.getString(5));
            empleado.setApellido(resultado.getString(6));
            empleado.setDni(resultado.getString(7));
            empleado.setDireccion(resultado.getString(8));
            empleado.setTelefono(resultado.getString(9));
            empleado.setCelular(resultado.getString(10));
            empleado.setCorreo(resultado.getString(11));
            empleado.setActivo(resultado.getBoolean(12));
            empleado.setFechainicio(resultado.getDate(13));
            empleado.setFechafin(resultado.getDate(14));
            empleado.setSueldo(resultado.getDouble(15));
            empleado.setCargo(cargo);
            
            usuario = new Usuario();
            usuario.setCodigo(resultado.getInt(16));
            usuario.setUsuario(resultado.getString(17));
            usuario.setPassword(resultado.getString(18));
            usuario.setEmpleado(empleado);
                    
            listaUsuario.add(usuario);
        }
        return listaUsuario;
    }

    @Override
    public Usuario IngresoUsuario(String user, String tipo, String password) throws Exception {
        Empleado empleado;
        Cargo cargo;
        Usuario usuario = null;
        String consulta = "select c.codigocargo,c.nombrecargo,c.descripcioncargo,e.codigoempleado,e.nombreempleado,e.apellidoempleado,e.dniempleado,e.direccionempleado,e.telefonoempleado,e.celularempleado,e.correoempleado,e.activoempleado,e.fechainicioempleado,e.fechafinempleado,e.sueldoempleado,u.codigousuario,u.usuariousuario,u.passwordusuario from empleado e inner join cargo c on e.codigocargo=c.codigocargo inner join usuario u on e.codigoempleado=u.codigoempleado where u.usuariousuario='"+user+"' and c.nombrecargo='"+tipo+"' and u.passwordusuario='"+password+"'";        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            cargo = new Cargo();
            cargo.setCodigo(resultado.getInt(1));
            cargo.setNombre(resultado.getString(2));
            cargo.setDescripcion(resultado.getString(3));
            
            empleado = new Empleado();
            empleado.setCodigo(resultado.getInt(4));
            empleado.setNombre(resultado.getString(5));
            empleado.setApellido(resultado.getString(6));
            empleado.setDni(resultado.getString(7));
            empleado.setDireccion(resultado.getString(8));
            empleado.setTelefono(resultado.getString(9));
            empleado.setCelular(resultado.getString(10));
            empleado.setCorreo(resultado.getString(11));
            empleado.setActivo(resultado.getBoolean(12));
            empleado.setFechainicio(resultado.getDate(13));
            empleado.setFechafin(resultado.getDate(14));
            empleado.setSueldo(resultado.getDouble(15));
            empleado.setCargo(cargo);
            
            usuario = new Usuario();
            usuario.setCodigo(resultado.getInt(16));
            usuario.setUsuario(resultado.getString(17));
            usuario.setPassword(resultado.getString(18));
            usuario.setEmpleado(empleado);
        }        
        return usuario;
    }
    
}
