package parcmetre;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

import static org.joda.time.DateTimeConstants.JANUARY;

// cette classe n'a aucune raison d'exister à part d'être un gros fourre tout de bugs 💩
public class FourreTout {

	public static boolean estEntre9et19(DateTime date) {
		return date.getHourOfDay() >= 9 && date.getHourOfDay() <= 18;
	}
	
	private static boolean heureEntreePayante(DateTime heureEntree) {
		boolean payant = true;
		if (!estEntre9et19(heureEntree) || estDimanche(heureEntree) || estJourFerie(heureEntree)
				|| estPeriodeFermee(heureEntree)) {
			payant = false;
		}
		return payant;
	}
	
	public static DateTime calculerFin(DateTime heureEntree, int tempsStationnementMinutes) {

		DateTime heureSortie = heureEntree.plusMinutes(tempsStationnementMinutes);
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
	
	public static String formatageHeure(DateTime heure) {
		String date_format = "dd-MM-yyyy HH:mm";
        DateTimeFormatter fmt = DateTimeFormat.forPattern(date_format);
        return heure.toString(fmt);
	}
	
 // Fonction qui vérifie si une date est un jour férié en France
    public static boolean estJourFerie(DateTime date) {
        int annee = date.getYear();
//        LocalDateTime paques = calculerPaques(annee);
//        LocalDateTime lundiPaques = paques.plusDays(1);
//        LocalDateTime ascension = paques.plusDays(39);
//        LocalDateTime lundiPentecote = paques.plusDays(50);
        
        // Jours fériés fixes
        if (date.getMonthOfYear() == JANUARY && date.getDayOfMonth() == 1) {
            return true; // 1er janvier
        }
        if (date.getMonthOfYear() == DateTimeConstants.MAY && date.getDayOfMonth() == 1) {
            return true; // 1er mai
        }
        if (date.getMonthOfYear() == DateTimeConstants.MAY && date.getDayOfMonth() == 8) {
            return true; // 8 mai
        }
        if (date.getMonthOfYear() == DateTimeConstants.JULY && date.getDayOfMonth() == 14) {
            return true; // 14 juillet
        }
        if (date.getMonthOfYear() == DateTimeConstants.AUGUST && date.getDayOfMonth() == 15) {
            return true; // 15 août
        }
        if (date.getMonthOfYear() == DateTimeConstants.NOVEMBER && date.getDayOfMonth() == 1) {
            return true; // 1er novembre
        }
        if (date.getMonthOfYear() == DateTimeConstants.DECEMBER && date.getDayOfMonth() == 25) {
            return true; // 25 décembre
        }

        return false;
    }
    

    // Fonction qui vérifie si une date est un dimanche
    public static boolean estDimanche(DateTime date) {
        return date.getDayOfWeek() ==  DateTimeConstants.SUNDAY;
    }
    
    // Fonction qui vérifie si une date est entre le 10 et le 15 août inclus
    public static boolean estPeriodeFermee(DateTime date) {
    	return date.getMonthOfYear() == 8 && date.getDayOfMonth() < 16;
    }

}
