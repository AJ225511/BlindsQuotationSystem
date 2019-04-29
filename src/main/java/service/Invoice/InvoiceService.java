package service.Invoice;

import domains.Invoice.Invoice;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface InvoiceService extends Service<Invoice, Integer> {
    Set<Invoice> getAll();
}
