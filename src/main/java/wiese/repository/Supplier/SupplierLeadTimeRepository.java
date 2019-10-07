package wiese.repository.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Supplier.SupplierLeadTime;


@Repository
public interface SupplierLeadTimeRepository extends JpaRepository<SupplierLeadTime, String> {

}
