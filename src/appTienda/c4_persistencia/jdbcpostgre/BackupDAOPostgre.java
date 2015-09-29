/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c4_persistencia.jdbcpostgre;

import appTienda.c3_dominio.contrato.IBackup;
import appTienda.c3_dominio.entidad.Backup;
import appTienda.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class BackupDAOPostgre implements IBackup{

    GestorJDBC gestorJDBC;

    public BackupDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public int modificar(Backup backup) throws Exception {
        String consulta = "update backup set hostbackup=?,puertobackup=?,usuariobackup=?,clavebackup=?,bdbackup=?,formatobackup=?,rutabackup=?,rutapostgres=? where codigobackup=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, backup.getHost());
        sentencia.setString(2, backup.getPuerto());
        sentencia.setString(3, backup.getUsuario());
        sentencia.setString(4, backup.getClave());
        sentencia.setString(5, backup.getBd());
        sentencia.setString(6, backup.getFormato());
        sentencia.setString(7, backup.getRuta());
        sentencia.setString(8, backup.getRutapostgres());
        sentencia.setInt(9 , backup.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public Backup buscar() throws Exception {
        Backup backup = null;
        String consulta = "select codigobackup,hostbackup,puertobackup,usuariobackup,clavebackup,bdbackup,formatobackup,rutabackup,rutapostgres from backup";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            backup = new Backup();
            backup.setCodigo(resultado.getInt(1));
            backup.setHost(resultado.getString(2));
            backup.setPuerto(resultado.getString(3));
            backup.setUsuario(resultado.getString(4));
            backup.setClave(resultado.getString(5));
            backup.setBd(resultado.getString(6));
            backup.setFormato(resultado.getString(7));
            backup.setRuta(resultado.getString(8));
            backup.setRutapostgres(resultado.getString(9));
        }
        return backup;
    }
    
}
