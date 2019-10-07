package wiese.service.Supplier;

import wiese.domains.Supplier.SupplierLeadTime;
import wiese.service.Service;

import java.util.List;
import java.util.Set;

public interface SupplierLeadTimeService extends Service<SupplierLeadTime, String> {
    SupplierLeadTime retrieveByDesc(String leadTimeDesc);
    List<SupplierLeadTime> getAll();
}
