package testsParcmetre;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import parcmetre.Horloge;


public class TestHorloge {
	
	Horloge horloge;
	
	@Before
	public void setUp() throws Exception {
		this.horloge = new Horloge();
	}

	@Test
    public void testCalculerFin() {
        LocalDateTime debut = LocalDateTime.of(2023, 3, 15, 10, 0);

        LocalDateTime fin = horloge.calculerFin(debut, 2);

        assertEquals(LocalDateTime.of(2023, 3, 15, 12, 0), fin);
    }

    @Test
    public void testEstJourFerie() {
        assertFalse(horloge.estJourFerie(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

    @Test
    public void testCalculerPaques() {
        assertEquals(LocalDateTime.of(2023, 4, 9, 0, 0), horloge.calculerPaques(2023));
    }

    @Test
    public void testEstDimanche() {
        assertFalse(horloge.estDimanche(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

    @Test
    public void testEstPeriodeFermee() {
        assertFalse(horloge.estPeriodeFermee(LocalDateTime.of(2023, 3, 15, 12, 0)));
    }

}
