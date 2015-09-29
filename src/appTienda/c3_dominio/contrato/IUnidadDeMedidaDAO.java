/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.contrato;

import appTienda.c3_dominio.entidad.UnidadDeMedida;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public interface IUnidadDeMedidaDAO {
    public int crear(UnidadDeMedida unidadDeMedida)throws Exception;
    public int modificar(UnidadDeMedida unidadDeMedida)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public UnidadDeMedida buscar(int codigo)throws Exception;
    public ArrayList<UnidadDeMedida> buscarPorNombre(String nombre)throws Exception;    
}
