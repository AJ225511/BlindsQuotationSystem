package wiese.service.Supplier;

import wiese.domains.Supplier.Supplier;
import wiese.service.Service;

import java.util.Set;

public interface SupplierService extends Service<Supplier, Integer> {
    Set<Supplier> getAll();
}
