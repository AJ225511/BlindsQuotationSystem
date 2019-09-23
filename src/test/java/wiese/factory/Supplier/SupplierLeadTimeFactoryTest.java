package wiese.factory.Supplier;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Supplier.SupplierLeadTime;
import wiese.factories.Supplier.SupplierLeadTimeFactory;

public class SupplierLeadTimeFactoryTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getSupplierLeadTime() {

        SupplierLeadTime slt = SupplierLeadTimeFactory.getSupplierLeadTime();
        Assert.assertNotNull(slt.getLeadTimeId());
        System.out.println(slt.getLeadTimeId());
    }
}
