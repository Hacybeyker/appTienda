/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.contrato;

import appTienda.c3_dominio.entidad.Empleado;
import java.util.ArrayList;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public interface IEmpleadoDAO {
    public int crear(Empleado empleado)throws Exception;
    public int modificar(Empleado empleado)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Empleado buscar(int codigo)throws Exception;
    public Empleado buscarPorDni(String dni)throws Exception;
    public ArrayList<Empleado> buscarPorApellido(String apellido)throws Exception;
}
