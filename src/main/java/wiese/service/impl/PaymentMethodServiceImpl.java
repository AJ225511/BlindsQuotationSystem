package wiese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.repository.PaymentMethod.PaymentMethodRepository;
import wiese.service.PaymentMethod.PaymentMethodService;

import java.util.List;
import java.util.Optional;

@Service("PaymentMethodServiceImpl")
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private static PaymentMethodServiceImpl assembleStatusService = null;
    @Autowired
    private PaymentMethodRepository assembleStatusRepository;

    private PaymentMethodServiceImpl() {

    }

    public static PaymentMethodService getPaymentMethodService() {
        if (assembleStatusService == null) assembleStatusService = new PaymentMethodServiceImpl();
        return assembleStatusService;
    }

    @Override
    public PaymentMethod create(PaymentMethod assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public PaymentMethod read(String s){
        Optional<PaymentMethod> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public PaymentMethod update(PaymentMethod assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public PaymentMethod retrieveByDesc(String assembleDesc){
        List<PaymentMethod> assembleStatuses = getAll();
        for(PaymentMethod assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<PaymentMethod> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}

