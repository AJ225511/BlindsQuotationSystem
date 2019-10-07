package wiese.repository.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Supplier.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {

}
