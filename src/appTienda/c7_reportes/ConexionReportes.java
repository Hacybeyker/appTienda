/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c7_reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class ConexionReportes {
    public static Connection Conexion(){
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/tienda";
            conexion = DriverManager.getConnection(url, "postgres", "123");             
        }catch(ClassNotFoundException | SQLException ex){}
        return conexion;
    }
}
