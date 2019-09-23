package wiese.repository.impl;

import org.springframework.stereotype.Repository;
import wiese.domains.Supplier.SupplierLeadTime;
import wiese.repository.Supplier.SupplierLeadTimeRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("SupplierLeadTimeInMemory")
public class SupplierLeadTimeRepositoryImpl implements SupplierLeadTimeRepository {

    private static SupplierLeadTimeRepositoryImpl repository = null;
    private Set<SupplierLeadTime> supplierLeadTimes;

    private SupplierLeadTimeRepositoryImpl() {
        this.supplierLeadTimes = new HashSet<>();
    }

    public static SupplierLeadTimeRepositoryImpl getRepository() {
        if (repository == null) repository = new SupplierLeadTimeRepositoryImpl();
        return repository;
    }

    public SupplierLeadTime find(String id) {
        return supplierLeadTimes.stream().filter(supplierLeadTime -> supplierLeadTime.getLeadTimeId() == id).findAny().orElse(null);
    }

    @Override
    public Set<SupplierLeadTime> getAll() {
        return supplierLeadTimes;
    }

    @Override
    public SupplierLeadTime create(SupplierLeadTime supplierLeadTime) {
        this.supplierLeadTimes.add(supplierLeadTime);
        return supplierLeadTime;
    }

    @Override
    public SupplierLeadTime update(SupplierLeadTime supplierLeadTime) {
        SupplierLeadTime supplierLeadTime1 = find(supplierLeadTime.getLeadTimeId());
        if (supplierLeadTimes.contains(supplierLeadTime1)) {
            supplierLeadTimes.remove(supplierLeadTime1);
            supplierLeadTimes.add(supplierLeadTime);
        }
        return supplierLeadTime1;
    }

    @Override
    public void delete(Integer id) {

        SupplierLeadTime supplierLeadTime = find(Integer.toString(id));
        supplierLeadTimes.remove(supplierLeadTime);

    }

    @Override
    public SupplierLeadTime read(Integer id) {
        SupplierLeadTime supplierLeadTime = find(Integer.toString(id));
        if (supplierLeadTime == null) {
            return null;
        } else {
            return supplierLeadTime;
        }
    }
}

