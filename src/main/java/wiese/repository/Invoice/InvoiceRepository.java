package wiese.repository.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Invoice.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {

}
