package parcmetre;

// expliquez moi comment je vais tester cette classe ?????
public class ImprimanteTicket {
	
	public void imprimer(Ticket ticket) {
		System.out.println("Impression du ticket en cours \n\n" + ticket.text() + "\nBonne fin de journee à vous.");
	}
}