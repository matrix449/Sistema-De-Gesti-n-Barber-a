package Test;

import Interfaces.IniciodeSesion;

public class Main {
    
public static void main(String[] args) {
        
        // Se utiliza EventQueue para asegurar que la interfaz gráfica corra en su propio hilo
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Instanciamos la ventana de inicio de sesión y la hacemos visible
                IniciodeSesion login = new IniciodeSesion();
                login.setVisible(true);
            }
        });
        
    }
}