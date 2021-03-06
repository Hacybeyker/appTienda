/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c1_presentacion.form;

import appTienda.c1_presentacion.util.Mensaje;
import appTienda.c2_aplicacion.servicio.GestionarMarcaServicio;
import appTienda.c2_aplicacion.servicio.GestionarProductoServicio;
import appTienda.c2_aplicacion.servicio.GestionarTipoProductoServicio;
import appTienda.c2_aplicacion.servicio.GestionarUnidadDeMedidaServicio;
import appTienda.c3_dominio.entidad.Marca;
import appTienda.c3_dominio.entidad.Producto;
import appTienda.c3_dominio.entidad.TipoProducto;
import appTienda.c3_dominio.entidad.UnidadDeMedida;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.JDialog;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class FormRegistrarProducto extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion = 0;
    private Producto producto;
    ArrayList<TipoProducto> listaTipoDeProducto;
    ArrayList<UnidadDeMedida> listaUnidadDeMedida;
    ArrayList<Marca> listaMarca;
    /**
     * Creates new form FormRegistrarProducto
     * @param owner
     */
    public FormRegistrarProducto(JDialog owner) {
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_CREAR;
        this.producto = new Producto();
        LlenarComboTipoProducto();
        LlenarComboUnidadDeMedida();
        LlenarComboMarca();
        inicializarCombos();
    }

    public void inicializarCombos(){
        comboUnidadDeMedida.setSelectedIndex(-1);
        comboMarca.setSelectedIndex(-1);
        comboTipoProducto.setSelectedIndex(-1);
    }
    
    public FormRegistrarProducto(Dialog owner, Producto producto) {
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_MODIFICAR;
        LlenarComboTipoProducto();
        LlenarComboUnidadDeMedida();
        LlenarComboMarca();
        obtenerObjetoDeGestionar(producto);
    }

    private void obtenerObjetoDeGestionar(Producto producto1) {
        this.producto = producto1;
        textoCodigo.setText(String.valueOf(producto1.getCodigo()));
        textoNombre.setText(producto1.getNombre());
        comboTipoProducto.setSelectedItem(producto1.getTipoProducto().getNombre());
        textoStock.setText(String.valueOf(producto1.getStock()));
        textoPrecio.setText(String.valueOf(producto1.getPrecio()));
        textoareaDescripcion.setText(producto1.getDescripcion());
    }
    
    
    
    private void LlenarComboTipoProducto(){
        try{
            GestionarTipoProductoServicio gestionarTipoProductoServicio = new GestionarTipoProductoServicio();
            listaTipoDeProducto = gestionarTipoProductoServicio.buscarPorNombre(null);
            comboTipoProducto.removeAllItems();
            for (TipoProducto tipoProducto : listaTipoDeProducto) {
                comboTipoProducto.addItem(tipoProducto.getNombre());
            }
        }catch(Exception ex){
            
        }
    }    
    
    private void LlenarComboUnidadDeMedida(){
        try{
            GestionarUnidadDeMedidaServicio gestionarUnidadDeMedidaServicio = new GestionarUnidadDeMedidaServicio();
            listaUnidadDeMedida = gestionarUnidadDeMedidaServicio.buscarPorNombre(null);
            comboUnidadDeMedida.removeAllItems();
            for (UnidadDeMedida unidadDeMedida : listaUnidadDeMedida) {
                comboUnidadDeMedida.addItem(unidadDeMedida.getNombre());
            }
        }catch(Exception ex){
            
        }
    }  
    
    private void LlenarComboMarca(){
        try{
            GestionarMarcaServicio gestionarMarcaServicio = new GestionarMarcaServicio();
            listaMarca = gestionarMarcaServicio.buscarPorNombre(null);
            comboMarca.removeAllItems();
            for (Marca marca : listaMarca) {
                comboMarca.addItem(marca.getNombre());
            }
        }catch(Exception ex){
            
        }
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
        textoCodigo = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoareaDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        comboTipoProducto = new javax.swing.JComboBox();
        textoStock = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textoPrecio = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        comboUnidadDeMedida = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        comboMarca = new javax.swing.JComboBox();
        botonCrearUMedida = new javax.swing.JButton();
        botonCrearMarca = new javax.swing.JButton();
        botonCrearTipoProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Producto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");

        textoCodigo.setEditable(false);
        textoCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoCodigo.setEnabled(false);

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tipo Producto:");

        textoareaDescripcion.setColumns(20);
        textoareaDescripcion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoareaDescripcion.setLineWrap(true);
        textoareaDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoareaDescripcion);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Descripción:");

        comboTipoProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        textoStock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textoStock.setText("1");
        textoStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoStockFocusGained(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Precio:");

        textoPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textoPrecio.setText("0.0");
        textoPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoPrecioFocusGained(evt);
            }
        });

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("U. Medida:");

        comboUnidadDeMedida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Marca:");

        comboMarca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        botonCrearUMedida.setBackground(new java.awt.Color(255, 255, 255));
        botonCrearUMedida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/unidaddemedidax20.png"))); // NOI18N
        botonCrearUMedida.setText("Crear");
        botonCrearUMedida.setOpaque(false);
        botonCrearUMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearUMedidaActionPerformed(evt);
            }
        });

        botonCrearMarca.setBackground(new java.awt.Color(255, 255, 255));
        botonCrearMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/marcax20.png"))); // NOI18N
        botonCrearMarca.setText("Crear");
        botonCrearMarca.setOpaque(false);
        botonCrearMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearMarcaActionPerformed(evt);
            }
        });

        botonCrearTipoProducto.setBackground(new java.awt.Color(255, 255, 255));
        botonCrearTipoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/tipoproductox20.png"))); // NOI18N
        botonCrearTipoProducto.setText("Crear");
        botonCrearTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearTipoProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboUnidadDeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(14, 14, 14)
                                .addComponent(comboTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonCrearTipoProducto)
                            .addComponent(botonCrearMarca)
                            .addComponent(botonCrearUMedida)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(textoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botonCrearUMedida)
                    .addComponent(comboUnidadDeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botonCrearMarca)
                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botonCrearTipoProducto)
                    .addComponent(comboTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(textoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(verificarCamposLlenos()){
            producto.setNombre(textoNombre.getText().trim().toUpperCase());
            producto.setDescripcion(textoareaDescripcion.getText().trim().toUpperCase());
            producto.setStock(Integer.parseInt(textoStock.getText().trim()));
            producto.setPrecio(Double.parseDouble(textoPrecio.getText().trim()));
            TipoProducto tipoProducto;
            tipoProducto = listaTipoDeProducto.get(comboTipoProducto.getSelectedIndex());
            producto.setTipoProducto(tipoProducto);      
            UnidadDeMedida unidadDeMedida;
            unidadDeMedida = listaUnidadDeMedida.get(comboUnidadDeMedida.getSelectedIndex());
            producto.setUnidadDeMedida(unidadDeMedida);
            Marca marca;
            marca = listaMarca.get(comboMarca.getSelectedIndex());
            producto.setMarca(marca);
            int registros_afectados;
            GestionarProductoServicio gestionarProductoServicio  = new GestionarProductoServicio();
            if(tipo_accion==ACCION_CREAR){
                try{
                    registros_afectados = gestionarProductoServicio.crear(producto);
                    if(registros_afectados>0){
                        Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                        this.dispose();
                    }
                }catch(Exception ex){
                    Mensaje.mostrarErrorExcepcion(this, ex.getMessage());
                    textoStock.selectAll();
                    textoStock.requestFocus();
                }
            }else{
                try{
                    registros_afectados = gestionarProductoServicio.modificar(producto);
                    if(registros_afectados>0){
                        Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                        this.dispose();
                    }
                }catch(Exception ex){
                    Mensaje.mostrarErrorExcepcion(this, ex.getMessage());
                    textoStock.selectAll();
                    textoStock.requestFocus();
                }
            }
        }else{
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            mostrarCampoVacio();
        }
                
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){
            if(Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
                this.dispose();
        }else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void textoPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoPrecioFocusGained
        // TODO add your handling code here:
        textoPrecio.selectAll();
        textoPrecio.requestFocus();
    }//GEN-LAST:event_textoPrecioFocusGained

    private void textoStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoStockFocusGained
        // TODO add your handling code here:
        textoStock.selectAll();
        textoStock.requestFocus();
    }//GEN-LAST:event_textoStockFocusGained

    private void botonCrearTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearTipoProductoActionPerformed
        // TODO add your handling code here:
        FormRegistrarTipoDeProducto formRegistrarTipoDeProducto = new FormRegistrarTipoDeProducto(this);
        formRegistrarTipoDeProducto.setVisible(true);
        LlenarComboTipoProducto();
    }//GEN-LAST:event_botonCrearTipoProductoActionPerformed

    private void botonCrearMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearMarcaActionPerformed
        // TODO add your handling code here:
        FormRegistrarMarca formRegistrarMarca = new FormRegistrarMarca(this);
        formRegistrarMarca.setVisible(true);
        LlenarComboMarca();
    }//GEN-LAST:event_botonCrearMarcaActionPerformed

    private void botonCrearUMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearUMedidaActionPerformed
        // TODO add your handling code here:
        FormRegistrarUnidadDeMedida formRegistrarUnidadDeMedida = new FormRegistrarUnidadDeMedida(this);
        formRegistrarUnidadDeMedida.setVisible(true);
        LlenarComboUnidadDeMedida();
    }//GEN-LAST:event_botonCrearUMedidaActionPerformed

    private boolean verificarCamposLlenos() {
        boolean estanLlenos;
        if(!(textoNombre.getText().trim().isEmpty() && textoPrecio.getText().trim().isEmpty() && textoStock.getText().trim().isEmpty() || textoPrecio.getText().trim().equals("0.0")))
            estanLlenos = true;
        else
            estanLlenos = false; 
        return estanLlenos;
    }

    private void mostrarCampoVacio(){
        if(textoNombre.getText().trim().isEmpty()){
            textoNombre.requestFocus();
        }else if(textoStock.getText().trim().isEmpty()){
            textoStock.requestFocus();
        }else if(textoPrecio.getText().trim().isEmpty() || textoPrecio.getText().trim().equals("0.0")){
            textoPrecio.selectAll();
            textoPrecio.requestFocus();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCrearMarca;
    private javax.swing.JButton botonCrearTipoProducto;
    private javax.swing.JButton botonCrearUMedida;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JComboBox comboMarca;
    private javax.swing.JComboBox comboTipoProducto;
    private javax.swing.JComboBox comboUnidadDeMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoPrecio;
    private javax.swing.JTextField textoStock;
    private javax.swing.JTextArea textoareaDescripcion;
    // End of variables declaration//GEN-END:variables
}
