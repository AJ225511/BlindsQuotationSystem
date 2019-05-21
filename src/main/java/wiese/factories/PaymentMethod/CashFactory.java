package wiese.factories.PaymentMethod;

import wiese.domains.PaymentMethod.Cash;

public class CashFactory {

    public static Cash getCash(int cashAmount){
        return(Cash) new Cash.Builder()
                .cashAmount(cashAmount)
                .build();
    }
}
