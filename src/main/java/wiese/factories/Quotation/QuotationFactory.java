package wiese.factories.Quotation;

import wiese.domains.Quotation.Quotation;
import wiese.util.Misc;

public class QuotationFactory {

    public static Quotation getQuotation(String quotationDate) {
        return new Quotation.Builder()
                .quotationDate(quotationDate)
                .quotationId(Misc.generateId())
                .build();
    }
}
