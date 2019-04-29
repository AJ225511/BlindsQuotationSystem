package service.Supplier;

import domains.Supplier.SupplierLeadTime;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface SupplierLeadTimeService extends Service<SupplierLeadTime, Integer> {
    Set<SupplierLeadTime> getAll();
}
