/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;

public class Empleado {
    private int idEmpleado;
    private int idUsuario;
    private String nombre;
    private String apellido;
    private int idEstado;
    private String especialidad;
    private double sueldo;
    
    private Timestamp deletedAt;
    private int idUserCreated;
    private int idUserUpdate;
    private Timestamp dateCreate;
    private Timestamp dateUpdate;

    public Empleado() {
    }

    public Empleado(int idEmpleado, int idUsuario, String nombre, String apellido, int idEstado, String especialidad, double sueldo, Timestamp deletedAt, int idUserCreated, int idUserUpdate, Timestamp dateCreate, Timestamp dateUpdate) {
        this.idEmpleado = idEmpleado;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEstado = idEstado;
        this.especialidad = especialidad;
        this.sueldo = sueldo;
        this.deletedAt = deletedAt;
        this.idUserCreated = idUserCreated;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public int getIdEstado() { return idEstado; }
    public void setIdEstado(int idEstado) { this.idEstado = idEstado; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

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