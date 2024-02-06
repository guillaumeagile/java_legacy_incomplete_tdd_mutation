package testsParcmetre;


import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import parcmetre.*;

public class ParcmetreTest {

    @Test
    public void testGetVoiture() {
        Voiture voiture = new Voiture("AB-123-CD");

        Parcmetre parcmetre = new Parcmetre(voiture, LocalDateTime.now(), 10.0);

        assertEquals(voiture, parcmetre.getVoiture());
    }

    @Test
    public void testGetDateEntree() {
        LocalDateTime dateEntree = LocalDateTime.now();
        Parcmetre parcmetre = new Parcmetre(new Voiture("AB-123-CD"), dateEntree, 10.0);

        assertEquals(dateEntree, parcmetre.getDateEntree());
    }

	@Test
    public void testGetMontantEntre() {
        Parcmetre parcmetre = new Parcmetre(new Voiture("AB-123-CD"), LocalDateTime.now(), 15.0);

        assertEquals(15.0, parcmetre.getMontantEntre());
    }

    @Test
    public void testGetHeureFin() {
        LocalDateTime dateEntree = LocalDateTime.now();
        Parcmetre parcmetre = new Parcmetre(new Voiture("AB-123-CD"), dateEntree, 10.0);

        assertEquals(dateEntree.plusHours(Parcmetre.calculerDureeStationnement(10.0)), parcmetre.getHeureFin());
    }

    @Test
    public void testCalculerDureeStationnement() {
        assertEquals(1, Parcmetre.calculerDureeStationnement(1.0));
        assertEquals(2, Parcmetre.calculerDureeStationnement(2.0));
        assertEquals(3, Parcmetre.calculerDureeStationnement(3.0));
        assertEquals(4, Parcmetre.calculerDureeStationnement(4.0));
        assertEquals(5, Parcmetre.calculerDureeStationnement(5.0));
        assertEquals(8, Parcmetre.calculerDureeStationnement(8.0));
        assertEquals(8, Parcmetre.calculerDureeStationnement(20.0)); 
    }
}