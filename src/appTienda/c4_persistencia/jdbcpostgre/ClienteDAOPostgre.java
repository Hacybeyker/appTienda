/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.IClienteDAO;
import appTienda.c3_dominio.entidad.Cliente;
import appTienda.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class ClienteDAOPostgre implements IClienteDAO{

    GestorJDBC gestorJDBC;

    public ClienteDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }    
    
    @Override
    public int crear(Cliente cliente) throws Exception {
        String consulta = "insert into cliente (nombrecliente,apellidocliente,dnicliente,direccioncliente,telefonocliente,celularcliente,correocliente,activocliente) values(?,?,?,?,?,?,?,?)";        
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, cliente.getNombre());
        sentencia.setString(2, cliente.getApellido());
        sentencia.setString(3, cliente.getDni());
        sentencia.setString(4, cliente.getDireccion());
        sentencia.setString(5, cliente.getTelefono());
        sentencia.setString(6, cliente.getCelular());
        sentencia.setString(7, cliente.getCorreo());
        sentencia.setBoolean(8, cliente.isActivo());
        System.out.println(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Cliente cliente) throws Exception {
        String consulta = "update cliente set nombrecliente=?,apellidocliente=?,dnicliente=?,direccioncliente=?,telefonocliente=?,celularcliente=?,correocliente=?,activocliente=? where codigocliente=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, cliente.getNombre());
        sentencia.setString(2, cliente.getApellido());
        sentencia.setString(3, cliente.getDni());
        sentencia.setString(4, cliente.getDireccion());
        sentencia.setString(5, cliente.getTelefono());
        sentencia.setString(6, cliente.getCelular());
        sentencia.setString(7, cliente.getCorreo());
        sentencia.setBoolean(8, cliente.isActivo());
        sentencia.setInt(9, cliente.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from cliente where codigocliente="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Cliente buscar(int codigo) throws Exception {
        Cliente cliente = null;
        String consulta = "select codigocliente,nombrecliente,apellidocliente,dnicliente,direccioncliente,telefonocliente,celularcliente,correocliente,activocliente from cliente where codigocliente="+codigo;        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            cliente = new Cliente();
            cliente.setCodigo(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setDni(resultado.getString(4));
            cliente.setDireccion(resultado.getString(5));
            cliente.setTelefono(resultado.getString(6));
            cliente.setCelular(resultado.getString(7));
            cliente.setCorreo(resultado.getString(8));
            cliente.setActivo(resultado.getBoolean(9));
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> buscarPorNombre(String nombre) throws Exception {
        if(nombre == null){
            nombre = "";
        }
        Cliente cliente;
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        String consulta = "select codigocliente,nombrecliente,apellidocliente,dnicliente,direccioncliente,telefonocliente,celularcliente,correocliente,activocliente from cliente where apellidocliente like '%"+nombre+"%'";        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            cliente = new Cliente();
            cliente.setCodigo(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setDni(resultado.getString(4));
            cliente.setDireccion(resultado.getString(5));
            cliente.setTelefono(resultado.getString(6));
            cliente.setCelular(resultado.getString(7));
            cliente.setCorreo(resultado.getString(8));
            cliente.setActivo(resultado.getBoolean(9));
            listaCliente.add(cliente);
        }
        return listaCliente;
    }

    @Override
    public Cliente buscarPorDni(String dni) throws Exception {
        Cliente cliente = null;
        String consulta = "select codigocliente,nombrecliente,apellidocliente,dnicliente,direccioncliente,telefonocliente,celularcliente,correocliente,activocliente from cliente where dnicliente='"+dni+"'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            cliente = new Cliente();
            cliente.setCodigo(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setDni(resultado.getString(4));
            cliente.setDireccion(resultado.getString(5));
            cliente.setTelefono(resultado.getString(6));
            cliente.setCelular(resultado.getString(7));
            cliente.setCorreo(resultado.getString(8));
            cliente.setActivo(resultado.getBoolean(9));
        }
        return cliente;
    }
    
}
