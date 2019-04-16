package factories.Quotation;

import domains.Quotation.Quotation;
import util.Misc;

public class QuotationFactory {

    public static Quotation getQuotation(String quotationDate){
        return new Quotation.Builder()
                .quotationDate(quotationDate)
                .quotationId(Misc.generateId())
                .build();
    }
}
