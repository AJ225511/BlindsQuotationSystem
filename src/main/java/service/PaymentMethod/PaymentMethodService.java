package service.PaymentMethod;

import domains.PaymentMethod.PaymentMethod;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface PaymentMethodService extends Service<PaymentMethod, Integer> {
    Set<PaymentMethod> getAll();
}
