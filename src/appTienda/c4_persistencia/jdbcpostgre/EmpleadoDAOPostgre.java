/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.IEmpleadoDAO;
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
public class EmpleadoDAOPostgre implements IEmpleadoDAO{
    GestorJDBC gestorJDBC;

    public EmpleadoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public int crear(Empleado empleado) throws Exception {
        String consulta = "insert into empleado (nombreempleado,apellidoempleado,dniempleado,direccionempleado,telefonoempleado,celularempleado,correoempleado,activoempleado,fechainicioempleado,fechafinempleado,sueldoempleado,codigocargo) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, empleado.getNombre());
        sentencia.setString(2, empleado.getApellido());
        sentencia.setString(3, empleado.getDni());
        sentencia.setString(4, empleado.getDireccion());
        sentencia.setString(5, empleado.getTelefono());
        sentencia.setString(6, empleado.getCelular());
        sentencia.setString(7, empleado.getCorreo());
        sentencia.setBoolean(8, empleado.isActivo());
        sentencia.setDate(9, empleado.getFechainicio());
        sentencia.setDate(10, empleado.getFechafin());
        sentencia.setDouble(11, empleado.getSueldo());
        sentencia.setInt(12, empleado.getCargo().getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Empleado empleado) throws Exception {
        String consulta = "update empleado set nombreempleado=?,apellidoempleado=?,dniempleado=?,direccionempleado=?,telefonoempleado=?,celularempleado=?,correoempleado=?,activoempleado=?,fechainicioempleado=?,fechafinempleado=?,sueldoempleado=?,codigocargo=? where codigoempleado=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, empleado.getNombre());
        sentencia.setString(2, empleado.getApellido());
        sentencia.setString(3, empleado.getDni());
        sentencia.setString(4, empleado.getDireccion());
        sentencia.setString(5, empleado.getTelefono());
        sentencia.setString(6, empleado.getCelular());
        sentencia.setString(7, empleado.getCorreo());
        sentencia.setBoolean(8, empleado.isActivo());
        sentencia.setDate(9, empleado.getFechainicio());
        sentencia.setDate(10, empleado.getFechafin());
        sentencia.setDouble(11, empleado.getSueldo());
        sentencia.setInt(12, empleado.getCargo().getCodigo());
        sentencia.setInt(13, empleado.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from empleado where codigo="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Empleado buscar(int codigo) throws Exception {
        Empleado empleado = null;
        Cargo cargo;
        String consulta = "select c.codigocargo,c.nombrecargo,c.descripcioncargo,e.codigoempleado,e.nombreempleado,e.apellidoempleado,e.dniempleado,e.direccionempleado,e.telefonoempleado,e.celularempleado,e.correoempleado,e.activoempleado,e.fechainicioempleado,e.fechafinempleado,e.sueldoempleado from empleado e inner join cargo c on e.codigocargo=c.codigocargo where e.codigoempleado="+codigo;
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
        }
        return empleado;
    }

    @Override
    public ArrayList<Empleado> buscarPorApellido(String apellido) throws Exception {
        if(apellido == null){
            apellido = "";
        }
        Empleado empleado;
        Cargo cargo;
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();
        String consulta = "select c.codigocargo,c.nombrecargo,c.descripcioncargo,e.codigoempleado,e.nombreempleado,e.apellidoempleado,e.dniempleado,e.direccionempleado,e.telefonoempleado,e.celularempleado,e.correoempleado,e.activoempleado,e.fechainicioempleado,e.fechafinempleado,e.sueldoempleado from empleado e inner join cargo c on e.codigocargo=c.codigocargo where e.apellidoempleado like '%"+apellido+"%'";       
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
                    
            listaEmpleado.add(empleado);
        }
        return listaEmpleado;
    }

    @Override
    public Empleado buscarPorDni(String dni) throws Exception {
        Empleado empleado = null;
        Cargo cargo;
        String consulta = "select c.codigocargo,c.nombrecargo,c.descripcioncargo,e.codigoempleado,e.nombreempleado,e.apellidoempleado,e.dniempleado,e.direccionempleado,e.telefonoempleado,e.celularempleado,e.correoempleado,e.activoempleado,e.fechainicioempleado,e.fechafinempleado,e.sueldoempleado from empleado e inner join cargo c on e.codigocargo=c.codigocargo where e.dniempleado='"+dni+"'";
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
        }
        return empleado;
    }
    
}
