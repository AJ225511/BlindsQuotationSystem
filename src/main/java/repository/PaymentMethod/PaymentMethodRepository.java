package repository.PaymentMethod;

import domains.PaymentMethod.PaymentMethod;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface PaymentMethodRepository extends Repository <PaymentMethod, Integer> {
    Set<PaymentMethod> getAll();
}
