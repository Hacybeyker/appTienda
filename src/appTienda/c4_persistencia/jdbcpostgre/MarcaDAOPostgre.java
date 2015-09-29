/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.IMarcaDAO;
import appTienda.c3_dominio.entidad.Marca;
import appTienda.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class MarcaDAOPostgre implements IMarcaDAO{
    GestorJDBC gestorJDBC;

    public MarcaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int crear(Marca marca) throws Exception {
        String consulta = "insert into marca (nombremarca,descripcionmarca) values(?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, marca.getNombre());
        sentencia.setString(2, marca.getDescripcion());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Marca marca) throws Exception {
        String consulta = "update marca set nombremarca=?,descripcionmarca=? where codigomarca=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, marca.getNombre());
        sentencia.setString(2, marca.getDescripcion());
        sentencia.setInt(3, marca.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from marca where codigomarca="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Marca buscar(int codigo) throws Exception {
        Marca marca = null;
        String consulta = "select codigomarca,nombremarca,descripcionmarca from marca where codigomarca="+codigo;        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            marca = new Marca();
            marca.setCodigo(resultado.getInt(1));
            marca.setNombre(resultado.getString(2));
            marca.setDescripcion(resultado.getString(3));
        }
        return marca;
    }

    @Override
    public ArrayList<Marca> buscarPorNombre(String nombre) throws Exception {
        if(nombre == null){
            nombre = "";
        }
        Marca marca;
        ArrayList<Marca> listaMarca = new ArrayList<>();
        String consulta = "select codigomarca,nombremarca,descripcionmarca from marca where nombremarca like '%"+nombre+"%' order by codigomarca desc";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            marca = new Marca();
            marca.setCodigo(resultado.getInt(1));
            marca.setNombre(resultado.getString(2));
            marca.setDescripcion(resultado.getString(3));
            listaMarca.add(marca);
        }
        return listaMarca;
    }
    
}
