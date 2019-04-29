package service.impl;

import domains.Supplier.SupplierLeadTime;
import repository.Supplier.SupplierLeadTimeRepository;
import repository.impl.SupplierLeadTimeRepositoryImpl;
import service.Supplier.SupplierLeadTimeService;

import java.util.Set;

public class SupplierLeadTimeServiceImpl implements SupplierLeadTimeService{

    private SupplierLeadTimeServiceImpl service = null;
    private SupplierLeadTimeRepository repository;
    private Integer id;

    public SupplierLeadTimeServiceImpl(){
        repository = SupplierLeadTimeRepositoryImpl.getRepository();
    }

    public SupplierLeadTimeService getService(){
        if(service == null) service = new SupplierLeadTimeServiceImpl();
        return service;
    }

    @Override
    public Set<SupplierLeadTime> getAll() {
        return this.repository.getAll();
    }

    @Override
    public SupplierLeadTime create(SupplierLeadTime supplierLeadTime) {
        return this.repository.create(supplierLeadTime);
    }

    @Override
    public SupplierLeadTime update(SupplierLeadTime supplierLeadTime) {
        return this.repository.update(supplierLeadTime);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public SupplierLeadTime read(Integer integer) {
        return this.repository.read(id);
    }
}

