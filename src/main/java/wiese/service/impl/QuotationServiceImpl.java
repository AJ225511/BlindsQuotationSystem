package wiese.service.impl;

import org.springframework.stereotype.Service;
import wiese.domains.Quotation.Quotation;
import wiese.repository.Quotation.QuotationRepository;
import wiese.repository.impl.QuotationRepositoryImpl;
import wiese.service.Quotation.QuotationService;

import java.util.Set;

@Service("QuotationServiceImpl")
public class QuotationServiceImpl implements QuotationService {

    private QuotationServiceImpl service = null;
    private QuotationRepository repository;
    private Integer id;

    public QuotationServiceImpl() {
        repository = QuotationRepositoryImpl.getRepository();
    }

    public QuotationService getService() {
        if (service == null) service = new QuotationServiceImpl();
        return service;
    }

    @Override
    public Set<Quotation> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Quotation create(Quotation quotation) {
        return this.repository.create(quotation);
    }

    @Override
    public Quotation update(Quotation quotation) {
        return this.repository.update(quotation);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public Quotation read(Integer integer) {
        return this.repository.read(id);
    }
}
