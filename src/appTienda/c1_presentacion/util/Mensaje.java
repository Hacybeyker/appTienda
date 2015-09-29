/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c1_presentacion.util;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class Mensaje {
        
    private static final String MENSAJE_ARRIBA = "Software Tienda";
    
    private static final String MENSAJE_SALIRSINGUARDAR = "Desea cancelar la operación? \n Se perderan los datos sin guardar!";
    private static final String MENSAJE_LLENARCAMPOSOBLIGATORIOS = "Llenar los campos obligatorios!";
    private static final String MENSAJE_LLENARCAMPOBUSCAR = "Ingresar un nombre para buscar!";
    private static final String MENSAJE_GUARDADOEXITOSO = "Datos registrados exitosamente";
    private static final String MENSAJE_GUARDADOERRONEO = "Datos NO registrados";
    private static final String MENSAJE_MODIFICADOEXITOSO = "Datos modificados exitosamente";
    private static final String MENSAJE_MODIFICADOERRONEO = "Datos NO modificados";
    private static final String MENSAJE_PREGUNTADEELIMINACION = "¿Está seguro de eliminar?";
    private static final String MENSAJE_ELIMINACIONEXITOSA = "Dato eliminado correctamente";
    private static final String MENSAJE_ELIMINACIONERRONEA = "Dato no eliminado";
    private static final String MENSAJE_NOSEENCONTRONINGUNRESULTADO = "No se encontro ningun resultado";
    private static final String MENSAJE_FILANOSELECCIONADO = "No se selecciono ninguna fila";
    private static final String MENSAJE_FILANOEXISTE = "La fila seleccionada ya no existe.";
    
    private static final String MENSAJE_INGRESARCANTIDAD = "Ingrese la cantidad de productos a comprar";
    
    //PARA VERIFICAR QUE EL STOCK INGRESADO SEA MAYOR A 0
    private static final String MENSAJE_VERIFICARSTOCKINGRESADO = "Usuario Inconrrecto le quedan : ";
    //INTENTOS EN EL LOGIN
    private static final String MENSAJE_AVISOINTENTOS = "Usuario Inconrrecto le quedan : ";
    //REGISTRAR PEDIDO
    private static final String MENSAJE_REGISTRARSINPRODUCTOS = "No existen Productos, para poder realizar el pepido";
    
    //INTERNET
    private static final String MENSAJE_INTERNETMAL = "Verificar Conexion a Internet";
    //CALCULADORA
    private static final String MENSAJE_CALCULADORAMAL = "Error al ejecutar la calculadora";
    //TECLADO
    private static final String MENSAJE_TECLADORAMAL = "Error al ejecutar el Teclado";
    //BACKUP
    private static final String MENSAJE_PREGUNTAHACERBACKUP = "¿Desea realizar un Copia de Seguridad?";
    private static final String MENSAJE_BACKUPEXITOSO = "Backup exitoso";
    
    public static boolean Mostrar_MENSAJE_SALIRSINGUARDAR(JDialog jDialog){
        int respuesta = JOptionPane.showConfirmDialog(jDialog,MENSAJE_SALIRSINGUARDAR,MENSAJE_ARRIBA,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        return ( respuesta == JOptionPane.YES_OPTION );
    }
    
    public static void Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_LLENARCAMPOSOBLIGATORIOS,MENSAJE_ARRIBA,JOptionPane.WARNING_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_LLENARCAMPOBUSCAR(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_LLENARCAMPOBUSCAR,MENSAJE_ARRIBA,JOptionPane.WARNING_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_GUARDADOEXITOSO(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_GUARDADOEXITOSO,MENSAJE_ARRIBA,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_GUARDADOERRONEO(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_GUARDADOERRONEO,MENSAJE_ARRIBA,JOptionPane.WARNING_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_MODIFICADOEXITOSO(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_MODIFICADOEXITOSO,MENSAJE_ARRIBA,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean Mostrar_MENSAJE_PREGUNTADEELIMINACION(JDialog jDialog){
        int respuesta = JOptionPane.showConfirmDialog(jDialog,MENSAJE_PREGUNTADEELIMINACION,MENSAJE_ARRIBA,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        return ( respuesta == JOptionPane.YES_OPTION );
    }
    
    public static void Mostrar_MENSAJE_ELIMINACIONEXITOSA(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_ELIMINACIONEXITOSA,MENSAJE_ARRIBA,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_ELIMINACIONERRONEA(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_ELIMINACIONERRONEA,MENSAJE_ARRIBA,JOptionPane.WARNING_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_NOSEENCONTRONINGUNRESULTADO,MENSAJE_ARRIBA,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_FILANOSELECCIONADO(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_FILANOSELECCIONADO,MENSAJE_ARRIBA,JOptionPane.WARNING_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_FILANOEXISTE(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_FILANOEXISTE,MENSAJE_ARRIBA,JOptionPane.WARNING_MESSAGE);
    }
    
    public static int Mostrar_MENSAJE_INGRESARCANTIDAD(JDialog jDialog){
        String cantidad = JOptionPane.showInputDialog(jDialog,MENSAJE_INGRESARCANTIDAD,MENSAJE_ARRIBA,JOptionPane.INFORMATION_MESSAGE);
        return Integer.parseInt(cantidad);
    }
    
    public static void Mostrar_MENSAJE_INTERNETMAL(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_INTERNETMAL,MENSAJE_ARRIBA,JOptionPane.ERROR_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_REGISTRARSINPRODUCTOS(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_REGISTRARSINPRODUCTOS,MENSAJE_ARRIBA,JOptionPane.ERROR_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_VERIFICARSTOCKINGRESADO(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_VERIFICARSTOCKINGRESADO,MENSAJE_ARRIBA,JOptionPane.ERROR_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_AVISOINTENTOS(JFrame jframe,int intentos){
        JOptionPane.showMessageDialog(jframe, MENSAJE_AVISOINTENTOS+(3-intentos)+" intentos",MENSAJE_ARRIBA,JOptionPane.ERROR_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_CALCULADORAMAL(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_CALCULADORAMAL,MENSAJE_ARRIBA,JOptionPane.ERROR_MESSAGE);
    }
    
    public static void Mostrar_MENSAJE_TECLADORAMAL(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_TECLADORAMAL,MENSAJE_ARRIBA,JOptionPane.ERROR_MESSAGE);
    }   
    
    public static boolean Mostrar_MENSAJE_PREGUNTAHACERBACKUP(JDialog jDialog){
        int respuesta = JOptionPane.showConfirmDialog(jDialog,MENSAJE_PREGUNTAHACERBACKUP,MENSAJE_ARRIBA,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        return ( respuesta == JOptionPane.YES_OPTION );
    }
    
    public static void Mostrar_MENSAJE_BACKUPEXITOSO(JDialog jDialog){
        JOptionPane.showMessageDialog(jDialog, MENSAJE_BACKUPEXITOSO,MENSAJE_ARRIBA,JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Muestra un mensaje de error
     * @param dialogo
     * @param mensaje es el mensaje que se desea mostrar
     */
    public static void mostrarErrorExcepcion(JDialog dialogo, String mensaje){
        JOptionPane.showMessageDialog(dialogo, mensaje,MENSAJE_ARRIBA,JOptionPane.ERROR_MESSAGE);
    }
}
