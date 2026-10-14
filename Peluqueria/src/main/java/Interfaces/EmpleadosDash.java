package Interfaces;

import Dao.EmpleadoDAO;
import Dao.EstadoDAO;
import Entity.Empleado;
import Entity.Estado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadosDash extends javax.swing.JFrame {
    
    private javax.swing.Timer timerActualizacion;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EmpleadosDash.class.getName());

    public EmpleadosDash() {
        initComponents();
        this.setLocationRelativeTo(null); // Centra la ventana
        
        NavegacionUtils.configurarMenuLateral(
            this, DashboardPanel, GestinTurnoPanel, ClientesPanel, 
            EmpleadosPanel, ServiciosPanel, InventarioPanel, 
            FacturacionPanel, ReportePanel, ConfiguracionPanel
        );
        
        cargarListaEstados();
        cargarTablaEmpleados();
        
        timerActualizacion = new javax.swing.Timer(10000, new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            cargarTablaEmpleados();
        }
    });
    timerActualizacion.start(); // Arranca el contador

    }

    // --- MÉTODOS DE LÓGICA ---

    private void cargarListaEstados() {
        EstadoDAO estadoDao = new EstadoDAO();
        List<Estado> estados = estadoDao.listarPorModulo("Usuario");
        
        DefaultListModel<Estado> modeloLista = new DefaultListModel<>();
        
        // Opción "Todos"
        Estado estadoTodos = new Estado();
        estadoTodos.setIdEstado(-1);
        estadoTodos.setNombreEstado("Todos");
        modeloLista.addElement(estadoTodos);
        
        for (Estado est : estados) {
            modeloLista.addElement(est);
        }
        
        ListaEstados.setModel(modeloLista);
        ListaEstados.setSelectedIndex(0); 
    }

    private void cargarTablaEmpleados() {
        String textoBusqueda = CargarNombredelCliente.getText();
        
        Estado estadoSeleccionado = ListaEstados.getSelectedValue();
        int idEstadoFiltro = -1;
        if (estadoSeleccionado != null) {
            idEstadoFiltro = estadoSeleccionado.getIdEstado();
        }

        String[] titulos = {"ID Empleado", "Nombre y Apellido", "Estado", "Especialidad", "Sueldo", "Fecha de Ingreso"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        
        EmpleadoDAO dao = new EmpleadoDAO();
        List<Empleado> lista = dao.listarFiltrado(textoBusqueda, idEstadoFiltro);
        
        for (Empleado e : lista) {
            Object[] fila = new Object[6];
            fila[0] = e.getIdEmpleado();
            fila[1] = e.getNombre() + " " + e.getApellido();
            fila[2] = (e.getIdEstado() == 1) ? "Activo" : "Inactivo"; 
            fila[3] = e.getEspecialidad();
            fila[4] = "$" + e.getSueldo(); 
            
            if(e.getDateCreate() != null) {
                fila[5] = e.getDateCreate().toString().substring(0, 10);
            } else {
                fila[5] = "-";
            }
            modelo.addRow(fila);
        }
        jTable1.setModel(modelo);
    }


    private void abrirPantallaEdicion(int idEmpleado) {
        EmpleadoEdit editarVentana = new EmpleadoEdit(idEmpleado);
        editarVentana.setVisible(true);
        this.dispose();
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
        ConfiguracionPanel = new javax.swing.JToggleButton();
        ReportePanel = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CrearCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaEstados = new javax.swing.JList<>();
        jPanel10 = new javax.swing.JPanel();
        CargarNombredelCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        EliminarCliente = new javax.swing.JButton();

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

        ConfiguracionPanel.setBackground(new java.awt.Color(51, 51, 51));
        ConfiguracionPanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        ConfiguracionPanel.setForeground(new java.awt.Color(255, 153, 0));
        ConfiguracionPanel.setText("Configuración");

        ReportePanel.setBackground(new java.awt.Color(51, 51, 51));
        ReportePanel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        ReportePanel.setForeground(new java.awt.Color(255, 153, 0));
        ReportePanel.setText("Reportes");

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
                            .addComponent(ConfiguracionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(ConfiguracionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                .addContainerGap())
        );

        CrearCliente.setBackground(new java.awt.Color(51, 51, 51));
        CrearCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        CrearCliente.setForeground(new java.awt.Color(255, 153, 0));
        CrearCliente.setText("Nuevo Empleado");
        CrearCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CrearCliente.setBorderPainted(false);
        CrearCliente.addActionListener(this::CrearClienteActionPerformed);

        ListaEstados.setForeground(new java.awt.Color(255, 153, 0));
        ListaEstados.addListSelectionListener(this::ListaEstadosValueChanged);
        jScrollPane2.setViewportView(ListaEstados);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        jPanel10.setForeground(new java.awt.Color(255, 153, 0));
        jPanel10.setToolTipText("");

        CargarNombredelCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CargarNombredelClienteKeyReleased(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Buscar Empleado:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CargarNombredelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CargarNombredelCliente)
                .addComponent(jLabel7))
        );

        EliminarCliente.setBackground(new java.awt.Color(51, 51, 51));
        EliminarCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        EliminarCliente.setForeground(new java.awt.Color(255, 153, 0));
        EliminarCliente.setText("Borrar Empleado");
        EliminarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EliminarCliente.setBorderPainted(false);
        EliminarCliente.addActionListener(this::EliminarClienteActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(EliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(CrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearClienteActionPerformed
        EmpleadosNew nuevaVentana = new EmpleadosNew();
        nuevaVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CrearClienteActionPerformed

    private void EliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarClienteActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un empleado de la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idEmpleado = (int) jTable1.getValueAt(filaSeleccionada, 0);
        String nombreEmpleado = (String) jTable1.getValueAt(filaSeleccionada, 1);

        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro que desea eliminar al empleado: " + nombreEmpleado + "?\nEsta acción no se puede deshacer.",
            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {
            EmpleadoDAO dao = new EmpleadoDAO();
            int idAdminSimulado = 4; // Usuario en sesión
            
            boolean exito = dao.eliminarLogico(idEmpleado, idAdminSimulado);
            
            if (exito) {
                JOptionPane.showMessageDialog(this, "Empleado eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTablaEmpleados(); // Refrescar la tabla
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_EliminarClienteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Verifica si el usuario hizo 2 clics
        if (evt.getClickCount() == 2) { 
            int filaSeleccionada = jTable1.getSelectedRow();
            if (filaSeleccionada != -1) {
                // Obtiene el ID de la columna 0
                int idEmpleado = (int) jTable1.getValueAt(filaSeleccionada, 0);
                abrirPantallaEdicion(idEmpleado);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void CargarNombredelClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CargarNombredelClienteKeyReleased
        cargarTablaEmpleados();
    }//GEN-LAST:event_CargarNombredelClienteKeyReleased

    private void ListaEstadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaEstadosValueChanged
        if (!evt.getValueIsAdjusting()) {
            cargarTablaEmpleados(); // Actualiza la tabla con el estado seleccionado
        }
    }//GEN-LAST:event_ListaEstadosValueChanged


    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(() -> new EmpleadosDash().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CargarNombredelCliente;
    private javax.swing.JToggleButton ClientesPanel;
    private javax.swing.JToggleButton ConfiguracionPanel;
    private javax.swing.JButton CrearCliente;
    private javax.swing.JToggleButton DashboardPanel;
    private javax.swing.JButton EliminarCliente;
    private javax.swing.JToggleButton EmpleadosPanel;
    private javax.swing.JToggleButton FacturacionPanel;
    private javax.swing.JToggleButton GestinTurnoPanel;
    private javax.swing.JToggleButton InventarioPanel;
    private javax.swing.JList<Entity.Estado> ListaEstados;
    private javax.swing.JToggleButton ReportePanel;
    private javax.swing.JToggleButton ServiciosPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
