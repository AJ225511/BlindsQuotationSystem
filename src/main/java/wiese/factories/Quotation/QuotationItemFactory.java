package wiese.factories.Quotation;

import wiese.domains.Quotation.QuotationItem;
import wiese.util.Misc;

public class QuotationItemFactory {

    public static QuotationItem getQuotationItem() {
        return (QuotationItem) new QuotationItem.Builder()
                .quotationItemId(Misc.generateId())
                .build();
    }
}
