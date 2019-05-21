package wiese.service.Supplier;

import wiese.domains.Supplier.SupplierLeadTime;
import wiese.service.Service;

import java.util.Set;

public interface SupplierLeadTimeService extends Service<SupplierLeadTime, Integer> {
    Set<SupplierLeadTime> getAll();
}
