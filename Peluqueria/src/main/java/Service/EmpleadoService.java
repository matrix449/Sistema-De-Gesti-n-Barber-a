package Service;

import Dao.EmpleadoDAO;
import Dao.LogDAO;
import Entity.Empleado;
import Entity.Log;

public class EmpleadoService {
    
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private LogDAO logDAO = new LogDAO();

    public boolean crearNuevoEmpleado(Empleado empleado, int idUsuarioEnSesion) {
        boolean exito = empleadoDAO.crear(empleado);
        
        if (exito) {
            Log registro = new Log();
            registro.setIdUsuario(idUsuarioEnSesion);
            registro.setTablaAfectada("empleados");
            registro.setAccion("CREAR");
            registro.setDescripcion("Se creó un nuevo empleado asociado al usuario ID: " + empleado.getIdUsuario());
            registro.setIdUserCreated(idUsuarioEnSesion);
            
            logDAO.insertarLog(registro);
        }
        
        return exito;
    }
    
    public boolean modificarEmpleado(Empleado empleado, int idUsuarioEnSesion) {
        boolean exito = empleadoDAO.modificar(empleado);
        
        if (exito) {
            Log registro = new Log();
            registro.setIdUsuario(idUsuarioEnSesion);
            registro.setTablaAfectada("empleados");
            registro.setAccion("MODIFICAR");
            registro.setDescripcion("Se modificaron los datos del empleado ID: " + empleado.getIdEmpleado());
            registro.setIdUserCreated(idUsuarioEnSesion);
            
            logDAO.insertarLog(registro);
        }
        
        return exito;
    }

    public boolean eliminarEmpleado(int idEmpleado, int idUsuarioEnSesion) {
        boolean exito = empleadoDAO.eliminarLogico(idEmpleado, idUsuarioEnSesion);
        
        if (exito) {
            Log registro = new Log();
            registro.setIdUsuario(idUsuarioEnSesion);
            registro.setTablaAfectada("empleados");
            registro.setAccion("ELIMINAR");
            registro.setDescripcion("Se dio de baja lógicamente al empleado ID: " + idEmpleado);
            registro.setIdUserCreated(idUsuarioEnSesion);
            
            logDAO.insertarLog(registro);
        }
        
        return exito;
    }
}