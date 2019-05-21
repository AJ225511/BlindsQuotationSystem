package wiese.repository.impl;

import org.springframework.stereotype.Repository;
import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.repository.PaymentMethod.PaymentMethodRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("PaymentMethodInMemory")
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {
    private static PaymentMethodRepositoryImpl repository = null;
    private Set<PaymentMethod> paymentMethods;

    private PaymentMethodRepositoryImpl(){
        this.paymentMethods = new HashSet<>();
    }

    public static PaymentMethodRepositoryImpl getRepository(){
        if(repository == null) repository = new PaymentMethodRepositoryImpl();
        return repository;
    }

    public PaymentMethod find(String id){
        return paymentMethods.stream().filter(paymentMethod -> paymentMethod.getPaymentId() == id).findAny().orElse(null);
    }

    @Override
    public Set<PaymentMethod> getAll() {
        return paymentMethods;
    }

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod) {
        this.paymentMethods.add(paymentMethod);
        return paymentMethod;
    }

    @Override
    public PaymentMethod update(PaymentMethod paymentMethod) {
        PaymentMethod paymentMethod1 = find(paymentMethod.getPaymentId());
        if(paymentMethods.contains(paymentMethod1)){
            paymentMethods.remove(paymentMethod1);
            paymentMethods.add(paymentMethod);
        }
        return paymentMethod1;
    }

    @Override
    public void delete(Integer id) {

        PaymentMethod paymentMethod = find(Integer.toString(id));
        paymentMethods.remove(paymentMethod);

    }

    @Override
    public PaymentMethod read(Integer id) {
        PaymentMethod paymentMethod = find(Integer.toString(id));
        if(paymentMethod == null){
            return null;
        }
        else{
            return paymentMethod;
        }
    }
}

