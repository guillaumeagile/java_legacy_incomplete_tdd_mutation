package parcmetre;

public class Ticket {
	private Parcmetre parcmetre;

    public Ticket(Parcmetre parcmetre) {
        this.parcmetre = parcmetre;
    }

    public String text() {
    	Voiture voiture = parcmetre.getVoiture();
    	String dateSortie = parcmetre.getHeureFin();
    	GrosBordel h = new GrosBordel();
    	StringBuilder res = new StringBuilder();
    	res.append("========== Ticket de stationnement ==========\n\n");
    	res.append("Votre vehicule : ");
    	res.append(voiture.getPlaqueImmatriculation());
    	res.append("\n");
    	res.append("Date d'entree : ");
    	res.append(h.formatageHeure(parcmetre.getDateEntree()));
    	res.append("\n");
    	res.append("Montant paye : ");
    	res.append(parcmetre.getMontantEntre());
    	res.append(" euros\n");
    	res.append("Date de sortie : ");
    	res.append(dateSortie);
    	res.append("\n");
    	res.append("\n\n");
    	res.append("Bonne journée à vous ! \n");
    	res.append("===============================================\n");
    	return res.toString();
    }
}