package testsParcmetre;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import parcmetre.FourreTout;


public class TesteLeFourreTout {

	@Before
	public void setUp() {

	}

	@Test
    public void testCalculerFin() {
        DateTime debut = new DateTime(2023, 3, 15, 10, 0);

        DateTime fin = FourreTout.calculerFin(debut, 2);

        assertEquals(LocalDateTime.of(2023, 3, 15, 12, 0), fin);
    }

    @Test
    public void testEstJourFerie() {
        assertFalse(FourreTout.estJourFerie(new DateTime(2023, 3, 15, 12, 0)));
    }



    @Test
    public void testEstDimanche() {
        assertFalse(FourreTout.estDimanche(new DateTime(2023, 3, 15, 12, 0)));
    }

    @Test
    public void testEstPeriodeFermee() {
        assertFalse(FourreTout.estPeriodeFermee(new DateTime(2023, 3, 15, 12, 0)));
    }

}
