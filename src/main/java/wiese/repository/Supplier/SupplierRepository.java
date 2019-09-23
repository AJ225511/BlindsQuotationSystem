package wiese.repository.Supplier;

import wiese.domains.Supplier.Supplier;
import wiese.repository.Repository;

import java.util.Set;

public interface SupplierRepository extends Repository<Supplier, Integer> {
    Set<Supplier> getAll();
}
