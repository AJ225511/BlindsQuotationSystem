package factories.PaymentMethod;

import domains.PaymentMethod.CreditCard;

public class CreditCardFactory {

    public static  CreditCard getCreditCard(String savings){
        return(CreditCard) new CreditCard.Builder()
                .savings(savings)
                .build();
    }
}
