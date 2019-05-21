package wiese.service.impl;

import org.springframework.stereotype.Service;
import wiese.domains.Supplier.Supplier;
import wiese.repository.Supplier.SupplierRepository;
import wiese.repository.impl.SupplierRepositoryImpl;
import wiese.service.Supplier.SupplierService;

import java.util.Set;

@Service("SupplierServiceImpl")
public class SupplierServiceImpl implements SupplierService {
    
    private SupplierServiceImpl service = null;
    private SupplierRepository repository;
    private Integer id;

    public SupplierServiceImpl(){
        repository = SupplierRepositoryImpl.getRepository();
    }

    public SupplierService getService(){
        if(service == null) service = new SupplierServiceImpl();
        return service;
    }

    @Override
    public Set<Supplier> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Supplier create(Supplier supplier) {
        return this.repository.create(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return this.repository.update(supplier);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public Supplier read(Integer integer) {
        return this.repository.read(id);
    }
}


