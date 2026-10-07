package Dao;

import config.Conexion;
import Entity.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {

    public boolean crear(Empleado empleado) {
        String sql = "INSERT INTO empleados (id_usuario, id_estado, especialidad, sueldo, id_user_created, date_create) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, empleado.getIdUsuario());
            ps.setInt(2, 1); // 1 = Activo
            ps.setString(3, empleado.getEspecialidad());
            ps.setDouble(4, empleado.getSueldo());
            ps.setInt(5, empleado.getIdUserCreated());
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear empleado: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones(con, ps);
        }
    }

    public boolean modificar(Empleado empleado) {
        String sql = "UPDATE empleados SET especialidad = ?, sueldo = ?, id_user_update = ?, date_update = ? WHERE id_empleado = ?";
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getEspecialidad());
            ps.setDouble(2, empleado.getSueldo());
            ps.setInt(3, empleado.getIdUserUpdate());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setInt(5, empleado.getIdEmpleado());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar empleado: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones(con, ps);
        }
    }

    public boolean eliminarLogico(int idEmpleado, int idUserDelete) {
        String sql = "UPDATE empleados SET id_estado = 0, deleted_at = ?, id_user_update = ? WHERE id_empleado = ?";
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setInt(2, idUserDelete);
            ps.setInt(3, idEmpleado);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones(con, ps);
        }
    }
    
    public java.util.List<Empleado> listar() {
        java.util.List<Empleado> lista = new java.util.ArrayList<>();
        
        // Consulta cruzada con INNER JOIN
        String sql = "SELECT e.id_empleado, e.id_estado, e.especialidad, e.sueldo, e.date_create, "
                   + "u.nombre, u.apellido "
                   + "FROM empleados e "
                   + "INNER JOIN usuarios u ON e.id_usuario = u.id_usuario "
                   + "WHERE e.id_estado = 1 LIMIT 100";
                   
        java.sql.Connection con = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        
        try {
            con = config.Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado")); 
                empleado.setIdEstado(rs.getInt("id_estado")); 
                empleado.setEspecialidad(rs.getString("especialidad")); 
                empleado.setSueldo(rs.getDouble("sueldo")); 
                empleado.setDateCreate(rs.getTimestamp("date_create")); 
                
                // Guardamos los datos traídos de la tabla usuarios
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                
                lista.add(empleado);
            }
        } catch (java.sql.SQLException ex) {
            System.out.println("Error al listar empleados con JOIN: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (java.sql.SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return lista;
    }

    private void cerrarConexiones(Connection con, PreparedStatement ps) {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}