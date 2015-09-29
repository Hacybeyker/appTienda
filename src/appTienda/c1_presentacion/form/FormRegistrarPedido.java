/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTienda.c1_presentacion.form;

import appTienda.c1_presentacion.util.Mensaje;
import appTienda.c2_aplicacion.servicio.GestionarClienteServicio;
import appTienda.c2_aplicacion.servicio.GestionarProductoServicio;
import appTienda.c2_aplicacion.servicio.RegistrarPedidoServicio;
import appTienda.c3_dominio.entidad.Cliente;
import appTienda.c3_dominio.entidad.ItemPedido;
import appTienda.c3_dominio.entidad.Producto;
import appTienda.c3_dominio.entidad.Pedido;
import appTienda.c3_dominio.entidad.Usuario;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author Osorio Perez Carlos - hacybeyker@gmail.com
 */
public class FormRegistrarPedido extends javax.swing.JDialog {

    
    Cliente cliente;
    Producto producto;
    Pedido pedido;
    Usuario usuario;
    ItemPedido itemPedido;
    ArrayList<Producto> listaProducto;
    LocalDate fecha;
    
    /**
     * Creates new form FormRegistrarVenta
     * @param owner
     * @param modal
     */
    public FormRegistrarPedido(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        setResizable(false);
        textoBuscarDniCliente.requestFocus();
        mostrarFecha();
        crearTabla();
        this.producto = new Producto();
        this.cliente = new Cliente();
        this.pedido = new Pedido();
        usuario = FormMenu.usuario;
        etiquetaEmpleado.setText(usuario.getEmpleado().getNombre()+" "+usuario.getEmpleado().getApellido());
        mostrarCodigoPedido();
    }

    private void mostrarCodigoPedido(){
        RegistrarPedidoServicio registrarPedidoServicio = new RegistrarPedidoServicio();
        try {
            textoCodigo.setText(String.valueOf(registrarPedidoServicio.obtenerSiguienteCodigo()));
        } catch (Exception ex) {
            Logger.getLogger(FormRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Gestionar Cliente
    public FormRegistrarPedido(Dialog owner, Cliente cliente) {
        super(owner, true);
        initComponents();
        setResizable(false);
        mostrarFecha();
        crearTabla();
        this.cliente = cliente;
        etiquetaNombreCliente.setText(cliente.getNombre()+" "+cliente.getApellido());
    }
//Gestionar Producto
    public FormRegistrarPedido(Dialog owner, Producto producto) {
        super(owner, true);
        initComponents();
        setResizable(false);
        mostrarFecha();
        crearTabla();
        this.producto = producto;
    }
    
    private void crearTabla() {
        //TABLA PRODUCTO
        Tabla tabla_Producto = new Tabla();
        
        tabla_Producto.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla_Producto.agregarColumna(new Columna("Nombre", "java.lang.String"));
        tabla_Producto.agregarColumna(new Columna("Tipo Producto", "java.lang.String"));
        tabla_Producto.agregarColumna(new Columna("U. Medida", "java.lang.String"));
        tabla_Producto.agregarColumna(new Columna("Marca", "java.lang.String"));
        tabla_Producto.agregarColumna(new Columna("Descripcion", "java.lang.String"));
        tabla_Producto.agregarColumna(new Columna("Stock", "java.lang.Integer"));
        tabla_Producto.agregarColumna(new Columna("Precio", "java.lang.Double"));
        
        ModeloTabla modeloTablaProducto = new ModeloTabla(tabla_Producto);
        tablaProducto.setModel(modeloTablaProducto );
        
        TableColumn columna0,columna1,columna2,columna3,columna4,columna5,columna6,columna7;
        //Codigo
        columna0 = tablaProducto.getColumnModel().getColumn(0);
        columna0.setPreferredWidth(150);
        columna0.setMaxWidth(200);
        columna0.setMinWidth(150);
        //Nombre
        columna1 = tablaProducto.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(140);
        columna1.setMaxWidth(250);
        columna1.setMinWidth(140);
        //Tipo Producto
        columna2 = tablaProducto.getColumnModel().getColumn(2);
        columna2.setPreferredWidth(120);
        columna2.setMaxWidth(160);
        columna2.setMinWidth(120);
        //Unidad de Medida
        columna3 = tablaProducto.getColumnModel().getColumn(3);
        columna3.setPreferredWidth(60);
        columna3.setMaxWidth(70);
        columna3.setMinWidth(60);
        //Marca
        columna4 = tablaProducto.getColumnModel().getColumn(4);
        columna4.setPreferredWidth(70);
        columna4.setMaxWidth(80);
        columna4.setMinWidth(70);
        //Descripcion
        columna5 = tablaProducto.getColumnModel().getColumn(5);
        columna5.setPreferredWidth(200);
        columna5.setMaxWidth(200);
        columna5.setMinWidth(200);
        //Stock
        columna6 = tablaProducto.getColumnModel().getColumn(6);
        columna6.setPreferredWidth(60);
        columna6.setMaxWidth(70);
        columna6.setMinWidth(60);
        //Precio
        columna7 = tablaProducto.getColumnModel().getColumn(7);
        columna7.setPreferredWidth(55);
        columna7.setMaxWidth(60);
        columna7.setMinWidth(55);
        tablaProducto.removeColumn(columna0);
        tablaProducto.removeColumn(columna5);
        
        //TABLA DETALLE PEDIDO
        Tabla tabla_DetallePedido = new Tabla();
        
        tabla_DetallePedido.agregarColumna(new Columna("CodigoProducto", "java.lang.Integer"));
        tabla_DetallePedido.agregarColumna(new Columna("Producto", "java.lang.String"));
        tabla_DetallePedido.agregarColumna(new Columna("Tipo", "java.lang.String"));
        tabla_DetallePedido.agregarColumna(new Columna("U.Medida", "java.lang.String"));
        tabla_DetallePedido.agregarColumna(new Columna("Marca", "java.lang.String"));
        tabla_DetallePedido.agregarColumna(new Columna("Precio", "java.lang.Double"));
        tabla_DetallePedido.agregarColumna(new Columna("Cantidad", "java.lang.Integer"));
        tabla_DetallePedido.agregarColumna(new Columna("Sub-Total", "java.lang.Double"));
        
        ModeloTabla modeloTablaDetallePedido  = new ModeloTabla(tabla_DetallePedido);
        tablaDetallePedido.setModel(modeloTablaDetallePedido);
        
        TableColumn columna8,columna9,columna10,columna11,columna12,columna13,columna14,columna15;
        
        //Codigo del Producto
        columna8 = tablaDetallePedido.getColumnModel().getColumn(0);
        columna8.setPreferredWidth(150);
        columna8.setMaxWidth(150);
        columna8.setMinWidth(150);
        //Producto
        columna9 = tablaDetallePedido.getColumnModel().getColumn(1);
        columna9.setPreferredWidth(150);
        columna9.setMaxWidth(200);
        columna9.setMinWidth(150);
        //Tipo
        columna10 = tablaDetallePedido.getColumnModel().getColumn(2);
        columna10.setPreferredWidth(120);
        columna10.setMaxWidth(160);
        columna10.setMinWidth(120);
        //Unidad de Medida
        columna11 = tablaDetallePedido.getColumnModel().getColumn(3);
        columna11.setPreferredWidth(60);
        columna11.setMaxWidth(70);
        columna11.setMinWidth(60);
        //Marca
        columna12 = tablaDetallePedido.getColumnModel().getColumn(4);
        columna12.setPreferredWidth(70);
        columna12.setMaxWidth(80);
        columna12.setMinWidth(70);
        //Precio
        columna13 = tablaDetallePedido.getColumnModel().getColumn(5);
        columna13.setPreferredWidth(55);
        columna13.setMaxWidth(60);
        columna13.setMinWidth(55);
        //Cantidad        
        columna14 = tablaDetallePedido.getColumnModel().getColumn(6);
        columna14.setPreferredWidth(60);
        columna14.setMaxWidth(60);
        columna14.setMinWidth(60);
        //Sub-Total
        columna15 = tablaDetallePedido.getColumnModel().getColumn(7);
        columna15.setPreferredWidth(85);
        columna15.setMaxWidth(85);
        columna15.setMinWidth(85);
        
        tablaDetallePedido.removeColumn(columna8);
    }
    
    private void mostrarFecha() {
        fecha = LocalDate.now();
        etiquetaFecha.setText(fecha.toString());
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        etiquetaEmpleado = new javax.swing.JLabel();
        textoCodigo = new javax.swing.JTextField();
        etiquetaFecha = new javax.swing.JLabel();
        botonBuscarCliente = new javax.swing.JButton();
        etiquetaNombreCliente = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        textoBuscarProducto = new javax.swing.JTextField();
        botonBuscarProducto = new javax.swing.JButton();
        botonGestionarProducto = new javax.swing.JButton();
        textoTotalAPagar = new javax.swing.JTextField();
        botonRegistrar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonGestionarCliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textoCantidad = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoSubTotal = new javax.swing.JTextField();
        textoDescuento = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDetallePedido = new javax.swing.JTable();
        textoBuscarDniCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Venta");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");

        jLabel2.setBackground(new java.awt.Color(244, 244, 244));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/clock32.png"))); // NOI18N
        jLabel2.setText("Fecha:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Empleado:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cliente:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Total:");

        etiquetaEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etiquetaEmpleado.setText("Nombre Completo del Empleado");

        textoCodigo.setEditable(false);
        textoCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        etiquetaFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etiquetaFecha.setText("Fecha");

        botonBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/buscarx20.png"))); // NOI18N
        botonBuscarCliente.setText("Buscar");
        botonBuscarCliente.setOpaque(false);
        botonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClienteActionPerformed(evt);
            }
        });

        etiquetaNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        etiquetaNombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Producto:");

        tablaProducto.setAutoCreateRowSorter(true);
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        textoBuscarProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoBuscarProductoKeyReleased(evt);
            }
        });

        botonBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscarProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/buscarx20.png"))); // NOI18N
        botonBuscarProducto.setText("Buscar");
        botonBuscarProducto.setOpaque(false);
        botonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductoActionPerformed(evt);
            }
        });

        botonGestionarProducto.setBackground(new java.awt.Color(255, 255, 255));
        botonGestionarProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonGestionarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/productox20.png"))); // NOI18N
        botonGestionarProducto.setText("Producto");
        botonGestionarProducto.setOpaque(false);
        botonGestionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionarProductoActionPerformed(evt);
            }
        });

        textoTotalAPagar.setEditable(false);
        textoTotalAPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoTotalAPagar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textoTotalAPagar.setText("0.0");

        botonRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/guardarx32.png"))); // NOI18N
        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
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

        botonGestionarCliente.setBackground(new java.awt.Color(255, 255, 255));
        botonGestionarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonGestionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/clientex20.png"))); // NOI18N
        botonGestionarCliente.setText("Cliente");
        botonGestionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionarClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cantidad:");

        textoCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textoCantidad.setEnabled(false);
        textoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoCantidadKeyReleased(evt);
            }
        });

        botonAgregar.setBackground(new java.awt.Color(255, 255, 255));
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appTienda/c5_recursos/iconos/agregarx20.png"))); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.setEnabled(false);
        botonAgregar.setOpaque(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("SubTotal :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Descuento :");

        textoSubTotal.setEditable(false);
        textoSubTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textoSubTotal.setText("0.0");

        textoDescuento.setEditable(false);
        textoDescuento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textoDescuento.setText("0.0");

        tablaDetallePedido.setAutoCreateRowSorter(true);
        tablaDetallePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetallePedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaDetallePedidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaDetallePedidoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tablaDetallePedido);

        textoBuscarDniCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(456, 456, 456))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonBuscarProducto)
                                .addGap(18, 18, 18)
                                .addComponent(botonGestionarProducto)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textoBuscarDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botonBuscarCliente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel2)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonGestionarCliente))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(10, 10, 10)
                                        .addComponent(etiquetaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(etiquetaNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(187, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etiquetaEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etiquetaFecha, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(botonGestionarCliente)
                            .addComponent(botonBuscarCliente)
                            .addComponent(jLabel4)
                            .addComponent(textoBuscarDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(etiquetaNombreCliente)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botonBuscarProducto)
                    .addComponent(textoBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(botonGestionarProducto))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textoSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(textoDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(textoTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(botonAgregar)
                            .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel6)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGestionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionarClienteActionPerformed
        // TODO add your handling code here:
        FormGestionarCliente formGestionarCliente = new FormGestionarCliente(this);
        formGestionarCliente.setVisible(true);
    }//GEN-LAST:event_botonGestionarClienteActionPerformed

    private void botonGestionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionarProductoActionPerformed
        // TODO add your handling code here:
        FormGestionarProducto formGestionarProducto = new FormGestionarProducto(this);
        formGestionarProducto.setVisible(true);
    }//GEN-LAST:event_botonGestionarProductoActionPerformed

    private void botonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClienteActionPerformed
        buscarCliente();
    }//GEN-LAST:event_botonBuscarClienteActionPerformed

    private void buscarCliente() {
        // TODO add your handling code here:
        //cliente = new Cliente();
        if(!textoBuscarDniCliente.getText().trim().isEmpty()){
            String dni = textoBuscarDniCliente.getText().trim();
            GestionarClienteServicio gestionarClienteServicio = new GestionarClienteServicio();
            try{
                cliente = gestionarClienteServicio.buscarPorDni(dni);
                if(cliente!=null){
                    etiquetaNombreCliente.setText(cliente.getNombre()+" "+cliente.getApellido());
                    ponerFocoConSeleccionEnBuscarProducto();
                }else{
                    Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                    etiquetaNombreCliente.setText("");
                    ponerFocoConSeleccionEnBuscarCliente();
                }
            }catch(Exception ex){
                ponerFocoConSeleccionEnBuscarCliente();
            }            
        }else{
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOBUSCAR(this);
            ponerFocoConSeleccionEnBuscarCliente();
        }
    }

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:        
        if(verificarCamposLlenos()){
            if(Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
                this.dispose();
        }else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private boolean verificarCamposLlenos() {
        boolean estanLlenos;
        if(tablaDetallePedido.getRowCount() > 0)
            estanLlenos = true;        
        else
            estanLlenos = false; 
        return estanLlenos;
    }

    private void mostrarCampoVacio(){
        if(etiquetaNombreCliente.getText().trim().isEmpty()){
            ponerFocoConSeleccionEnBuscarCliente();
        }else if(tablaDetallePedido.getRowCount() == -1){
            ponerFocoConSeleccionEnBuscarProducto();
        }
    }
    
    private void botonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductoActionPerformed
        // TODO add your handling code here:
        if(!textoBuscarProducto.getText().trim().isEmpty()){
            consultarProducto();
            ponerFocoConSeleccionEnBuscarProducto();            
        }else{            
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOBUSCAR(this);            
            ponerFocoConSeleccionEnBuscarProducto();
        }
    }//GEN-LAST:event_botonBuscarProductoActionPerformed

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        // TODO add your handling code here:
        textoCantidad.setEnabled(true);
        textoCantidad.selectAll();
        textoCantidad.requestFocus();
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:            
        agregarProductoAlDetalle(); 
        textoCantidad.setText("");
        controlDeCantidadYAgregar();
        ponerFocoConSeleccionEnBuscarProducto();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void textoCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCantidadKeyReleased
        controlDeCantidadYAgregar();
    }//GEN-LAST:event_textoCantidadKeyReleased

    private void tablaDetallePedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaDetallePedidoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==127)
            eliminarItemPedidoDeLaTabla();        
    }//GEN-LAST:event_tablaDetallePedidoKeyPressed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        // TODO add your handling code here:
        int cantidad_DetallePedido = tablaDetallePedido.getRowCount();
        if(cantidad_DetallePedido > 0){
            RegistrarPedidoServicio registrarPedidoServicio = new RegistrarPedidoServicio();
            pedido.setCodigo(Integer.parseInt(textoCodigo.getText().trim()));
            pedido.setEmpleado(usuario.getEmpleado());
            pedido.setCliente(cliente);
            pedido.setFecha(Date.valueOf(fecha));            
            try{
                int registros_afectado = registrarPedidoServicio.crear(pedido);
                if(registros_afectado>0){
                    Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                    this.dispose();
                }else{
                    Mensaje.Mostrar_MENSAJE_GUARDADOERRONEO(this);
                }
            }catch(Exception ex){
                Mensaje.mostrarErrorExcepcion(this, ex.getMessage());
            }
        }else{
            Mensaje.Mostrar_MENSAJE_REGISTRARSINPRODUCTOS(this);
            mostrarCampoVacio();
        }                
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void tablaDetallePedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaDetallePedidoKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode()==KeyEvent.VK_DOWN ||evt.getKeyCode()==KeyEvent.VK_UP){//VK_DOWN VK_UP VK_ENTER
            int fila = tablaDetallePedido.getSelectedRow();
            if(fila != -1)
                actualizarFilaTabla(tablaDetallePedido, fila);
        }
    }//GEN-LAST:event_tablaDetallePedidoKeyReleased

    private void textoBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoBuscarProductoKeyReleased
        // TODO add your handling code here:        
        consultarProducto();
    }//GEN-LAST:event_textoBuscarProductoKeyReleased

    private void actualizarFilaTabla(JTable jTable, int numero_fila){
        ModeloTabla modeloTabla = (ModeloTabla)jTable.getModel();
        itemPedido = new ItemPedido();
        int cantidad = (Integer)modeloTabla.getValueAt(numero_fila, 6);
        producto = buscarProductoPorCodigo(jTable);
        itemPedido.setCantidad(cantidad);
        itemPedido.setProducto(producto);
        try{
            pedido.actualizarStockPedido(itemPedido);
            double Sub_Total = itemPedido.calcularSubTotal();
            //Actualizamos el subtotal en la tabla enviandoles el subtotal, la fila y la columna
            modeloTabla.setValueAt(Sub_Total, numero_fila, 7);
        }catch(Exception ex){
            itemPedido = pedido.getItemPedido(itemPedido.getProducto().getNombre());
            modeloTabla.setValueAt(itemPedido.getCantidad(), numero_fila, 6);
            Mensaje.mostrarErrorExcepcion(this, ex.getMessage());
        }
        calcularTotales();
    }
    
    public void eliminarItemPedidoDeLaTabla(){
        int filaSeleccionada = tablaDetallePedido.getSelectedRow();
        if(filaSeleccionada != -1){
            if(Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                quitarFilaTabla(tablaDetallePedido, filaSeleccionada);
        }
        else
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);        
    }
    
    public void quitarFilaTabla(JTable jTable, int filaSeleccionada){
        ModeloTabla modeloTabla = (ModeloTabla)jTable.getModel();
        String nombreProducto = (String)modeloTabla.getValueAt(filaSeleccionada, 0);
        modeloTabla.eliminarFila(filaSeleccionada);
        pedido.eliminarItemPedido(nombreProducto);
        calcularTotales();
    }
    
    private void calcularTotales() {
        textoSubTotal.setText(String.valueOf(pedido.calcularSubTotalPedido()));
        textoDescuento.setText(String.valueOf(pedido.calcularDescuentoPedido()));
        textoTotalAPagar.setText(String.valueOf(pedido.calcularTotalPedido()));
    }
    
    private void controlDeCantidadYAgregar() throws NumberFormatException {
        // TODO add your handling code here:        
        if( !textoCantidad.getText().isEmpty()){
            int cantidad = Integer.parseInt(textoCantidad.getText().trim());
            if(cantidad > 0)
                botonAgregar.setEnabled(true);
        }else{
            textoCantidad.setEnabled(false);
            botonAgregar.setEnabled(false);
        }
    }

    private int obtenerCodigoDelProducto(JTable jTable) {
        int codigoProducto = jTable.getSelectedRow();
        if(codigoProducto == -1){
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
            return 0;
        }
        ModeloTabla modeloTablaProducto = (ModeloTabla) jTable.getModel();
        return (Integer)modeloTablaProducto.getValueAt(codigoProducto, 0); // se retorna el id de la fila seleccionada
    }
    
    public Producto buscarProductoPorCodigo(JTable jtable){
        producto = new Producto();
        GestionarProductoServicio gestionarProductoServicio = new GestionarProductoServicio();
        try{
            producto = gestionarProductoServicio.buscar(obtenerCodigoDelProducto(jtable));
        }catch(Exception ex){}
        return  producto;
    }
    
    private void agregarProductoAlDetalle(){        
        ModeloTabla modeloTablaDetallePedido = (ModeloTabla)tablaDetallePedido.getModel();
        itemPedido = new ItemPedido();
        int cantidad; 
        cantidad = Integer.parseInt(textoCantidad.getText().trim());         
        itemPedido.setCantidad(cantidad);
        itemPedido.setProducto(buscarProductoPorCodigo(tablaProducto));
        try{
            pedido.agregarItemPedido(itemPedido);        
            calcularTotales();
        }catch(Exception ex){
            Mensaje.mostrarErrorExcepcion(this, ex.getMessage());            
            ponerFocoConSeleccionEnBuscarProducto();
            return;//si sale la excepcion ya no avanza
        }
        Fila fila = new Fila();
        fila.agregarValorCelda(itemPedido.getProducto().getCodigo());
        fila.agregarValorCelda(itemPedido.getProducto().getNombre());
        fila.agregarValorCelda(itemPedido.getProducto().getTipoProducto().getNombre());
        fila.agregarValorCelda(itemPedido.getProducto().getUnidadDeMedida().getNombre());
        fila.agregarValorCelda(itemPedido.getProducto().getMarca().getNombre());
        fila.agregarValorCelda(itemPedido.getProducto().getPrecio());
        fila.agregarValorCelda(itemPedido.getCantidad());
        fila.agregarValorCelda(itemPedido.calcularSubTotal());                     
        fila.agregarValorCelda(itemPedido.getProducto().getCodigo());          
        fila.obtenerCelda(6).setEditable(true);        
        modeloTablaDetallePedido.agregarFila(fila);
    }
    
    private void consultarProducto(){   
        ModeloTabla modeloTablaProducto = (ModeloTabla) tablaProducto.getModel();
        modeloTablaProducto.eliminarTotalFilas();
        String nombre = textoBuscarProducto.getText().trim().toUpperCase();
        try {
            GestionarProductoServicio gestionarProductoServicio = new GestionarProductoServicio();
            listaProducto = gestionarProductoServicio.buscarPorNombre(nombre);
            if(listaProducto!=null && listaProducto.size()>0){
                for(Producto productos : listaProducto){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(productos.getCodigo());
                    fila.agregarValorCelda(productos.getNombre());
                    fila.agregarValorCelda(productos.getTipoProducto().getNombre());
                    fila.agregarValorCelda(productos.getUnidadDeMedida().getNombre());
                    fila.agregarValorCelda(productos.getMarca().getNombre());
                    fila.agregarValorCelda(productos.getDescripcion());
                    fila.agregarValorCelda(productos.getStock());
                    fila.agregarValorCelda(productos.getPrecio());
                    modeloTablaProducto.agregarFila(fila);
                }  
                tablaProducto.setModel(modeloTablaProducto);
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscarProducto();
            }             
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void ponerFocoConSeleccionEnBuscarProducto() {
        textoBuscarProducto.selectAll();        
        textoBuscarProducto.requestFocus();
    }
    private void ponerFocoConSeleccionEnBuscarCliente() {      
        textoBuscarDniCliente.selectAll();
        textoBuscarDniCliente.requestFocus();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscarCliente;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonGestionarCliente;
    private javax.swing.JButton botonGestionarProducto;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel etiquetaEmpleado;
    private javax.swing.JLabel etiquetaFecha;
    private javax.swing.JLabel etiquetaNombreCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaDetallePedido;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField textoBuscarDniCliente;
    private javax.swing.JTextField textoBuscarProducto;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoDescuento;
    private javax.swing.JTextField textoSubTotal;
    private javax.swing.JTextField textoTotalAPagar;
    // End of variables declaration//GEN-END:variables
}
