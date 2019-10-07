package wiese.repository.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Supplier.AssembleStatus;

@Repository
public interface AssembleStatusRepository extends JpaRepository<AssembleStatus, String> {

}
