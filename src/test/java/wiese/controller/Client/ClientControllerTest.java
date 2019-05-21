package wiese.controller.Client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Client.Client;
import wiese.factories.Client.ClientFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClientControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/client";

    @Test
    public void create(){
        Client client = ClientFactory.getClient("AJ", "West Beach", "ajwiese@gmail.com", 123);
        client.setClientId(client.getClientId());

        ResponseEntity<Client> postResponse = restTemplate.postForEntity(baseURL + "/create", client, Client.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(client);
    }

    @Test
    public void findId(){
        Client client = restTemplate.getForObject(baseURL + "/client/1", Client.class);
        assertNotNull(client);
        System.out.println(client.getClientName());
    }

    @Test
    public void update(){
        int id = 1;
        Client client = restTemplate.getForObject(baseURL = "/client/"+id, Client.class);

        restTemplate.put(baseURL + "/client/" + id, Client.class);
        Client updatedClient = restTemplate.getForObject(baseURL + "/client/" +id, Client.class);
        assertNotNull(updatedClient);
        System.out.println(updatedClient);
    }

    @Test
    public void delete(){
        int id = 2;
        Client client = restTemplate.getForObject(baseURL = "/client/"+id, Client.class);
        assertNotNull(client);
        restTemplate.put(baseURL + "/client/" + id, Client.class);
        try{
            client = restTemplate.getForObject(baseURL + "/client/" +id, Client.class);
        }
        catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllClients(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}
