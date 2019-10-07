package wiese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiese.domains.Supplier.Supplier;
import wiese.repository.Supplier.SupplierRepository;
import wiese.service.Supplier.SupplierService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("SupplierServiceImpl")
public class SupplierServiceImpl implements SupplierService {

    private static SupplierServiceImpl assembleStatusService = null;
    @Autowired
    private SupplierRepository assembleStatusRepository;

    private SupplierServiceImpl() {

    }

    public static SupplierService getSupplierService() {
        if (assembleStatusService == null) assembleStatusService = new SupplierServiceImpl();
        return assembleStatusService;
    }

    @Override
    public Supplier create(Supplier assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public Supplier read(String s){
        Optional<Supplier> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public Supplier update(Supplier assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public Supplier retrieveByDesc(String assembleDesc){
        List<Supplier> assembleStatuses = getAll();
        for(Supplier assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<Supplier> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}


