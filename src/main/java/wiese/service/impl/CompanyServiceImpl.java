package wiese.service.impl;

import org.springframework.stereotype.Service;
import wiese.service.Company.CompanyService;
import wiese.domains.Company.Company;
import wiese.repository.Company.CompanyRepository;
import wiese.repository.impl.CompanyRepositoryImpl;

import java.util.Set;

@Service("CompanyServiceImpl")
public class CompanyServiceImpl implements CompanyService {

    private CompanyServiceImpl service = null;
    private CompanyRepository repository;
    private Integer id;

    public CompanyServiceImpl(){
        repository = CompanyRepositoryImpl.getRepository();
    }

    public CompanyService getService(){
        if(service == null) service = new CompanyServiceImpl();
        return service;
    }

    @Override
    public Set<Company> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Company create(Company company) {
        return this.repository.create(company);
    }

    @Override
    public Company update(Company company) {
        return this.repository.update(company);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public Company read(Integer integer) {
        return this.repository.read(id);
    }
}

