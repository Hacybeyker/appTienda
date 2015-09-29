/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.entidad;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class Cliente extends Persona{

    public Cliente() {
    }

    public Cliente(int codigo, String nombre, String apellido, String dni, String direccion, String telefono, String celular, String correo, boolean activo) {
        super(codigo, nombre, apellido, dni, direccion, telefono, celular, correo, activo);
    }

    public Cliente(String nombre, String apellido, String dni, String direccion, String telefono, String celular, String correo) {
        super(nombre, apellido, dni, direccion, telefono, celular, correo);
    }
    
    
}
