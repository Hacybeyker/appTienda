/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.contrato;

import appTienda.c3_dominio.entidad.Producto;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public interface IProductoDAO {
    public int crear(Producto producto)throws Exception;
    public int modificar(Producto producto)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Producto buscar(int codigo)throws Exception;
    public ArrayList<Producto> buscarPorNombre(String nombre)throws Exception;
}
