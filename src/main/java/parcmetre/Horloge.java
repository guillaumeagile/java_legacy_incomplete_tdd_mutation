package parcmetre;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Horloge {
	
	private LocalDateTime tryNextMorning(LocalDateTime heureEntree) {
		LocalDateTime newHeureEntree = LocalDateTime.of(heureEntree.getYear(), heureEntree.getMonthValue(), heureEntree.getDayOfMonth(), 9, 0);
		if (heureEntree.getHour() >= 9) {
			newHeureEntree = newHeureEntree.plusDays(1);
		}
		return newHeureEntree;
	}
	
	public boolean estEntre9et19(LocalDateTime date) {
		return date.getHour() >= 9 && date.getHour() <= 18;
	}
	
	private boolean heureEntreePayante(LocalDateTime heureEntree) {
		boolean payant = true;
		if (!estEntre9et19(heureEntree) || estDimanche(heureEntree) || estJourFerie(heureEntree)
				|| estPeriodeFermee(heureEntree)) {
			payant = false;
		}
		return payant;
	}
	
	public LocalDateTime calculerFin(LocalDateTime heureEntree, int tempsStationnementMinutes) {
		while (!heureEntreePayante(heureEntree)) {
			heureEntree = tryNextMorning(heureEntree);
		}
		LocalDateTime heureSortie = heureEntree.plusMinutes(tempsStationnementMinutes);
		if (!estEntre9et19(heureSortie)) {	
			System.out.println("C'est tard");// Si on dépasse 19h,
			heureSortie = heureSortie.plusMinutes(840);		// on ajoute 14h (840min) à l'heure de sortie
		}
		if (estDimanche(heureSortie)) {				// Si on tombe le dimanche,
			heureSortie = heureSortie.plusMinutes(1440);	// on ajoute 24h (1440min) à l'heure de sortie
		}
		if (estJourFerie(heureSortie)) {				// Si on tombe un jour férié,
			heureSortie = heureSortie.plusMinutes(1440);	// on ajoute 24h (1440mn) à l'heure de sortie
		}
		if (estPeriodeFermee(heureSortie)) {					// Si on tombe pendant la période fermée d'août,
			heureSortie = heureSortie.plusMinutes(21600);	// on ajoute 15j (21600mn) à l'heure de sortie
		}
		return heureSortie;
	}
	
	public String formatageHeure(LocalDateTime heure) {
		String date_format = "dd-MM-yyyy HH:mm";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(date_format);
		return heure.format(formatter);
	}
	
 // Fonction qui vérifie si une date est un jour férié en France
    public boolean estJourFerie(LocalDateTime date) {
        int annee = date.getYear();
        LocalDateTime paques = calculerPaques(annee);
        LocalDateTime lundiPaques = paques.plusDays(1);
        LocalDateTime ascension = paques.plusDays(39);
        LocalDateTime lundiPentecote = paques.plusDays(50);
        
        // Jours fériés fixes
        if (date.getMonth() == Month.JANUARY && date.getDayOfMonth() == 1) {
            return true; // 1er janvier
        }
        if (date.getMonth() == Month.MAY && date.getDayOfMonth() == 1) {
            return true; // 1er mai
        }
        if (date.getMonth() == Month.MAY && date.getDayOfMonth() == 8) {
            return true; // 8 mai
        }
        if (date.getMonth() == Month.JULY && date.getDayOfMonth() == 14) {
            return true; // 14 juillet
        }
        if (date.getMonth() == Month.AUGUST && date.getDayOfMonth() == 15) {
            return true; // 15 août
        }
        if (date.getMonth() == Month.NOVEMBER && date.getDayOfMonth() == 1) {
            return true; // 1er novembre
        }
        if (date.getMonth() == Month.DECEMBER && date.getDayOfMonth() == 25) {
            return true; // 25 décembre
        }
        
        // Jours fériés mobiles
        if (date.isEqual(paques)) {
            return true; // Pâques
        }
        if (date.isEqual(lundiPaques)) {
            return true; // Lundi de Paques

            
        }
        if (date.isEqual(ascension)) {
            return true; // Ascension
        }
        if (date.isEqual(lundiPentecote)) {
            return true; // Lundi de Pentecôte
        }
        
        return false;
    }
    
 // Fonction qui calcule la date de Pâques pour une année donnée
    public LocalDateTime calculerPaques(int annee) {
        int a = annee / 100;
        int b = annee % 100;
        int c = (3 * (a + 25)) / 4;
        int d = (3 * (a + 25)) % 4;
        int e = (8 * (a + 11)) / 25;
        int f = (5 * a + b) % 19;
        int g = (19 * f + c - e) % 30;
        int h = (f + 11 * g) / 319;
        int j = (60 * (5 - d) + b) / 4;
        int k = (60 * (5 - d) + b) % 4;
        int m = (2 * j - k - g + h) % 7;
        int n = (g - h + m + 114) / 31;
        int p = (g - h + m + 114) % 31;
        int jour = p + 1;
        int mois = n;
        
     // Heure et minute arbitraires (00:00)
        int heure = LocalDateTime.now().getHour();
        int minutes = LocalDateTime.now().getMinute();

        return LocalDateTime.of(annee, mois, jour, heure, minutes);
    }
    
    // Fonction qui vérifie si une date est un dimanche
    public boolean estDimanche(LocalDateTime date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
    
    // Fonction qui vérifie si une date est entre le 10 et le 15 août inclus
    public boolean estPeriodeFermee(LocalDateTime date) {
    	return date.getMonthValue() == 8 && date.getDayOfMonth() < 16;
    }

}
