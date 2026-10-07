package Dao;

import config.Conexion;
import Entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean crear(Cliente cliente) {
        String sql = "INSERT INTO clientes (id_usuario, id_estado, puntos_fidelidad, id_user_created, date_create) VALUES (?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdUsuario());
            ps.setInt(2, 1); // 1 = Activo por defecto
            ps.setDouble(3, cliente.getPuntosFidelidad());
            ps.setInt(4, cliente.getIdUserCreated());
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear cliente: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones(con, ps);
        }
    }

    public boolean modificar(Cliente cliente) {
        String sql = "UPDATE clientes SET puntos_fidelidad = ?, id_user_update = ?, date_update = ? WHERE id_cliente = ?";
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, cliente.getPuntosFidelidad());
            ps.setInt(2, cliente.getIdUserUpdate());
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setInt(4, cliente.getIdCliente());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones(con, ps);
        }
    }

    public boolean eliminarLogico(int idCliente, int idUserDelete) {
        String sql = "UPDATE clientes SET id_estado = 0, deleted_at = ?, id_user_update = ? WHERE id_cliente = ?";
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setInt(2, idUserDelete); 
            ps.setInt(3, idCliente);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones(con, ps);
        }
    }
    
public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        
        // Consulta cruzada con INNER JOIN usando alias (c para clientes, u para usuarios)
        String sql = "SELECT c.id_cliente, c.id_estado, c.puntos_fidelidad, c.fecha_de_nacimiento, c.date_create, "
                   + "u.nombre, u.apellido "
                   + "FROM clientes c "
                   + "INNER JOIN usuarios u ON c.id_usuario = u.id_usuario "
                   + "WHERE c.id_estado = 1 LIMIT 100";
                   
        java.sql.Connection con = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        
        try {
            con = config.Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente")); 
                cliente.setIdEstado(rs.getInt("id_estado")); 
                cliente.setPuntosFidelidad(rs.getDouble("puntos_fidelidad")); 
                cliente.setFecha_de_nacimiento(rs.getString("fecha_de_nacimiento"));
                cliente.setDateCreate(rs.getTimestamp("date_create")); 
                
                // Guardamos los datos que trajimos de la tabla usuarios
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                
                lista.add(cliente);
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Error al listar clientes con JOIN: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (java.sql.SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return lista;
    }

    // Método auxiliar para no repetir el bloque try-catch al cerrar
    private void cerrarConexiones(Connection con, PreparedStatement ps) {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}