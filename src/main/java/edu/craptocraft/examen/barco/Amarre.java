package edu.craptocraft.examen.barco;

public class Amarre {
    
    private static int contador = 0;
    private int id;
    private float size = 0;
    private boolean ocupado;
    private Barco barco;

    public Amarre(float size) {
        this.id = ++contador;
        this.size = size;
        this.ocupado = false;
        this.barco = null;
    }

    public int getId() {
        return this.id;
    }

    public float getSize() {
        return this.size;
    }

    private void setSize(float newSize) {
        this.size = newSize;
    }

    public boolean getOcupado() {
        return this.ocupado;
    }

    public void setOcupado(boolean newValue) {
        this.ocupado = newValue;
    }

    public Barco getBarco() {
        return this.barco;
    }

    public void setBarco(Barco newBarco) {
        this.barco = newBarco;
    }

    public boolean asignarBarco(Barco barco) {
        if (!ocupado && barco.getSize() <= this.getSize()) {
            this.barco = barco;
            this.ocupado = true;
            return true;
        }
        return false;
    }

    public void liberarBarco() {
        this.barco = null;
        this.ocupado = false;
    }

}
