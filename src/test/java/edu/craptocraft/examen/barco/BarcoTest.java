package edu.craptocraft.examen.barco;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BarcoTest {
    
    private static Barco barco1 = null;
    private static Barco barco2 = null;

    @BeforeClass
    public static void setup_amarre() {
        barco1 = new Comercial("1234ABC", "Barco Comercial 1", 10, "Cajas");
        barco2 = new Recreo("5678DEF", "Barco Comercial 2", 5, "Minerales");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1234ABC", barco1.getMatricula());
        assertEquals("Barco Comercial 1", barco1.getNombre());
        assertEquals(10.0f, barco1.getSize(), 0.0f);

        barco1.setMatricula("M5678");
        barco1.setNombre("Nuevo nombre");
        barco1.setSize(15.0f);

        assertEquals("M5678", barco1.getMatricula());
        assertEquals("Nuevo nombre", barco1.getNombre());
        assertEquals(15.0f, barco1.getSize(), 0.0f);
    }

    @Test
    public void testMayorSize() {

        List<Barco> barcos = new ArrayList<>();
        barcos.add(barco1);
        barcos.add(barco2);

        String matricula = Barco.mayorSize(barcos);
        assertEquals("M5678", matricula);
    }

    @Test
    public void testEncajaTipo() {
        Pantalan pantalan = new Pantalan(new ArrayList<>(Arrays.asList(
            new Amarre(10),
            new Amarre(20),
            new Amarre(15),
            new Amarre(5),
            new Amarre(25)
        )), "Comercial");

        assertTrue(barco1.encajaTipo(pantalan, barco1.getClass().getSimpleName()));
        assertFalse(barco2.encajaTipo(pantalan, barco2.getClass().getSimpleName()));
    }

    @Test
    public void testEncajaSize() {
        Amarre amarre1 = new Amarre(15.0f);
        Amarre amarre2 = new Amarre(10.0f);

        assertEquals(0f, barco1.encajaSize(amarre1), 0.0f);
        assertEquals(5f, barco2.encajaSize(amarre2), 0.0f);
    }

}
