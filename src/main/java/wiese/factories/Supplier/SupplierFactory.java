package wiese.factories.Supplier;

import wiese.domains.Supplier.Supplier;

public class SupplierFactory {

    public static Supplier getSupplier(String supplierName, String supplierAddress){
        return new Supplier.Builder()
                .supplierName(supplierName)
                .supplierAddress(supplierAddress)
                .build();
    }
}
