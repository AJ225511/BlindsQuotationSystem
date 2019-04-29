package service.impl;

import domains.Supplier.AssembleStatus;
import repository.Supplier.AssembleStatusRepository;
import repository.impl.AssembleStatusRepositoryImpl;
import service.Supplier.AssembleStatusService;

import java.util.Set;

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

