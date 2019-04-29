package service.impl;

import repository.impl.LeadRepositoryImpl;
import service.Client.LeadService;
import domains.Client.Lead;
import repository.Client.LeadRepository;

import java.util.Set;

public class LeadServiceImpl implements LeadService {

    private LeadServiceImpl service = null;
    private LeadRepository repository;
    private Integer id;

    public LeadServiceImpl() {
        repository = LeadRepositoryImpl.getRepository();
    }

    public LeadService getService(){
        if(service == null) service = new LeadServiceImpl();
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

