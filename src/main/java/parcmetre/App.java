package parcmetre;
import java.time.LocalDateTime;

public class App {
	
	public static void main(String[] args) {
		LocalDateTime now =  LocalDateTime.now();
		LocalDateTime heure1 = LocalDateTime.of(2023, 1, 18, 9, 30);
		Voiture voiture = new Voiture("AB-761-CD");
		Parcmetre parc = new Parcmetre(voiture);
		Ticket ticket = new Ticket(parc);
		ImprimanteTicket imprimante = new ImprimanteTicket();
		imprimante.imprimer(ticket);
	}

}