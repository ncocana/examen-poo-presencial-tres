package edu.craptocraft.examen.barco;

import java.util.ArrayList;
import java.util.List;

public class Pantalan {
    
    private static int contador = 0;
    private int id;
    private List<Amarre> listAmarre = new ArrayList<>();
    private String tipo = "";

    public Pantalan(List<Amarre> listAmarre, String tipo) {
        this.id = ++contador;
        this.listAmarre = listAmarre;
        this.tipo = tipo;
    }

    public int getId() {
        return this.id;
    }

    public List<Amarre> getListAmarre() {
        return this.listAmarre;
    }

    private void setListAmarre(List<Amarre> newList) {
        this.listAmarre = newList;
    }

    public String getTipo() {
        return this.tipo;
    }

    private void setTipo(String newTipo) {
        this.tipo = newTipo;
    }

}
