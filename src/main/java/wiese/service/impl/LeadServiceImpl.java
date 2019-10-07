package wiese.service.impl;

import wiese.service.Client.LeadService;
import wiese.domains.Client.Lead;
import wiese.repository.Client.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadServiceImpl implements LeadService {

    private static LeadServiceImpl assembleStatusService = null;
    @Autowired
    private LeadRepository assembleStatusRepository;

    private LeadServiceImpl() {

    }

    public static LeadService getLeadService() {
        if (assembleStatusService == null) assembleStatusService = new LeadServiceImpl();
        return assembleStatusService;
    }

    @Override
    public Lead create(Lead assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public Lead read(String s){
        Optional<Lead> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public Lead update(Lead assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public Lead retrieveByDesc(String assembleDesc){
        List<Lead> assembleStatuses = getAll();
        for(Lead assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<Lead> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}

