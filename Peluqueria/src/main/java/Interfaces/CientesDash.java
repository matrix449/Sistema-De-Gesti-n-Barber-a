
package Interfaces;

/**
 *
 * @author chaco
 */
public class CientesDash extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CientesDash.class.getName());

    
public CientesDash() {
        initComponents();

        this.setLocationRelativeTo(null);
        
        
        if (Entity.Sesion.getIdRolActual() == 2) {
            EmpleadosPanel.setVisible(false); // Desaparecemos el botón Empleados
        }
        // Configuramos el menú lateral
        NavegacionUtils.configurarMenuLateral(this, 
            DashboardPanel, // Panel
            GestinTurnoPanel, // Gestión de turnos
            ClientesPanel, // Clientes
            EmpleadosPanel, // Empleados
            ServiciosPanel, // Servicios
            InventarioPanel, // Inventario
            FacturacionPanel, // Facturación
            ReportePanel, //Reportes
            PerfilPanel1 //Perfil
        );
        
        cargarListaEstados();
        cargarTablaClientes();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ClientesPanel = new javax.swing.JToggleButton();
        DashboardPanel = new javax.swing.JToggleButton();
        EmpleadosPanel = new javax.swing.JToggleButton();
        ServiciosPanel = new javax.swing.JToggleButton();
        InventarioPanel = new javax.swing.JToggleButton();
        GestinTurnoPanel = new javax.swing.JToggleButton();
        FacturacionPanel = new javax.swing.JToggleButton();
        ReportePanel = new javax.swing.JToggleButton();
        PerfilPanel1 = new javax.swing.JToggleButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        txtBuscarCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        EliminarCliente = new javax.swing.JButton();
        ListaEstado2 = new javax.swing.JComboBox<>();

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel9.setForeground(new java.awt.Color(255, 153, 0));
        jPanel9.setToolTipText("");

        jTextField2.setText("jTextField1");

        jLabel6.setText("Buscar Cliente:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField2)
                .addComponent(jLabel6))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 3));
        jPanel1.setForeground(new java.awt.Color(255, 153, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel2.setForeground(new java.awt.Color(255, 153, 0));
        jPanel2.setToolTipText("");

        jLabel3.setBackground(new java.awt.Color(255, 153, 0));
        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Clientes");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Administrador");

        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Administrador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 9, 884, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel4.setForeground(new java.awt.Color(255, 153, 0));
        jPanel4.setToolTipText("");

        ClientesPanel.setBackground(new java.awt.Color(51, 51, 51));
        ClientesPanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        ClientesPanel.setForeground(new java.awt.Color(255, 153, 0));
        ClientesPanel.setText("Clientes");

        DashboardPanel.setBackground(new java.awt.Color(51, 51, 51));
        DashboardPanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        DashboardPanel.setForeground(new java.awt.Color(255, 153, 0));
        DashboardPanel.setText("Panel");

        EmpleadosPanel.setBackground(new java.awt.Color(51, 51, 51));
        EmpleadosPanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        EmpleadosPanel.setForeground(new java.awt.Color(255, 153, 0));
        EmpleadosPanel.setText("Empleados");

        ServiciosPanel.setBackground(new java.awt.Color(51, 51, 51));
        ServiciosPanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        ServiciosPanel.setForeground(new java.awt.Color(255, 153, 0));
        ServiciosPanel.setText("Servicios");

        InventarioPanel.setBackground(new java.awt.Color(51, 51, 51));
        InventarioPanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        InventarioPanel.setForeground(new java.awt.Color(255, 153, 0));
        InventarioPanel.setText("Inventario");

        GestinTurnoPanel.setBackground(new java.awt.Color(51, 51, 51));
        GestinTurnoPanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        GestinTurnoPanel.setForeground(new java.awt.Color(255, 153, 0));
        GestinTurnoPanel.setText("Gestión de turnos");

        FacturacionPanel.setBackground(new java.awt.Color(51, 51, 51));
        FacturacionPanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        FacturacionPanel.setForeground(new java.awt.Color(255, 153, 0));
        FacturacionPanel.setText("Facturación");

        ReportePanel.setBackground(new java.awt.Color(51, 51, 51));
        ReportePanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        ReportePanel.setForeground(new java.awt.Color(255, 153, 0));
        ReportePanel.setText("Reportes");

        PerfilPanel1.setBackground(new java.awt.Color(51, 51, 51));
        PerfilPanel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        PerfilPanel1.setForeground(new java.awt.Color(255, 153, 0));
        PerfilPanel1.setText("Perfil");
        PerfilPanel1.addActionListener(this::PerfilPanel1ActionPerformed);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel13.setForeground(new java.awt.Color(255, 153, 0));
        jPanel13.setToolTipText("");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Barber 102x80.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(58, 58, 58))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GestinTurnoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClientesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmpleadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ServiciosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InventarioPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FacturacionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReportePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PerfilPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(DashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GestinTurnoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClientesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ServiciosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InventarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FacturacionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReportePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PerfilPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, 242, -1));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel7.setForeground(new java.awt.Color(255, 153, 0));
        jPanel7.setToolTipText("");

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel8.setForeground(new java.awt.Color(255, 153, 0));
        jPanel8.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 0));
        jButton1.setText("Nuevo Cliente");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel10.setForeground(new java.awt.Color(255, 153, 0));
        jPanel10.setToolTipText("");

        txtBuscarCliente.addActionListener(this::txtBuscarClienteActionPerformed);

        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Buscar Cliente:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBuscarCliente)
                .addComponent(jLabel7))
        );

        EliminarCliente.setBackground(new java.awt.Color(51, 51, 51));
        EliminarCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        EliminarCliente.setForeground(new java.awt.Color(255, 153, 0));
        EliminarCliente.setText("Borrar Cliente");
        EliminarCliente.addActionListener(this::EliminarClienteActionPerformed);

        ListaEstado2.addActionListener(this::ListaEstado2ActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ListaEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ListaEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 72, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Instanciar y abrir la pantalla para crear un nuevo cliente
        ClientesNew nuevaVentana = new ClientesNew();
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
        
        // Cerrar la pantalla actual
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarClienteActionPerformed
        // 1. Verificamos si hay alguna fila seleccionada
        int filaSeleccionada = jTable1.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente de la tabla primero.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Extraemos el ID y el Nombre de la fila seleccionada (La columna 0 es el ID, la 1 es el Nombre)
        int idCliente = (int) jTable1.getValueAt(filaSeleccionada, 0);
        String nombreCliente = (String) jTable1.getValueAt(filaSeleccionada, 1);

        // 3. Le preguntamos si está seguro de eliminarlo (medida de seguridad)
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, 
            "¿Está seguro que desea dar de baja al cliente: " + nombreCliente + "?", 
            "Confirmar Eliminación", 
            javax.swing.JOptionPane.YES_NO_OPTION, 
            javax.swing.JOptionPane.QUESTION_MESSAGE);

        // 4. Si dice que SÍ (YES_OPTION), lo borramos
        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            Dao.ClienteDAO dao = new Dao.ClienteDAO();
            
            // --- CORRECCIÓN AQUÍ: Borramos el int idAdminEnSesion = 1 y pasamos solo el idCliente ---
            if (dao.eliminarLogico(idCliente)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.");
                cargarTablaClientes(); // Recargamos la tabla para que desaparezca automáticamente
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar el cliente.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_EliminarClienteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    // Verificamos si el usuario hizo doble clic
        if (evt.getClickCount() == 2) {
            int filaSeleccionada = jTable1.getSelectedRow();
            
            if (filaSeleccionada != -1) {
                // Obtenemos el ID del cliente de la columna 0
                int idCliente = (int) jTable1.getValueAt(filaSeleccionada, 0);
                
                // Abrimos la pantalla de edición pasándole el ID
                ClienteEdit ventanaEditar = new ClienteEdit(idCliente);
                ventanaEditar.setVisible(true);
                this.dispose(); // Cerramos la ventana actual
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClienteActionPerformed
        cargarTablaClientes();
    }//GEN-LAST:event_txtBuscarClienteActionPerformed

    private void PerfilPanel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilPanel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerfilPanel1ActionPerformed

    private void ListaEstado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaEstado2ActionPerformed
        cargarTablaClientes();
    }//GEN-LAST:event_ListaEstado2ActionPerformed

    private void cargarListaEstados() {
    Dao.EstadoDAO estadoDao = new Dao.EstadoDAO();
        java.util.List<Entity.Estado> estados = estadoDao.listarPorModulo("Usuario");
        javax.swing.DefaultComboBoxModel<Entity.Estado> modelo = new javax.swing.DefaultComboBoxModel<>();


        for (Entity.Estado est : estados) {
            modelo.addElement(est);
        }
        
        ListaEstado2.setModel(modelo );
    }

    private void cargarTablaClientes() {
        // Obtener el texto de la barra de búsqueda
        String busqueda = txtBuscarCliente.getText(); 
        
        int idEstadoFiltro = -1; // Por defecto "Todos"
        
        // LEER DESDE EL COMBOBOX (ListaEstado2)
        Entity.Estado estadoSeleccionado = (Entity.Estado) ListaEstado2.getSelectedItem();
        if (estadoSeleccionado != null) {
            idEstadoFiltro = estadoSeleccionado.getIdEstado();
        }

        String[] titulos = {"ID Cliente", "Nombre y Apellido", "Estado", "Puntos", "Fecha Nac.", "Fecha Registro"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        Dao.ClienteDAO dao = new Dao.ClienteDAO();
        // Llamamos al nuevo método pasándole ambos filtros
        java.util.List<Entity.Cliente> lista = dao.listarFiltrado(busqueda, idEstadoFiltro);
        
        for (Entity.Cliente c : lista) {
            Object[] fila = new Object[6];
            fila[0] = c.getIdCliente();
            fila[1] = c.getNombre() + " " + c.getApellido();
            
            // Asignar el nombre del estado basándonos en el ID
            if (c.getIdEstado() == 1) fila[2] = "Activo";
            else if (c.getIdEstado() == 2) fila[2] = "Inactivo";
            else if (c.getIdEstado() == 3) fila[2] = "Eliminado";
            else fila[2] = "Desconocido";
            
            fila[3] = c.getPuntosFidelidad();
            fila[4] = c.getFecha_de_nacimiento();
            fila[5] = (c.getDateCreate() != null) ? c.getDateCreate().toString().substring(0, 10) : "-";
            
            modelo.addRow(fila);
        }
        

        jTable1.setModel(modelo);
        

        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CientesDash().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ClientesPanel;
    private javax.swing.JToggleButton DashboardPanel;
    private javax.swing.JButton EliminarCliente;
    private javax.swing.JToggleButton EmpleadosPanel;
    private javax.swing.JToggleButton FacturacionPanel;
    private javax.swing.JToggleButton GestinTurnoPanel;
    private javax.swing.JToggleButton InventarioPanel;
    private javax.swing.JComboBox<Entity.Estado> ListaEstado2;
    private javax.swing.JToggleButton PerfilPanel1;
    private javax.swing.JToggleButton ReportePanel;
    private javax.swing.JToggleButton ServiciosPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables
}
