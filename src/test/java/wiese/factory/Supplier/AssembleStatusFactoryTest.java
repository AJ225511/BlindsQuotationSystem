package wiese.factory.Supplier;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Supplier.AssembleStatus;
import wiese.factories.Supplier.AssembleStatusFactory;

public class AssembleStatusFactoryTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getAssembleStatus() {

        AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
        Assert.assertNotNull(assembleStatus.getAssembleStatusId());
        System.out.println(assembleStatus.getAssembleStatusId());
    }
}

