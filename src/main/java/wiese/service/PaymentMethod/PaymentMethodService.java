package wiese.service.PaymentMethod;

import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.service.Service;

import java.util.Set;

public interface PaymentMethodService extends Service<PaymentMethod, Integer> {
    Set<PaymentMethod> getAll();
}
