package wiese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiese.domains.Quotation.Quotation;
import wiese.repository.Quotation.QuotationRepository;
import wiese.service.Quotation.QuotationService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuotationServiceImpl implements QuotationService {

    private static QuotationServiceImpl assembleStatusService = null;
    @Autowired
    private QuotationRepository assembleStatusRepository;

    private QuotationServiceImpl() {

    }

    public static QuotationService getQuotationService() {
        if (assembleStatusService == null) assembleStatusService = new QuotationServiceImpl();
        return assembleStatusService;
    }

    @Override
    public Quotation create(Quotation assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public Quotation read(String s){
        Optional<Quotation> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public Quotation update(Quotation assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public Quotation retrieveByDesc(String assembleDesc){
        List<Quotation> assembleStatuses = getAll();
        for(Quotation assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<Quotation> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}