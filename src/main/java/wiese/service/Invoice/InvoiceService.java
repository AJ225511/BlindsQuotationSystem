package wiese.service.Invoice;

import wiese.domains.Invoice.Invoice;
import wiese.service.Service;

import java.util.Set;

public interface InvoiceService extends Service<Invoice, Integer> {
    Set<Invoice> getAll();
}
