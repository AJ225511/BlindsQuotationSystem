package factories.PaymentMethod;

import domains.PaymentMethod.Cash;

public class CashFactory {

    public static Cash getCash(int cashAmount){
        return(Cash) new Cash.Builder()
                .cashAmount(cashAmount)
                .build();
    }
}
