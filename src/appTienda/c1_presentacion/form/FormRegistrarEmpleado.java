/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c1_presentacion.form;

import appTienda.c1_presentacion.util.Mensaje;
import appTienda.c2_aplicacion.servicio.GestionarCargoServicio;
import appTienda.c2_aplicacion.servicio.GestionarEmpleadoServicio;
import appTienda.c2_aplicacion.servicio.GestionarUsuarioServicio;
import appTienda.c3_dominio.entidad.Cargo;
import appTienda.c3_dominio.entidad.Empleado;
import appTienda.c3_dominio.entidad.Usuario;
import java.awt.Dialog;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JDialog;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class FormRegistrarEmpleado extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion = 0;
    Empleado empleado;
    Usuario usuario;
    LocalDate fecha = LocalDate.now();
    ArrayList<Cargo> listaCargo;
    
    /**
     * Creates new form FormRegistrarEmpleado
     * @param owner
     */
    //CREAR
    public FormRegistrarEmpleado(JDialog owner) {
        super(owner);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_CREAR;
        this.empleado = new Empleado();
        this.usuario  = new Usuario();
        dateInicio.setDate(Date.valueOf(fecha));
        LlenarComboCargo();
        mostrarCampoVacio();
    }
    //MODIFICAR
    public FormRegistrarEmpleado(Dialog owner, Usuario usuario, Empleado empleado) {
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_MODIFICAR;
        checkActivo.setEnabled(true);
        checkActivo.setSelected(true);
        LlenarComboCargo();
        obtenerObjetoEmpleadoDeGestionar(empleado);
        obtenerObjetoUsuarioDeGestionar(usuario);
    }
    
    //CUADNO SE PRESIONA MODIFICAR
    private void obtenerObjetoEmpleadoDeGestionar(Empleado empleado1){
        this.empleado = empleado1;
        //Datos personales
        textoCodigoEmpleado.setText(String.valueOf(empleado1.getCodigo()));
        textoNombre.setText(String.valueOf(empleado1.getNombre()));
        textoApellido.setText(String.valueOf(empleado1.getApellido()));
        textoDni.setText(String.valueOf(empleado1.getDni()));
        textoDireccion.setText(String.valueOf(empleado1.getDireccion()));
        textoTelefono.setText(String.valueOf(empleado1.getTelefono()));
        textoCelular.setText(String.valueOf(empleado1.getCelular()));
        textoCorreo.setText(String.valueOf(empleado1.getCorreo()));
        checkActivo.setSelected(empleado1.isActivo());
        //contrato
        textoSueldo.setText(String.valueOf(empleado1.getSueldo()));
        dateInicio.setDate(empleado1.getFechainicio());
        dateFin.setDate(empleado1.getFechafin());
        //Aceso
        comboCargo.setSelectedItem(empleado1.getCargo().getNombre());
    }
    //CUADNO SE PRESIONA MODIFICAR
    private void obtenerObjetoUsuarioDeGestionar(Usuario usuario1) {
        this.usuario = usuario1;        
        //Acceso
        textoUsuario.setText(usuario1.getUsuario());
        textoPassword.setText(usuario1.getPassword());        
    }
    

    private void LlenarComboCargo(){
        try{
            Cargo cargo;
            GestionarCargoServicio gestionarCargoServicio = new GestionarCargoServicio();
            listaCargo = gestionarCargoServicio.buscarPorNombre(null);
            comboCargo.removeAllItems();
            for (Cargo listalistaCargo1 : listaCargo) {
                cargo = listalistaCargo1;
                comboCargo.addItem(cargo.getNombre());
            }
        }catch(Exception ex){
            
        }
    } 
    
    private boolean verificarCamposLlenos() {
        return  !textoNombre.getText().trim().isEmpty() && !textoApellido.getText().trim().isEmpty() && !textoDni.getText().trim().isEmpty() &&
                !textoSueldo.getText().trim().isEmpty() && !textoUsuario.getText().trim().isEmpty() && !textoPassword.getText().trim().isEmpty() &&
                comboCargo.getSelectedIndex()!=-1; 
    }

    private void mostrarCampoVacio(){
        if(textoNombre.getText().trim().isEmpty()){
            jTabbedPane1.setSelectedIndex(0);
            textoNombre.requestFocus();
        }
        else if(textoApellido.getText().trim().isEmpty()){
            jTabbedPane1.setSelectedIndex(0);
            textoApellido.requestFocus();
        }
        else if(textoDni.getText().trim().isEmpty()){
            jTabbedPane1.setSelectedIndex(0);
            textoDni.requestFocus();
        }
        else if(textoSueldo.getText().trim().isEmpty()){
            textoSueldo.setEditable(true);
            textoSueldo.setEnabled(true);
            jTabbedPane1.setSelectedIndex(1);
            textoSueldo.requestFocus();
        }
        else if(textoUsuario.getText().trim().isEmpty()){
            jTabbedPane1.setSelectedIndex(2);
            textoUsuario.requestFocus();
        }
        else if(textoPassword.getText().trim().isEmpty()){
            jTabbedPane1.setSelectedIndex(2);
            textoPassword.requestFocus();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoCodigoEmpleado = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoDni = new javax.swing.JTextField();
        textoCelular = new javax.swing.JTextField();
        textoCorreo = new javax.swing.JTextField();
        textoApellido = new javax.swing.JTextField();
        textoDireccion = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        checkActivo = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textoSueldo = new javax.swing.JTextField();
        dateInicio = new com.toedter.calendar.JDateChooser();
        dateFin = new com.toedter.calendar.JDateChooser();
        checkModificar = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        textoCodigoContrato = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        textoCodigoAcceso = new javax.swing.JTextField();
        textoUsuario = new javax.swing.JTextField();
        textoPassword = new javax.swing.JPasswordField();
        comboCargo = new javax.swing.JComboBox();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Empleado");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Dni:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Direccion:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Celular:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Telefono:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Correo:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Activo:");

        textoCodigoEmpleado.setEditable(false);
        textoCodigoEmpleado.setEnabled(false);

        checkActivo.setSelected(true);
        checkActivo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoCodigoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(textoDni)
                    .addComponent(textoCelular)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(textoNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkActivo)
                    .addComponent(textoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(textoDireccion)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoDni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoCelular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkActivo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos Personales", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Sueldo:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Fecha Inicio:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fecha Fin:");

        textoSueldo.setEditable(false);
        textoSueldo.setEnabled(false);

        checkModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkModificar.setText("Modificar");
        checkModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkModificarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Codigo:");

        textoCodigoContrato.setEditable(false);
        textoCodigoContrato.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textoSueldo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoCodigoContrato)
                    .addComponent(dateInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkModificar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(textoCodigoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(checkModificar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contrato", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Codigo:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Usuario:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Password:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Cargo:");

        textoCodigoAcceso.setEditable(false);
        textoCodigoAcceso.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoCodigoAcceso)
                    .addComponent(textoUsuario)
                    .addComponent(comboCargo, 0, 171, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(textoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textoCodigoAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Acceso", jPanel3);

        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/guardarx32.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkModificarActionPerformed
        // TODO add your handling code here:
        if(checkModificar.isSelected()){
            textoSueldo.setEditable(true);
            textoSueldo.setEnabled(true);
            textoSueldo.selectAll();
            textoSueldo.requestFocus();
        }else{
            textoSueldo.setEditable(false);
            textoSueldo.setEnabled(false);
        }
            
    }//GEN-LAST:event_checkModificarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){     
            empleado.setNombre(textoNombre.getText().trim().toUpperCase());
            empleado.setApellido(textoApellido.getText().trim().toUpperCase());
            empleado.setDni(textoDni.getText().trim().toUpperCase());
            empleado.setDireccion(textoDireccion.getText().trim().toUpperCase());
            empleado.setCelular(textoCelular.getText().trim().toUpperCase());
            empleado.setTelefono(textoTelefono.getText().trim().toUpperCase());
            empleado.setCorreo(textoCorreo.getText().trim().toUpperCase());
            empleado.setActivo(checkActivo.isSelected());
            empleado.setFechainicio(Date.valueOf(String.format("%1$tY-%1$tm-%1$te",dateInicio.getDate())));
            empleado.setFechafin(Date.valueOf(String.format("%1$tY-%1$tm-%1$te",dateFin.getDate())));
            empleado.setSueldo(Double.parseDouble(textoSueldo.getText()));
            Cargo cargo;
            cargo = listaCargo.get(comboCargo.getSelectedIndex());
            empleado.setCargo(cargo);  
            usuario.setEmpleado(empleado);
            int registros_afectadosUsuario,registros_afectadosEmpleado;
            GestionarEmpleadoServicio gestionarEmpleadoServicio = new GestionarEmpleadoServicio();
            GestionarUsuarioServicio gestionarUsuarioServicio = new  GestionarUsuarioServicio();
            if(tipo_accion==ACCION_CREAR){//SE CREA PRIMERO EL EMPLEADO Y LUEGO EL USUARIO
                try{                    
                    registros_afectadosEmpleado = gestionarEmpleadoServicio.crear(empleado);
                    if(registros_afectadosEmpleado > 0){                        
                        empleado = gestionarEmpleadoServicio.buscarPorDni(empleado.getDni());
                        usuario.setUsuario(textoUsuario.getText().trim().toUpperCase());
                        usuario.setPassword(textoPassword.getText().trim());
                        usuario.setEmpleado(empleado);
                        registros_afectadosUsuario = gestionarUsuarioServicio.crear(usuario);
                        if(registros_afectadosUsuario > 0){
                            Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                            this.dispose();
                        }else{
                            Mensaje.Mostrar_MENSAJE_GUARDADOERRONEO(this);
                        }                        
                    }else{
                        Mensaje.Mostrar_MENSAJE_GUARDADOERRONEO(this);
                    }
                }catch(Exception ex){
                }
            }else{
                try{                    
                    registros_afectadosEmpleado = gestionarEmpleadoServicio.modificar(empleado);
                    if(registros_afectadosEmpleado > 0){                        
                        empleado = gestionarEmpleadoServicio.buscarPorDni(empleado.getDni());
                        usuario.setUsuario(textoUsuario.getText().trim().toUpperCase());
                        usuario.setPassword(textoPassword.getText().trim());
                        usuario.setEmpleado(empleado);
                        registros_afectadosUsuario = gestionarUsuarioServicio.modificar(usuario);
                        if(registros_afectadosUsuario > 0){
                            Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                            this.dispose();
                        }else{
                            Mensaje.Mostrar_MENSAJE_GUARDADOERRONEO(this);
                        }                        
                    }else{
                        Mensaje.Mostrar_MENSAJE_GUARDADOERRONEO(this);
                    }
                }catch(Exception ex){
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
            Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this);
            this.dispose();                    
        }else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JCheckBox checkActivo;
    private javax.swing.JCheckBox checkModificar;
    private javax.swing.JComboBox comboCargo;
    private com.toedter.calendar.JDateChooser dateFin;
    private com.toedter.calendar.JDateChooser dateInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField textoApellido;
    private javax.swing.JTextField textoCelular;
    private javax.swing.JTextField textoCodigoAcceso;
    private javax.swing.JTextField textoCodigoContrato;
    private javax.swing.JTextField textoCodigoEmpleado;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoDni;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JPasswordField textoPassword;
    private javax.swing.JTextField textoSueldo;
    private javax.swing.JTextField textoTelefono;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
