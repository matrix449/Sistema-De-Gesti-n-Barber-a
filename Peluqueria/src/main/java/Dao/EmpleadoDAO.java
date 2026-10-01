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
    
    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        // Filtramos por estado 1 (activo) y limitamos a 100
        String sql = "SELECT * FROM empleados WHERE id_estado = 1 LIMIT 100";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado")); //[cite: 3]
                empleado.setIdUsuario(rs.getInt("id_usuario")); //[cite: 3]
                empleado.setIdEstado(rs.getInt("id_estado")); //[cite: 3]
                empleado.setEspecialidad(rs.getString("especialidad")); //[cite: 3]
                empleado.setSueldo(rs.getDouble("sueldo")); //[cite: 3]
                empleado.setDeletedAt(rs.getTimestamp("deleted_at")); //[cite: 3]
                empleado.setIdUserCreated(rs.getInt("id_user_created")); //[cite: 3]
                empleado.setIdUserUpdate(rs.getInt("id_user_update")); //[cite: 3]
                empleado.setDateCreate(rs.getTimestamp("date_create")); //[cite: 3]
                empleado.setDateUpdate(rs.getTimestamp("date_update")); //[cite: 3]
                
                lista.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
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