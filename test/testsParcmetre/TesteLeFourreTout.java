package testsParcmetre;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import parcmetre.FourreTout;


public class TesteLeFourreTout {

	@Before
	public void setUp() {

	}

	@Test
    public void testCalculerFin() {
        LocalDateTime debut = LocalDateTime.of(2023, 3, 15, 10, 0);

        LocalDateTime fin = FourreTout.calculerFin(debut, 2);

        assertEquals(LocalDateTime.of(2023, 3, 15, 12, 0), fin);
    }

    @Test
    public void testEstJourFerie() {
        assertFalse(FourreTout.estJourFerie(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

    @Test
    public void testCalculerPaques() {
        assertEquals(LocalDateTime.of(2023, 4, 9, 0, 0), FourreTout.calculerPaques(2023));
    }

    @Test
    public void testEstDimanche() {
        assertFalse(FourreTout.estDimanche(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

    @Test
    public void testEstPeriodeFermee() {
        assertFalse(FourreTout.estPeriodeFermee(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

}
