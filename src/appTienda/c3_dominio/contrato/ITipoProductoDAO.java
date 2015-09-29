/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.contrato;

import appTienda.c3_dominio.entidad.TipoProducto;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public interface ITipoProductoDAO {
    public int crear(TipoProducto tipoProducto)throws Exception;
    public int modificar(TipoProducto tipoProducto)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public TipoProducto buscar(int codigo)throws Exception;
    public ArrayList<TipoProducto> buscarPorNombre(String nombre)throws Exception;    
}
