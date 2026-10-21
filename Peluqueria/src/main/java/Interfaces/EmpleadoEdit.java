
package Interfaces;


public class EmpleadoEdit extends javax.swing.JFrame {
    
    private int idEmpleadoSeleccionado;
    private int idUsuarioRelacionado;
    private String passwordActual;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EmpleadoEdit.class.getName());


    // --- 1. CONSTRUCTOR MODIFICADO ---
    public EmpleadoEdit(int idEmpleado) {
    initComponents();
        this.setLocationRelativeTo(null); // Centra la ventana
        
        // --- NUEVO: Configuración de permisos y datos de Sesión ---
        jLabel5.setText(Entity.Sesion.getNombreCompletoActual());
        if (Entity.Sesion.getIdRolActual() == 1) {
            jLabel4.setText("Administrador");
        } else {
            jLabel4.setText("Empleado");
            EmpleadosPanel.setVisible(false); // Ocultar el menú de empleados por seguridad
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

        // Guardamos el ID y cargamos los datos
        this.idEmpleadoSeleccionado = idEmpleado;
        cargarDatosEmpleado(idEmpleado);
    }

    // --- 2. MÉTODO PARA CARGAR DATOS EN LOS RECUADROS ---
    private void cargarDatosEmpleado(int id) {
        Dao.EmpleadoDAO dao = new Dao.EmpleadoDAO();
        Object[] datos = dao.obtenerPorId(id); 
        
        if (datos != null && datos[0] != null && datos[1] != null) {
            Entity.Empleado empleado = (Entity.Empleado) datos[0];
            Entity.Usuario usuario = (Entity.Usuario) datos[1];
            
            this.idUsuarioRelacionado = empleado.getIdUsuario(); 
            // ¡MAGIA! Guardamos la contraseña en segundo plano
            this.passwordActual = usuario.getPassword(); 
            
            // Rellenamos los campos visuales
            NombreEmpleRell.setText(usuario.getNombre());
            ApellidoEmpleRell.setText(usuario.getApellido());
            TelefoRell.setText(usuario.getTelefono());
            EmailRell.setText(usuario.getEmail());
            // (Ya no rellenamos ContraseñaRell porque lo eliminamos visualmente)
            EspecialidadRell.setText(empleado.getEspecialidad());
            SueldoRell.setText(String.valueOf(empleado.getSueldo()));
            
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar los datos del empleado.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        ClientesPanel = new javax.swing.JToggleButton();
        DashboardPanel = new javax.swing.JToggleButton();
        EmpleadosPanel = new javax.swing.JToggleButton();
        ServiciosPanel = new javax.swing.JToggleButton();
        InventarioPanel = new javax.swing.JToggleButton();
        GestinTurnoPanel = new javax.swing.JToggleButton();
        FacturacionPanel = new javax.swing.JToggleButton();
        ReportePanel = new javax.swing.JToggleButton();
        PerfilPanel1 = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        NombreEmpleRell = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TelefoRell = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        EspecialidadRell = new javax.swing.JTextField();
        BotonCrearEmpleado = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ApellidoEmpleRell = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        EmailRell = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        SueldoRell = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 3));
        jPanel1.setForeground(new java.awt.Color(255, 153, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 720));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel2.setForeground(new java.awt.Color(255, 153, 0));
        jPanel2.setToolTipText("");

        jLabel3.setBackground(new java.awt.Color(255, 153, 0));
        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Empleados");

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

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel4.setForeground(new java.awt.Color(255, 153, 0));
        jPanel4.setToolTipText("");

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel5.setForeground(new java.awt.Color(255, 153, 0));
        jPanel5.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

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
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmpleadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ServiciosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InventarioPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FacturacionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReportePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PerfilPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel7.setForeground(new java.awt.Color(255, 153, 0));
        jPanel7.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Teléfono:");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Especialidad:");

        EspecialidadRell.setMinimumSize(new java.awt.Dimension(13, 36));

        BotonCrearEmpleado.setBackground(new java.awt.Color(102, 102, 102));
        BotonCrearEmpleado.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        BotonCrearEmpleado.setForeground(new java.awt.Color(255, 153, 0));
        BotonCrearEmpleado.setText("ModificarEmpleado");
        BotonCrearEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        BotonCrearEmpleado.addActionListener(this::BotonCrearEmpleadoActionPerformed);

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Apellido:");

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Email:");

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("Sueldo:");

        SueldoRell.setMinimumSize(new java.awt.Dimension(13, 36));
        SueldoRell.addActionListener(this::SueldoRellActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EspecialidadRell, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NombreEmpleRell, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ApellidoEmpleRell, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TelefoRell, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailRell, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SueldoRell, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonCrearEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreEmpleRell, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ApellidoEmpleRell, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(EspecialidadRell, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TelefoRell, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(EmailRell, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(SueldoRell, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonCrearEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearEmpleadoActionPerformed
        String nombre = NombreEmpleRell.getText().trim();
        String apellido = ApellidoEmpleRell.getText().trim();
        String telefono = TelefoRell.getText().trim();
        String email = EmailRell.getText().trim();
        String especialidad = EspecialidadRell.getText().trim();
        String sueldoStr = SueldoRell.getText().trim();

        // Eliminamos la validación de la contraseña
        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || sueldoStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete al menos Nombre, Apellido, Email y Sueldo.");
            return;
        }
        
        double sueldo;
        try {
            sueldo = Double.parseDouble(sueldoStr); 
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El sueldo debe ser un número válido (ej: 45000.50).");
            return;
        }

        // Armamos el Usuario
        Entity.Usuario u = new Entity.Usuario();
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setTelefono(telefono);
        u.setEmail(email);
        // Le devolvemos su contraseña original para que el DAO no la borre
        u.setPassword(this.passwordActual); 

        // Armamos el Empleado
        Entity.Empleado e = new Entity.Empleado();
        e.setIdEmpleado(this.idEmpleadoSeleccionado);
        e.setIdUsuario(this.idUsuarioRelacionado);
        e.setEspecialidad(especialidad);
        e.setSueldo(sueldo);

        // Enviamos al DAO
        Dao.EmpleadoDAO dao = new Dao.EmpleadoDAO();
        if (dao.modificarCompleto(u, e)) {
            javax.swing.JOptionPane.showMessageDialog(this, "¡Empleado modificado exitosamente!");
            // Volvemos al Dashboard de empleados
            EmpleadosDash dash = new EmpleadosDash();
            dash.setVisible(true);
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al modificar en la base de datos.");
        }
    }//GEN-LAST:event_BotonCrearEmpleadoActionPerformed

    private void SueldoRellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueldoRellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueldoRellActionPerformed

    private void PerfilPanel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilPanel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerfilPanel1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new EmpleadoEdit(1).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidoEmpleRell;
    private javax.swing.JButton BotonCrearEmpleado;
    private javax.swing.JToggleButton ClientesPanel;
    private javax.swing.JToggleButton DashboardPanel;
    private javax.swing.JTextField EmailRell;
    private javax.swing.JToggleButton EmpleadosPanel;
    private javax.swing.JTextField EspecialidadRell;
    private javax.swing.JToggleButton FacturacionPanel;
    private javax.swing.JToggleButton GestinTurnoPanel;
    private javax.swing.JToggleButton InventarioPanel;
    private javax.swing.JTextField NombreEmpleRell;
    private javax.swing.JToggleButton PerfilPanel1;
    private javax.swing.JToggleButton ReportePanel;
    private javax.swing.JToggleButton ServiciosPanel;
    private javax.swing.JTextField SueldoRell;
    private javax.swing.JTextField TelefoRell;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
