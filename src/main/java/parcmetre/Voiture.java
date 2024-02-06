package parcmetre;

public class Voiture {

	private  String plaqueImma = "";
	
	public Voiture(String plaqueImma) throws IllegalArgumentException{
		if(!isPlaqueValid(plaqueImma)) {
			throw new IllegalArgumentException("Plaque d'immatriculation invalide. Veuillez réessayer.");
		}
		this.plaqueImma = plaqueImma;
	} 
	
	public boolean isPlaqueValid(String immatriculation) {
		 String regex = "^[A-Z]{2}-\\d{3}-[A-Z]{2}$";
		 return immatriculation.matches(regex);
	}
	
	public String getPlaqueImmatriculation() {
		return this.plaqueImma;
	}
	
}
