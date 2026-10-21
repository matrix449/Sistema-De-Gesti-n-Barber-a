package Interfaces;

import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class NavegacionUtils {

    public static void configurarMenuLateral(
            JFrame ventanaActual,
            JToggleButton dashboardPanel,
            JToggleButton gestinTurnoPanel,
            JToggleButton clientesPanel,
            JToggleButton empleadosPanel,
            JToggleButton serviciosPanel,
            JToggleButton inventarioPanel,
            JToggleButton facturacionPanel,
            JToggleButton reportePanel,
            JToggleButton perfilPanel1) {

        dashboardPanel.addActionListener(e -> cambiarVentana(ventanaActual, new PanelDeControl()));
        gestinTurnoPanel.addActionListener(e -> cambiarVentana(ventanaActual, new GestionDash()));
        clientesPanel.addActionListener(e -> cambiarVentana(ventanaActual, new CientesDash())); 
        empleadosPanel.addActionListener(e -> cambiarVentana(ventanaActual, new EmpleadosDash()));
        serviciosPanel.addActionListener(e -> cambiarVentana(ventanaActual, new ServiciosDash()));
        inventarioPanel.addActionListener(e -> cambiarVentana(ventanaActual, new InventarioDash()));
        facturacionPanel.addActionListener(e -> cambiarVentana(ventanaActual, new FacturacionDash()));
        reportePanel.addActionListener(e -> cambiarVentana(ventanaActual, new ReportesDash()));
        perfilPanel1.addActionListener(e -> cambiarVentana(ventanaActual, new PerfilUsuario()));
        
    }

    private static void cambiarVentana(JFrame actual, JFrame nueva) {
        nueva.setVisible(true);
        nueva.setLocationRelativeTo(null);
        actual.dispose();
    }
}