package Dao;

import config.Conexion;
import Entity.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class LogDAO {

    public boolean insertarLog(Log log) {
        // Se omiten los campos de update porque un log normalmente no se modifica[cite: 5]
        String sql = "INSERT INTO logs (id_usuario, tabla_afectada, accion, descripcion, fecha_log, id_user_created, date_create) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, log.getIdUsuario());
            ps.setString(2, log.getTablaAfectada());
            ps.setString(3, log.getAccion());
            ps.setString(4, log.getDescripcion());
            
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(5, fechaActual);
            ps.setInt(6, log.getIdUserCreated());
            ps.setTimestamp(7, fechaActual);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar log: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}