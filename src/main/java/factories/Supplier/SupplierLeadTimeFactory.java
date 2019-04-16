package factories.Supplier;

import domains.Supplier.SupplierLeadTime;
import util.Misc;

public class SupplierLeadTimeFactory {

    public static SupplierLeadTime getSupplierLeadTime(){
        return(SupplierLeadTime) new SupplierLeadTime.Builder()
                .leadTimeId(Misc.generateId())
                .build();
    }
}
