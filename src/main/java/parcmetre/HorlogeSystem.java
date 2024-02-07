package parcmetre;

import org.joda.time.DateTime;

import java.util.Date;

public class HorlogeSystem implements IHorloge {
    @Override
    public DateTime ilEstExactement() {
        return new DateTime(DateTime.now());
    }
}
