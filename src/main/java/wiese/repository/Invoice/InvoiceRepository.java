package wiese.repository.Invoice;

import wiese.domains.Invoice.Invoice;
import wiese.repository.Repository;

import java.util.Set;

public interface InvoiceRepository extends Repository <Invoice, Integer> {
    Set<Invoice> getAll();
}
