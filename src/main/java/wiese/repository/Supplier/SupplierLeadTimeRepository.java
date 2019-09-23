package wiese.repository.Supplier;

import wiese.domains.Supplier.SupplierLeadTime;
import wiese.repository.Repository;

import java.util.Set;

public interface SupplierLeadTimeRepository extends Repository<SupplierLeadTime, Integer> {
    Set<SupplierLeadTime> getAll();
}
