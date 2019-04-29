package repository;

import domains.Client.Client;
import factories.Client.ClientFactory;
import repository.impl.ClientRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientRepositoryImplTest {

    ClientRepositoryImpl clientRepository;

    @Before
    public void setUp() throws Exception{
        clientRepository = ClientRepositoryImpl.getRepository();
    }

    @Test
    public void create(){

        Client client = ClientFactory.getClient("AJ", "West Beach", "ajwiese@gmail.com", 123);
        clientRepository.create(client);

        Assert.assertNotNull(clientRepository.getAll());
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
}
