package wiese.service.impl;

import org.springframework.stereotype.Service;
import wiese.domains.Supplier.AssembleStatus;
import wiese.repository.Supplier.AssembleStatusRepository;
import wiese.service.Supplier.AssembleStatusService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AssembleStatusServiceImpl implements AssembleStatusService {

    private static AssembleStatusServiceImpl assembleStatusService = null;
    @Autowired
    private AssembleStatusRepository assembleStatusRepository;

    private AssembleStatusServiceImpl() {

    }

    public static AssembleStatusService getAssembleStatusService() {
        if (assembleStatusService == null) assembleStatusService = new AssembleStatusServiceImpl();
        return assembleStatusService;
    }

    @Override
    public AssembleStatus create(AssembleStatus assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public AssembleStatus read(String s){
        Optional<AssembleStatus> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public AssembleStatus update(AssembleStatus assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public AssembleStatus retrieveByDesc(String assembleDesc){
        List<AssembleStatus> assembleStatuses = getAll();
        for(AssembleStatus assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<AssembleStatus> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}

