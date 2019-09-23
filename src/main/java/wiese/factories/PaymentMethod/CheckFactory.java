package wiese.factories.PaymentMethod;

import wiese.domains.PaymentMethod.Check;
import wiese.util.Misc;

public class CheckFactory {

    public static Check getCheck() {
        return (Check) new Check.Builder()
                .checkId(Misc.generateId())
                .build();
    }
}
