/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c3_dominio.contrato;

import appTienda.c3_dominio.entidad.Backup;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public interface IBackup {
    public int modificar(Backup backup)throws Exception;
    public Backup buscar()throws Exception;
}
