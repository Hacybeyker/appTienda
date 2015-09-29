/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c1_presentacion.form;

import appTienda.c1_presentacion.util.Mensaje;
import appTienda.c2_aplicacion.servicio.GestionarUnidadDeMedidaServicio;
import appTienda.c3_dominio.entidad.UnidadDeMedida;
import javax.swing.JDialog;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class FormRegistrarUnidadDeMedida extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion = 0;
    UnidadDeMedida unidadDeMedida;
    
    /**
     * Creates new form FormRegistrarUnidadDeMedida
     * @param owner
     */
    public FormRegistrarUnidadDeMedida(JDialog owner) {
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_CREAR;
        this.unidadDeMedida = new UnidadDeMedida();
    }

    public FormRegistrarUnidadDeMedida(JDialog owner, UnidadDeMedida unidadDeMedida) {
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_MODIFICAR;
        obtenerObjetoDeGestionar(unidadDeMedida);
    }

    private void obtenerObjetoDeGestionar(UnidadDeMedida unidadDeMedida1) {
        this.unidadDeMedida = unidadDeMedida1;
        textoCodigo.setText(String.valueOf(unidadDeMedida1.getCodigo()));
        textoNombre.setText(unidadDeMedida1.getNombre());
        textoAreaDescripcion.setText(unidadDeMedida1.getDescripcion());
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textoCodigo = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoAreaDescripcion = new javax.swing.JTextArea();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Unidad de Medida");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descripción:");

        textoCodigo.setEditable(false);
        textoCodigo.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoCodigo.setEnabled(false);

        textoNombre.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        textoAreaDescripcion.setColumns(20);
        textoAreaDescripcion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoAreaDescripcion.setLineWrap(true);
        textoAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoAreaDescripcion);

        botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/guardarx32.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoNombre)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){            
            if(Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
                this.dispose();               
        }else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){            
            unidadDeMedida.setNombre(textoNombre.getText().trim().toUpperCase());
            unidadDeMedida.setDescripcion(textoAreaDescripcion.getText().trim().toUpperCase());
            GestionarUnidadDeMedidaServicio gestionarUnidadDeMedidaServicio  = new GestionarUnidadDeMedidaServicio();
            int estado;
            if(tipo_accion==ACCION_CREAR){
                try{
                    estado = gestionarUnidadDeMedidaServicio.crear(unidadDeMedida);
                    if(estado > 0){
                        Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                        this.dispose();
                    }
                }catch(Exception ex){
                    //JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }            
            }else{
                try{
                    estado = gestionarUnidadDeMedidaServicio.modificar(unidadDeMedida);
                    if(estado > 0){
                        Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                        this.dispose();
                    }
                }catch(Exception ex){
                    //JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            }
            
        }else{
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            mostrarCampoVacio();
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    
    private boolean verificarCamposLlenos() {
        boolean estanLlenos;
        if(!(textoNombre.getText().trim().isEmpty()))
            estanLlenos = true;
        else
            estanLlenos = false; 
        return estanLlenos;
    }

    private void mostrarCampoVacio(){
        if(textoNombre.getText().trim().isEmpty())
            textoNombre.requestFocus();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textoAreaDescripcion;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}