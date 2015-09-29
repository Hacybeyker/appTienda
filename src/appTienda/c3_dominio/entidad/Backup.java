/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.entidad;

import appTienda.c2_aplicacion.servicio.GestionarBackupServicio;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class Backup {
    private int codigo;
    private String host;
    private String puerto;
    private String usuario;
    private String clave;
    private String bd;
    private String formato;
    private String ruta;
    private String rutapostgres;

    public Backup() {
    }
    
    public Backup(int codigo, String host, String puerto, String usuario, String clave, String bd, String formato, String ruta, String rutapostgres) {
        this.codigo = codigo;
        this.host = host;
        this.puerto = puerto;
        this.usuario = usuario;
        this.clave = clave;
        this.bd = bd;
        this.formato = formato;
        this.ruta = ruta;
        this.rutapostgres = rutapostgres;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getRutapostgres() {
        return rutapostgres;
    }

    public void setRutapostgres(String rutapostgres) {
        this.rutapostgres = rutapostgres;
    }    
    
    public void realizarBackup(){
        LocalDate fecha = LocalDate.now();       
        LocalDateTime time = LocalDateTime.now();        
        int cadenaHora = time.getHour();
        int cadenaMinuto = time.getMinute();
        int cadenaSegundo = time.getSecond();
        String cadenaFecha = fecha.toString();    
        try {
            ProcessBuilder pb;
            Process p;
            String rutaCompleta = ruta+bd+"_"+cadenaFecha+"_"+cadenaHora+"-"+cadenaMinuto+"-"+cadenaSegundo+".backup";
            System.out.println(rutaCompleta);
            pb = new ProcessBuilder(rutapostgres, "--verbose", "--format", formato, "-f", rutaCompleta);           
            pb.environment().put("PGHOST", host);
            pb.environment().put("PGPORT", puerto);
            pb.environment().put("PGUSER", usuario);
            pb.environment().put("PGPASSWORD", clave);
            pb.environment().put("PGDATABASE", bd);
            pb.redirectErrorStream(true);
            p = pb.start();            
        }catch(Exception e) {
        }    
    }    
}
