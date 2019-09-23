package wiese.factories.Quotation;

import wiese.domains.Quotation.QuotationStatus;
import wiese.util.Misc;

public class QuotationStatusFactory {

    public static QuotationStatus getQuotationStatus() {
        return (QuotationStatus) new QuotationStatus.Builder()
                .quotationStatusId(Misc.generateId())
                .build();
    }
}
