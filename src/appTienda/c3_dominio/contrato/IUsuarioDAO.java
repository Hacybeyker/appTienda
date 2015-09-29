/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.contrato;

import appTienda.c3_dominio.entidad.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public interface IUsuarioDAO {
    public int crear(Usuario usuario)throws Exception;
    public int modificar(Usuario usuario)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Usuario buscar(int codigo)throws Exception;
    public ArrayList<Usuario> buscarPorApellido(String apellido)throws Exception; 
    public Usuario IngresoUsuario(String usuario,String cargo, String password)throws Exception;
}
