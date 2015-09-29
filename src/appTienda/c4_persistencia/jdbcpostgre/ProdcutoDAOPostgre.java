/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.IProductoDAO;
import appTienda.c3_dominio.entidad.Marca;
import appTienda.c3_dominio.entidad.Producto;
import appTienda.c3_dominio.entidad.TipoProducto;
import appTienda.c3_dominio.entidad.UnidadDeMedida;
import appTienda.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class ProdcutoDAOPostgre implements IProductoDAO{

    GestorJDBC gestorJDBC;

    public ProdcutoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
        
    @Override
    public int crear(Producto producto) throws Exception {
        String consulta = "insert into producto (codigotipoproducto,codigounidaddemedida,codigomarca,nombreproducto,descripcionproducto,stockproducto,precioproducto) values(?,?,?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, producto.getTipoProducto().getCodigo());
        sentencia.setInt(2, producto.getUnidadDeMedida().getCodigo());
        sentencia.setInt(3, producto.getMarca().getCodigo());
        sentencia.setString(4, producto.getNombre());
        sentencia.setString(5, producto.getDescripcion());
        sentencia.setInt(6, producto.getStock());
        sentencia.setDouble(7, producto.getPrecio());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Producto producto) throws Exception {
        String consulta = "update producto set codigotipoproducto=?,codigounidaddemedida=?,codigomarca=?,nombreproducto=?,descripcionproducto=?,stockproducto=?,precioproducto=? where codigoproducto=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, producto.getTipoProducto().getCodigo());
        sentencia.setInt(2, producto.getUnidadDeMedida().getCodigo());
        sentencia.setInt(3, producto.getMarca().getCodigo());
        sentencia.setString(4, producto.getNombre());
        sentencia.setString(5, producto.getDescripcion());
        sentencia.setInt(6, producto.getStock());
        sentencia.setDouble(7, producto.getPrecio());
        sentencia.setInt(8, producto.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from producto where codigoproducto="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Producto buscar(int codigo) throws Exception {       
        Producto producto = null;
        TipoProducto tipoProducto;
        UnidadDeMedida unidadDeMedida;
        Marca marca;
        String consulta = "select tp.codigotipoproducto, tp.nombretipoproducto, tp.descripciontipoproducto, um.codigounidaddemedida,um.nombreunidaddemedida,um.descripcionunidaddemedida,m.codigomarca,m.nombremarca,m.descripcionmarca,p.codigoproducto, p.nombreproducto, p.descripcionproducto, p.stockproducto, p.precioproducto from producto p inner join tipoproducto tp on p.codigotipoproducto=tp.codigotipoproducto inner join unidaddemedida um on p.codigounidaddemedida=um.codigounidaddemedida inner join marca m on p.codigomarca=m.codigomarca where codigoproducto="+codigo;        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            producto = new Producto();
            tipoProducto = new TipoProducto();
            unidadDeMedida = new UnidadDeMedida();
            marca = new Marca();
            
            tipoProducto.setCodigo(resultado.getInt(1));
            tipoProducto.setNombre(resultado.getString(2));
            tipoProducto.setDescripcion(resultado.getString(3));
            
            unidadDeMedida.setCodigo(resultado.getInt(4));
            unidadDeMedida.setNombre(resultado.getString(5));
            unidadDeMedida.setDescripcion(resultado.getString(6));
            
            marca.setCodigo(resultado.getInt(7));
            marca.setNombre(resultado.getString(8));
            marca.setDescripcion(resultado.getString(9));
            
            producto.setCodigo(resultado.getInt(10));
            producto.setTipoProducto(tipoProducto);
            producto.setUnidadDeMedida(unidadDeMedida);
            producto.setMarca(marca);
            producto.setNombre(resultado.getString(11));
            producto.setDescripcion(resultado.getString(12));
            producto.setStock(resultado.getInt(13));
            producto.setPrecio(resultado.getDouble(14));
        }
        return producto;
    }

    @Override
    public ArrayList<Producto> buscarPorNombre(String nombre) throws Exception {
        if(nombre == null){
            nombre = "";
        }
        Producto producto;
        TipoProducto tipoProducto;
        UnidadDeMedida unidadDeMedida;
        Marca marca;
        ArrayList<Producto> listaProducto = new ArrayList<>();
        String consulta = "select tp.codigotipoproducto, tp.nombretipoproducto, tp.descripciontipoproducto, um.codigounidaddemedida,um.nombreunidaddemedida,um.descripcionunidaddemedida,m.codigomarca,m.nombremarca,m.descripcionmarca,p.codigoproducto, p.nombreproducto, p.descripcionproducto, p.stockproducto, p.precioproducto from producto p inner join tipoproducto tp on p.codigotipoproducto=tp.codigotipoproducto inner join unidaddemedida um on p.codigounidaddemedida=um.codigounidaddemedida inner join marca m on p.codigomarca=m.codigomarca where nombreproducto like '%"+nombre+"%'";        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            producto = new Producto();
            tipoProducto = new TipoProducto();
            unidadDeMedida = new UnidadDeMedida();
            marca = new Marca();
            
            tipoProducto.setCodigo(resultado.getInt(1));
            tipoProducto.setNombre(resultado.getString(2));
            tipoProducto.setDescripcion(resultado.getString(3));
            
            unidadDeMedida.setCodigo(resultado.getInt(4));
            unidadDeMedida.setNombre(resultado.getString(5));
            unidadDeMedida.setDescripcion(resultado.getString(6));
            
            marca.setCodigo(resultado.getInt(7));
            marca.setNombre(resultado.getString(8));
            marca.setDescripcion(resultado.getString(9));
            
            producto.setCodigo(resultado.getInt(10));
            producto.setTipoProducto(tipoProducto);
            producto.setUnidadDeMedida(unidadDeMedida);
            producto.setMarca(marca);
            producto.setNombre(resultado.getString(11));
            producto.setDescripcion(resultado.getString(12));
            producto.setStock(resultado.getInt(13));
            producto.setPrecio(resultado.getDouble(14));
            
            listaProducto.add(producto);
        }
        return listaProducto;
    }
    
}
