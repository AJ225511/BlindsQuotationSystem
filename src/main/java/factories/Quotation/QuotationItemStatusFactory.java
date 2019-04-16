package factories.Quotation;

import domains.Quotation.QuotationItemStatus;
import util.Misc;

public class QuotationItemStatusFactory {

        public static QuotationItemStatus getQuotationItemStatus(){
            return( QuotationItemStatus) new  QuotationItemStatus.Builder()
                    .quotationItemStatusId(Misc.generateId())
                    .build();
        }
}
