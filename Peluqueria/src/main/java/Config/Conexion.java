package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(
                "No se encontró la clase del Driver de MySQL en el Classpath",
                e
            );
        }

        String url = "jdbc:mysql://localhost:3305/peluqueria";
        String user = "root";
        String pass = "";

        return DriverManager.getConnection(url, user, pass);
    }

    // Probar la conexión
    public static void main(String[] args) {
        try (Connection conexion = getConnection()) {
            if (conexion != null && !conexion.isClosed()) {
                System.out.println("✅ Conexión exitosa a la base de datos.");
            } else {
                System.out.println("❌ No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}