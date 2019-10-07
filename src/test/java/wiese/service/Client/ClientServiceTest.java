package wiese.service.Client;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import wiese.domains.Client.Client;
import wiese.factories.Client.ClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.repository.Client.ClientRepository;
import wiese.service.impl.ClientServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    public void create() {

        Client client = ClientFactory.getClient("Aj", "13 Bratton Way", "ajwiese@gnail.com");
        clientService.create(client);
        Assert.assertNotNull(clientService.getAll());

    }

    @Test
    public void read(){
        Client client = ClientFactory.getClient("Aj", "13 Bratton Way", "ajwiese@gnail.com");
        clientService.create(client);
        Assert.assertNotNull(clientService.getAll());

        Client client1 = clientService.read(client.getClientId());
        Assert.assertEquals(client,client1);
    }

    @Test
    public void update(){
        Client client = ClientFactory.getClient("Aj", "13 Bratton Way", "ajwiese@gnail.com");
        clientService.create(client);
        Assert.assertNotNull(clientService.getAll());

        Client clientUpdate = ClientFactory.getClient("JJ", "15 Bratton Way", "jjwiese@gnail.com");
        clientUpdate.setClientId(client.getClientId());
        clientService.update(clientUpdate);

        Client updated = clientService.read(clientUpdate.getClientId());
        Assert.assertEquals(clientUpdate,updated);
    }

    @Test
    public void delete() {
        Client client = ClientFactory.getClient("Aj", "13 Bratton Way", "ajwiese@gnail.com");
        clientService.create(client);
        Assert.assertNotNull(clientService.getAll());
        clientService.delete(client.getClientId());

        Client deleted = clientService.read(client.getClientId());
        Assert.assertNull(deleted);

    }
}
