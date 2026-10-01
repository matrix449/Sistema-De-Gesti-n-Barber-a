package Service;

import Dao.ClienteDAO;
import Dao.LogDAO;
import Entity.Cliente;
import Entity.Log;

public class ClienteService {
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    private LogDAO logDAO = new LogDAO();

    public boolean crearNuevoCliente(Cliente cliente, int idUsuarioEnSesion) {
        // 1. Intentamos crear el cliente
        boolean exito = clienteDAO.crear(cliente);
        
        // 2. Si se creó correctamente, registramos el log
        if (exito) {
            Log registro = new Log();
            registro.setIdUsuario(idUsuarioEnSesion); // El admin o empleado logueado
            registro.setTablaAfectada("clientes");
            registro.setAccion("CREAR");
            registro.setDescripcion("Se creó un nuevo cliente asociado al usuario ID: " + cliente.getIdUsuario());
            registro.setIdUserCreated(idUsuarioEnSesion);
            
            logDAO.insertarLog(registro);
        }
        
        return exito; // Retorna a la interfaz si funcionó o no
    }
    
    public boolean modificarCliente(Cliente cliente, int idUsuarioEnSesion) {
        boolean exito = clienteDAO.modificar(cliente);
        
        if (exito) {
            Log registro = new Log();
            registro.setIdUsuario(idUsuarioEnSesion);
            registro.setTablaAfectada("clientes");
            registro.setAccion("MODIFICAR");
            registro.setDescripcion("Se modificaron los datos del cliente ID: " + cliente.getIdCliente());
            registro.setIdUserCreated(idUsuarioEnSesion);
            
            logDAO.insertarLog(registro);
        }
        
        return exito;
    }
    
    public boolean eliminarCliente(int idCliente, int idUsuarioEnSesion) {
        boolean exito = clienteDAO.eliminarLogico(idCliente, idUsuarioEnSesion);
        
        if (exito) {
            Log registro = new Log();
            registro.setIdUsuario(idUsuarioEnSesion);
            registro.setTablaAfectada("clientes");
            registro.setAccion("ELIMINAR");
            registro.setDescripcion("Se dio de baja lógicamente al cliente ID: " + idCliente);
            registro.setIdUserCreated(idUsuarioEnSesion);
            
            logDAO.insertarLog(registro);
        }
        
        return exito;
    }
}