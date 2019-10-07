package wiese.service.Supplier;

import wiese.domains.Supplier.Supplier;
import wiese.service.Service;

import java.util.List;
import java.util.Set;

public interface SupplierService extends Service<Supplier, String> {
    Supplier retrieveByDesc(String supplierDesc);
    List<Supplier> getAll();
}
