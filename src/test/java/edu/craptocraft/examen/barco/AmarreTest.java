package edu.craptocraft.examen.barco;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;

public class AmarreTest {
    
    private static Amarre amarre = null;
    private static Barco barco1 = null;
    private static Barco barco2 = null;

    @BeforeClass
    public static void setup_amarre() {
        amarre = new Amarre(10.0f);
        barco1 = new Comercial("1234ABC", "Barco Comercial 1", 10, "Cajas");
        barco2 = new Comercial("5678DEF", "Barco Comercial 2", 5, "Minerales");
    }

    @Test
    public void testCrearAmarre() {
        assertNotNull(amarre);
        assertEquals(1, amarre.getId());
        assertEquals(10.0f, amarre.getSize(), 0.0f);
        assertFalse(amarre.getOcupado());
        assertNull(amarre.getBarco());
    }

    @Test
    public void testAsignarBarco() {
        // Assigns the ship.
        assertTrue(amarre.asignarBarco(barco1));
        assertTrue(amarre.getOcupado());
        assertEquals(barco1, amarre.getBarco());

        // Can't assign the ship because there's not enough space.
        assertFalse(amarre.asignarBarco(barco2));
        assertTrue(amarre.getOcupado());
        assertEquals(barco1, amarre.getBarco());
    }

    @Test
    public void testLiberarBarco() {
        // Assigns the ship.
        assertTrue(amarre.asignarBarco(barco1));
        assertTrue(amarre.getOcupado());

        // Frees the ship.
        amarre.liberarBarco();

        assertFalse(amarre.getOcupado());
        assertNull(amarre.getBarco());
    }

}
