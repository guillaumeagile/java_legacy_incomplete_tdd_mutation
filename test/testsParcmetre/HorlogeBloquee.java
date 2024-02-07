package testsParcmetre;

import org.joda.time.DateTime;
import parcmetre.IHorloge;

public class HorlogeBloquee implements IHorloge {
    @Override
    public DateTime ilEstExactement() {
        return new DateTime(2005, 3, 26, 0, 0, 0, 0);
    }
}
