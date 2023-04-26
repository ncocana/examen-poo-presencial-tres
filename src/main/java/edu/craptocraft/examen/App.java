package edu.craptocraft.examen;

import java.util.ArrayList;
import java.util.List;

import edu.craptocraft.examen.barco.Barco;
import edu.craptocraft.examen.barco.Pantalan;
import edu.craptocraft.examen.barco.Puerto;

public class App 
{
    public static void main( String[] args )
    {
        List<Pantalan> listPantalan = new ArrayList<>();

        List<Barco> barcosEntrantes = new ArrayList<>();
        
        Puerto.cargarBarcosEntrantes(barcosEntrantes);
        Puerto.simular(listPantalan);
        Puerto.buscarAmarre(barcosEntrantes, listPantalan);
        Puerto.verAmarre(listPantalan);
    }
}
