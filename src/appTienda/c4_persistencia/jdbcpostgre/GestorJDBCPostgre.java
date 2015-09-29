/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c4_persistencia.GestorJDBC;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class GestorJDBCPostgre extends GestorJDBC{

    @Override
    public void abrirConexion() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) { }
        String url = "jdbc:postgresql://localhost:5432/tienda";
        conexion = DriverManager.getConnection(url, "postgres", "123"); 
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        } catch (ClassNotFoundException ex) { }
//        String url = "jdbc:sqlserver://Hacybeyker:1433;databaseName=tienda";
//        conexion = DriverManager.getConnection(url, "sa", "123");
    }
    
}
