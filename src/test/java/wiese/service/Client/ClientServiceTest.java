package wiese.service.Client;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Client.Client;
import wiese.factories.Client.ClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.ClientServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientServiceImpl clientService;

    @Test
    public void create() {
        Client client = ClientFactory.getClient("AJ", "13 Bratton way", "ajwiese@gmail.com", 1234);
        clientService.create(client);

        assertNotNull(clientService.getAll());
        System.out.println(client);
    }

    @Test
    public void read() {
        try {
            Client client = ClientFactory.getClient("JJ", "22 Bratton way", "jjwiese@gmail.com", 1224);
            clientService.create(client);

            Client client1 = clientService.read(Integer.parseInt(client.getClientId()));
            assertEquals(client, client1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            Client client = ClientFactory.getClient("AJ", "13 Bratton way", "ajwiese@gmail.com", 1234);
            clientService.create(client);

            Client client1 = ClientFactory.getClient("JJ", "22 Bratton way", "jjwiese@gmail.com", 1224);
            client1.setClientId(client.getClientId());
            clientService.update(client1);
            System.out.println("Original: \n" + client);
            System.out.println("Updated: \n" + client1);

            Client client2 = clientService.read(Integer.parseInt(client1.getClientId()));
            assertEquals(client1, client2);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }

    @Test
    public void delete() {
        try {
            Client client = ClientFactory.getClient("Erik", "11 Bratton way", "erik@gmail.com", 2214);
            clientService.create(client);

            assertNotNull(clientService.getAll());
            Client client1 = clientService.read(Integer.parseInt(client.getClientId()));
            assertNull(client1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }
}
