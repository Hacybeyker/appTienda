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
public class Usuario {
    private int codigo;
    private String usuario;
    private String password;
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String usuario, String password, Empleado empleado) {
        this.usuario = usuario;
        this.password = password;
        this.empleado = empleado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    
    public boolean verificarEmpleadoActivo(){
        return empleado.isActivo();
    }
    
    public boolean verificarCargoEmpleado(String cargo){
        return empleado.getCargo().getNombre().equals(cargo);
    }
    
}
