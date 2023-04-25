package edu.craptocraft.examen.barco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public abstract class Barco {
    
    private String matricula = "";
    private String nombre = "";
    private float size = 0;

    public Barco(String matricula, String nombre, float size) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.size = size;
    }

    public String getMatricula() {
        return this.matricula;
    }

    private void setMatricula(String newMatricula) {
        this.matricula = newMatricula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public float getSize() {
        return this.size;
    }

    private void setSize(float newSize) {
        this.size = newSize;
    }

    public static String mayorSize(List<Barco> barcosEntrantes) {
        Optional<Barco> maxSize = barcosEntrantes.stream().max(Comparator.comparing(Barco::getSize));
        return maxSize.map(Barco::getMatricula).orElse(null);
    }

    public boolean encajaTipo(Pantalan pantalan) {
        return pantalan instanceof Pantalan;
    }

    public float encajaSize(Amarre amarre) {
        return amarre - this.getSize();
    }

    public void cargarBarcosEntrantes(List<Barco> barcosEntrantes) {
        
    }

}
