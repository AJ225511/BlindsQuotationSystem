package wiese.repository.Quotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Quotation.Quotation;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, String> {

}
