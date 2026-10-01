package Test;

import Interfaces.PanelDeControl;

public class Main {
    
    public static void main(String[] args) {
        
        // Se utiliza EventQueue para asegurar que la interfaz gráfica corra en su propio hilo
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Instanciamos la ventana principal y la hacemos visible
                PanelDeControl inicio = new PanelDeControl();
                inicio.setVisible(true);
            }
        });
        
    }
}