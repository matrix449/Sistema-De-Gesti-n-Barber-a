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
        // Filtramos por estado 1 (activo) y limitamos a 100
        String sql = "SELECT * FROM clientes WHERE id_estado = 1 LIMIT 100";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente")); //[cite: 2]
                cliente.setIdUsuario(rs.getInt("id_usuario")); //[cite: 2]
                cliente.setIdEstado(rs.getInt("id_estado")); //[cite: 2]
                cliente.setPuntosFidelidad(rs.getDouble("puntos_fidelidad")); //[cite: 2]
                cliente.setDeletedAt(rs.getTimestamp("deleted_at")); //[cite: 2]
                cliente.setIdUserCreated(rs.getInt("id_user_created")); //[cite: 2]
                cliente.setIdUserUpdate(rs.getInt("id_user_update")); //[cite: 2]
                cliente.setDateCreate(rs.getTimestamp("date_create")); //[cite: 2]
                cliente.setDateUpdate(rs.getTimestamp("date_update")); //[cite: 2]
                
                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
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