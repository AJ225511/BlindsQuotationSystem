package repository.Invoice;

import domains.Invoice.Invoice;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface InvoiceRepository extends Repository <Invoice, Integer> {
    Set<Invoice> getAll();
}
