

package Dao;

import Entity.Usuario;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    // Método que verifica el correo y la contraseña
    public Usuario autenticar(String email, String password) {
        Usuario usu = null;
        // Buscamos al usuario que coincida EXACTAMENTE con el email y contraseña
        String sql = "SELECT id_usuario, id_rol, nombre, apellido FROM usuarios WHERE email = ? AND password = ?";

        try (Connection con = config.Conexion.getConnection(); // Asegúrate de que la ruta a tu Conexion sea correcta
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, email);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) { // Si encuentra un resultado, el login es correcto
                    usu = new Usuario();
                    usu.setIdUsuario(rs.getInt("id_usuario"));
                    usu.setIdRol(rs.getInt("id_rol")); // 1 = Admin, 2 = Empleado
                    usu.setNombre(rs.getString("nombre"));
                    usu.setApellido(rs.getString("apellido"));
                    // No hace falta extraer ni guardar la contraseña por seguridad
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en autenticación: " + e.getMessage());
        }
        
        return usu; // Retorna el usuario si lo encontró, o null si las credenciales son inválidas
    }
    
    // Método para obtener los datos actuales del usuario en sesión
    public Usuario obtenerUsuarioPorId(int idUsuario) {
        Usuario usu = null;
        String sql = "SELECT nombre, apellido, telefono, email, password FROM usuarios WHERE id_usuario = ?";
        
        try (Connection con = config.Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usu = new Usuario();
                    usu.setIdUsuario(idUsuario);
                    usu.setNombre(rs.getString("nombre"));
                    usu.setApellido(rs.getString("apellido"));
                    usu.setTelefono(rs.getString("telefono"));
                    usu.setEmail(rs.getString("email"));
                    usu.setPassword(rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario: " + e.getMessage());
        }
        return usu;
    }

    // Método para actualizar los datos personales y contraseña
    public boolean actualizarPerfil(Usuario usu) {
        String sql = "UPDATE usuarios SET nombre=?, apellido=?, telefono=?, email=?, password=? WHERE id_usuario=?";
        boolean exito = false;
        
        try (Connection con = config.Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getApellido());
            ps.setString(3, usu.getTelefono());
            ps.setString(4, usu.getEmail());
            ps.setString(5, usu.getPassword());
            ps.setInt(6, usu.getIdUsuario()); 
            
            if(ps.executeUpdate() > 0){
                exito = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar perfil: " + e.getMessage());
        }
        return exito;
    }
}


