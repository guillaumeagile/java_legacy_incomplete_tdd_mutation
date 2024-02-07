package testsParcmetre;

import org.joda.time.DateTime;
import org.junit.Test;
import parcmetre.IHorloge;
import parcmetre.Parcmetre;
import parcmetre.Voiture;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("ALL")
public class ParcmetreTest {
    IHorloge fausseHorloge = new HorlogeBloquee();
    // il vous faut critiquer chaque test, dire si il sert à quelque chose, si il est propre ou pas.
    @Test
    public void testGetVoiture() {
        Voiture voiture = new Voiture("AB-123-CD");

        Parcmetre parcmetre = new Parcmetre(voiture, fausseHorloge);

        assertThat(voiture).isEqualTo(parcmetre.getVoiture());  // org.assertj.core.api.Assertions
      //  Assert.assertEquals(voiture, parcmetre.getVoiture());   DEPRECATED
    }

	//@Test // j'ai volontairement retiré ce test
    public void testGetMontantEntre() {
        Parcmetre parcmetre = new Parcmetre(new Voiture("AB-123-CD"), fausseHorloge);

        assertEquals(0.0, parcmetre.getMontantEntree());
    }

    @Test
    public void testGCreationDuTicketAvecMontant() {
        double montantInsere = 1.5;
        Parcmetre parcmetre = new Parcmetre(new Voiture("AB-123-CD"), fausseHorloge);
        parcmetre.ObtenirTicket(montantInsere);

        assertEquals(1.5, parcmetre.getMontantEntree());
    }

    @Test
    public void testGCreationDuTicketAvecHeureEntree() {
        double montantInsere = 1.5;

        Parcmetre parcmetre = new Parcmetre(new Voiture("AB-123-CD") , fausseHorloge);
        parcmetre.ObtenirTicket(montantInsere);

        assertEquals(DateTime.parse("2005-03-26"), parcmetre.getDateHeureEntree());
    }

    @Test
    public void testGetHeureFin() {
        LocalDateTime dateEntree = LocalDateTime.now();
        Parcmetre parcmetre = new Parcmetre(new Voiture("AB-123-CD"), fausseHorloge);

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