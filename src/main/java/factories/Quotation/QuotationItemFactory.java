package factories.Quotation;

import domains.Quotation.QuotationItem;
import util.Misc;

public class QuotationItemFactory {

    public static QuotationItem getQuotationItem(){
        return(QuotationItem) new QuotationItem.Builder()
                .quotationItemId(Misc.generateId())
                .build();
    }
}
