package wiese.service.impl;

import org.springframework.stereotype.Service;
import wiese.domains.Supplier.AssembleStatus;
import wiese.repository.Supplier.AssembleStatusRepository;
import wiese.repository.impl.AssembleStatusRepositoryImpl;
import wiese.service.Supplier.AssembleStatusService;

import java.util.Set;

@Service("AssembleStatusServiceImpl")
public class AssembleStatusServiceImpl implements AssembleStatusService {

    private AssembleStatusServiceImpl service = null;
    private AssembleStatusRepository repository;
    private Integer id;

    public AssembleStatusServiceImpl(){
        repository = AssembleStatusRepositoryImpl.getRepository();
    }

    public AssembleStatusService getService(){
        if(service == null) service = new AssembleStatusServiceImpl();
        return service;
    }

    @Override
    public Set<AssembleStatus> getAll() {
        return this.repository.getAll();
    }

    @Override
    public AssembleStatus create(AssembleStatus assembleStatus) {
        return this.repository.create(assembleStatus);
    }

    @Override
    public AssembleStatus update(AssembleStatus assembleStatus) {
        return this.repository.update(assembleStatus);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public AssembleStatus read(Integer integer) {
        return this.repository.read(id);
    }
}

