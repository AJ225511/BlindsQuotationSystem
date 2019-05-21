package wiese.repository.impl;

import org.springframework.stereotype.Repository;
import wiese.domains.Supplier.AssembleStatus;
import wiese.repository.Supplier.AssembleStatusRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("AssembleStatusInMemory")
public class AssembleStatusRepositoryImpl implements AssembleStatusRepository{

    private static AssembleStatusRepositoryImpl repository = null;
    private Set<AssembleStatus> assembleStatuss;

    private AssembleStatusRepositoryImpl(){
        this.assembleStatuss = new HashSet<>();
    }

    public static AssembleStatusRepositoryImpl getRepository(){
        if(repository == null) repository = new AssembleStatusRepositoryImpl();
        return repository;
    }

    public AssembleStatus find(String id){
        return assembleStatuss.stream().filter(assembleStatus -> assembleStatus.getAssembleStatusId() == id).findAny().orElse(null);
    }

    @Override
    public Set<AssembleStatus> getAll() {
        return assembleStatuss;
    }

    @Override
    public AssembleStatus create(AssembleStatus assembleStatus) {
        this.assembleStatuss.add(assembleStatus);
        return assembleStatus;
    }

    @Override
    public AssembleStatus update(AssembleStatus assembleStatus) {
        AssembleStatus assembleStatus1 = find(assembleStatus.getAssembleStatusId());
        if(assembleStatuss.contains(assembleStatus1)){
            assembleStatuss.remove(assembleStatus1);
            assembleStatuss.add(assembleStatus);
        }
        return assembleStatus1;
    }

    @Override
    public void delete(Integer id) {

        AssembleStatus assembleStatus = find(Integer.toString(id));
        assembleStatuss.remove(assembleStatus);

    }

    @Override
    public AssembleStatus read(Integer id) {
        AssembleStatus assembleStatus = find(Integer.toString(id));
        if(assembleStatus == null){
            return null;
        }
        else{
            return assembleStatus;
        }
    }
}
