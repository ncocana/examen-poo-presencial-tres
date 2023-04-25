package edu.craptocraft.examen.barco;

public class Recreo extends Barco {
    
    private String permiso = "";

    public Recreo(String matricula, String nombre, float size, String permiso) {
        super(matricula, nombre, size);
        this.permiso = permiso;
    }

    public String getPermiso() {
        return this.permiso;
    }

    private void setPermiso(String newPermiso) {
        this.permiso = newPermiso;
    }

}
