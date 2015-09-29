/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.entidad;

import java.sql.Date;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class Empleado extends Persona{
    //private int horastrabajadas;
    private Date fechainicio;
    private Date fechafin;
    private double sueldo;
    Cargo cargo;

    public Empleado() {
    }

    public Empleado(Date fechainicio, Date fechafin, double sueldo, Cargo cargo, String nombre, String apellido, String dni, String direccion, String telefono, String celular, String correo) {
        super(nombre, apellido, dni, direccion, telefono, celular, correo);
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public Empleado(Date fechainicio, Date fechafin, Cargo cargo, String nombre, String apellido, String dni, String direccion, String telefono, String celular, String correo) {
        super(nombre, apellido, dni, direccion, telefono, celular, correo);
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.cargo = cargo;
        this.sueldo = 1000.0;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
