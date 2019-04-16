package factories.Invoice;

import domains.Invoice.Invoice;
import util.Misc;

public class InvoiceFactory {

    public static Invoice getInvoice(String invoiceDate, String invoiceItems){
        return new Invoice.Builder()
                .invoiceDate(invoiceDate)
                .invoiceItems(invoiceItems)
                .invoiceId(Misc.generateId())
                .build();
    }
}
