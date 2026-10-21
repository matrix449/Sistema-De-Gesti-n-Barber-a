
package Entity;


public class Sesion {
    // Variables estáticas para que mantengan su valor en todo el programa
    private static int idUsuarioActual = -1;
    private static int idRolActual = -1;
    private static String nombreCompletoActual = "";

    // Método para guardar los datos cuando el login es exitoso
    public static void iniciarSesion(int idUsuario, int idRol, String nombre, String apellido) {
        idUsuarioActual = idUsuario;
        idRolActual = idRol;
        nombreCompletoActual = nombre + " " + apellido;
    }

    // Método para limpiar los datos si el usuario cierra sesión
    public static void cerrarSesion() {
        idUsuarioActual = -1;
        idRolActual = -1;
        nombreCompletoActual = "";
    }

    // Getters para consultar quién está logueado desde cualquier parte del sistema
    public static int getIdUsuarioActual() {
        return idUsuarioActual;
    }

    public static int getIdRolActual() {
        return idRolActual;
    }

    public static String getNombreCompletoActual() {
        return nombreCompletoActual;
    }
}