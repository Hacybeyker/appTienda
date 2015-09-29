/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.ITipoProductoDAO;
import appTienda.c3_dominio.entidad.TipoProducto;
import appTienda.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class TipoProductoDAOPostgre implements ITipoProductoDAO{
    GestorJDBC gestorJDBC;

    public TipoProductoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int crear(TipoProducto tipoProducto) throws Exception {
        String consulta = "insert into tipoproducto (nombretipoproducto,descripciontipoproducto) values(?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, tipoProducto.getNombre());
        sentencia.setString(2, tipoProducto.getDescripcion());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(TipoProducto tipoProducto) throws Exception {
        String consulta = "update tipoproducto set nombretipoproducto=?,descripciontipoproducto=? where codigotipoproducto=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, tipoProducto.getNombre());
        sentencia.setString(2, tipoProducto.getDescripcion());
        sentencia.setInt(3, tipoProducto.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from tipoproducto where codigotipoproducto="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public TipoProducto buscar(int codigo) throws Exception {
        TipoProducto tipoProducto = null;
        String consulta = "select codigotipoproducto,nombretipoproducto,descripciontipoproducto from tipoproducto where codigotipoproducto="+codigo;        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            tipoProducto = new TipoProducto();
            tipoProducto.setCodigo(resultado.getInt(1));
            tipoProducto.setNombre(resultado.getString(2));
            tipoProducto.setDescripcion(resultado.getString(3));
        }
        return tipoProducto;
    }

    @Override
    public ArrayList<TipoProducto> buscarPorNombre(String nombre) throws Exception {
        if(nombre == null){
            nombre = "";
        }
        TipoProducto tipoProducto;
        ArrayList<TipoProducto> listaTipoProducto = new ArrayList<>();
        String consulta = "select codigotipoproducto,nombretipoproducto,descripciontipoproducto from tipoproducto where nombretipoproducto like '%"+nombre+"%' order by codigotipoproducto desc";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            tipoProducto = new TipoProducto();
            tipoProducto.setCodigo(resultado.getInt(1));
            tipoProducto.setNombre(resultado.getString(2));
            tipoProducto.setDescripcion(resultado.getString(3));
            listaTipoProducto.add(tipoProducto);
        }
        return listaTipoProducto;
    }
    
}
