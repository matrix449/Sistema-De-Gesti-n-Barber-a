package Dao;

import config.Conexion;
import Entity.Empleado;
import Entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    // --- 1. CREAR EMPLEADO (Y SU USUARIO) ---
    public boolean crear(Usuario usuario, Empleado empleado) {
        // CORREGIDO: id_user_create sin "d" en ambas tablas
        String sqlUsuario = "INSERT INTO usuarios (id_rol, id_estado, nombre, apellido, telefono, email, password, id_user_create, date_create) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlEmpleado = "INSERT INTO empleados (id_usuario, id_estado, especialidad, sueldo, id_user_create, date_create) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection con = null;
        PreparedStatement psUsuario = null;
        PreparedStatement psEmpleado = null;
        ResultSet rs = null;
        boolean exito = false;
        
        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false); 
            
            psUsuario = con.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
            psUsuario.setInt(1, usuario.getIdRol()); // 2 = Empleado
            psUsuario.setInt(2, 1); 
            psUsuario.setString(3, usuario.getNombre());
            psUsuario.setString(4, usuario.getApellido());
            psUsuario.setString(5, usuario.getTelefono());
            psUsuario.setString(6, usuario.getEmail());
            psUsuario.setString(7, usuario.getPassword());
            psUsuario.setInt(8, 4); // Admin 4
            psUsuario.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
            
            if (psUsuario.executeUpdate() > 0) {
                rs = psUsuario.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    
                    psEmpleado = con.prepareStatement(sqlEmpleado);
                    psEmpleado.setInt(1, idGenerado);
                    psEmpleado.setInt(2, 1); 
                    psEmpleado.setString(3, empleado.getEspecialidad());
                    psEmpleado.setDouble(4, empleado.getSueldo());
                    psEmpleado.setInt(5, 4); // Admin 4
                    psEmpleado.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                    
                    if (psEmpleado.executeUpdate() > 0) {
                        con.commit(); 
                        exito = true;
                    } else {
                        con.rollback(); 
                    }
                }
            }
        } catch (SQLException e) {
            try { if (con != null) con.rollback(); } catch (SQLException ex) {} 
            System.out.println("Error al crear empleado completo: " + e.getMessage());
        } finally {
            cerrarConexiones(con, psUsuario, rs);
            if (psEmpleado != null) try { psEmpleado.close(); } catch(SQLException e){}
        }
        return exito;
    }

    // --- 2. OBTENER EMPLEADO POR ID ---
    public Object[] obtenerPorId(int idEmpleado) {
        Object[] resultado = new Object[2]; 
        
        String sql = "SELECT e.id_empleado, e.id_usuario, e.especialidad, e.sueldo, " +
                     "u.nombre, u.apellido, u.telefono, u.email, u.password " +
                     "FROM empleados e INNER JOIN usuarios u ON e.id_usuario = u.id_usuario " +
                     "WHERE e.id_empleado = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("id_empleado"));
                e.setIdUsuario(rs.getInt("id_usuario"));
                e.setEspecialidad(rs.getString("especialidad"));
                e.setSueldo(rs.getDouble("sueldo"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setTelefono(rs.getString("telefono")); 
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                
                resultado[0] = e;
                resultado[1] = u;
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener empleado: " + ex.getMessage());
        } finally {
            cerrarConexiones(con, ps, rs);
        }
        return resultado; 
    }

    // --- 3. MODIFICAR EMPLEADO COMPLETO ---
    public boolean modificarCompleto(Usuario usuario, Empleado empleado) {
        String sqlUsuario = "UPDATE usuarios SET nombre = ?, apellido = ?, telefono = ?, email = ?, password = ?, id_user_update = ?, date_update = ? WHERE id_usuario = ?";
        String sqlEmpleado = "UPDATE empleados SET especialidad = ?, sueldo = ?, id_user_update = ?, date_update = ? WHERE id_empleado = ?";
        
        Connection con = null;
        PreparedStatement psUsuario = null;
        PreparedStatement psEmpleado = null;
        boolean exito = false;
        
        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false); 
            
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
            
            psUsuario = con.prepareStatement(sqlUsuario);
            psUsuario.setString(1, usuario.getNombre());
            psUsuario.setString(2, usuario.getApellido());
            psUsuario.setString(3, usuario.getTelefono());
            psUsuario.setString(4, usuario.getEmail());
            psUsuario.setString(5, usuario.getPassword());
            psUsuario.setInt(6, 4); 
            psUsuario.setTimestamp(7, fechaActual);
            psUsuario.setInt(8, empleado.getIdUsuario());
            
            int filasUs = psUsuario.executeUpdate();
            
            psEmpleado = con.prepareStatement(sqlEmpleado);
            psEmpleado.setString(1, empleado.getEspecialidad());
            psEmpleado.setDouble(2, empleado.getSueldo());
            psEmpleado.setInt(3, 4); 
            psEmpleado.setTimestamp(4, fechaActual);
            psEmpleado.setInt(5, empleado.getIdEmpleado());
            
            int filasEm = psEmpleado.executeUpdate();
            
            if (filasUs > 0 && filasEm > 0) {
                con.commit(); 
                exito = true;
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            try { if (con != null) con.rollback(); } catch (SQLException ex) {}
            System.out.println("Error al modificar empleado completo: " + e.getMessage());
        } finally {
            cerrarConexiones(con, psUsuario, null);
            if (psEmpleado != null) try { psEmpleado.close(); } catch(SQLException e){}
        }
        return exito;
    }

    // --- 4. ELIMINAR LOGICO EMPLEADO ---
    public boolean eliminarLogico(int idEmpleado, int idAdminEnSesion) {
        String sqlBaja = "UPDATE empleados SET id_estado = 0, deleted_at = ?, id_user_update = ? WHERE id_empleado = ?";
        // CORREGIDO: id_user_create sin "d" en logs
        String sqlLog = "INSERT INTO logs (id_usuario, tabla_afectada, accion, descripcion, fecha_log, id_user_create, date_create) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection con = null;
        PreparedStatement psBaja = null;
        PreparedStatement psLog = null;
        boolean exito = false;
        
        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false); 
            
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
            
            psBaja = con.prepareStatement(sqlBaja);
            psBaja.setTimestamp(1, fechaActual);
            psBaja.setInt(2, 4); 
            psBaja.setInt(3, idEmpleado);
            
            if (psBaja.executeUpdate() > 0) {
                psLog = con.prepareStatement(sqlLog);
                psLog.setInt(1, 4);
                psLog.setString(2, "empleados");
                psLog.setString(3, "ELIMINAR");
                psLog.setString(4, "Se dio de baja lógicamente al empleado ID: " + idEmpleado);
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
            System.out.println("Error al eliminar empleado y generar log: " + e.getMessage());
        } finally {
            cerrarConexiones(con, psBaja, null);
            if (psLog != null) try { psLog.close(); } catch(SQLException e){}
        }
        return exito;
    }
    
    // --- 5. LISTAR EMPLEADOS ---
    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        
        String sql = "SELECT e.id_empleado, e.id_estado, e.especialidad, e.sueldo, e.date_create, u.nombre, u.apellido "
                   + "FROM empleados e INNER JOIN usuarios u ON e.id_usuario = u.id_usuario WHERE e.id_estado = 1 LIMIT 100";
                   
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado")); 
                empleado.setIdEstado(rs.getInt("id_estado")); 
                empleado.setEspecialidad(rs.getString("especialidad")); 
                empleado.setSueldo(rs.getDouble("sueldo")); 
                empleado.setDateCreate(rs.getTimestamp("date_create")); 
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                lista.add(empleado);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar empleados: " + ex.getMessage());
        } finally {
            cerrarConexiones(con, ps, rs);
        }
        return lista;
    }

    // --- 6. LISTAR EMPLEADOS FILTRADOS (Buscador y Estados) ---
    public List<Empleado> listarFiltrado(String textoBusqueda, int idEstado) {
        List<Empleado> lista = new ArrayList<>();
        
        StringBuilder sql = new StringBuilder(
            "SELECT e.id_empleado, e.id_estado, e.especialidad, e.sueldo, e.date_create, u.nombre, u.apellido " +
            "FROM empleados e INNER JOIN usuarios u ON e.id_usuario = u.id_usuario WHERE 1=1 "
        );
        
        boolean hayBusqueda = (textoBusqueda != null && !textoBusqueda.trim().isEmpty());
        if (hayBusqueda) {
            sql.append("AND (u.nombre LIKE ? OR u.apellido LIKE ?) ");
        }
        
        boolean hayEstado = (idEstado != -1);
        if (hayEstado) {
            sql.append("AND e.id_estado = ? ");
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
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado")); 
                empleado.setIdEstado(rs.getInt("id_estado")); 
                empleado.setEspecialidad(rs.getString("especialidad")); 
                empleado.setSueldo(rs.getDouble("sueldo")); 
                empleado.setDateCreate(rs.getTimestamp("date_create")); 
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                lista.add(empleado);
            }
        } catch (SQLException ex) {
            System.out.println("Error al filtrar empleados: " + ex.getMessage());
        } finally {
            cerrarConexiones(con, ps, rs);
        }
        return lista;
    }

    private void cerrarConexiones(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar conexión: " + ex.getMessage());
        }
    }
}