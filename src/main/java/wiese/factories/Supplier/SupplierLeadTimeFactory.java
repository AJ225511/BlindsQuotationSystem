package wiese.factories.Supplier;

import wiese.domains.Supplier.SupplierLeadTime;
import wiese.util.Misc;

public class SupplierLeadTimeFactory {

    public static SupplierLeadTime getSupplierLeadTime() {
        return (SupplierLeadTime) new SupplierLeadTime.Builder()
                .leadTimeId(Misc.generateId())
                .build();
    }
}
