package Dao;

import config.Conexion;
import Entity.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EstadoDAO {
    
    // Trae los estados filtrados por el módulo (ej. "Usuario")
    public List<Estado> listarPorModulo(String modulo) {
        List<Estado> lista = new ArrayList<>();
        // Agregamos una opción "Todos" por defecto con ID -1 para limpiar el filtro
        lista.add(new Estado(-1, "Todos", modulo));
        
        String sql = "SELECT id_estado, nombre_estado, modulo FROM estados WHERE modulo = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, modulo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(new Estado(
                    rs.getInt("id_estado"),
                    rs.getString("nombre_estado"),
                    rs.getString("modulo")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar estados: " + e.getMessage());
        }
        return lista;
    }
}