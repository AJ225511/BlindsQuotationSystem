package factories.Quotation;

import domains.Quotation.QuotationStatus;
import util.Misc;

public class QuotationStatusFactory {

    public static QuotationStatus getQuotationStatus(){
        return(QuotationStatus) new  QuotationStatus.Builder()
                .quotationStatusId(Misc.generateId())
                .build();
    }
}
