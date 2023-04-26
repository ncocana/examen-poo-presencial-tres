package edu.craptocraft.examen.barco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Puerto {
    
    private List<Barco> barcosEntrantes = new ArrayList<>();
    private List<Pantalan> listPantalan = new ArrayList<>();

    public Puerto(List<Barco> barcosEntrantes, List<Pantalan> listPantalan) {
        this.barcosEntrantes = barcosEntrantes;
        this.listPantalan = listPantalan;
    }

    public List<Barco> getBarcosEntrantes() {
        return this.barcosEntrantes;
    }

    public List<Pantalan> getListPantalan() {
        return this.listPantalan;
    }

    public static void buscarAmarre(List<Barco> barcosEntrantes, List<Pantalan> listPantalan) {
        // Sort the list of Barcos in descending order of size
        Collections.sort(barcosEntrantes, Comparator.comparing(Barco::getSize).reversed());

        // Iterate through each Barco and each Pantalan
        for (Barco barco : barcosEntrantes) {
            for (Pantalan pantalan : listPantalan) {
                // Check if the Pantalan is of the same type as the Barco
                if (barco.encajaTipo(pantalan, barco.getClass().getSimpleName())) {
                    // Try to find an unoccupied Amarre that has enough space for the Barco
                    Optional<Amarre> amarreDisponible = pantalan.getListAmarre().stream()
                        .filter(amarre -> !amarre.getOcupado() && amarre.getSize() >= barco.getSize())
                        .findFirst();

                    if (amarreDisponible.isPresent()) {
                        Amarre amarre = amarreDisponible.get();
                        amarre.asignarBarco(barco); // Assign the Barco to the Amarre
                        // barcosEntrantes.remove(barco); // Remove the Barco from the list of Barcos
                        break; // Break out of the loop over Amarres
                    }
                }
            }
        }

        // Any Barcos remaining in the list of Barcos have not been assigned to an Amarre
        // and must be redirected to another port or anchored outside the port.

    }

    public static void verAmarre(List<Pantalan> listPantalan) {
        for (Pantalan pantalan : listPantalan) {
            System.out.println("Amarres del pantalán #" + pantalan.getId() + ":");
            List<Amarre> listAmarre = pantalan.getListAmarre();
            for (int i = 0; i < listAmarre.size(); i++) {
                Amarre amarre = listAmarre.get(i);
                System.out.println("\tAmarre #" + (i+1) + ":");
                if (amarre.getBarco() != null) {
                    System.out.println("\t\tBarco amarrado: " + amarre.getBarco().getNombre());
                    System.out.println("\t\tTipo de barco: " + amarre.getBarco().getClass().getSimpleName());
                    System.out.println("\t\tMatrícula: " + amarre.getBarco().getMatricula());
                    System.out.println("\t\tTamaño: " + amarre.getBarco().getSize());
                    if (amarre.getBarco() instanceof Comercial) {
                        System.out.println("\t\tCarga: " + ((Comercial) amarre.getBarco()).getCarga());
                    } else if (amarre.getBarco() instanceof Recreo) {
                        System.out.println("\t\tPermiso: " + ((Recreo) amarre.getBarco()).getPermiso());
                    }
                } else {
                    System.out.println("\t\tLibre");
                }
            }
        }
    }

    public static void simular(List<Pantalan> listPantalan) {
        // Create two new Pantalan with 5 Amarres for Barcos Comercial and 5 Amarres for Barcos Recreo
        Pantalan pantalan1 = new Pantalan(new ArrayList<>(Arrays.asList(
            new Amarre(10),
            new Amarre(20),
            new Amarre(15),
            new Amarre(5),
            new Amarre(25)
        )), "Comercial");
        Pantalan pantalan2 = new Pantalan(new ArrayList<>(Arrays.asList(
            new Amarre(10),
            new Amarre(20),
            new Amarre(15),
            new Amarre(5),
            new Amarre(25)
        )), "Recreo");

        // Add the new Pantalan to the list of Pantalanes
        listPantalan.add(pantalan1);
        listPantalan.add(pantalan2);
    }

    public static void cargarBarcosEntrantes(List<Barco> barcosEntrantes) {
        // Create two new Comercial Barco
        Barco comercial1 = new Comercial("1234ABC", "Barco Comercial 1", 10, "Cajas");
        Barco comercial2 = new Comercial("5678DEF", "Barco Comercial 2", 5, "Minerales");

        // Create two new Recreo Barco
        Barco recreo1 = new Recreo("9123GHI", "Barco Recreo 1", 5, "Navegación deportiva");
        Barco recreo2 = new Recreo("4567JKL", "Barco Recreo 2", 10, "Navegación");

        // Add the new Barco to the list of Barcos
        barcosEntrantes.add(comercial1);
        barcosEntrantes.add(comercial2);
        barcosEntrantes.add(recreo1);
        barcosEntrantes.add(recreo2);
    }

}
