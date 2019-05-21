package wiese.factories.PaymentMethod;

import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.util.Misc;

public class PaymentMethodFactory {

    public static PaymentMethod getPaymentMethod(int paymentAmount, String paymentDate){
        return new PaymentMethod.Builder()
                .paymentAmount(paymentAmount)
                .paymentDate(paymentDate)
                .paymentId(Misc.generateId())
                .build();
    }
}
