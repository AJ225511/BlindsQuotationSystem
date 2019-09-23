package wiese.service.impl;

import wiese.repository.impl.LeadRepositoryImpl;
import wiese.service.Client.LeadService;
import wiese.domains.Client.Lead;
import wiese.repository.Client.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("LeadServiceImpl")
public class LeadServiceImpl implements LeadService {

    private LeadServiceImpl service = null;
    private LeadRepository repository;
    private Integer id;

    public LeadServiceImpl() {
        repository = LeadRepositoryImpl.getRepository();
    }

    public LeadService getService() {
        if (service == null) service = new LeadServiceImpl();
        return service;
    }

    @Override
    public Set<Lead> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Lead create(Lead lead) {
        return this.repository.create(lead);
    }

    @Override
    public Lead update(Lead lead) {
        return this.repository.update(lead);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public Lead read(Integer integer) {
        return this.repository.read(id);
    }
}

