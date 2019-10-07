package wiese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiese.service.Company.CompanyService;
import wiese.domains.Company.Company;
import wiese.repository.Company.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static CompanyServiceImpl assembleStatusService = null;
    @Autowired
    private CompanyRepository assembleStatusRepository;

    private CompanyServiceImpl() {

    }

    public static CompanyService getCompanyService() {
        if (assembleStatusService == null) assembleStatusService = new CompanyServiceImpl();
        return assembleStatusService;
    }

    @Override
    public Company create(Company assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public Company read(String s){
        Optional<Company> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public Company update(Company assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public Company retrieveByDesc(String assembleDesc){
        List<Company> assembleStatuses = getAll();
        for(Company assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<Company> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}


