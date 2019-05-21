package wiese.factories.Invoice;

import wiese.domains.Invoice.Invoice;
import wiese.util.Misc;

public class InvoiceFactory {

    public static Invoice getInvoice(String invoiceDate, String invoiceItems){
        return new Invoice.Builder()
                .invoiceDate(invoiceDate)
                .invoiceItems(invoiceItems)
                .invoiceId(Misc.generateId())
                .build();
    }
}
