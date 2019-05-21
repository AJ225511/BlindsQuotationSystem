package wiese.factories.Quotation;

import wiese.domains.Quotation.QuotationItemStatus;
import wiese.util.Misc;

public class QuotationItemStatusFactory {

        public static QuotationItemStatus getQuotationItemStatus(){
            return( QuotationItemStatus) new  QuotationItemStatus.Builder()
                    .quotationItemStatusId(Misc.generateId())
                    .build();
        }
}
