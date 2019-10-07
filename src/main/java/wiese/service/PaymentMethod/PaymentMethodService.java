package wiese.service.PaymentMethod;

import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.service.Service;

import java.util.List;
import java.util.Set;

public interface PaymentMethodService extends Service<PaymentMethod, String> {
    PaymentMethod retrieveByDesc(String paymentMethodDesc);
    List<PaymentMethod> getAll();
}
