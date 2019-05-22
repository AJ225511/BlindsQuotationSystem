package wiese.factory.Client;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Client.Lead;
import wiese.factories.Client.LeadFactory;

public class LeadFactoryTest {
    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void getEmployee(){

        Lead lead= LeadFactory.getLead("12 April 2019");
        Assert.assertNotNull(lead.getLeadId());
        System.out.println(lead.getLeadDate());
    }
}
