package wiese.repository.PaymentMethod;

import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.repository.Repository;

import java.util.Set;

public interface PaymentMethodRepository extends Repository<PaymentMethod, Integer> {
    Set<PaymentMethod> getAll();
}
