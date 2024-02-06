package testsParcmetre;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import parcmetre.GrosBordel;


public class TesteLeGrosBordel {
	
	GrosBordel bordel;
	
	@Before
	public void setUp() throws Exception {
		this.bordel = new GrosBordel();
	}

	@Test
    public void testCalculerFin() {
        LocalDateTime debut = LocalDateTime.of(2023, 3, 15, 10, 0);

        LocalDateTime fin = bordel.calculerFin(debut, 2);

        assertEquals(LocalDateTime.of(2023, 3, 15, 12, 0), fin);
    }

    @Test
    public void testEstJourFerie() {
        assertFalse(bordel.estJourFerie(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

    @Test
    public void testCalculerPaques() {
        assertEquals(LocalDateTime.of(2023, 4, 9, 0, 0), bordel.calculerPaques(2023));
    }

    @Test
    public void testEstDimanche() {
        assertFalse(bordel.estDimanche(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

    @Test
    public void testEstPeriodeFermee() {
        assertFalse(bordel.estPeriodeFermee(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

}
