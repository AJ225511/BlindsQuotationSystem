package wiese.factory.Supplier;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Supplier.Supplier;
import wiese.factories.Supplier.SupplierFactory;

public class SupplierFactoryTest {
    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void getSupplier(){

        Supplier sup = SupplierFactory.getSupplier("Taylor Blinds", "12 Bratton Way");
        Assert.assertNotNull(sup.getSupplierId());
        System.out.println(sup.getSupplierName());
    }
}
