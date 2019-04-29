package repository.Supplier;

import domains.Supplier.Supplier;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface SupplierRepository extends Repository <Supplier, Integer> {
    Set<Supplier> getAll();
}
