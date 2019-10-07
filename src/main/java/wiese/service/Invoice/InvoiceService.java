package wiese.service.Invoice;

import wiese.domains.Invoice.Invoice;
import wiese.service.Service;

import java.util.List;
import java.util.Set;

public interface InvoiceService extends Service<Invoice, String> {
    Invoice retrieveByDesc(String invoiceDesc);
    List<Invoice> getAll();
}
