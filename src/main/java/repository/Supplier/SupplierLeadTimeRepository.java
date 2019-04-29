package repository.Supplier;

import domains.Supplier.SupplierLeadTime;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface SupplierLeadTimeRepository extends Repository <SupplierLeadTime, Integer> {
    Set<SupplierLeadTime> getAll();
}
