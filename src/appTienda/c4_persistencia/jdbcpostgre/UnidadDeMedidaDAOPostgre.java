/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.IUnidadDeMedidaDAO;
import appTienda.c3_dominio.entidad.UnidadDeMedida;
import appTienda.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class UnidadDeMedidaDAOPostgre implements IUnidadDeMedidaDAO{
    GestorJDBC gestorJDBC;

    public UnidadDeMedidaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int crear(UnidadDeMedida unidadDeMedida) throws Exception {
        String consulta = "insert into unidaddemedida (nombreunidaddemedida,descripcionunidaddemedida) values(?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, unidadDeMedida.getNombre());
        sentencia.setString(2, unidadDeMedida.getDescripcion());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(UnidadDeMedida unidadDeMedida) throws Exception {
        String consulta = "update unidaddemedida set nombreunidaddemedida=?,descripcionunidaddemedida=? where codigounidaddemedida=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, unidadDeMedida.getNombre());
        sentencia.setString(2, unidadDeMedida.getDescripcion());
        sentencia.setInt(3, unidadDeMedida.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from unidaddemedida where codigounidaddemedida="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public UnidadDeMedida buscar(int codigo) throws Exception {
        UnidadDeMedida unidadDeMedida = null;
        String consulta = "select codigounidaddemedida,nombreunidaddemedida,descripcionunidaddemedida from unidaddemedida where codigounidaddemedida="+codigo;        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            unidadDeMedida = new UnidadDeMedida();
            unidadDeMedida.setCodigo(resultado.getInt(1));
            unidadDeMedida.setNombre(resultado.getString(2));
            unidadDeMedida.setDescripcion(resultado.getString(3));
        }
        return unidadDeMedida;
    }

    @Override
    public ArrayList<UnidadDeMedida> buscarPorNombre(String nombre) throws Exception {
        if(nombre == null){
            nombre = "";
        }
        UnidadDeMedida unidadDeMedida;
        ArrayList<UnidadDeMedida> listaUnidadDeMedida = new ArrayList<>();
        String consulta = "select codigounidaddemedida,nombreunidaddemedida,descripcionunidaddemedida from unidaddemedida where nombreunidaddemedida like '%"+nombre+"%' order by codigounidaddemedida desc";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            unidadDeMedida = new UnidadDeMedida();
            unidadDeMedida.setCodigo(resultado.getInt(1));
            unidadDeMedida.setNombre(resultado.getString(2));
            unidadDeMedida.setDescripcion(resultado.getString(3));
            listaUnidadDeMedida.add(unidadDeMedida);
        }
        return listaUnidadDeMedida;
    }
    
}
