package wiese.factories.PaymentMethod;

import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.util.Misc;

public class PaymentMethodFactory {

    public static PaymentMethod getPaymentMethod(String paymentDate) {
        return new PaymentMethod.Builder()
                .paymentDate(paymentDate)
                .paymentMethodId(Misc.generateId())
                .build();
    }
}
