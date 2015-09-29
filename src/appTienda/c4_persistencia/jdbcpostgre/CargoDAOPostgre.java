/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.ICargoDAO;
import appTienda.c3_dominio.entidad.Cargo;
import appTienda.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class CargoDAOPostgre implements ICargoDAO{

    GestorJDBC gestorJDBC;

    public CargoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public int crear(Cargo cargo) throws Exception {
        String consulta = "insert into cargo (nombrecargo,descripcioncargo) values(?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, cargo.getNombre());
        sentencia.setString(2, cargo.getDescripcion());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Cargo cargo) throws Exception {
        String consulta = "update cargo set nombrecargo=?,descripcioncargo=? where codigocargo=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, cargo.getNombre());
        sentencia.setString(2, cargo.getDescripcion());
        sentencia.setInt(3, cargo.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from cargo where codigocargo="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Cargo buscar(int codigo) throws Exception {
        Cargo cargo = null;
        String consulta = "select codigocargo,nombrecargo,descripcioncargo from cargo where codigocargo="+codigo;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            cargo = new Cargo();
            cargo.setCodigo(resultado.getInt(1));
            cargo.setNombre(resultado.getString(2));
            cargo.setDescripcion(resultado.getString(3));
        }
        return cargo;
    }

    @Override
    public ArrayList<Cargo> buscarPorNombre(String nombre) throws Exception {
        if(nombre == null){
            nombre = "";
        }
        Cargo cargo;
        ArrayList<Cargo> listaCargo = new ArrayList<>();
        String consulta = "select codigocargo,nombrecargo,descripcioncargo from cargo where nombrecargo like '%"+nombre+"%'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            cargo = new Cargo();
            cargo.setCodigo(resultado.getInt(1));
            cargo.setNombre(resultado.getString(2));
            cargo.setDescripcion(resultado.getString(3));
            listaCargo.add(cargo);
        }
        return listaCargo;
    }
    
}
