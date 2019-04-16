package factories.PaymentMethod;

import domains.PaymentMethod.PaymentMethod;
import util.Misc;

public class PaymentMethodFactory {

    public static PaymentMethod getPaymentMethod(String paymentAmount, String paymentDate){
        return new PaymentMethod.Builder()
                .paymentAmount(paymentAmount)
                .paymentDate(paymentDate)
                .paymentId(Misc.generateId())
                .build();
    }
}
