package testsParcmetre;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import parcmetre.*;

public class TestTicket {

	private Ticket ticket;

	@Before
	public void setUp() throws Exception {
		Voiture voiture = new Voiture("AA-123-BB");
		LocalDateTime dateEntree = LocalDateTime.of(2023, Month.APRIL, 1, 12, 0);
		Parcmetre parcmetre = new Parcmetre(voiture, dateEntree, 2.0);
		ticket = new Ticket(parcmetre);
	}
	
	@Test
	public void testText() {
		String expected = "========== Ticket de stationnement ==========\n\n"
				+ "Votre vehicule : AA-123-BB\n"
				+ "Date d'entree : 01-04-2023 12:00\n"
				+ "Montant paye : 2.0 euros\n"
				+ "Date de sortie : 01-04-2023 16:00\n"
				+ "\n\n"
				+ "Bonne journée à vous ! \n"
				+ "===============================================\n";
		assertEquals(expected, ticket.text());
	}

}