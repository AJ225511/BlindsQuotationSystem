package wiese.repository.Client;

import wiese.domains.Client.Client;
import wiese.factories.Client.ClientFactory;
import wiese.repository.impl.ClientRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class ClientRepositoryImplTest {
    @Autowired
    private ClientRepositoryImpl clientRepository;
    private String clientId = null;

    @Test
    public void create() throws IOException{

        Client client = ClientFactory.getClient("AJ", "West Beach", "ajwiese@gmail.com", 123);
        Client result = clientRepository.create(client);
        clientId = result.getClientId();
        Assert.assertNotNull(client);
        //System.out.println(clientId);
    }

    @Test
    public void read(){
        try {
            Client client = ClientFactory.getClient("AJ", "West Beach", "ajwiese@gmail.com", 123);
            clientRepository.create(client);

            Assert.assertNotNull(clientRepository.getAll());
            System.out.println(client);

            Client client1 = clientRepository.read(Integer.parseInt(client.getClientId()));
            Assert.assertEquals(client, client1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update(){

        Client client = ClientFactory.getClient("AJ", "West Beach", "ajwiese@gmail.com", 123);
        clientRepository.create(client);

        Assert.assertNotNull(clientRepository.getAll());
        Client client1 = ClientFactory.getClient("JJ", "Parklands", "jjwiese@gmail.com", 1234);
        client1.setClientId(client.getClientId());
        clientRepository.update(client1);

        Client updatedClient = clientRepository.find(client1.getClientId());
        Assert.assertEquals(client1, updatedClient);

        System.out.println(updatedClient);

    }

    @Test
    public void delete(){
        try {
            Client client = ClientFactory.getClient("AJ", "West Beach", "ajwiese@gmail.com", 123);
            clientRepository.create(client);

            Assert.assertNotNull(clientRepository.getAll());
            clientRepository.delete(Integer.parseInt(client.getClientId()));
            Client deleted = clientRepository.find(client.getClientId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
        }

    }
    @Test
    public void getAll(){
        Set<Client> clients = clientRepository.getAll();
        Assert.assertEquals(0, clients.size());
    }

}
