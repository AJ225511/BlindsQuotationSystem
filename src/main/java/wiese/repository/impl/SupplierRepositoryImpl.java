package wiese.repository.impl;

import org.springframework.stereotype.Repository;
import wiese.domains.Supplier.Supplier;
import wiese.repository.Supplier.SupplierRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("SupplierInMemory")
public class SupplierRepositoryImpl implements SupplierRepository {

    private static SupplierRepositoryImpl repository = null;
    private Set<Supplier> suppliers;

    private SupplierRepositoryImpl() {
        this.suppliers = new HashSet<>();
    }

    public static SupplierRepositoryImpl getRepository() {
        if (repository == null) repository = new SupplierRepositoryImpl();
        return repository;
    }

    public Supplier find(String id) {
        return suppliers.stream().filter(supplier -> supplier.getSupplierId() == id).findAny().orElse(null);
    }

    @Override
    public Set<Supplier> getAll() {
        return suppliers;
    }

    @Override
    public Supplier create(Supplier supplier) {
        this.suppliers.add(supplier);
        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier) {
        Supplier supplier1 = find(supplier.getSupplierId());
        if (suppliers.contains(supplier1)) {
            suppliers.remove(supplier1);
            suppliers.add(supplier);
        }
        return supplier1;
    }

    @Override
    public void delete(Integer id) {

        Supplier supplier = find(Integer.toString(id));
        suppliers.remove(supplier);

    }

    @Override
    public Supplier read(Integer id) {
        Supplier supplier = find(Integer.toString(id));
        if (supplier == null) {
            return null;
        } else {
            return supplier;
        }
    }
}
