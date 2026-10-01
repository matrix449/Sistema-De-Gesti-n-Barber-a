package Entity;

import java.sql.Timestamp;

public class Log {
    private int idLog;
    private int idUsuario;
    private String tablaAfectada;
    private String accion;
    private String descripcion;
    private Timestamp fechaLog;
    
    private int idUserCreated;
    private int idUserUpdate;
    private Timestamp dateCreate;
    private Timestamp dateUpdate;

    public Log() {
    }

    public Log(int idLog, int idUsuario, String tablaAfectada, String accion, String descripcion, Timestamp fechaLog, int idUserCreated, int idUserUpdate, Timestamp dateCreate, Timestamp dateUpdate) {
        this.idLog = idLog;
        this.idUsuario = idUsuario;
        this.tablaAfectada = tablaAfectada;
        this.accion = accion;
        this.descripcion = descripcion;
        this.fechaLog = fechaLog;
        this.idUserCreated = idUserCreated;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public int getIdLog() { return idLog; }
    public void setIdLog(int idLog) { this.idLog = idLog; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getTablaAfectada() { return tablaAfectada; }
    public void setTablaAfectada(String tablaAfectada) { this.tablaAfectada = tablaAfectada; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Timestamp getFechaLog() { return fechaLog; }
    public void setFechaLog(Timestamp fechaLog) { this.fechaLog = fechaLog; }

    public int getIdUserCreated() { return idUserCreated; }
    public void setIdUserCreated(int idUserCreated) { this.idUserCreated = idUserCreated; }

    public int getIdUserUpdate() { return idUserUpdate; }
    public void setIdUserUpdate(int idUserUpdate) { this.idUserUpdate = idUserUpdate; }

    public Timestamp getDateCreate() { return dateCreate; }
    public void setDateCreate(Timestamp dateCreate) { this.dateCreate = dateCreate; }

    public Timestamp getDateUpdate() { return dateUpdate; }
    public void setDateUpdate(Timestamp dateUpdate) { this.dateUpdate = dateUpdate; }
}