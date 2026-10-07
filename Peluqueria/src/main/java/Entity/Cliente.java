package Entity;

import java.sql.Timestamp;

public class Cliente {
    private int idCliente;
    private int idUsuario;
    private int idEstado;
    private String nombre;
    private String apellido;
    private double puntosFidelidad;
    private String fecha_de_nacimiento;
    
    private Timestamp deletedAt;
    private int idUserCreated;
    private int idUserUpdate;
    private Timestamp dateCreate;
    private Timestamp dateUpdate;

    public Cliente() {
    }

    public Cliente(int idCliente, int idUsuario, int idEstado, String nombre, String apellido, double puntosFidelidad,String fecha_de_nacimiento, Timestamp deletedAt, int idUserCreated, 
            int idUserUpdate, Timestamp dateCreate, Timestamp dateUpdate) {
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntosFidelidad = puntosFidelidad;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.deletedAt = deletedAt;
        this.idUserCreated = idUserCreated;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdEstado() { return idEstado; }
    public void setIdEstado(int idEstado) { this.idEstado = idEstado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public double getPuntosFidelidad() { return puntosFidelidad; }
    public void setPuntosFidelidad(double puntosFidelidad) { this.puntosFidelidad = puntosFidelidad; }

    public String getFecha_de_nacimiento() {return fecha_de_nacimiento;}
    public void setFecha_de_nacimiento(String fecha_de_nacimiento) {this.fecha_de_nacimiento = fecha_de_nacimiento;}

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