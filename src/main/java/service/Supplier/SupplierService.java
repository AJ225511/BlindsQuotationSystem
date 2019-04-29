package service.Supplier;

import domains.Supplier.Supplier;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface SupplierService extends Service<Supplier, Integer> {
    Set<Supplier> getAll();
}
