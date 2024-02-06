package testsParcmetre;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import parcmetre.GrosBordel;


public class TesteLeGrosBordel {

	@Before
	public void setUp() {

	}

	@Test
    public void testCalculerFin() {
        LocalDateTime debut = LocalDateTime.of(2023, 3, 15, 10, 0);

        LocalDateTime fin = GrosBordel.calculerFin(debut, 2);

        assertEquals(LocalDateTime.of(2023, 3, 15, 12, 0), fin);
    }

    @Test
    public void testEstJourFerie() {
        assertFalse(GrosBordel.estJourFerie(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

    @Test
    public void testCalculerPaques() {
        assertEquals(LocalDateTime.of(2023, 4, 9, 0, 0), GrosBordel.calculerPaques(2023));
    }

    @Test
    public void testEstDimanche() {
        assertFalse(GrosBordel.estDimanche(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

    @Test
    public void testEstPeriodeFermee() {
        assertFalse(GrosBordel.estPeriodeFermee(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

}
