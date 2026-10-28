package Entity;

public class Estado {
    private int idEstado;
    private String nombreEstado;
    private String modulo;
    
    public Estado() {
    }
    
    public Estado(int idEstado, String nombreEstado, String modulo) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
        this.modulo = modulo;
    }

    // --- GETTERS (Para obtener los datos) ---
    public int getIdEstado() { return idEstado; }
    public String getNombreEstado() { return nombreEstado; }
    public String getModulo() { return modulo; }

    // --- SETTERS ---
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

@Override
    public String toString() {
        return this.nombreEstado;
    }
}