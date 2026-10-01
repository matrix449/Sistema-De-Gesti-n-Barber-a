package Entity;

import java.sql.Timestamp;

public class Cliente {
    private int idCliente;
    private int idUsuario;
    private int idEstado;
    private double puntosFidelidad;
    
    private Timestamp deletedAt;
    private int idUserCreated;
    private int idUserUpdate;
    private Timestamp dateCreate;
    private Timestamp dateUpdate;

    public Cliente() {
    }

    public Cliente(int idCliente, int idUsuario, int idEstado, double puntosFidelidad, Timestamp deletedAt, int idUserCreated, 
            int idUserUpdate, Timestamp dateCreate, Timestamp dateUpdate) {
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idEstado = idEstado;
        this.puntosFidelidad = puntosFidelidad;
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

    public double getPuntosFidelidad() { return puntosFidelidad; }
    public void setPuntosFidelidad(double puntosFidelidad) { this.puntosFidelidad = puntosFidelidad; }

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