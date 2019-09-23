package wiese.factory.Client;

import wiese.factories.Client.ClientFactory;
import wiese.domains.Client.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ClientFactoryTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getEmployee() {

        Client client = ClientFactory.getClient("AJ", "12 Bratton Way", "wiese@gmail.com", 1234);
        Assert.assertNotNull(client.getClientId());
        System.out.println(client.getClientName());
    }
}
