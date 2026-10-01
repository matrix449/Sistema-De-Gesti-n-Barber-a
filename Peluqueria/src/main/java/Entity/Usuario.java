package Entity;


import java.sql.Timestamp;

public class Usuario {
    private int idUsuario;
    private int idRol;
    private int idEstado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    
    private Timestamp deletedAt;
    private int idUserCreated;
    private int idUserUpdate;
    private Timestamp dateCreate;
    private Timestamp dateUpdate;

    public Usuario() {
    }

    public Usuario(int idUsuario, int idRol, int idEstado, String nombre, String apellido, String telefono, String email, String password, Timestamp deletedAt, int idUserCreated, int idUserUpdate, Timestamp dateCreate, Timestamp dateUpdate) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.deletedAt = deletedAt;
        this.idUserCreated = idUserCreated;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdRol() { return idRol; }
    public void setIdRol(int idRol) { this.idRol = idRol; }

    public int getIdEstado() { return idEstado; }
    public void setIdEstado(int idEstado) { this.idEstado = idEstado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Timestamp getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Timestamp deletedAt) { this.deletedAt = deletedAt; }

    public int getIdUserCreated() { return idUserCreated; }
    public void setIdUserCreated(int idUserCreated) { this.idUserCreated = idUserCreated; }

    public int getIdUserUpdate() { return idUserUpdate; }
    public void setIdUserUpdate(int idUserUpdate) { this.idUserUpdate = idUserUpdate; }

    public Timestamp getDateCreate() { return dateCreate; }
    public void setDateCreate(Timestamp dateCreate) { this.dateCreate = dateCreate; }

    public Timestamp getDateUpdate() { return dateUpdate; }
    public void setDateUpdate(Timestamp dateUpdate) { this.dateUpdate = dateUpdate; }
}