package Dao;

import config.Conexion;
import Entity.Cliente;
import Entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // --- 1. CREAR CLIENTE (Y SU USUARIO) ---
    public boolean crear(Usuario usuario, Cliente cliente) {
        String sqlUsuario = "INSERT INTO usuarios (id_rol, id_estado, nombre, apellido, telefono, email, password, id_user_created, date_create) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlCliente = "INSERT INTO clientes (id_usuario, id_estado, puntos_fidelidad, fecha_de_nacimiento, id_user_created, date_create) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection con = null;
        PreparedStatement psUsuario = null;
        PreparedStatement psCliente = null;
        ResultSet rs = null;
        boolean exito = false;
        
        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false); // Iniciamos la transacción
            
            // 1er INSERT: Tabla Usuarios
            psUsuario = con.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
            psUsuario.setInt(1, usuario.getIdRol());
            psUsuario.setInt(2, 1); // Activo
            psUsuario.setString(3, usuario.getNombre());
            psUsuario.setString(4, usuario.getApellido());
            psUsuario.setString(5, usuario.getTelefono());
            psUsuario.setString(6, usuario.getEmail());
            psUsuario.setString(7, usuario.getPassword());
            psUsuario.setInt(8, 4);
            psUsuario.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
            
            int filasUsuario = psUsuario.executeUpdate();
            
            if (filasUsuario > 0) {
                rs = psUsuario.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    
                    // 2do INSERT: Tabla Clientes
                    psCliente = con.prepareStatement(sqlCliente);
                    psCliente.setInt(1, idGenerado);
                    psCliente.setInt(2, 1);
                    psCliente.setDouble(3, cliente.getPuntosFidelidad());
                    psCliente.setString(4, cliente.getFecha_de_nacimiento());
                    psCliente.setInt(5, 4);
                    psCliente.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                    
                    int filasCliente = psCliente.executeUpdate();
                    
                    if (filasCliente > 0) {
                        con.commit(); 
                        exito = true;
                    } else {
                        con.rollback(); 
                    }
                }
            }
        } catch (SQLException e) {
            try { if (con != null) con.rollback(); } catch (SQLException ex) {} 
            System.out.println("Error al crear cliente completo: " + e.getMessage());
        } finally {
            cerrarConexiones(con, psUsuario, rs);
            if (psCliente != null) try { psCliente.close(); } catch(SQLException e){}
        }
        return exito;
    }

    
    // --- 2. OBTENER CLIENTE POR ID ---
    public Object[] obtenerPorId(int idCliente) {
        Object[] resultado = new Object[2]; 
        
        String sql = "SELECT c.id_cliente, c.id_usuario, c.fecha_de_nacimiento, " +
                     "u.nombre, u.apellido, u.telefono, u.email, u.password " +
                     "FROM clientes c INNER JOIN usuarios u ON c.id_usuario = u.id_usuario " +
                     "WHERE c.id_cliente = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setIdUsuario(rs.getInt("id_usuario"));
                c.setFecha_de_nacimiento(rs.getString("fecha_de_nacimiento"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setTelefono(rs.getString("telefono")); 
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                
                resultado[0] = c;
                resultado[1] = u;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cliente: " + e.getMessage());
        } finally {
            cerrarConexiones(con, ps, rs);
        }
        return resultado; 
    }
    
    // --- 3. MODIFICAR CLIENTE (Con logs de Update) ---
    public boolean modificarCompleto(Usuario usuario, Cliente cliente) {
        
        String sqlUsuario = "UPDATE usuarios SET nombre = ?, apellido = ?, telefono = ?, email = ?, password = ?, id_user_update = ?, date_update = ? WHERE id_usuario = ?";
        String sqlCliente = "UPDATE clientes SET fecha_de_nacimiento = ?, id_user_update = ?, date_update = ? WHERE id_cliente = ?";
        
        Connection con = null;
        PreparedStatement psUsuario = null;
        PreparedStatement psCliente = null;
        boolean exito = false;
        
        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false); 
            
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
            
            // 1. Modificamos al usuario
            psUsuario = con.prepareStatement(sqlUsuario);
            psUsuario.setString(1, usuario.getNombre());
            psUsuario.setString(2, usuario.getApellido());
            psUsuario.setString(3, usuario.getTelefono());
            psUsuario.setString(4, usuario.getEmail());
            psUsuario.setString(5, usuario.getPassword());
            psUsuario.setInt(6, 4);
            psUsuario.setTimestamp(7, fechaActual); // Fecha actual
            psUsuario.setInt(8, cliente.getIdUsuario());
            
            int filasUs = psUsuario.executeUpdate();
            
            // 2. Modificamos al cliente
            psCliente = con.prepareStatement(sqlCliente);
            psCliente.setString(1, cliente.getFecha_de_nacimiento());
            psCliente.setInt(2, 4);
            psCliente.setTimestamp(3, fechaActual); // Fecha actual
            psCliente.setInt(4, cliente.getIdCliente());
            
            int filasCl = psCliente.executeUpdate();
            
            if (filasUs > 0 && filasCl > 0) {
                con.commit(); 
                exito = true;
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            try { if (con != null) con.rollback(); } catch (SQLException ex) {}
            System.out.println("Error al modificar completo: " + e.getMessage());
        } finally {
            cerrarConexiones(con, psUsuario, null);
            if (psCliente != null) try { psCliente.close(); } catch(SQLException e){}
        }
        return exito;
    }

    // --- 4. ELIMINAR CLIENTE ---
    public boolean eliminarLogico(int idCliente, int idAdminEnSesion) {
        String sqlBaja = "UPDATE clientes SET id_estado = 0, deleted_at = ?, id_user_update = ? WHERE id_cliente = ?";
        String sqlLog = "INSERT INTO logs (id_usuario, tabla_afectada, accion, descripcion, fecha_log, id_user_created, date_create) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection con = null;
        PreparedStatement psBaja = null;
        PreparedStatement psLog = null;
        boolean exito = false;
        
        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false); 
            
            // 1. Damos de baja al cliente
            psBaja = con.prepareStatement(sqlBaja);
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
            psBaja.setTimestamp(1, fechaActual);
            psBaja.setInt(2, 4);
            psBaja.setInt(3, idCliente);
            
            if (psBaja.executeUpdate() > 0) {
                // 2. Si se dio de baja bien, insertamos el LOG
                psLog = con.prepareStatement(sqlLog);
                psLog.setInt(1, 4);
                psLog.setString(2, "clientes");
                psLog.setString(3, "ELIMINAR");
                psLog.setString(4, "Se dio de baja lógicamente al cliente ID: " + idCliente);
                psLog.setTimestamp(5, fechaActual);
                psLog.setInt(6, 4);
                psLog.setTimestamp(7, fechaActual);
                
                if (psLog.executeUpdate() > 0) {
                    con.commit(); 
                    exito = true;
                } else {
                    con.rollback();
                }
            }
        } catch (SQLException e) {
            try { if (con != null) con.rollback(); } catch (SQLException ex) {}
            System.out.println("Error al eliminar cliente y generar log: " + e.getMessage());
        } finally {
            cerrarConexiones(con, psBaja, null);
            if (psLog != null) try { psLog.close(); } catch(SQLException e){}
        }
        return exito;
    }

    // --- 5. LISTAR CLIENTES ---
// --- NUEVO: LISTAR CLIENTES FILTRADOS ---
    public List<Cliente> listarFiltrado(String textoBusqueda, int idEstado) {
        List<Cliente> lista = new ArrayList<>();
        
        // Empezamos la consulta base
        StringBuilder sql = new StringBuilder(
            "SELECT c.id_cliente, c.id_estado, c.puntos_fidelidad, c.fecha_de_nacimiento, c.date_create, u.nombre, u.apellido " +
            "FROM clientes c INNER JOIN usuarios u ON c.id_usuario = u.id_usuario WHERE 1=1 "
        );
        
        // Si hay texto, filtramos por nombre o apellido
        boolean hayBusqueda = (textoBusqueda != null && !textoBusqueda.trim().isEmpty());
        if (hayBusqueda) {
            sql.append("AND (u.nombre LIKE ? OR u.apellido LIKE ?) ");
        }
        
        // Si el estado es distinto de -1 ("Todos"), filtramos por estado
        boolean hayEstado = (idEstado != -1);
        if (hayEstado) {
            sql.append("AND c.id_estado = ? ");
        }
        
        sql.append("LIMIT 100");
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql.toString());
            
            int paramIndex = 1;
            if (hayBusqueda) {
                ps.setString(paramIndex++, "%" + textoBusqueda.trim() + "%");
                ps.setString(paramIndex++, "%" + textoBusqueda.trim() + "%");
            }
            if (hayEstado) {
                ps.setInt(paramIndex, idEstado);
            }
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente")); 
                c.setIdEstado(rs.getInt("id_estado")); 
                c.setPuntosFidelidad(rs.getDouble("puntos_fidelidad")); 
                c.setFecha_de_nacimiento(rs.getString("fecha_de_nacimiento"));
                c.setDateCreate(rs.getTimestamp("date_create")); 
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al filtrar clientes: " + e.getMessage());
        } finally {
            cerrarConexiones(con, ps, rs);
        }
        return lista;
    }

    // Método auxiliar para limpiar recursos
    private void cerrarConexiones(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) { }
    }
}