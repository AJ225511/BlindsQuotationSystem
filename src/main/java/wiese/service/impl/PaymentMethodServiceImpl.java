package wiese.service.impl;

import org.springframework.stereotype.Service;
import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.repository.PaymentMethod.PaymentMethodRepository;
import wiese.repository.impl.PaymentMethodRepositoryImpl;
import wiese.service.PaymentMethod.PaymentMethodService;

import java.util.Set;

@Service("PaymentMethodServiceImpl")
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private PaymentMethodServiceImpl service = null;
    private PaymentMethodRepository repository;
    private Integer id;

    public PaymentMethodServiceImpl() {
        repository = PaymentMethodRepositoryImpl.getRepository();
    }

    public PaymentMethodService getService() {
        if (service == null) service = new PaymentMethodServiceImpl();
        return service;
    }

    @Override
    public Set<PaymentMethod> getAll() {
        return this.repository.getAll();
    }

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod) {
        return this.repository.create(paymentMethod);
    }

    @Override
    public PaymentMethod update(PaymentMethod paymentMethod) {
        return this.repository.update(paymentMethod);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public PaymentMethod read(Integer integer) {
        return this.repository.read(id);
    }
}

