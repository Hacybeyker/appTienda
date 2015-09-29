/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c2_aplicacion.servicio;

import appTienda.c3_dominio.contrato.IBackup;
import appTienda.c3_dominio.entidad.Backup;
import appTienda.c4_persistencia.GestorJDBC;
import appTienda.c4_persistencia.jdbcpostgre.BackupDAOPostgre;
import appTienda.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class GestionarBackupServicio{

    GestorJDBC gestorJDBC;
    IBackup backupDAO;
    
    public GestionarBackupServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        backupDAO = new BackupDAOPostgre(gestorJDBC);
    }
    
    public int modificar(Backup backup) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = backupDAO.modificar(backup);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    
    public Backup buscar() throws Exception {
        gestorJDBC.abrirConexion();
        Backup backup = backupDAO.buscar();
        gestorJDBC.cerrarConexion();
        return backup;
    }
    
}
