package factories.PaymentMethod;

import domains.PaymentMethod.Check;
import util.Misc;

public class CheckFactory {

    public static  Check getCheck(){
        return(Check) new Check.Builder()
                .checkId(Misc.generateId())
                .build();
    }
}
