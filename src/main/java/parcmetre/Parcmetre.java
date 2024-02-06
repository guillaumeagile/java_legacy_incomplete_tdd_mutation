package parcmetre;

import java.time.LocalDateTime;

public class Parcmetre {
	private Voiture voiture;
	private double montantEntre;
	private LocalDateTime dateEntree;
	private Horloge horloge; 
	
	public Parcmetre(Voiture voiture, LocalDateTime dateEntree, double montant) {
		this.voiture = voiture;
		this.dateEntree = dateEntree; 
		this.montantEntre = montant; 
		this.horloge = new Horloge();
	}
	
	public Voiture getVoiture() {
		return this.voiture; 
	}
	
	public LocalDateTime getDateEntree() {
		return this.dateEntree; 
	}
	
	public double getMontantEntre() {
		return this.montantEntre; 
	}
	
	public String getHeureFin() {
		return this.horloge.formatageHeure(this.horloge.calculerFin(this.dateEntree, calculerDureeStationnement(this.montantEntre)));
	}
	
	public static int calculerDureeStationnement(double montantPaye) {
		int tempsEnMinutes = -1;
		if (montantPaye < 0 || montantPaye > 14) {
			throw new IllegalArgumentException();
		} else if (montantPaye <= 2) {
			tempsEnMinutes = (int) (120 * montantPaye);
		} else {
			tempsEnMinutes = 240 + (int) ((montantPaye - 2) * 20);
		}
		return tempsEnMinutes;
	}  

}
