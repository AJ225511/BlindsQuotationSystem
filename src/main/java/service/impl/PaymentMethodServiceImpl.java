package service.impl;

import domains.PaymentMethod.PaymentMethod;
import repository.PaymentMethod.PaymentMethodRepository;
import repository.impl.PaymentMethodRepositoryImpl;
import service.PaymentMethod.PaymentMethodService;

import java.util.Set;

public class PaymentMethodServiceImpl implements PaymentMethodService {

    private PaymentMethodServiceImpl service = null;
    private PaymentMethodRepository repository;
    private Integer id;

    public PaymentMethodServiceImpl(){
        repository = PaymentMethodRepositoryImpl.getRepository();
    }

    public PaymentMethodService getService(){
        if(service == null) service = new PaymentMethodServiceImpl();
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

