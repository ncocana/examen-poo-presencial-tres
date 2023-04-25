package edu.craptocraft.examen.barco;

public class Comercial extends Barco {
    
    private String carga = "";

    public Comercial(String matricula, String nombre, float size, String carga) {
        super(matricula, nombre, size);
        this.carga = carga;
    }

    public String getCarga() {
        return this.carga;
    }

    private void setCarga(String newCarga) {
        this.carga = newCarga;
    }

}
