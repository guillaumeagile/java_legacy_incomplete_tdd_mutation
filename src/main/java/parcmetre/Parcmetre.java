package parcmetre;

import org.joda.time.DateTime;

import java.time.LocalDateTime;

public class Parcmetre {
	private final IHorloge horlogeInterne;
	private final Voiture voiture;
	private double montantEntre;
	private DateTime dateEntree;

	
	public Parcmetre(Voiture voiture, IHorloge horlogeInterne) {
		this.voiture = voiture;
		this.montantEntre = 0;
		this.horlogeInterne = horlogeInterne;
	}
	
	public Voiture getVoiture() {
		return this.voiture; 
	}
	
	public DateTime getDateHeureEntree() {
		return this.dateEntree; 
	}
	
	public double getMontantEntree() {
		return this.montantEntre; 
	}
	
	public String getHeureFin() {
		return FourreTout.formatageHeure(FourreTout.calculerFin(this.dateEntree, calculerDureeStationnement(this.montantEntre)));
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

	public void ObtenirTicket(double montantInsere) {
		this.montantEntre = montantInsere;
		this.dateEntree = this.horlogeInterne.ilEstExactement();
	}
}
